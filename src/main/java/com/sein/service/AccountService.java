package com.sein.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sein.dao.AccountDAO;
import com.sein.enums.ResultEnum;
import com.sein.pojo.dto.PageResult;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Account;
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

    /**
     * 获取所有账户封装成分页列表信息
     * @param pageNum
     * @return
     */
    public PageResult<Account> listAccount(Integer pageNum, Integer pageSize) {
        PageResult<Account> pageResult=new PageResult<>();
        //切入分页sql
        Page<Account> page = PageHelper.startPage(pageNum,pageSize);
        //获取分页后结果
        Example example=new Example(Account.class);
        //倒序排序
        example.setOrderByClause("id DESC");
        List<Account> accountList =accountDAO.selectByExample(example);
        //获取总记录数
        long total = page.getTotal();
        //封装参数
        pageResult.setRows(accountList);
        pageResult.setTotal(total);
        return pageResult;
    }
}
