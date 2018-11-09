package com.pro.sign.persistent;

import java.util.Collection;

import com.pro.sign.entity.UserGroupsNexus;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.UserGroupsNexusQuery;
import com.pro.sign.vo.UserGroupsNexusVO;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

public interface IUserGroupsNexusPersistent {

  public static final String TABLE_NAME = "PRO_USER_GROUPS_NEXUS";

  public void saveUserGroupsNexus(UserGroupsNexus userGroupsNexus) throws SignException;

  public void batchSaveUserGroupsNexus(Collection<UserGroupsNexus> userGroupsNexuss) throws SignException;

  public void updateUserGroupsNexus(UserGroupsNexus userGroupsNexus) throws SignException;

  public void batchUpdateUserGroupsNexus(Collection<UserGroupsNexus> userGroupsNexuss) throws SignException;

  public void removeUserGroupsNexus(UserGroupsNexus userGroupsNexus) throws SignException;

  public void batchRemoveUserGroupsNexus(Collection<UserGroupsNexus> userGroupsNexuss) throws SignException;

  public Long getCountUserGroupsNexus(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException;

  public UserGroupsNexus getUserGroupsNexusByPk(java.lang.String nexusId) throws SignException;

  public Collection<UserGroupsNexus> getAllUserGroupsNexus() throws SignException;

  public Paging<UserGroupsNexus> pagingGetUserGroupsNexus(Parameter parameter) throws SignException;

  public Collection<UserGroupsNexus> queryUserGroupsNexus(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException;

  public Paging<UserGroupsNexus> pagingQueryUserGroupsNexus(Parameter parameter, UserGroupsNexusQuery userGroupsNexusQuery) throws SignException;

  public boolean isUnique(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException;

  public String getNotUniqueErrorMessage(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException;

  public UserGroupsNexusVO getUserGroupsNexusVOByPk(java.lang.String nexusId) throws SignException;

  public Collection<UserGroupsNexusVO> getAllUserGroupsNexusVO() throws SignException;

  public Paging<UserGroupsNexusVO> pagingGetUserGroupsNexusVO(Parameter parameter) throws SignException;

  public Collection<UserGroupsNexusVO> queryUserGroupsNexusVO(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException;

  public Paging<UserGroupsNexusVO> pagingQueryUserGroupsNexusVO(Parameter parameter, UserGroupsNexusQuery userGroupsNexusQuery) throws SignException;

}
