package com.maximus.dao;

import com.maximus.model.Account;
import com.maximus.model.Permission;
import com.maximus.model.Role;

import java.util.List;

public interface RoleDao {

    /**
     * 删除指定id的角色,同时account级联删除
     * 
     * @param id 角色id
     * @return
     * @throws Exception
     */
    boolean remove(String id) throws Exception;

    /**
     * 查询指定名称的角色
     * 
     * @param roleName 角色名
     * @return
     * @throws Exception
     */
    Role findOne(String roleName) throws Exception;

    /**
     * 更新角色的权限
     * 
     * @param id 角色objId
     * @param permissions 新增权限列表
     * @return
     * @throws Exception
     */
    boolean updatePremissionById(String id, List<Permission> permissions) throws Exception;

    /**
     * 获取指定roleName的所有账户
     * 
     * @param roleName
     * @return
     * @throws Exception
     */
    List<Account> getAccountsByRoleName(String roleName) throws Exception;

}
