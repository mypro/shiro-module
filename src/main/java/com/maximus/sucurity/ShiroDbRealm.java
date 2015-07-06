package com.maximus.sucurity;


import com.maximus.dao.AccountDao;
import com.maximus.model.Account;
import com.maximus.model.Role;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Objects;

public class ShiroDbRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroDbRealm.class);

    protected AccountDao accountDao;

    /**
     * 认证回调函数。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        try {
            Account account = null;
            account = accountDao.getAccountByLoginName(token.getUsername());
            if (account != null) {
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(new ShiroUser(account.getUserId(), account.getLoginName(), account.getNickName()), token.getPassword(),
                        getName());
                return info;
            } else {
                AuthenticationException e = new AuthenticationException("该账户未被允许登录系统，请联系管理员。");
                LOGGER.error("非法账户" + token.getUsername(), e);
                throw e;
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new AuthenticationException("登录发生异常，请联系管理员", ex);
        }
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无账户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName()).iterator().next();
        String loginName = shiroUser.getLoginName();
        Account account = null;
        try {
            account = accountDao.getAccountByLoginName(loginName);
        } catch (Exception e) {
            LOGGER.error("授权查询失败，查询账户信息异常", e);
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (account == null || account.getRoles() == null) {
            LOGGER.error("账户不存在或权限异常");
        } else {
            for (Role role : account.getRoles()) {
                // 基于Role的权限信息
                info.addRole(role.getName());
            }
            // 基于Permission的权限信息
            try {
                info.addStringPermissions(accountDao.getAccountPermissionsByloginName(loginName));
            } catch (Exception e) {
                LOGGER.error("授权查询失败", e);
            }
        }
        return info;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 自定义Authentication对象，使得Subject除了携带账户的登录名外还可以携带更多信息.
     */
    public static class ShiroUser implements Serializable {
        private static final long serialVersionUID = -1373760761780840081L;
        public Integer userId;
        public String loginName;
        public String nickName;

        public ShiroUser(Integer userId, String loginName, String nickName) {
            this.userId = userId;
            this.loginName = loginName;
            this.nickName = nickName;
        }

        public String getNickName() {
            return nickName;
        }

        public String getLoginName() {
            return loginName;
        }

        public Integer getUserId() {
            return userId;
        }

        /**
         * 本函数输出将作为默认的<shiro:principal/>输出.
         */
        @Override
        public String toString() {
            return loginName;
        }

        /**
         * 重载hashCode,只计算loginName;
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(loginName);
        }

        /**
         * 重载equals,只计算loginName;
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            ShiroUser other = (ShiroUser) obj;
            if (loginName == null) {
                if (other.loginName != null) {
                    return false;
                }
            } else if (!loginName.equals(other.loginName)) {
                return false;
            }
            return true;
        }
    }
}
