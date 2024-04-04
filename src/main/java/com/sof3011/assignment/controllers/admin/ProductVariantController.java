package com.sof3011.assignment.controllers.admin;

import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.entities.ProductVariant;
import com.sof3011.assignment.services.IFileService;
import com.sof3011.assignment.services.IProductAttributeService;
import com.sof3011.assignment.services.IProductService;
import com.sof3011.assignment.services.IProductVariantService;
import com.sof3011.assignment.services.impl.FileService;
import com.sof3011.assignment.services.impl.ProductAttributeService;
import com.sof3011.assignment.services.impl.ProductService;
import com.sof3011.assignment.services.impl.ProductVariantService;
import com.sof3011.assignment.utils.ContextUtil;
import com.sof3011.assignment.utils.ValidatorUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(value = {"/admin/product/add-product-variant-page",
        "/admin/product/add-product-variant",
        "/admin/product-variant/delete",
        "/admin/product-variant/update-page"
        ,"/admin/product-variant/update"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)


public class ProductVariantController extends HttpServlet {
    private final IProductVariantService productVariantService = ContextUtil.getBean(ProductVariantService.class);
    private final IProductService productService = ContextUtil.getBean(ProductService.class);
    private final IProductAttributeService productAttributeService = ContextUtil.getBean(ProductAttributeService.class);
    private final IFileService fileService = new FileService();
    private Product product;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/add-product-variant-page")){
            String slug = req.getParameter("product");
            product = productService.getBySlug(slug);
            req.setAttribute("product", product);
            req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProductVariant());
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-variant-form.jsp").forward(req,resp);
        }
        else if (uri.contains("/delete")){
            Long id = Long.valueOf(req.getParameter("id"));
            productVariantService.delete(id);
            resp.sendRedirect("/admin/product/add-product-variant-page?product="+product.getSlug());
        }
        else if (uri.contains("/update-page")){
            req.setAttribute("product", product);
            Long id = Long.valueOf(req.getParameter("id"));
            req.setAttribute("productVariant",productVariantService.getById(id));
            req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProductVariant());
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-variant-form-update.jsp").forward(req,resp);
        }
        else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/add-product-variant")){
            Part filePart = req.getPart("image");
            String fileName = fileService.getFileName(filePart,req);
            ProductVariant productVariant = ProductVariant.builder()
                    .variantName(req.getParameter("variantName"))
                    .product(product)
                    .price(Long.parseLong(req.getParameter("price")))
                    .quantity(Integer.parseInt(req.getParameter("quantity")))
                    .productVariantAttributes(productAttributeService.getAllBySetIds(getAttributeIds(req)))
                    .image(fileService.getName())
                    .build();
            Map<String,String> violations = ValidatorUtils.validate(productVariant);
            if (!violations.isEmpty()){
                req.setAttribute("violations",violations);
                req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProductVariant());
                req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-variant-form.jsp").forward(req,resp);
            }
            else {
                productVariantService.insert(productVariant);
                filePart.write(fileName);
                resp.sendRedirect("/admin/product/add-product-variant-page?product="+product.getSlug());
            }
        } else if
        (uri.contains("/admin/product-variant/update")){
            Part filePart = req.getPart("image");
            String fileName = fileService.getFileName(filePart,req);
            Long id = Long.valueOf(req.getParameter("id"));
            ProductVariant productVariant = productVariantService.getById(id);
            productVariant.setVariantName(req.getParameter("variantName"));
            productVariant.setPrice(Long.parseLong(req.getParameter("price")));
            productVariant.setQuantity(Integer.parseInt(req.getParameter("quantity")));
            productVariant.setProductVariantAttributes(productAttributeService.getAllBySetIds(getAttributeIds(req)));
            System.out.println(productVariant.getImage());
            Map<String,String> violations = ValidatorUtils.validate(productVariant);
            if (!violations.isEmpty()){
                req.setAttribute("violations",violations);
                req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProductVariant());
                req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-variant-form.jsp").forward(req,resp);
            }
            else {
                if (filePart.getSize() != 0){
                    productVariant.setImage(fileService.getName());
                    filePart.write(fileName);
                }
                productVariantService.update(productVariant);
                resp.sendRedirect("/admin/product/add-product-variant-page?product="+product.getSlug());
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);

        }
    }
    private Set<Long> getAttributeIds(HttpServletRequest req){
        return  productAttributeService
                .getAllProductVariantAttributeSlug()
                .stream()
                .map(s ->Long.valueOf(req.getParameter(s)))
                .collect(Collectors.toSet());
    }
}
