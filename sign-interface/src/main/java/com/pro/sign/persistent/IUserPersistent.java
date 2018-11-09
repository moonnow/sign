package com.pro.sign.persistent;

import java.util.Collection;

import com.pro.sign.entity.User;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.UserQuery;
import com.pro.sign.vo.UserVO;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

public interface IUserPersistent {

  public static final String TABLE_NAME = "PRO_USER";

  public void saveUser(User user) throws SignException;

  public void batchSaveUser(Collection<User> users) throws SignException;

  public void updateUser(User user) throws SignException;

  public void batchUpdateUser(Collection<User> users) throws SignException;

  public void removeUser(User user) throws SignException;

  public void batchRemoveUser(Collection<User> users) throws SignException;

  public Long getCountUser(UserQuery userQuery) throws SignException;

  public User getUserByPk(java.lang.String userId) throws SignException;

  public Collection<User> getAllUser() throws SignException;

  public Paging<User> pagingGetUser(Parameter parameter) throws SignException;

  public Collection<User> queryUser(UserQuery userQuery) throws SignException;

  public Paging<User> pagingQueryUser(Parameter parameter, UserQuery userQuery) throws SignException;

  public boolean isUnique(UserQuery userQuery) throws SignException;

  public String getNotUniqueErrorMessage(UserQuery userQuery) throws SignException;

  public UserVO getUserVOByPk(java.lang.String userId) throws SignException;

  public Collection<UserVO> getAllUserVO() throws SignException;

  public Paging<UserVO> pagingGetUserVO(Parameter parameter) throws SignException;

  public Collection<UserVO> queryUserVO(UserQuery userQuery) throws SignException;

  public Paging<UserVO> pagingQueryUserVO(Parameter parameter, UserQuery userQuery) throws SignException;

}
