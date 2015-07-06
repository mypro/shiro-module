package com.maximus.dao;

import com.maximus.model.Permission;

public interface PermissionDao  {

    /**
     * 根据id删除权限，同时角色级联删除
     * 
     * @param id
     * @return
     * @throws Exception
     */
    boolean remove(String id) throws Exception;

    Permission findOne(String name) throws Exception;
}
