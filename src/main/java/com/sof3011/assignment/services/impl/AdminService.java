package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Admin;
import com.sof3011.assignment.services.IAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService implements IAdminService {
    @Override
    public List<Admin> getAll() {
        return null;
    }

    @Override
    public Admin insert(Admin e) {
        return null;
    }

    @Override
    public void update(Admin e) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Admin login(Admin admin) {
        return null;
    }
}
