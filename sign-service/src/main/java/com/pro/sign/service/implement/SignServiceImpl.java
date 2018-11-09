package com.pro.sign.service.implement;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.pro.sign.exception.SignException;
import com.pro.sign.service.ISignService;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.ToolUtil;

import com.pro.sign.entity.User;
import com.pro.sign.persistent.IUserPersistent;
import com.pro.sign.query.UserQuery;
import com.pro.sign.vo.UserVO;

import com.pro.sign.entity.Account;
import com.pro.sign.persistent.IAccountPersistent;
import com.pro.sign.query.AccountQuery;
import com.pro.sign.vo.AccountVO;

import com.pro.sign.entity.UserInfo;
import com.pro.sign.persistent.IUserInfoPersistent;
import com.pro.sign.query.UserInfoQuery;
import com.pro.sign.vo.UserInfoVO;

import com.pro.sign.entity.Groups;
import com.pro.sign.persistent.IGroupsPersistent;
import com.pro.sign.query.GroupsQuery;
import com.pro.sign.vo.GroupsVO;

import com.pro.sign.entity.UserGroupsNexus;
import com.pro.sign.persistent.IUserGroupsNexusPersistent;
import com.pro.sign.query.UserGroupsNexusQuery;
import com.pro.sign.vo.UserGroupsNexusVO;

import com.pro.sign.entity.LoginLog;
import com.pro.sign.persistent.ILoginLogPersistent;
import com.pro.sign.query.LoginLogQuery;
import com.pro.sign.vo.LoginLogVO;

import com.pro.sign.entity.Session;
import com.pro.sign.persistent.ISessionPersistent;
import com.pro.sign.query.SessionQuery;
import com.pro.sign.vo.SessionVO;

@org.springframework.stereotype.Service("com.pro.sign.SignService")
@org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = java.lang.Exception.class)
public class SignServiceImpl implements ISignService {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(SignServiceImpl.class);

  @javax.annotation.Resource(name = "com.pro.sign.UserPersistent")
  private IUserPersistent userPersistent;

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveUser(User user) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.saveUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
      }
      user.setUserId(ToolUtil.getUUID());
      UserQuery userQuery = new UserQuery();
      userQuery.setUserKeyAndeq(user.getUserKey());
      if (!userPersistent.isUnique(userQuery)) {
        throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { userPersistent.getNotUniqueErrorMessage(userQuery) });
      }
      userPersistent.saveUser(user);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveUser(Collection<User> users) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchSaveUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (ToolUtil.isEmpty(users)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " users ");
      }
      for (User user : users) {
        if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
        }
        user.setUserId(ToolUtil.getUUID());
        UserQuery userQuery = new UserQuery();
        userQuery.setUserKeyAndeq(user.getUserKey());
        if (!userPersistent.isUnique(userQuery)) {
          throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { userPersistent.getNotUniqueErrorMessage(userQuery) });
        }
      }
      userPersistent.batchSaveUser(users);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateUser(User user) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.updateUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
      }
      if (ToolUtil.isNullStr(user.getUserId())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userId ");
      }
      User oldUser = userPersistent.getUserByPk(user.getUserId());
      if (oldUser == null) {
        throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
      }
      UserQuery userQuery = new UserQuery();
      userQuery.setUserKeyAndeq(user.getUserKey());
      if (!userQuery.getUserKeyAndeq().equals(oldUser.getUserKey())) {
        if (!userPersistent.isUnique(userQuery)) {
          throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { userPersistent.getNotUniqueErrorMessage(userQuery) });
        }
      }
      userPersistent.updateUser(user);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateUser(Collection<User> users) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchUpdateUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (ToolUtil.isEmpty(users)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " users ");
      }
      for (User user : users) {
        if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
        }
        if (ToolUtil.isNullStr(user.getUserId())) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userId ");
        }
        User oldUser = userPersistent.getUserByPk(user.getUserId());
        if (oldUser == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        UserQuery userQuery = new UserQuery();
        userQuery.setUserKeyAndeq(user.getUserKey());
        if (!userQuery.getUserKeyAndeq().equals(oldUser.getUserKey())) {
          if (!userPersistent.isUnique(userQuery)) {
            throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { userPersistent.getNotUniqueErrorMessage(userQuery) });
          }
        }
      }
      userPersistent.batchUpdateUser(users);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeUser(User user) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.removeUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
      }
      Set<User> userSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(user.getUserId())) {
        UserQuery userQuery = ToolUtil.attributeReplication(UserQuery.class, user);
        userSet.addAll(userPersistent.queryUser(userQuery));
      } else {
        User oldUser = userPersistent.getUserByPk(user.getUserId());
        if (oldUser == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        userSet.add(oldUser);
      }
      if (ToolUtil.isNotEmpty(userSet)) {
        userPersistent.batchRemoveUser(userSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveUser(Collection<User> users) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchRemoveUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (ToolUtil.isEmpty(users)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " users ");
      }
      Set<User> userSet = new LinkedHashSet<>();
      for (User user : users) {
        if (ToolUtil.isNullStr(user.getUserId())) {
          UserQuery userQuery = ToolUtil.attributeReplication(UserQuery.class, user);
          userSet.addAll(userPersistent.queryUser(userQuery));
        } else {
          User oldUser = userPersistent.getUserByPk(user.getUserId());
          if (oldUser == null) {
            throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
          }
          userSet.add(oldUser);
        }
      }
      if (ToolUtil.isNotEmpty(userSet)) {
        userPersistent.batchRemoveUser(userSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Long getCountUser(UserQuery userQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getCountUser ");
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      return userPersistent.getCountUser(userQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public User getUserByPk(java.lang.String userId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getUserByPk ");
      log.debug("parameter userId is : " + userId);
    }
    try {
      if (ToolUtil.isNullStr(userId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userId ");
      }
      return userPersistent.getUserByPk(userId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<User> getAllUser() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllUser ");
    }
    try {
      return userPersistent.getAllUser();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<User> pagingGetUser(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetUser ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userPersistent.pagingGetUser(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<User> queryUser(UserQuery userQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryUser ");
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      return userPersistent.queryUser(userQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<User> pagingQueryUser(Parameter parameter, UserQuery userQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryUser ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userPersistent.pagingQueryUser(parameter, userQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public UserVO getUserVOByPk(java.lang.String userId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getUserVOByPk ");
      log.debug("parameter userId is : " + userId);
    }
    try {
      if (ToolUtil.isNullStr(userId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userId ");
      }
      return userPersistent.getUserVOByPk(userId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<UserVO> getAllUserVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllUserVO ");
    }
    try {
      return userPersistent.getAllUserVO();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<UserVO> pagingGetUserVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetUserVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userPersistent.pagingGetUserVO(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<UserVO> queryUserVO(UserQuery userQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryUserVO ");
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      return userPersistent.queryUserVO(userQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<UserVO> pagingQueryUserVO(Parameter parameter, UserQuery userQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryUserVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userPersistent.pagingQueryUserVO(parameter, userQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @javax.annotation.Resource(name = "com.pro.sign.AccountPersistent")
  private IAccountPersistent accountPersistent;

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveAccount(Account account) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.saveAccount ");
      log.debug("parameter account is : " + account);
    }
    try {
      if (account == null || ToolUtil.isNullEntityAllFieldValue(account)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " account ");
      }
      account.setAccountId(ToolUtil.getUUID());
      AccountQuery accountQuery = new AccountQuery();
      accountQuery.setAccountAndeq(account.getAccount());
      if (!accountPersistent.isUnique(accountQuery)) {
        throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { accountPersistent.getNotUniqueErrorMessage(accountQuery) });
      }
      accountPersistent.saveAccount(account);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveAccount(Collection<Account> accounts) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchSaveAccount ");
      log.debug("parameter accounts is : " + accounts);
    }
    try {
      if (ToolUtil.isEmpty(accounts)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accounts ");
      }
      for (Account account : accounts) {
        if (account == null || ToolUtil.isNullEntityAllFieldValue(account)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " account ");
        }
        account.setAccountId(ToolUtil.getUUID());
        AccountQuery accountQuery = new AccountQuery();
        accountQuery.setAccountAndeq(account.getAccount());
        if (!accountPersistent.isUnique(accountQuery)) {
          throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { accountPersistent.getNotUniqueErrorMessage(accountQuery) });
        }
      }
      accountPersistent.batchSaveAccount(accounts);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateAccount(Account account) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.updateAccount ");
      log.debug("parameter account is : " + account);
    }
    try {
      if (account == null || ToolUtil.isNullEntityAllFieldValue(account)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " account ");
      }
      if (ToolUtil.isNullStr(account.getAccountId())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accountId ");
      }
      Account oldAccount = accountPersistent.getAccountByPk(account.getAccountId());
      if (oldAccount == null) {
        throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
      }
      AccountQuery accountQuery = new AccountQuery();
      accountQuery.setAccountAndeq(account.getAccount());
      if (!accountQuery.getAccountAndeq().equals(oldAccount.getAccount())) {
        if (!accountPersistent.isUnique(accountQuery)) {
          throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { accountPersistent.getNotUniqueErrorMessage(accountQuery) });
        }
      }
      accountPersistent.updateAccount(account);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateAccount(Collection<Account> accounts) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchUpdateAccount ");
      log.debug("parameter accounts is : " + accounts);
    }
    try {
      if (ToolUtil.isEmpty(accounts)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accounts ");
      }
      for (Account account : accounts) {
        if (account == null || ToolUtil.isNullEntityAllFieldValue(account)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " account ");
        }
        if (ToolUtil.isNullStr(account.getAccountId())) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accountId ");
        }
        Account oldAccount = accountPersistent.getAccountByPk(account.getAccountId());
        if (oldAccount == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        AccountQuery accountQuery = new AccountQuery();
        accountQuery.setAccountAndeq(account.getAccount());
        if (!accountQuery.getAccountAndeq().equals(oldAccount.getAccount())) {
          if (!accountPersistent.isUnique(accountQuery)) {
            throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { accountPersistent.getNotUniqueErrorMessage(accountQuery) });
          }
        }
      }
      accountPersistent.batchUpdateAccount(accounts);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeAccount(Account account) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.removeAccount ");
      log.debug("parameter account is : " + account);
    }
    try {
      if (account == null || ToolUtil.isNullEntityAllFieldValue(account)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " account ");
      }
      Set<Account> accountSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(account.getAccountId())) {
        AccountQuery accountQuery = ToolUtil.attributeReplication(AccountQuery.class, account);
        accountSet.addAll(accountPersistent.queryAccount(accountQuery));
      } else {
        Account oldAccount = accountPersistent.getAccountByPk(account.getAccountId());
        if (oldAccount == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        accountSet.add(oldAccount);
      }
      if (ToolUtil.isNotEmpty(accountSet)) {
        accountPersistent.batchRemoveAccount(accountSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveAccount(Collection<Account> accounts) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchRemoveAccount ");
      log.debug("parameter accounts is : " + accounts);
    }
    try {
      if (ToolUtil.isEmpty(accounts)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accounts ");
      }
      Set<Account> accountSet = new LinkedHashSet<>();
      for (Account account : accounts) {
        if (ToolUtil.isNullStr(account.getAccountId())) {
          AccountQuery accountQuery = ToolUtil.attributeReplication(AccountQuery.class, account);
          accountSet.addAll(accountPersistent.queryAccount(accountQuery));
        } else {
          Account oldAccount = accountPersistent.getAccountByPk(account.getAccountId());
          if (oldAccount == null) {
            throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
          }
          accountSet.add(oldAccount);
        }
      }
      if (ToolUtil.isNotEmpty(accountSet)) {
        accountPersistent.batchRemoveAccount(accountSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Long getCountAccount(AccountQuery accountQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getCountAccount ");
      log.debug("parameter accountQuery is : " + accountQuery);
    }
    try {
      return accountPersistent.getCountAccount(accountQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Account getAccountByPk(java.lang.String accountId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAccountByPk ");
      log.debug("parameter accountId is : " + accountId);
    }
    try {
      if (ToolUtil.isNullStr(accountId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accountId ");
      }
      return accountPersistent.getAccountByPk(accountId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<Account> getAllAccount() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllAccount ");
    }
    try {
      return accountPersistent.getAllAccount();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<Account> pagingGetAccount(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetAccount ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return accountPersistent.pagingGetAccount(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<Account> queryAccount(AccountQuery accountQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryAccount ");
      log.debug("parameter accountQuery is : " + accountQuery);
    }
    try {
      return accountPersistent.queryAccount(accountQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<Account> pagingQueryAccount(Parameter parameter, AccountQuery accountQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryAccount ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter accountQuery is : " + accountQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return accountPersistent.pagingQueryAccount(parameter, accountQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public AccountVO getAccountVOByPk(java.lang.String accountId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAccountVOByPk ");
      log.debug("parameter accountId is : " + accountId);
    }
    try {
      if (ToolUtil.isNullStr(accountId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accountId ");
      }
      return accountPersistent.getAccountVOByPk(accountId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<AccountVO> getAllAccountVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllAccountVO ");
    }
    try {
      return accountPersistent.getAllAccountVO();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<AccountVO> pagingGetAccountVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetAccountVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return accountPersistent.pagingGetAccountVO(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<AccountVO> queryAccountVO(AccountQuery accountQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryAccountVO ");
      log.debug("parameter accountQuery is : " + accountQuery);
    }
    try {
      return accountPersistent.queryAccountVO(accountQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<AccountVO> pagingQueryAccountVO(Parameter parameter, AccountQuery accountQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryAccountVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter accountQuery is : " + accountQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return accountPersistent.pagingQueryAccountVO(parameter, accountQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @javax.annotation.Resource(name = "com.pro.sign.UserInfoPersistent")
  private IUserInfoPersistent userInfoPersistent;

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveUserInfo(UserInfo userInfo) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.saveUserInfo ");
      log.debug("parameter userInfo is : " + userInfo);
    }
    try {
      if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
      }
      userInfo.setUserInfoId(ToolUtil.getUUID());
      userInfoPersistent.saveUserInfo(userInfo);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveUserInfo(Collection<UserInfo> userInfos) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchSaveUserInfo ");
      log.debug("parameter userInfos is : " + userInfos);
    }
    try {
      if (ToolUtil.isEmpty(userInfos)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfos ");
      }
      for (UserInfo userInfo : userInfos) {
        if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
        }
        userInfo.setUserInfoId(ToolUtil.getUUID());
      }
      userInfoPersistent.batchSaveUserInfo(userInfos);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateUserInfo(UserInfo userInfo) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.updateUserInfo ");
      log.debug("parameter userInfo is : " + userInfo);
    }
    try {
      if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
      }
      if (ToolUtil.isNullStr(userInfo.getUserInfoId())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfoId ");
      }
      UserInfo oldUserInfo = userInfoPersistent.getUserInfoByPk(userInfo.getUserInfoId());
      if (oldUserInfo == null) {
        throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
      }
      userInfoPersistent.updateUserInfo(userInfo);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateUserInfo(Collection<UserInfo> userInfos) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchUpdateUserInfo ");
      log.debug("parameter userInfos is : " + userInfos);
    }
    try {
      if (ToolUtil.isEmpty(userInfos)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfos ");
      }
      for (UserInfo userInfo : userInfos) {
        if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
        }
        if (ToolUtil.isNullStr(userInfo.getUserInfoId())) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfoId ");
        }
        UserInfo oldUserInfo = userInfoPersistent.getUserInfoByPk(userInfo.getUserInfoId());
        if (oldUserInfo == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
      }
      userInfoPersistent.batchUpdateUserInfo(userInfos);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeUserInfo(UserInfo userInfo) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.removeUserInfo ");
      log.debug("parameter userInfo is : " + userInfo);
    }
    try {
      if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
      }
      Set<UserInfo> userInfoSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(userInfo.getUserInfoId())) {
        UserInfoQuery userInfoQuery = ToolUtil.attributeReplication(UserInfoQuery.class, userInfo);
        userInfoSet.addAll(userInfoPersistent.queryUserInfo(userInfoQuery));
      } else {
        UserInfo oldUserInfo = userInfoPersistent.getUserInfoByPk(userInfo.getUserInfoId());
        if (oldUserInfo == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        userInfoSet.add(oldUserInfo);
      }
      if (ToolUtil.isNotEmpty(userInfoSet)) {
        userInfoPersistent.batchRemoveUserInfo(userInfoSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveUserInfo(Collection<UserInfo> userInfos) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchRemoveUserInfo ");
      log.debug("parameter userInfos is : " + userInfos);
    }
    try {
      if (ToolUtil.isEmpty(userInfos)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfos ");
      }
      Set<UserInfo> userInfoSet = new LinkedHashSet<>();
      for (UserInfo userInfo : userInfos) {
        if (ToolUtil.isNullStr(userInfo.getUserInfoId())) {
          UserInfoQuery userInfoQuery = ToolUtil.attributeReplication(UserInfoQuery.class, userInfo);
          userInfoSet.addAll(userInfoPersistent.queryUserInfo(userInfoQuery));
        } else {
          UserInfo oldUserInfo = userInfoPersistent.getUserInfoByPk(userInfo.getUserInfoId());
          if (oldUserInfo == null) {
            throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
          }
          userInfoSet.add(oldUserInfo);
        }
      }
      if (ToolUtil.isNotEmpty(userInfoSet)) {
        userInfoPersistent.batchRemoveUserInfo(userInfoSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Long getCountUserInfo(UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getCountUserInfo ");
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    try {
      return userInfoPersistent.getCountUserInfo(userInfoQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public UserInfo getUserInfoByPk(java.lang.String userInfoId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getUserInfoByPk ");
      log.debug("parameter userInfoId is : " + userInfoId);
    }
    try {
      if (ToolUtil.isNullStr(userInfoId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfoId ");
      }
      return userInfoPersistent.getUserInfoByPk(userInfoId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<UserInfo> getAllUserInfo() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllUserInfo ");
    }
    try {
      return userInfoPersistent.getAllUserInfo();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<UserInfo> pagingGetUserInfo(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetUserInfo ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userInfoPersistent.pagingGetUserInfo(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<UserInfo> queryUserInfo(UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryUserInfo ");
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    try {
      return userInfoPersistent.queryUserInfo(userInfoQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<UserInfo> pagingQueryUserInfo(Parameter parameter, UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryUserInfo ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userInfoPersistent.pagingQueryUserInfo(parameter, userInfoQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public UserInfoVO getUserInfoVOByPk(java.lang.String userInfoId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getUserInfoVOByPk ");
      log.debug("parameter userInfoId is : " + userInfoId);
    }
    try {
      if (ToolUtil.isNullStr(userInfoId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfoId ");
      }
      return userInfoPersistent.getUserInfoVOByPk(userInfoId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<UserInfoVO> getAllUserInfoVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllUserInfoVO ");
    }
    try {
      return userInfoPersistent.getAllUserInfoVO();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<UserInfoVO> pagingGetUserInfoVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetUserInfoVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userInfoPersistent.pagingGetUserInfoVO(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<UserInfoVO> queryUserInfoVO(UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryUserInfoVO ");
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    try {
      return userInfoPersistent.queryUserInfoVO(userInfoQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<UserInfoVO> pagingQueryUserInfoVO(Parameter parameter, UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryUserInfoVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userInfoPersistent.pagingQueryUserInfoVO(parameter, userInfoQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @javax.annotation.Resource(name = "com.pro.sign.GroupsPersistent")
  private IGroupsPersistent groupsPersistent;

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveGroups(Groups groups) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.saveGroups ");
      log.debug("parameter groups is : " + groups);
    }
    try {
      if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
      }
      groups.setGroupsId(ToolUtil.getUUID());
      GroupsQuery groupsQuery = new GroupsQuery();
      groupsQuery.setGroupsKeyAndeq(groups.getGroupsKey());
      if (!groupsPersistent.isUnique(groupsQuery)) {
        throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { groupsPersistent.getNotUniqueErrorMessage(groupsQuery) });
      }
      groupsPersistent.saveGroups(groups);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveGroups(Collection<Groups> groupss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchSaveGroups ");
      log.debug("parameter groupss is : " + groupss);
    }
    try {
      if (ToolUtil.isEmpty(groupss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupss ");
      }
      for (Groups groups : groupss) {
        if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
        }
        groups.setGroupsId(ToolUtil.getUUID());
        GroupsQuery groupsQuery = new GroupsQuery();
        groupsQuery.setGroupsKeyAndeq(groups.getGroupsKey());
        if (!groupsPersistent.isUnique(groupsQuery)) {
          throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { groupsPersistent.getNotUniqueErrorMessage(groupsQuery) });
        }
      }
      groupsPersistent.batchSaveGroups(groupss);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateGroups(Groups groups) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.updateGroups ");
      log.debug("parameter groups is : " + groups);
    }
    try {
      if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
      }
      if (ToolUtil.isNullStr(groups.getGroupsId())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupsId ");
      }
      Groups oldGroups = groupsPersistent.getGroupsByPk(groups.getGroupsId());
      if (oldGroups == null) {
        throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
      }
      GroupsQuery groupsQuery = new GroupsQuery();
      groupsQuery.setGroupsKeyAndeq(groups.getGroupsKey());
      if (!groupsQuery.getGroupsKeyAndeq().equals(oldGroups.getGroupsKey())) {
        if (!groupsPersistent.isUnique(groupsQuery)) {
          throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { groupsPersistent.getNotUniqueErrorMessage(groupsQuery) });
        }
      }
      groupsPersistent.updateGroups(groups);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateGroups(Collection<Groups> groupss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchUpdateGroups ");
      log.debug("parameter groupss is : " + groupss);
    }
    try {
      if (ToolUtil.isEmpty(groupss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupss ");
      }
      for (Groups groups : groupss) {
        if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
        }
        if (ToolUtil.isNullStr(groups.getGroupsId())) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupsId ");
        }
        Groups oldGroups = groupsPersistent.getGroupsByPk(groups.getGroupsId());
        if (oldGroups == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        GroupsQuery groupsQuery = new GroupsQuery();
        groupsQuery.setGroupsKeyAndeq(groups.getGroupsKey());
        if (!groupsQuery.getGroupsKeyAndeq().equals(oldGroups.getGroupsKey())) {
          if (!groupsPersistent.isUnique(groupsQuery)) {
            throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { groupsPersistent.getNotUniqueErrorMessage(groupsQuery) });
          }
        }
      }
      groupsPersistent.batchUpdateGroups(groupss);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeGroups(Groups groups) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.removeGroups ");
      log.debug("parameter groups is : " + groups);
    }
    try {
      if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
      }
      Set<Groups> groupsSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(groups.getGroupsId())) {
        GroupsQuery groupsQuery = ToolUtil.attributeReplication(GroupsQuery.class, groups);
        groupsSet.addAll(groupsPersistent.queryGroups(groupsQuery));
      } else {
        Groups oldGroups = groupsPersistent.getGroupsByPk(groups.getGroupsId());
        if (oldGroups == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        groupsSet.add(oldGroups);
      }
      if (ToolUtil.isNotEmpty(groupsSet)) {
        groupsPersistent.batchRemoveGroups(groupsSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveGroups(Collection<Groups> groupss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchRemoveGroups ");
      log.debug("parameter groupss is : " + groupss);
    }
    try {
      if (ToolUtil.isEmpty(groupss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupss ");
      }
      Set<Groups> groupsSet = new LinkedHashSet<>();
      for (Groups groups : groupss) {
        if (ToolUtil.isNullStr(groups.getGroupsId())) {
          GroupsQuery groupsQuery = ToolUtil.attributeReplication(GroupsQuery.class, groups);
          groupsSet.addAll(groupsPersistent.queryGroups(groupsQuery));
        } else {
          Groups oldGroups = groupsPersistent.getGroupsByPk(groups.getGroupsId());
          if (oldGroups == null) {
            throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
          }
          groupsSet.add(oldGroups);
        }
      }
      if (ToolUtil.isNotEmpty(groupsSet)) {
        groupsPersistent.batchRemoveGroups(groupsSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Long getCountGroups(GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getCountGroups ");
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    try {
      return groupsPersistent.getCountGroups(groupsQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Groups getGroupsByPk(java.lang.String groupsId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getGroupsByPk ");
      log.debug("parameter groupsId is : " + groupsId);
    }
    try {
      if (ToolUtil.isNullStr(groupsId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupsId ");
      }
      return groupsPersistent.getGroupsByPk(groupsId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<Groups> getAllGroups() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllGroups ");
    }
    try {
      return groupsPersistent.getAllGroups();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<Groups> pagingGetGroups(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetGroups ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return groupsPersistent.pagingGetGroups(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<Groups> queryGroups(GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryGroups ");
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    try {
      return groupsPersistent.queryGroups(groupsQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<Groups> pagingQueryGroups(Parameter parameter, GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryGroups ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return groupsPersistent.pagingQueryGroups(parameter, groupsQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public GroupsVO getGroupsVOByPk(java.lang.String groupsId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getGroupsVOByPk ");
      log.debug("parameter groupsId is : " + groupsId);
    }
    try {
      if (ToolUtil.isNullStr(groupsId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupsId ");
      }
      return groupsPersistent.getGroupsVOByPk(groupsId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<GroupsVO> getAllGroupsVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllGroupsVO ");
    }
    try {
      return groupsPersistent.getAllGroupsVO();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<GroupsVO> pagingGetGroupsVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetGroupsVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return groupsPersistent.pagingGetGroupsVO(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<GroupsVO> queryGroupsVO(GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryGroupsVO ");
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    try {
      return groupsPersistent.queryGroupsVO(groupsQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<GroupsVO> pagingQueryGroupsVO(Parameter parameter, GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryGroupsVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return groupsPersistent.pagingQueryGroupsVO(parameter, groupsQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @javax.annotation.Resource(name = "com.pro.sign.UserGroupsNexusPersistent")
  private IUserGroupsNexusPersistent userGroupsNexusPersistent;

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveUserGroupsNexus(UserGroupsNexus userGroupsNexus) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.saveUserGroupsNexus ");
      log.debug("parameter userGroupsNexus is : " + userGroupsNexus);
    }
    try {
      if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
      }
      userGroupsNexus.setNexusId(ToolUtil.getUUID());
      userGroupsNexusPersistent.saveUserGroupsNexus(userGroupsNexus);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveUserGroupsNexus(Collection<UserGroupsNexus> userGroupsNexuss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchSaveUserGroupsNexus ");
      log.debug("parameter userGroupsNexuss is : " + userGroupsNexuss);
    }
    try {
      if (ToolUtil.isEmpty(userGroupsNexuss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexuss ");
      }
      for (UserGroupsNexus userGroupsNexus : userGroupsNexuss) {
        if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
        }
        userGroupsNexus.setNexusId(ToolUtil.getUUID());
      }
      userGroupsNexusPersistent.batchSaveUserGroupsNexus(userGroupsNexuss);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateUserGroupsNexus(UserGroupsNexus userGroupsNexus) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.updateUserGroupsNexus ");
      log.debug("parameter userGroupsNexus is : " + userGroupsNexus);
    }
    try {
      if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
      }
      if (ToolUtil.isNullStr(userGroupsNexus.getNexusId())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " nexusId ");
      }
      UserGroupsNexus oldUserGroupsNexus = userGroupsNexusPersistent.getUserGroupsNexusByPk(userGroupsNexus.getNexusId());
      if (oldUserGroupsNexus == null) {
        throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
      }
      userGroupsNexusPersistent.updateUserGroupsNexus(userGroupsNexus);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateUserGroupsNexus(Collection<UserGroupsNexus> userGroupsNexuss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchUpdateUserGroupsNexus ");
      log.debug("parameter userGroupsNexuss is : " + userGroupsNexuss);
    }
    try {
      if (ToolUtil.isEmpty(userGroupsNexuss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexuss ");
      }
      for (UserGroupsNexus userGroupsNexus : userGroupsNexuss) {
        if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
        }
        if (ToolUtil.isNullStr(userGroupsNexus.getNexusId())) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " nexusId ");
        }
        UserGroupsNexus oldUserGroupsNexus = userGroupsNexusPersistent.getUserGroupsNexusByPk(userGroupsNexus.getNexusId());
        if (oldUserGroupsNexus == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
      }
      userGroupsNexusPersistent.batchUpdateUserGroupsNexus(userGroupsNexuss);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeUserGroupsNexus(UserGroupsNexus userGroupsNexus) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.removeUserGroupsNexus ");
      log.debug("parameter userGroupsNexus is : " + userGroupsNexus);
    }
    try {
      if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
      }
      Set<UserGroupsNexus> userGroupsNexusSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(userGroupsNexus.getNexusId())) {
        UserGroupsNexusQuery userGroupsNexusQuery = ToolUtil.attributeReplication(UserGroupsNexusQuery.class, userGroupsNexus);
        userGroupsNexusSet.addAll(userGroupsNexusPersistent.queryUserGroupsNexus(userGroupsNexusQuery));
      } else {
        UserGroupsNexus oldUserGroupsNexus = userGroupsNexusPersistent.getUserGroupsNexusByPk(userGroupsNexus.getNexusId());
        if (oldUserGroupsNexus == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        userGroupsNexusSet.add(oldUserGroupsNexus);
      }
      if (ToolUtil.isNotEmpty(userGroupsNexusSet)) {
        userGroupsNexusPersistent.batchRemoveUserGroupsNexus(userGroupsNexusSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveUserGroupsNexus(Collection<UserGroupsNexus> userGroupsNexuss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchRemoveUserGroupsNexus ");
      log.debug("parameter userGroupsNexuss is : " + userGroupsNexuss);
    }
    try {
      if (ToolUtil.isEmpty(userGroupsNexuss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexuss ");
      }
      Set<UserGroupsNexus> userGroupsNexusSet = new LinkedHashSet<>();
      for (UserGroupsNexus userGroupsNexus : userGroupsNexuss) {
        if (ToolUtil.isNullStr(userGroupsNexus.getNexusId())) {
          UserGroupsNexusQuery userGroupsNexusQuery = ToolUtil.attributeReplication(UserGroupsNexusQuery.class, userGroupsNexus);
          userGroupsNexusSet.addAll(userGroupsNexusPersistent.queryUserGroupsNexus(userGroupsNexusQuery));
        } else {
          UserGroupsNexus oldUserGroupsNexus = userGroupsNexusPersistent.getUserGroupsNexusByPk(userGroupsNexus.getNexusId());
          if (oldUserGroupsNexus == null) {
            throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
          }
          userGroupsNexusSet.add(oldUserGroupsNexus);
        }
      }
      if (ToolUtil.isNotEmpty(userGroupsNexusSet)) {
        userGroupsNexusPersistent.batchRemoveUserGroupsNexus(userGroupsNexusSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Long getCountUserGroupsNexus(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getCountUserGroupsNexus ");
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    try {
      return userGroupsNexusPersistent.getCountUserGroupsNexus(userGroupsNexusQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public UserGroupsNexus getUserGroupsNexusByPk(java.lang.String nexusId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getUserGroupsNexusByPk ");
      log.debug("parameter nexusId is : " + nexusId);
    }
    try {
      if (ToolUtil.isNullStr(nexusId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " nexusId ");
      }
      return userGroupsNexusPersistent.getUserGroupsNexusByPk(nexusId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<UserGroupsNexus> getAllUserGroupsNexus() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllUserGroupsNexus ");
    }
    try {
      return userGroupsNexusPersistent.getAllUserGroupsNexus();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<UserGroupsNexus> pagingGetUserGroupsNexus(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetUserGroupsNexus ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userGroupsNexusPersistent.pagingGetUserGroupsNexus(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<UserGroupsNexus> queryUserGroupsNexus(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryUserGroupsNexus ");
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    try {
      return userGroupsNexusPersistent.queryUserGroupsNexus(userGroupsNexusQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<UserGroupsNexus> pagingQueryUserGroupsNexus(Parameter parameter, UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryUserGroupsNexus ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userGroupsNexusPersistent.pagingQueryUserGroupsNexus(parameter, userGroupsNexusQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public UserGroupsNexusVO getUserGroupsNexusVOByPk(java.lang.String nexusId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getUserGroupsNexusVOByPk ");
      log.debug("parameter nexusId is : " + nexusId);
    }
    try {
      if (ToolUtil.isNullStr(nexusId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " nexusId ");
      }
      return userGroupsNexusPersistent.getUserGroupsNexusVOByPk(nexusId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<UserGroupsNexusVO> getAllUserGroupsNexusVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllUserGroupsNexusVO ");
    }
    try {
      return userGroupsNexusPersistent.getAllUserGroupsNexusVO();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<UserGroupsNexusVO> pagingGetUserGroupsNexusVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetUserGroupsNexusVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userGroupsNexusPersistent.pagingGetUserGroupsNexusVO(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<UserGroupsNexusVO> queryUserGroupsNexusVO(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryUserGroupsNexusVO ");
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    try {
      return userGroupsNexusPersistent.queryUserGroupsNexusVO(userGroupsNexusQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<UserGroupsNexusVO> pagingQueryUserGroupsNexusVO(Parameter parameter, UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryUserGroupsNexusVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return userGroupsNexusPersistent.pagingQueryUserGroupsNexusVO(parameter, userGroupsNexusQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @javax.annotation.Resource(name = "com.pro.sign.LoginLogPersistent")
  private ILoginLogPersistent loginLogPersistent;

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveLoginLog(LoginLog loginLog) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.saveLoginLog ");
      log.debug("parameter loginLog is : " + loginLog);
    }
    try {
      if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
      }
      loginLog.setLogId(ToolUtil.getUUID());
      loginLogPersistent.saveLoginLog(loginLog);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveLoginLog(Collection<LoginLog> loginLogs) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchSaveLoginLog ");
      log.debug("parameter loginLogs is : " + loginLogs);
    }
    try {
      if (ToolUtil.isEmpty(loginLogs)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLogs ");
      }
      for (LoginLog loginLog : loginLogs) {
        if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
        }
        loginLog.setLogId(ToolUtil.getUUID());
      }
      loginLogPersistent.batchSaveLoginLog(loginLogs);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateLoginLog(LoginLog loginLog) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.updateLoginLog ");
      log.debug("parameter loginLog is : " + loginLog);
    }
    try {
      if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
      }
      if (ToolUtil.isNullStr(loginLog.getLogId())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " logId ");
      }
      LoginLog oldLoginLog = loginLogPersistent.getLoginLogByPk(loginLog.getLogId());
      if (oldLoginLog == null) {
        throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
      }
      loginLogPersistent.updateLoginLog(loginLog);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateLoginLog(Collection<LoginLog> loginLogs) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchUpdateLoginLog ");
      log.debug("parameter loginLogs is : " + loginLogs);
    }
    try {
      if (ToolUtil.isEmpty(loginLogs)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLogs ");
      }
      for (LoginLog loginLog : loginLogs) {
        if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
        }
        if (ToolUtil.isNullStr(loginLog.getLogId())) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " logId ");
        }
        LoginLog oldLoginLog = loginLogPersistent.getLoginLogByPk(loginLog.getLogId());
        if (oldLoginLog == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
      }
      loginLogPersistent.batchUpdateLoginLog(loginLogs);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeLoginLog(LoginLog loginLog) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.removeLoginLog ");
      log.debug("parameter loginLog is : " + loginLog);
    }
    try {
      if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
      }
      Set<LoginLog> loginLogSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(loginLog.getLogId())) {
        LoginLogQuery loginLogQuery = ToolUtil.attributeReplication(LoginLogQuery.class, loginLog);
        loginLogSet.addAll(loginLogPersistent.queryLoginLog(loginLogQuery));
      } else {
        LoginLog oldLoginLog = loginLogPersistent.getLoginLogByPk(loginLog.getLogId());
        if (oldLoginLog == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        loginLogSet.add(oldLoginLog);
      }
      if (ToolUtil.isNotEmpty(loginLogSet)) {
        loginLogPersistent.batchRemoveLoginLog(loginLogSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveLoginLog(Collection<LoginLog> loginLogs) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchRemoveLoginLog ");
      log.debug("parameter loginLogs is : " + loginLogs);
    }
    try {
      if (ToolUtil.isEmpty(loginLogs)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLogs ");
      }
      Set<LoginLog> loginLogSet = new LinkedHashSet<>();
      for (LoginLog loginLog : loginLogs) {
        if (ToolUtil.isNullStr(loginLog.getLogId())) {
          LoginLogQuery loginLogQuery = ToolUtil.attributeReplication(LoginLogQuery.class, loginLog);
          loginLogSet.addAll(loginLogPersistent.queryLoginLog(loginLogQuery));
        } else {
          LoginLog oldLoginLog = loginLogPersistent.getLoginLogByPk(loginLog.getLogId());
          if (oldLoginLog == null) {
            throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
          }
          loginLogSet.add(oldLoginLog);
        }
      }
      if (ToolUtil.isNotEmpty(loginLogSet)) {
        loginLogPersistent.batchRemoveLoginLog(loginLogSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Long getCountLoginLog(LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getCountLoginLog ");
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    try {
      return loginLogPersistent.getCountLoginLog(loginLogQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public LoginLog getLoginLogByPk(java.lang.String logId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getLoginLogByPk ");
      log.debug("parameter logId is : " + logId);
    }
    try {
      if (ToolUtil.isNullStr(logId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " logId ");
      }
      return loginLogPersistent.getLoginLogByPk(logId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<LoginLog> getAllLoginLog() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllLoginLog ");
    }
    try {
      return loginLogPersistent.getAllLoginLog();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<LoginLog> pagingGetLoginLog(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetLoginLog ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return loginLogPersistent.pagingGetLoginLog(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<LoginLog> queryLoginLog(LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryLoginLog ");
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    try {
      return loginLogPersistent.queryLoginLog(loginLogQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<LoginLog> pagingQueryLoginLog(Parameter parameter, LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryLoginLog ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return loginLogPersistent.pagingQueryLoginLog(parameter, loginLogQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public LoginLogVO getLoginLogVOByPk(java.lang.String logId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getLoginLogVOByPk ");
      log.debug("parameter logId is : " + logId);
    }
    try {
      if (ToolUtil.isNullStr(logId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " logId ");
      }
      return loginLogPersistent.getLoginLogVOByPk(logId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<LoginLogVO> getAllLoginLogVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllLoginLogVO ");
    }
    try {
      return loginLogPersistent.getAllLoginLogVO();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<LoginLogVO> pagingGetLoginLogVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetLoginLogVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return loginLogPersistent.pagingGetLoginLogVO(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<LoginLogVO> queryLoginLogVO(LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.queryLoginLogVO ");
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    try {
      return loginLogPersistent.queryLoginLogVO(loginLogQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<LoginLogVO> pagingQueryLoginLogVO(Parameter parameter, LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQueryLoginLogVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return loginLogPersistent.pagingQueryLoginLogVO(parameter, loginLogQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @javax.annotation.Resource(name = "com.pro.sign.SessionPersistent")
  private ISessionPersistent sessionPersistent;

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveSession(Session session) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.saveSession ");
      log.debug("parameter session is : " + session);
    }
    try {
      if (session == null || ToolUtil.isNullEntityAllFieldValue(session)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " session ");
      }
      session.setSessionId(ToolUtil.getUUID());
      SessionQuery sessionQuery = new SessionQuery();
      sessionQuery.setAccountIdAndeq(session.getAccountId());
      sessionQuery.setLoginKeyAndeq(session.getLoginKey());
      if (!sessionPersistent.isUnique(sessionQuery)) {
        throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { sessionPersistent.getNotUniqueErrorMessage(sessionQuery) });
      }
      sessionPersistent.saveSession(session);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveSession(Collection<Session> sessions) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchSaveSession ");
      log.debug("parameter sessions is : " + sessions);
    }
    try {
      if (ToolUtil.isEmpty(sessions)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessions ");
      }
      for (Session session : sessions) {
        if (session == null || ToolUtil.isNullEntityAllFieldValue(session)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " session ");
        }
        session.setSessionId(ToolUtil.getUUID());
        SessionQuery sessionQuery = new SessionQuery();
        sessionQuery.setAccountIdAndeq(session.getAccountId());
        sessionQuery.setLoginKeyAndeq(session.getLoginKey());
        if (!sessionPersistent.isUnique(sessionQuery)) {
          throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { sessionPersistent.getNotUniqueErrorMessage(sessionQuery) });
        }
      }
      sessionPersistent.batchSaveSession(sessions);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateSession(Session session) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.updateSession ");
      log.debug("parameter session is : " + session);
    }
    try {
      if (session == null || ToolUtil.isNullEntityAllFieldValue(session)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " session ");
      }
      if (ToolUtil.isNullStr(session.getSessionId())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessionId ");
      }
      Session oldSession = sessionPersistent.getSessionByPk(session.getSessionId());
      if (oldSession == null) {
        throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
      }
      SessionQuery sessionQuery = new SessionQuery();
      sessionQuery.setAccountIdAndeq(session.getAccountId());
      sessionQuery.setLoginKeyAndeq(session.getLoginKey());
      if (!(sessionQuery.getAccountIdAndeq().equals(oldSession.getAccountId()) && sessionQuery.getLoginKeyAndeq().equals(oldSession.getLoginKey()))) {
        if (!sessionPersistent.isUnique(sessionQuery)) {
          throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { sessionPersistent.getNotUniqueErrorMessage(sessionQuery) });
        }
      }
      sessionPersistent.updateSession(session);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateSession(Collection<Session> sessions) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchUpdateSession ");
      log.debug("parameter sessions is : " + sessions);
    }
    try {
      if (ToolUtil.isEmpty(sessions)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessions ");
      }
      for (Session session : sessions) {
        if (session == null || ToolUtil.isNullEntityAllFieldValue(session)) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " session ");
        }
        if (ToolUtil.isNullStr(session.getSessionId())) {
          throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessionId ");
        }
        Session oldSession = sessionPersistent.getSessionByPk(session.getSessionId());
        if (oldSession == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        SessionQuery sessionQuery = new SessionQuery();
        sessionQuery.setAccountIdAndeq(session.getAccountId());
        sessionQuery.setLoginKeyAndeq(session.getLoginKey());
        if (!(sessionQuery.getAccountIdAndeq().equals(oldSession.getAccountId()) && sessionQuery.getLoginKeyAndeq().equals(oldSession.getLoginKey()))) {
          if (!sessionPersistent.isUnique(sessionQuery)) {
            throw SignException.getException(SignException.FW_DATA_CONTENTION_ERROR, new String[] { sessionPersistent.getNotUniqueErrorMessage(sessionQuery) });
          }
        }
      }
      sessionPersistent.batchUpdateSession(sessions);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeSession(Session session) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.removeSession ");
      log.debug("parameter session is : " + session);
    }
    try {
      if (session == null || ToolUtil.isNullEntityAllFieldValue(session)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " session ");
      }
      Set<Session> sessionSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(session.getSessionId())) {
        SessionQuery sessionQuery = ToolUtil.attributeReplication(SessionQuery.class, session);
        sessionSet.addAll(sessionPersistent.querySession(sessionQuery));
      } else {
        Session oldSession = sessionPersistent.getSessionByPk(session.getSessionId());
        if (oldSession == null) {
          throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        sessionSet.add(oldSession);
      }
      if (ToolUtil.isNotEmpty(sessionSet)) {
        sessionPersistent.batchRemoveSession(sessionSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveSession(Collection<Session> sessions) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.batchRemoveSession ");
      log.debug("parameter sessions is : " + sessions);
    }
    try {
      if (ToolUtil.isEmpty(sessions)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessions ");
      }
      Set<Session> sessionSet = new LinkedHashSet<>();
      for (Session session : sessions) {
        if (ToolUtil.isNullStr(session.getSessionId())) {
          SessionQuery sessionQuery = ToolUtil.attributeReplication(SessionQuery.class, session);
          sessionSet.addAll(sessionPersistent.querySession(sessionQuery));
        } else {
          Session oldSession = sessionPersistent.getSessionByPk(session.getSessionId());
          if (oldSession == null) {
            throw SignException.getException(SignException.FW_UPDATE_DATA_NOT_FIND_ERROR);
          }
          sessionSet.add(oldSession);
        }
      }
      if (ToolUtil.isNotEmpty(sessionSet)) {
        sessionPersistent.batchRemoveSession(sessionSet);
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Long getCountSession(SessionQuery sessionQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getCountSession ");
      log.debug("parameter sessionQuery is : " + sessionQuery);
    }
    try {
      return sessionPersistent.getCountSession(sessionQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Session getSessionByPk(java.lang.String sessionId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getSessionByPk ");
      log.debug("parameter sessionId is : " + sessionId);
    }
    try {
      if (ToolUtil.isNullStr(sessionId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessionId ");
      }
      return sessionPersistent.getSessionByPk(sessionId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<Session> getAllSession() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllSession ");
    }
    try {
      return sessionPersistent.getAllSession();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<Session> pagingGetSession(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetSession ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return sessionPersistent.pagingGetSession(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<Session> querySession(SessionQuery sessionQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.querySession ");
      log.debug("parameter sessionQuery is : " + sessionQuery);
    }
    try {
      return sessionPersistent.querySession(sessionQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<Session> pagingQuerySession(Parameter parameter, SessionQuery sessionQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQuerySession ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter sessionQuery is : " + sessionQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return sessionPersistent.pagingQuerySession(parameter, sessionQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public SessionVO getSessionVOByPk(java.lang.String sessionId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getSessionVOByPk ");
      log.debug("parameter sessionId is : " + sessionId);
    }
    try {
      if (ToolUtil.isNullStr(sessionId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessionId ");
      }
      return sessionPersistent.getSessionVOByPk(sessionId);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<SessionVO> getAllSessionVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.getAllSessionVO ");
    }
    try {
      return sessionPersistent.getAllSessionVO();
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<SessionVO> pagingGetSessionVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingGetSessionVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return sessionPersistent.pagingGetSessionVO(parameter);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<SessionVO> querySessionVO(SessionQuery sessionQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.querySessionVO ");
      log.debug("parameter sessionQuery is : " + sessionQuery);
    }
    try {
      return sessionPersistent.querySessionVO(sessionQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<SessionVO> pagingQuerySessionVO(Parameter parameter, SessionQuery sessionQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SignService.pagingQuerySessionVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter sessionQuery is : " + sessionQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return sessionPersistent.pagingQuerySessionVO(parameter, sessionQuery);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

}
