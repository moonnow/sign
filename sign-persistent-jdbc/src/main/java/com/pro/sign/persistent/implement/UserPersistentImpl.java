package com.pro.sign.persistent.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.pro.sign.entity.User;
import com.pro.sign.exception.SignException;
import com.pro.sign.persistent.IUserPersistent;
import com.pro.sign.query.UserQuery;
import com.pro.sign.vo.UserVO;
import com.pro.tool.persistent.implement.ToolPersistent;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Repository("com.pro.sign.UserPersistent")
public class UserPersistentImpl extends ToolPersistent implements IUserPersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UserPersistentImpl.class);

  public static final String TABLE_ALIAS = "user";

  public static final LinkedHashSet<String> PRIMARY_KEY = new LinkedHashSet<>();
  public static final LinkedHashSet<String> COLUMNS = new LinkedHashSet<>();
  public static final LinkedHashMap<String, String> COLUMNS_PARAMETER = new LinkedHashMap<>();
  public static final LinkedHashSet<String> VIRTUAL_COLUMNS = new LinkedHashSet<>();
  public static final LinkedHashMap<String, String> SORT = new LinkedHashMap<>();

  private static StringBuilder INSERT_SQL = new StringBuilder();
  private static StringBuilder UPDATE_SQL = new StringBuilder();
  private static StringBuilder DEL_SQL_BY_PK = new StringBuilder();
  public static StringBuilder SELECT_SQL = new StringBuilder();
  public static StringBuilder SELECT_VO_SQL = new StringBuilder();
  public static StringBuilder COUNT_SQL = new StringBuilder();
  public static StringBuilder COLUMN_LIST_ALIAS = new StringBuilder();
  public static StringBuilder COLUMN_LIST_NOT_ALIAS = new StringBuilder();

  @PostConstruct
  private void init() {
    super.init(TABLE_NAME, PRIMARY_KEY, COLUMNS, COLUMNS_PARAMETER, VIRTUAL_COLUMNS, SORT);
    INSERT_SQL = getInsertSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER);
    UPDATE_SQL = getUpdateSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, PRIMARY_KEY);
    DEL_SQL_BY_PK = getDelSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY);
    SELECT_SQL = getSelectSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS);
    SELECT_VO_SQL = getSelectSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, VIRTUAL_COLUMNS, PRIMARY_KEY, TABLE_ALIAS);
    COUNT_SQL = getCountSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS);
    COLUMN_LIST_ALIAS = getColumnList(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS);
    COLUMN_LIST_NOT_ALIAS = getColumnList(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER);
  }

  @Override
  public void saveUser(User user) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.saveUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
      }
      this.insert(INSERT_SQL, user);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public void batchSaveUser(Collection<User> users) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.batchSaveUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (ToolUtil.isEmpty(users)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " users ");
      }
      this.insert(INSERT_SQL, users);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public void updateUser(User user) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.updateUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
      }
      this.update(UPDATE_SQL, user);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public void batchUpdateUser(Collection<User> users) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.batchUpdateUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (ToolUtil.isEmpty(users)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " users ");
      }
      this.update(UPDATE_SQL, users);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public void removeUser(User user) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.removeUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, user.getUserId());
        }
      }
      this.del(DEL_SQL_BY_PK, mapSqlParameterSource);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public void batchRemoveUser(Collection<User> users) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.batchRemoveUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (ToolUtil.isEmpty(users)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " users ");
      }
      this.del(DEL_SQL_BY_PK, users);
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call UserPersistent.getCountUser ");
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userQuery));
      }
      return this.queryCount(countSql, userQuery, Long.class);
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call UserPersistent.getUserByPk ");
      log.debug("parameter userId is : " + userId);
    }
    try {
      if (ToolUtil.isNullStr(userId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, userId);
        }
      }
      Collection<User> userSet = this.query(querySql, mapSqlParameterSource, User.class);
      return ToolUtil.isNotEmpty(userSet) ? userSet.iterator().next() : null;
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call UserPersistent.getAllUser ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, User.class);
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call UserPersistent.pagingGetUser ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      if (parameter.getRows() < 0) {
        throw SignException.getException(SignException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " rows ", " 大于等于0" });
      }
      if (parameter.getPage() < 1) {
        throw SignException.getException(SignException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " page ", " 大于等于1" });
      }
      Paging<User> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<User> userSet = this.query(querySql, User.class);
        if (ToolUtil.isNotEmpty(userSet)) {
          Set<String> inUserId = new LinkedHashSet<>();
          for (User user : userSet) {
            inUserId.add(user.getUserId());
          }
          UserQuery userQuery = new UserQuery();
          userQuery.setUserIdAndin(new ArrayList<>(inUserId));
          Collection<User> rUserSet = this.queryUser(userQuery);
          if (ToolUtil.isNotEmpty(rUserSet)) {
            paging.setData(rUserSet);
          }
        }
      }
      return paging;
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call UserPersistent.queryUser ");
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, User.class, userQuery);
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call UserPersistent.pagingQueryUser ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      if (parameter == null) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      if (parameter.getRows() < 0) {
        throw SignException.getException(SignException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " rows ", " 大于等于0" });
      }
      if (parameter.getPage() < 1) {
        throw SignException.getException(SignException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " page ", " 大于等于1" });
      }
      Paging<User> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<User> userSet = this.query(querySql, User.class, userQuery);
        if (ToolUtil.isNotEmpty(userSet)) {
          Set<String> inUserId = new LinkedHashSet<>();
          for (User user : userSet) {
            inUserId.add(user.getUserId());
          }
          UserQuery rUserQuery = new UserQuery();
          rUserQuery.setUserIdAndin(new ArrayList<>(inUserId));
          Collection<User> rUserSet = this.queryUser(rUserQuery);
          if (ToolUtil.isNotEmpty(rUserSet)) {
            paging.setData(rUserSet);
          }
        }
      }
      return paging;
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public boolean isUnique(UserQuery userQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.isUnique ");
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userQuery));
      }
      Long count = this.queryCount(countSql, userQuery, Long.class);
      return count < 1;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public String getNotUniqueErrorMessage(UserQuery userQuery) throws SignException {
    return this.getNotUniqueErrorMsg(COLUMNS, COLUMNS_PARAMETER, userQuery).toString();
  }

  @Override
  public UserVO getUserVOByPk(java.lang.String userId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserPersistent.getUserVOByPk ");
      log.debug("parameter userId is : " + userId);
    }
    try {
      if (ToolUtil.isNullStr(userId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, userId);
        }
      }
      Collection<UserVO> userVOSet = this.query(querySql, mapSqlParameterSource, UserVO.class);
      return ToolUtil.isNotEmpty(userVOSet) ? userVOSet.iterator().next() : null;
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call UserPersistent.getAllUserVO ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, UserVO.class);
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call UserPersistent.pagingGetUserVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      if (parameter.getRows() < 0) {
        throw SignException.getException(SignException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " rows ", " 大于等于0" });
      }
      if (parameter.getPage() < 1) {
        throw SignException.getException(SignException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " page ", " 大于等于1" });
      }
      Paging<UserVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<User> userSet = this.query(querySql, User.class);
        if (ToolUtil.isNotEmpty(userSet)) {
          Set<String> inUserId = new LinkedHashSet<>();
          for (User user : userSet) {
            inUserId.add(user.getUserId());
          }
          UserQuery userQuery = new UserQuery();
          userQuery.setUserIdAndin(new ArrayList<>(inUserId));
          Collection<UserVO> rUserVOSet = this.queryUserVO(userQuery);
          if (ToolUtil.isNotEmpty(rUserVOSet)) {
            paging.setData(rUserVOSet);
          }
        }
      }
      return paging;
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call UserPersistent.queryUserVO ");
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, UserVO.class, userQuery);
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call UserPersistent.pagingQueryUserVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userQuery is : " + userQuery);
    }
    try {
      if (parameter == null) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      if (parameter.getRows() < 0) {
        throw SignException.getException(SignException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " rows ", " 大于等于0" });
      }
      if (parameter.getPage() < 1) {
        throw SignException.getException(SignException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " page ", " 大于等于1" });
      }
      Paging<UserVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<User> userSet = this.query(querySql, User.class, userQuery);
        if (ToolUtil.isNotEmpty(userSet)) {
          Set<String> inUserId = new LinkedHashSet<>();
          for (User user : userSet) {
            inUserId.add(user.getUserId());
          }
          UserQuery rUserQuery = new UserQuery();
          rUserQuery.setUserIdAndin(new ArrayList<>(inUserId));
          Collection<UserVO> rUserVOSet = this.queryUserVO(rUserQuery);
          if (ToolUtil.isNotEmpty(rUserVOSet)) {
            paging.setData(rUserVOSet);
          }
        }
      }
      return paging;
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

}
