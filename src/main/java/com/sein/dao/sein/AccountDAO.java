package com.sein.dao.sein;

import com.sein.pojo.po.Account;
import com.sein.utils.MyMapper;

/**
 * Created by ldb on 2017/7/12.
 * 用户dao类
 */
public interface AccountDAO extends MyMapper<Account> {

    Account getAccountById(Integer id);

}
