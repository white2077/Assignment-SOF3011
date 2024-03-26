package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.Admin;

public interface IAdminService extends IServiceInterface<Admin,Long> {
    Admin login(Admin admin);
}
