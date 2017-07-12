package com.sein.service;

import com.sein.pojo.po.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ldb on 2017/7/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void testLogin(){
        Admin user=new Admin();
        user.setAdminName("admin");
        user.setPassword("admin");
        adminService.checkLogin(user);
    }

}
