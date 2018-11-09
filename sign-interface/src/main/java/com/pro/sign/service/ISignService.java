package com.pro.sign.service;

import java.util.Collection;

import com.pro.sign.exception.SignException;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

import com.pro.sign.entity.User;
import com.pro.sign.query.UserQuery;
import com.pro.sign.vo.UserVO;

import com.pro.sign.entity.Account;
import com.pro.sign.query.AccountQuery;
import com.pro.sign.vo.AccountVO;

import com.pro.sign.entity.UserInfo;
import com.pro.sign.query.UserInfoQuery;
import com.pro.sign.vo.UserInfoVO;

import com.pro.sign.entity.Groups;
import com.pro.sign.query.GroupsQuery;
import com.pro.sign.vo.GroupsVO;

import com.pro.sign.entity.UserGroupsNexus;
import com.pro.sign.query.UserGroupsNexusQuery;
import com.pro.sign.vo.UserGroupsNexusVO;

import com.pro.sign.entity.LoginLog;
import com.pro.sign.query.LoginLogQuery;
import com.pro.sign.vo.LoginLogVO;

import com.pro.sign.entity.Session;
import com.pro.sign.query.SessionQuery;
import com.pro.sign.vo.SessionVO;

public interface ISignService {

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

  public UserVO getUserVOByPk(java.lang.String userId) throws SignException;

  public Collection<UserVO> getAllUserVO() throws SignException;

  public Paging<UserVO> pagingGetUserVO(Parameter parameter) throws SignException;

  public Collection<UserVO> queryUserVO(UserQuery userQuery) throws SignException;

  public Paging<UserVO> pagingQueryUserVO(Parameter parameter, UserQuery userQuery) throws SignException;

  public void saveAccount(Account account) throws SignException;

  public void batchSaveAccount(Collection<Account> accounts) throws SignException;

  public void updateAccount(Account account) throws SignException;

  public void batchUpdateAccount(Collection<Account> accounts) throws SignException;

  public void removeAccount(Account account) throws SignException;

  public void batchRemoveAccount(Collection<Account> accounts) throws SignException;

  public Long getCountAccount(AccountQuery accountQuery) throws SignException;

  public Account getAccountByPk(java.lang.String accountId) throws SignException;

  public Collection<Account> getAllAccount() throws SignException;

  public Paging<Account> pagingGetAccount(Parameter parameter) throws SignException;

  public Collection<Account> queryAccount(AccountQuery accountQuery) throws SignException;

  public Paging<Account> pagingQueryAccount(Parameter parameter, AccountQuery accountQuery) throws SignException;

  public AccountVO getAccountVOByPk(java.lang.String accountId) throws SignException;

  public Collection<AccountVO> getAllAccountVO() throws SignException;

  public Paging<AccountVO> pagingGetAccountVO(Parameter parameter) throws SignException;

  public Collection<AccountVO> queryAccountVO(AccountQuery accountQuery) throws SignException;

  public Paging<AccountVO> pagingQueryAccountVO(Parameter parameter, AccountQuery accountQuery) throws SignException;

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

  public UserInfoVO getUserInfoVOByPk(java.lang.String userInfoId) throws SignException;

  public Collection<UserInfoVO> getAllUserInfoVO() throws SignException;

  public Paging<UserInfoVO> pagingGetUserInfoVO(Parameter parameter) throws SignException;

  public Collection<UserInfoVO> queryUserInfoVO(UserInfoQuery userInfoQuery) throws SignException;

  public Paging<UserInfoVO> pagingQueryUserInfoVO(Parameter parameter, UserInfoQuery userInfoQuery) throws SignException;

  public void saveGroups(Groups groups) throws SignException;

  public void batchSaveGroups(Collection<Groups> groupss) throws SignException;

  public void updateGroups(Groups groups) throws SignException;

  public void batchUpdateGroups(Collection<Groups> groupss) throws SignException;

  public void removeGroups(Groups groups) throws SignException;

  public void batchRemoveGroups(Collection<Groups> groupss) throws SignException;

  public Long getCountGroups(GroupsQuery groupsQuery) throws SignException;

  public Groups getGroupsByPk(java.lang.String groupsId) throws SignException;

  public Collection<Groups> getAllGroups() throws SignException;

  public Paging<Groups> pagingGetGroups(Parameter parameter) throws SignException;

  public Collection<Groups> queryGroups(GroupsQuery groupsQuery) throws SignException;

  public Paging<Groups> pagingQueryGroups(Parameter parameter, GroupsQuery groupsQuery) throws SignException;

  public GroupsVO getGroupsVOByPk(java.lang.String groupsId) throws SignException;

  public Collection<GroupsVO> getAllGroupsVO() throws SignException;

  public Paging<GroupsVO> pagingGetGroupsVO(Parameter parameter) throws SignException;

  public Collection<GroupsVO> queryGroupsVO(GroupsQuery groupsQuery) throws SignException;

  public Paging<GroupsVO> pagingQueryGroupsVO(Parameter parameter, GroupsQuery groupsQuery) throws SignException;

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

  public UserGroupsNexusVO getUserGroupsNexusVOByPk(java.lang.String nexusId) throws SignException;

  public Collection<UserGroupsNexusVO> getAllUserGroupsNexusVO() throws SignException;

  public Paging<UserGroupsNexusVO> pagingGetUserGroupsNexusVO(Parameter parameter) throws SignException;

  public Collection<UserGroupsNexusVO> queryUserGroupsNexusVO(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException;

  public Paging<UserGroupsNexusVO> pagingQueryUserGroupsNexusVO(Parameter parameter, UserGroupsNexusQuery userGroupsNexusQuery) throws SignException;

  public void saveLoginLog(LoginLog loginLog) throws SignException;

  public void batchSaveLoginLog(Collection<LoginLog> loginLogs) throws SignException;

  public void updateLoginLog(LoginLog loginLog) throws SignException;

  public void batchUpdateLoginLog(Collection<LoginLog> loginLogs) throws SignException;

  public void removeLoginLog(LoginLog loginLog) throws SignException;

  public void batchRemoveLoginLog(Collection<LoginLog> loginLogs) throws SignException;

  public Long getCountLoginLog(LoginLogQuery loginLogQuery) throws SignException;

  public LoginLog getLoginLogByPk(java.lang.String logId) throws SignException;

  public Collection<LoginLog> getAllLoginLog() throws SignException;

  public Paging<LoginLog> pagingGetLoginLog(Parameter parameter) throws SignException;

  public Collection<LoginLog> queryLoginLog(LoginLogQuery loginLogQuery) throws SignException;

  public Paging<LoginLog> pagingQueryLoginLog(Parameter parameter, LoginLogQuery loginLogQuery) throws SignException;

  public LoginLogVO getLoginLogVOByPk(java.lang.String logId) throws SignException;

  public Collection<LoginLogVO> getAllLoginLogVO() throws SignException;

  public Paging<LoginLogVO> pagingGetLoginLogVO(Parameter parameter) throws SignException;

  public Collection<LoginLogVO> queryLoginLogVO(LoginLogQuery loginLogQuery) throws SignException;

  public Paging<LoginLogVO> pagingQueryLoginLogVO(Parameter parameter, LoginLogQuery loginLogQuery) throws SignException;

  public void saveSession(Session session) throws SignException;

  public void batchSaveSession(Collection<Session> sessions) throws SignException;

  public void updateSession(Session session) throws SignException;

  public void batchUpdateSession(Collection<Session> sessions) throws SignException;

  public void removeSession(Session session) throws SignException;

  public void batchRemoveSession(Collection<Session> sessions) throws SignException;

  public Long getCountSession(SessionQuery sessionQuery) throws SignException;

  public Session getSessionByPk(java.lang.String sessionId) throws SignException;

  public Collection<Session> getAllSession() throws SignException;

  public Paging<Session> pagingGetSession(Parameter parameter) throws SignException;

  public Collection<Session> querySession(SessionQuery sessionQuery) throws SignException;

  public Paging<Session> pagingQuerySession(Parameter parameter, SessionQuery sessionQuery) throws SignException;

  public SessionVO getSessionVOByPk(java.lang.String sessionId) throws SignException;

  public Collection<SessionVO> getAllSessionVO() throws SignException;

  public Paging<SessionVO> pagingGetSessionVO(Parameter parameter) throws SignException;

  public Collection<SessionVO> querySessionVO(SessionQuery sessionQuery) throws SignException;

  public Paging<SessionVO> pagingQuerySessionVO(Parameter parameter, SessionQuery sessionQuery) throws SignException;

}
