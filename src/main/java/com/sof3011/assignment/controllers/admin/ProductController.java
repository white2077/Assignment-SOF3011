package com.sof3011.assignment.controllers.admin;

import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.services.IProductAttributeService;
import com.sof3011.assignment.services.IProductService;
import com.sof3011.assignment.services.impl.ProductAttributeService;
import com.sof3011.assignment.services.impl.ProductService;
import com.sof3011.assignment.utils.ContextUtil;
import com.sof3011.assignment.utils.SlugUtil;
import com.sof3011.assignment.utils.ValidatorUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(value =
        {       "/admin/products",
                "/admin/products/add-product",
                "/admin/products/add-new",
                "/admin/products/delete",
                "/admin/products/update-product",
                "/admin/products/update"})
public class ProductController extends HttpServlet {
    private final IProductService productService = ContextUtil.getBean(ProductService.class);
    private final IProductAttributeService productAttributeService = ContextUtil.getBean(ProductAttributeService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProduct());
        req.setAttribute("categories",productAttributeService.getCategory());
        String url = req.getRequestURI();
        if (url.equals("/admin/products")) {
            req.setAttribute("products",productService.getAll());
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product.jsp").forward(req, resp);
        }
        if (url.equals("/admin/products/add-product")) {
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-form.jsp").forward(req,resp);
        }
        if (url.contains("/admin/products/update-product")){
            req.setAttribute("product",productService.getById(Long.valueOf(req.getParameter("productId"))));
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-form-update.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/admin/products/add-new")){
            Part thumbnail = req.getPart("thumbnail");
            String name  = UUID.randomUUID() + thumbnail.getSubmittedFileName();
            String path = "/assets/uploads/product-thumbnail/"+name;
            String fileName = req.getServletContext().getRealPath(path);
//            Set<Long> ids = productAttributeService
//                    .getAllProductAttributeSlug()
//                    .stream()
//                    .map(s ->Long.valueOf(req.getParameter(s)))
//                    .collect(Collectors.toSet());

            String productName = req.getParameter("productName");
            Product product = Product
                    .builder()
                    .productName(productName)
                    .description(req.getParameter("description"))
                    .slug(SlugUtil.convertNameToSlug(productName))
                    .thumbnail(name)
                    .productAttribute(productAttributeService
                            .getAllProductAttributeByIds
                                    (categoriesIdSet(req.getParameterValues("categoriesId"))))
                    .status(true).build();
            Map<String,String> violations = ValidatorUtils.validate(product);

            if (!violations.isEmpty()){
                req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProduct());
                req.setAttribute("violations",violations);
                req.setAttribute("categories",productAttributeService.getCategory());
                req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-form.jsp").forward(req,resp);
            }
            else {
                thumbnail.write(fileName);
                productService.insert(product);
                resp.sendRedirect("/admin/products");
            }
        }
        else if (uri.contains("/admin/products/delete")){
            productService.delete(Long.valueOf(req.getParameter("productId")));
            resp.sendRedirect("/admin/products");
        }
        else if(uri.contains("/update")) {
            Part thumbnail = req.getPart("thumbnail");
            String productName = req.getParameter("productName");
            Product product = productService.getById(Long.valueOf(req.getParameter("productId")));
            product.setProductName(productName);
            product.setDescription(req.getParameter("description"));
            product.setSlug(SlugUtil.convertNameToSlug(productName));
            product.setProductAttribute(productAttributeService
                    .getAllProductAttributeByIds
                            (categoriesIdSet(req.getParameterValues("categoriesId"))));
            Map<String,String> violations = ValidatorUtils.validate(product);
            if (!violations.isEmpty()){
                req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProduct());
                if (thumbnail.getSize() > 0){
                    violations.remove("thumbnail");
                    req.setAttribute("violations",violations);
                }
                else req.setAttribute("violations",violations);
                req.setAttribute("categories",productAttributeService.getCategory());
                req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-form.jsp").forward(req,resp);
            } else if (thumbnail.getSize() > 0){
                String name  = UUID.randomUUID() + thumbnail.getSubmittedFileName();
                String path = "/assets/uploads/product-thumbnail/"+name;
                String fileName = req.getServletContext().getRealPath(path);
                product.setThumbnail(name);
                thumbnail.write(fileName);
                productService.update(product);
                resp.sendRedirect("/admin/products");
            }
            else {
                productService.update(product);
                resp.sendRedirect("/admin/products");
            }
        }
    }
    Set<Long> categoriesIdSet(String[] categoriesIdArray){
        return (categoriesIdArray != null)
                ? Arrays.stream(categoriesIdArray)
                .map(Long::parseLong)
                .collect(Collectors.toSet())
                : new HashSet<>();
    }
}
