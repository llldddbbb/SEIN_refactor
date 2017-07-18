package com.sein.shiro;

import com.sein.pojo.po.Account;
import com.sein.pojo.po.Admin;
import com.sein.service.AccountService;
import com.sein.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldb on 2017/4/27.
 * 自定义Realm
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AdminService adminService;
    Logger logger=LoggerFactory.getLogger(this.getClass());


    //权限设置
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户名
        String loginName = (String) super.getAvailablePrincipal(principals);
        List<String> roles = new ArrayList<String>();
        if ("admin".equals(loginName)) {
            roles.add("admin");
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            // 如果是超级管理员，设置角色
            simpleAuthorizationInfo.addRoles(roles);
            return simpleAuthorizationInfo;
        }else{
            roles.add("user");
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            // 如果是普通用户，设置角色
            simpleAuthorizationInfo.addRoles(roles);
            return simpleAuthorizationInfo;
        }

    }

    //身份设置
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName=(String)authenticationToken.getPrincipal();
        Account account=accountService.getAccountByUserName(userName);
        Admin admin=adminService.getAdminByUserName(userName);
        if(account.getId()!=null){
            SecurityUtils.getSubject().getSession().setAttribute("currentAccount", account);
            //设置session超时时间2h。
            SecurityUtils.getSubject().getSession().setTimeout(-1000l);
            AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(account.getUserName(),account.getPassword(),"xx");
            return authcInfo;
        }else if(admin.getId()!=null){
            AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(admin.getAdminName(),admin.getPassword(),"xx");
            return authcInfo;
        }else{
            return null;
        }
    }
}
