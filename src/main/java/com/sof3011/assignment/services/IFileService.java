package com.sof3011.assignment.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public interface IFileService {
    public String getFileName(Part part, HttpServletRequest request);
    public void deletedFile();
    public String getName();
}
