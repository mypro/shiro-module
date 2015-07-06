package com.maximus.dao.impl;

import com.maximus.dao.AccountDao;
import com.maximus.model.Account;
import com.maximus.model.Pager;
import com.maximus.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountDao")
public class AccountDaoImpl  implements AccountDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);


    public Account getAccountByUserId(Integer userId) throws Exception {
        return null;
    }

    public boolean deleteAccountByUserId(Integer userId) throws Exception {
        return false;
    }

    public Account getAccountByLoginName(String loginName) throws Exception {
        return null;
    }

    public List<String> getAccountPermissionsByloginName(String loginName) throws Exception {
        return null;
    }

    public boolean updateAccountRoleById(String id, List<Role> roles) throws Exception {
        return false;
    }

    public boolean exists(String loginName) throws Exception {
        return false;
    }

    public Pager<Account> getAccountByNickName(String nickName, Pager pager) {
        return null;
    }

    public Pager<Account> getAccountByLoginNameOrNickName(String keyWord, Pager pager) {
        return null;
    }

    public List<String> getLoginNames(String nickName) {
        return null;
    }

    public List<Integer> getUserIds(String nickName) {
        return null;
    }
}
