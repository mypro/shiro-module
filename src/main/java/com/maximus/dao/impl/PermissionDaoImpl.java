package com.maximus.dao.impl;

import com.maximus.model.Permission;
import com.maximus.dao.PermissionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("permissionDao")
public class PermissionDaoImpl implements PermissionDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionDaoImpl.class);


    public boolean remove(String id) throws Exception {
        return false;
    }

    public Permission findOne(String name) throws Exception {
        return null;
    }
}
