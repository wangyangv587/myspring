package com.kaikeba.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * 自定义的realm实现
 */
public class MyRealm1 implements Realm {

    /**
     * 为realm设置名字
     * @return
     */
    @Override
    public String getName() {
        return "myRealm1";
    }

    /**
     * 判断是否支持这个token类型，这里只支持UsernamePasswordToken类型
     * @param authenticationToken
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    /**
     * 真正的认证信息的方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取认证信息中的用户名，principal：用户名
        String username = (String)authenticationToken.getPrincipal();
        //获取认证信息中的密码，credentials：密码
        String password = new String((char[])authenticationToken.getCredentials());

        if(!username.equals("zhangsan")){
            throw new UnknownAccountException("用户名错误");
        }

        if(!password.equals("123")){
            throw new IncorrectCredentialsException("密码错误");
        }

        //验证通过返回AuthenticationInfo实现
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
