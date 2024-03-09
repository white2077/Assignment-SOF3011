package com.sof3011.assignment.service;

import static org.junit.jupiter.api.Assertions.*;

import com.sof3011.assignment.entities.Address;
import com.sof3011.assignment.entities.Customer;
import com.sof3011.assignment.services.IAddressService;
import com.sof3011.assignment.services.ICustomerService;
import com.sof3011.assignment.utils.ContextUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomerServiceTests {
    private static ICustomerService service;
    private static IAddressService addrService;

    @BeforeAll
    public static void init() {
        service = ContextUtil.getBean(ICustomerService.class);
        addrService = ContextUtil.getBean(IAddressService.class);

        Address addr1 = new Address();
        addr1.setAddress("Ha Noi, VN");
        addrService.insert(addr1);

        Customer c1 = new Customer();
        c1.setCustomerName("Nguyen Thai Nguyen 1");
        c1.setEmail("nguyenntph33935@fpt.edu.vn");
        c1.setPassword("p@ssw0rd");
        c1.setPhoneNumber("0123456789");
        c1.setUsername("nguyenthainguyen");
        c1.addAddress(addr1);

        Address addr2 = new Address();
        addr2.setAddress("Ha Noi, VN");
        addrService.insert(addr2);

        Customer c2 = new Customer();
        c2.setCustomerName("Nguyen Thai Nguyen 2");
        c2.setEmail("nguyenntph33935@fpt.edu.vn");
        c2.setPassword("p@ssw0rd");
        c2.setPhoneNumber("0123456789");
        c2.setUsername("nguyenthainguyen");
        c2.addAddress(addr2);

        Address addr3 = new Address();
        addr3.setAddress("Ha Noi, VN");
        addrService.insert(addr3);

        Customer c3 = new Customer();
        c3.setCustomerName("Nguyen Thai Nguyen 3");
        c3.setEmail("nguyenntph33935@fpt.edu.vn");
        c3.setPassword("p@ssw0rd");
        c3.setPhoneNumber("0123456789");
        c3.setUsername("nguyenthainguyen");
        c3.addAddress(addr3);

        Address addr4 = new Address();
        addr4.setAddress("Ha Noi, VN");
        addrService.insert(addr4);

        Customer c4 = new Customer();
        c4.setCustomerName("Nguyen Thai Nguyen 4");
        c4.setEmail("nguyenntph33935@fpt.edu.vn");
        c4.setPassword("p@ssw0rd");
        c4.setPhoneNumber("0123456789");
        c4.setUsername("nguyenthainguyen");
        c4.addAddress(addr4);

        service.insert(c1);
        service.insert(c2);
        service.insert(c3);
        service.insert(c4);
    }

    @Test
    void testExpectListSizeEq4() {
        List<Customer> customers = service.getAll();
        assertEquals(customers.size(), 4);
    }

    @Test
    void testCreateACustomer() {
        Address addr = new Address();
        addr.setAddress("Ha Noi, VN");

        Customer customer = new Customer();
        customer.setCustomerName("Nguyen Thai Nguyen 4");
        customer.setEmail("nguyenntph33935@fpt.edu.vn");
        customer.setPassword("p@ssw0rd");
        customer.setPhoneNumber("0123456789");
        customer.setUsername("nguyenthainguyen");
        customer.setAddresses(Collections.singletonList(addr));

        service.insert(customer);
        List<Customer> customers = service.getAll();
        assertEquals(customers.size(), 5);
    }

    @Test
    void testFindById() {
        Customer customerOptional = service.getById(1L);
        assertEquals(customerOptional.getCustomerName(), "Nguyen Thai Nguyen 1");
    }

    @Test
    void testFindByIdThrows() {
        try {
            Customer customerOptional = service.getById(9999L);
            assertEquals(customerOptional.getCustomerName(), "Nguyen Thai Nguyen 1");
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }

    @Test
    void testUpdate() {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Customer customer = service.getById(1L);
            customer.setPhoneNumber("1234567890");
            customer.setCustomerName("dit cu");

            service.update(1L, customer);
            Customer c = service.getById(1L);
            assertEquals(c.getAddresses().size(), 0);
            assertEquals(c.getPhoneNumber(), "1234567890");
        }).run();
    }
}
