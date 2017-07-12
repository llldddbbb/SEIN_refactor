package com.sein.service;

import com.sein.dao.AdminDAO;
import com.sein.enums.ResultEnum;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Admin currentAdmin= adminDAO.selectOne(admin);
        if(currentAdmin!=null){
            //将登录用户返回给Controller
            return Result.isOK(currentAdmin);
        }else{
            return Result.isNotOK(ResultEnum.LOGIN_ERROR.getInfo());
        }
    }



}
