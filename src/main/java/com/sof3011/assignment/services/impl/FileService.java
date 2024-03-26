package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.services.IFileService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import lombok.Getter;

import java.util.UUID;
@Getter
public class FileService implements IFileService {
    private String name;

    @Override
    public String getFileName(Part part, HttpServletRequest request) {
        name  = UUID.randomUUID() + part.getSubmittedFileName();
        String path = "/assets/uploads/product-thumbnail/"+name;
        return request.getServletContext().getRealPath(path);
    }

    @Override
    public void deletedFile() {

    }

}
