package com.maximus.dao;
import com.maximus.model.Account;
import com.maximus.model.Pager;
import com.maximus.model.Role;

import java.util.List;

public interface AccountDao  {

    /**
     * 查询账户(根据id)
     * 
     * @param userId 账户id
     * @return
     * @throws Exception
     */
    Account getAccountByUserId(Integer userId) throws Exception;

    /**
     * 删除账户(根据userId)
     * 
     * @param userId 账户userId
     * @return
     * @throws Exception
     */
    boolean deleteAccountByUserId(Integer userId) throws Exception;

    /**
     * 查询账户(根据loginName)
     * 
     * @param loginName 账户loginName
     * @return
     * @throws Exception
     */
    Account getAccountByLoginName(String loginName) throws Exception;

    /**
     * 根据登录名，查询指定账户的全部权限的权限表达式列表
     * 
     * @param loginName 账户loginName
     * @return
     * @throws Exception
     */
    List<String> getAccountPermissionsByloginName(String loginName) throws Exception;

    /**
     * 更新账户的角色
     * 
     * @param id 账户objId
     * @param roles 角色列表
     * @return
     * @throws Exception
     */
    boolean updateAccountRoleById(String id, List<Role> roles) throws Exception;

    /**
     * 根据loginName判断账户是否存在
     */
    boolean exists(String loginName) throws Exception;

    Pager<Account> getAccountByNickName(String nickName, Pager pager);

    Pager<Account> getAccountByLoginNameOrNickName(String keyWord, Pager pager);

    List<String> getLoginNames(String nickName);

    List<Integer> getUserIds(String nickName);
}
