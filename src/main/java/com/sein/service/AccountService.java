package com.sein.service;

import com.sein.dao.AccountDAO;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 */
@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public Result testProject() {
        List<Account> accountList = accountDAO.selectAll();
        if (accountList != null && accountList.size() > 0) {
            return Result.isOK();
        } else {
            return Result.isNotOK();
        }
    }
}
