package com.sein.shiro;

import com.sein.pojo.po.Account;
import com.sein.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ldb on 2017/4/27.
 * 自定义Realm
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private AccountService accountService;


    //权限设置
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //身份设置
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName=(String)authenticationToken.getPrincipal();
        Account account=accountService.getAccountByUserName(userName);
        if(account!=null){
            SecurityUtils.getSubject().getSession().setAttribute("currentAccount", account);
            //设置session超时时间2h。
            SecurityUtils.getSubject().getSession().setTimeout(7200000);
            AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(account.getUserName(),account.getPassword(),"xx");
            return authcInfo;
        }else{
            return null;
        }
    }
}
