package com.sof3011.assignment.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

@WebServlet("/image/*")
public class ImageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imagePath = "D:\\FPTPOLYTECHNIC\\Semester5\\java4\\assignment\\Assignment-SOF3011\\src\\uploads\\product-image\\";
        String imageName = req.getParameter("image");
        Path image = Path.of("upload",imageName);
        File imageFile = new File(imagePath+imageName);
        if (!imageFile.exists()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        resp.setContentType(getServletContext().getMimeType(imageFile.getName()));
        try (FileInputStream fis = new FileInputStream(imageFile);
             ServletOutputStream os = resp.getOutputStream()) {
            byte[] buffer = new byte[3048];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }
    }
}
