package com.pro.sign.persistent.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.pro.sign.entity.UserInfo;
import com.pro.sign.exception.SignException;
import com.pro.sign.persistent.IUserInfoPersistent;
import com.pro.sign.query.UserInfoQuery;
import com.pro.sign.vo.UserInfoVO;
import com.pro.tool.persistent.implement.ToolPersistent;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Repository("com.pro.sign.UserInfoPersistent")
public class UserInfoPersistentImpl extends ToolPersistent implements IUserInfoPersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UserInfoPersistentImpl.class);

  public static final String TABLE_ALIAS = "userInfo";

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
  public void saveUserInfo(UserInfo userInfo) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.saveUserInfo ");
      log.debug("parameter userInfo is : " + userInfo);
    }
    try {
      if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
      }
      this.insert(INSERT_SQL, userInfo);
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
  public void batchSaveUserInfo(Collection<UserInfo> userInfos) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.batchSaveUserInfo ");
      log.debug("parameter userInfos is : " + userInfos);
    }
    try {
      if (ToolUtil.isEmpty(userInfos)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfos ");
      }
      this.insert(INSERT_SQL, userInfos);
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
  public void updateUserInfo(UserInfo userInfo) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.updateUserInfo ");
      log.debug("parameter userInfo is : " + userInfo);
    }
    try {
      if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
      }
      this.update(UPDATE_SQL, userInfo);
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
  public void batchUpdateUserInfo(Collection<UserInfo> userInfos) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.batchUpdateUserInfo ");
      log.debug("parameter userInfos is : " + userInfos);
    }
    try {
      if (ToolUtil.isEmpty(userInfos)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfos ");
      }
      this.update(UPDATE_SQL, userInfos);
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
  public void removeUserInfo(UserInfo userInfo) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.removeUserInfo ");
      log.debug("parameter userInfo is : " + userInfo);
    }
    try {
      if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, userInfo.getUserInfoId());
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
  public void batchRemoveUserInfo(Collection<UserInfo> userInfos) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.batchRemoveUserInfo ");
      log.debug("parameter userInfos is : " + userInfos);
    }
    try {
      if (ToolUtil.isEmpty(userInfos)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfos ");
      }
      this.del(DEL_SQL_BY_PK, userInfos);
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
  public Long getCountUserInfo(UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.getCountUserInfo ");
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userInfoQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userInfoQuery));
      }
      return this.queryCount(countSql, userInfoQuery, Long.class);
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
  public UserInfo getUserInfoByPk(java.lang.String userInfoId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.getUserInfoByPk ");
      log.debug("parameter userInfoId is : " + userInfoId);
    }
    try {
      if (ToolUtil.isNullStr(userInfoId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfoId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, userInfoId);
        }
      }
      Collection<UserInfo> userInfoSet = this.query(querySql, mapSqlParameterSource, UserInfo.class);
      return ToolUtil.isNotEmpty(userInfoSet) ? userInfoSet.iterator().next() : null;
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
  public Collection<UserInfo> getAllUserInfo() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.getAllUserInfo ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, UserInfo.class);
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
  public Paging<UserInfo> pagingGetUserInfo(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.pagingGetUserInfo ");
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
      Paging<UserInfo> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<UserInfo> userInfoSet = this.query(querySql, UserInfo.class);
        if (ToolUtil.isNotEmpty(userInfoSet)) {
          Set<String> inUserInfoId = new LinkedHashSet<>();
          for (UserInfo userInfo : userInfoSet) {
            inUserInfoId.add(userInfo.getUserInfoId());
          }
          UserInfoQuery userInfoQuery = new UserInfoQuery();
          userInfoQuery.setUserInfoIdAndin(new ArrayList<>(inUserInfoId));
          Collection<UserInfo> rUserInfoSet = this.queryUserInfo(userInfoQuery);
          if (ToolUtil.isNotEmpty(rUserInfoSet)) {
            paging.setData(rUserInfoSet);
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
  public Collection<UserInfo> queryUserInfo(UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.queryUserInfo ");
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userInfoQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userInfoQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, UserInfo.class, userInfoQuery);
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
  public Paging<UserInfo> pagingQueryUserInfo(Parameter parameter, UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.pagingQueryUserInfo ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
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
      Paging<UserInfo> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userInfoQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<UserInfo> userInfoSet = this.query(querySql, UserInfo.class, userInfoQuery);
        if (ToolUtil.isNotEmpty(userInfoSet)) {
          Set<String> inUserInfoId = new LinkedHashSet<>();
          for (UserInfo userInfo : userInfoSet) {
            inUserInfoId.add(userInfo.getUserInfoId());
          }
          UserInfoQuery rUserInfoQuery = new UserInfoQuery();
          rUserInfoQuery.setUserInfoIdAndin(new ArrayList<>(inUserInfoId));
          Collection<UserInfo> rUserInfoSet = this.queryUserInfo(rUserInfoQuery);
          if (ToolUtil.isNotEmpty(rUserInfoSet)) {
            paging.setData(rUserInfoSet);
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
  public boolean isUnique(UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.isUnique ");
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userInfoQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userInfoQuery));
      }
      Long count = this.queryCount(countSql, userInfoQuery, Long.class);
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
  public String getNotUniqueErrorMessage(UserInfoQuery userInfoQuery) throws SignException {
    return this.getNotUniqueErrorMsg(COLUMNS, COLUMNS_PARAMETER, userInfoQuery).toString();
  }

  @Override
  public UserInfoVO getUserInfoVOByPk(java.lang.String userInfoId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.getUserInfoVOByPk ");
      log.debug("parameter userInfoId is : " + userInfoId);
    }
    try {
      if (ToolUtil.isNullStr(userInfoId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfoId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, userInfoId);
        }
      }
      Collection<UserInfoVO> userInfoVOSet = this.query(querySql, mapSqlParameterSource, UserInfoVO.class);
      return ToolUtil.isNotEmpty(userInfoVOSet) ? userInfoVOSet.iterator().next() : null;
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
  public Collection<UserInfoVO> getAllUserInfoVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.getAllUserInfoVO ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, UserInfoVO.class);
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
  public Paging<UserInfoVO> pagingGetUserInfoVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.pagingGetUserInfoVO ");
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
      Paging<UserInfoVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<UserInfo> userInfoSet = this.query(querySql, UserInfo.class);
        if (ToolUtil.isNotEmpty(userInfoSet)) {
          Set<String> inUserInfoId = new LinkedHashSet<>();
          for (UserInfo userInfo : userInfoSet) {
            inUserInfoId.add(userInfo.getUserInfoId());
          }
          UserInfoQuery userInfoQuery = new UserInfoQuery();
          userInfoQuery.setUserInfoIdAndin(new ArrayList<>(inUserInfoId));
          Collection<UserInfoVO> rUserInfoVOSet = this.queryUserInfoVO(userInfoQuery);
          if (ToolUtil.isNotEmpty(rUserInfoVOSet)) {
            paging.setData(rUserInfoVOSet);
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
  public Collection<UserInfoVO> queryUserInfoVO(UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.queryUserInfoVO ");
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userInfoQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userInfoQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, UserInfoVO.class, userInfoQuery);
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
  public Paging<UserInfoVO> pagingQueryUserInfoVO(Parameter parameter, UserInfoQuery userInfoQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoPersistent.pagingQueryUserInfoVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
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
      Paging<UserInfoVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userInfoQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<UserInfo> userInfoSet = this.query(querySql, UserInfo.class, userInfoQuery);
        if (ToolUtil.isNotEmpty(userInfoSet)) {
          Set<String> inUserInfoId = new LinkedHashSet<>();
          for (UserInfo userInfo : userInfoSet) {
            inUserInfoId.add(userInfo.getUserInfoId());
          }
          UserInfoQuery rUserInfoQuery = new UserInfoQuery();
          rUserInfoQuery.setUserInfoIdAndin(new ArrayList<>(inUserInfoId));
          Collection<UserInfoVO> rUserInfoVOSet = this.queryUserInfoVO(rUserInfoQuery);
          if (ToolUtil.isNotEmpty(rUserInfoVOSet)) {
            paging.setData(rUserInfoVOSet);
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
