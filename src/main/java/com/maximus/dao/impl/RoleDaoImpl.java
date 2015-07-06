package com.maximus.dao.impl;

import com.maximus.model.Role;
import com.maximus.dao.RoleDao;
import com.maximus.model.Account;
import com.maximus.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl  implements RoleDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleDaoImpl.class);


    public boolean remove(String id) throws Exception {
        return false;
    }

    public Role findOne(String roleName) throws Exception {
        return null;
    }

    public boolean updatePremissionById(String id, List<Permission> permissions) throws Exception {
        return false;
    }

    public List<Account> getAccountsByRoleName(String roleName) throws Exception {
        return null;
    }
}
