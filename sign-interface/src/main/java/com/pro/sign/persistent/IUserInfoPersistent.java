package com.pro.sign.persistent;

import java.util.Collection;

import com.pro.sign.entity.UserInfo;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.UserInfoQuery;
import com.pro.sign.vo.UserInfoVO;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

public interface IUserInfoPersistent {

  public static final String TABLE_NAME = "PRO_USER_INFO";

  public void saveUserInfo(UserInfo userInfo) throws SignException;

  public void batchSaveUserInfo(Collection<UserInfo> userInfos) throws SignException;

  public void updateUserInfo(UserInfo userInfo) throws SignException;

  public void batchUpdateUserInfo(Collection<UserInfo> userInfos) throws SignException;

  public void removeUserInfo(UserInfo userInfo) throws SignException;

  public void batchRemoveUserInfo(Collection<UserInfo> userInfos) throws SignException;

  public Long getCountUserInfo(UserInfoQuery userInfoQuery) throws SignException;

  public UserInfo getUserInfoByPk(java.lang.String userInfoId) throws SignException;

  public Collection<UserInfo> getAllUserInfo() throws SignException;

  public Paging<UserInfo> pagingGetUserInfo(Parameter parameter) throws SignException;

  public Collection<UserInfo> queryUserInfo(UserInfoQuery userInfoQuery) throws SignException;

  public Paging<UserInfo> pagingQueryUserInfo(Parameter parameter, UserInfoQuery userInfoQuery) throws SignException;

  public boolean isUnique(UserInfoQuery userInfoQuery) throws SignException;

  public String getNotUniqueErrorMessage(UserInfoQuery userInfoQuery) throws SignException;

  public UserInfoVO getUserInfoVOByPk(java.lang.String userInfoId) throws SignException;

  public Collection<UserInfoVO> getAllUserInfoVO() throws SignException;

  public Paging<UserInfoVO> pagingGetUserInfoVO(Parameter parameter) throws SignException;

  public Collection<UserInfoVO> queryUserInfoVO(UserInfoQuery userInfoQuery) throws SignException;

  public Paging<UserInfoVO> pagingQueryUserInfoVO(Parameter parameter, UserInfoQuery userInfoQuery) throws SignException;

}
