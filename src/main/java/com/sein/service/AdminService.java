package com.sein.service;

import com.sein.dao.AdminDAO;
import com.sein.enums.ResultEnum;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Admin;
import com.sein.pojo.po.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 */
@Service
public class AdminService {

    @Autowired
    private AdminDAO adminDAO;

    /**
     * 登录验证
     * @param admin
     * @return
     */
    public Result checkLogin(Admin admin){
        if(admin.getAdminName()==null||admin.getPassword()==null){
            return Result.isNotOK(ResultEnum.LOGIN_INFO_NULL.getInfo());
        }
        Admin currentAdmin= adminDAO.selectOne(admin);
        if(currentAdmin!=null){
            //将登录用户返回给Controller
            return Result.isOK(currentAdmin);
        }else{
            return Result.isNotOK(ResultEnum.LOGIN_ERROR.getInfo());
        }
    }

    /**
     * 根据用户名查找Admin
     *
     * @param adminName
     * @return
     */
    public Admin getAdminByUserName(String adminName) {
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("adminName", adminName);
        List<Admin> adminList = adminDAO.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        } else {
            return new Admin();
        }

    }



}
