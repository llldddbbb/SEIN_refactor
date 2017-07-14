package com.sein.service;

import com.sein.dao.AccountDAO;
import com.sein.enums.ResultEnum;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 */
@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    /**
     * 用户登录判断
     *
     * @param account
     * @return
     */
    public Result checkLogin(Account account) {
        Account currentAccount = accountDAO.selectOne(account);
        if (currentAccount != null) {
            return Result.isOK(currentAccount);
        } else {
            return Result.isNotOK(ResultEnum.LOGIN_ERROR.getInfo());
        }
    }

    /**
     * 根据用户名查找Account
     * @param userName
     * @return
     */
    public Account getAccountByUserName(String userName){
        Example example=new Example(Account.class);
        example.createCriteria().andEqualTo("userName",userName);
        List<Account> accountList = accountDAO.selectByExample(example);
        if(accountList!=null&&accountList.size()>0){
            return accountList.get(0);
        }else{
            return new Account();
        }

    }

    /**
     * 添加用户
     *
     * @param account
     * @return
     */
    public Result addAccount(Account account) {
        int result = accountDAO.insert(account);
        if (result > 0) {
            return Result.isOK();
        } else {
            return Result.isNotOK();
        }
    }

    /**
     * 更新用户信息
     *
     * @param account
     * @return
     */
    public Result updateAccount(Account account) {
        int result = accountDAO.updateByPrimaryKey(account);
        if (result > 0) {
            return Result.isOK();
        } else {
            return Result.isNotOK();
        }
    }
}
