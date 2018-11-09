package com.pro.sign.persistent.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.pro.sign.entity.UserGroupsNexus;
import com.pro.sign.exception.SignException;
import com.pro.sign.persistent.IUserGroupsNexusPersistent;
import com.pro.sign.query.UserGroupsNexusQuery;
import com.pro.sign.vo.UserGroupsNexusVO;
import com.pro.tool.persistent.implement.ToolPersistent;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Repository("com.pro.sign.UserGroupsNexusPersistent")
public class UserGroupsNexusPersistentImpl extends ToolPersistent implements IUserGroupsNexusPersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UserGroupsNexusPersistentImpl.class);

  public static final String TABLE_ALIAS = "userGroupsNexus";

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
  public void saveUserGroupsNexus(UserGroupsNexus userGroupsNexus) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.saveUserGroupsNexus ");
      log.debug("parameter userGroupsNexus is : " + userGroupsNexus);
    }
    try {
      if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
      }
      this.insert(INSERT_SQL, userGroupsNexus);
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
  public void batchSaveUserGroupsNexus(Collection<UserGroupsNexus> userGroupsNexuss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.batchSaveUserGroupsNexus ");
      log.debug("parameter userGroupsNexuss is : " + userGroupsNexuss);
    }
    try {
      if (ToolUtil.isEmpty(userGroupsNexuss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexuss ");
      }
      this.insert(INSERT_SQL, userGroupsNexuss);
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
  public void updateUserGroupsNexus(UserGroupsNexus userGroupsNexus) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.updateUserGroupsNexus ");
      log.debug("parameter userGroupsNexus is : " + userGroupsNexus);
    }
    try {
      if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
      }
      this.update(UPDATE_SQL, userGroupsNexus);
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
  public void batchUpdateUserGroupsNexus(Collection<UserGroupsNexus> userGroupsNexuss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.batchUpdateUserGroupsNexus ");
      log.debug("parameter userGroupsNexuss is : " + userGroupsNexuss);
    }
    try {
      if (ToolUtil.isEmpty(userGroupsNexuss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexuss ");
      }
      this.update(UPDATE_SQL, userGroupsNexuss);
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
  public void removeUserGroupsNexus(UserGroupsNexus userGroupsNexus) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.removeUserGroupsNexus ");
      log.debug("parameter userGroupsNexus is : " + userGroupsNexus);
    }
    try {
      if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, userGroupsNexus.getNexusId());
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
  public void batchRemoveUserGroupsNexus(Collection<UserGroupsNexus> userGroupsNexuss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.batchRemoveUserGroupsNexus ");
      log.debug("parameter userGroupsNexuss is : " + userGroupsNexuss);
    }
    try {
      if (ToolUtil.isEmpty(userGroupsNexuss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexuss ");
      }
      this.del(DEL_SQL_BY_PK, userGroupsNexuss);
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
  public Long getCountUserGroupsNexus(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.getCountUserGroupsNexus ");
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userGroupsNexusQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userGroupsNexusQuery));
      }
      return this.queryCount(countSql, userGroupsNexusQuery, Long.class);
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
  public UserGroupsNexus getUserGroupsNexusByPk(java.lang.String nexusId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.getUserGroupsNexusByPk ");
      log.debug("parameter nexusId is : " + nexusId);
    }
    try {
      if (ToolUtil.isNullStr(nexusId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " nexusId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, nexusId);
        }
      }
      Collection<UserGroupsNexus> userGroupsNexusSet = this.query(querySql, mapSqlParameterSource, UserGroupsNexus.class);
      return ToolUtil.isNotEmpty(userGroupsNexusSet) ? userGroupsNexusSet.iterator().next() : null;
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
  public Collection<UserGroupsNexus> getAllUserGroupsNexus() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.getAllUserGroupsNexus ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, UserGroupsNexus.class);
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
  public Paging<UserGroupsNexus> pagingGetUserGroupsNexus(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.pagingGetUserGroupsNexus ");
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
      Paging<UserGroupsNexus> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<UserGroupsNexus> userGroupsNexusSet = this.query(querySql, UserGroupsNexus.class);
        if (ToolUtil.isNotEmpty(userGroupsNexusSet)) {
          Set<String> inNexusId = new LinkedHashSet<>();
          for (UserGroupsNexus userGroupsNexus : userGroupsNexusSet) {
            inNexusId.add(userGroupsNexus.getNexusId());
          }
          UserGroupsNexusQuery userGroupsNexusQuery = new UserGroupsNexusQuery();
          userGroupsNexusQuery.setNexusIdAndin(new ArrayList<>(inNexusId));
          Collection<UserGroupsNexus> rUserGroupsNexusSet = this.queryUserGroupsNexus(userGroupsNexusQuery);
          if (ToolUtil.isNotEmpty(rUserGroupsNexusSet)) {
            paging.setData(rUserGroupsNexusSet);
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
  public Collection<UserGroupsNexus> queryUserGroupsNexus(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.queryUserGroupsNexus ");
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userGroupsNexusQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userGroupsNexusQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, UserGroupsNexus.class, userGroupsNexusQuery);
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
  public Paging<UserGroupsNexus> pagingQueryUserGroupsNexus(Parameter parameter, UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.pagingQueryUserGroupsNexus ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
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
      Paging<UserGroupsNexus> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userGroupsNexusQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<UserGroupsNexus> userGroupsNexusSet = this.query(querySql, UserGroupsNexus.class, userGroupsNexusQuery);
        if (ToolUtil.isNotEmpty(userGroupsNexusSet)) {
          Set<String> inNexusId = new LinkedHashSet<>();
          for (UserGroupsNexus userGroupsNexus : userGroupsNexusSet) {
            inNexusId.add(userGroupsNexus.getNexusId());
          }
          UserGroupsNexusQuery rUserGroupsNexusQuery = new UserGroupsNexusQuery();
          rUserGroupsNexusQuery.setNexusIdAndin(new ArrayList<>(inNexusId));
          Collection<UserGroupsNexus> rUserGroupsNexusSet = this.queryUserGroupsNexus(rUserGroupsNexusQuery);
          if (ToolUtil.isNotEmpty(rUserGroupsNexusSet)) {
            paging.setData(rUserGroupsNexusSet);
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
  public boolean isUnique(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.isUnique ");
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userGroupsNexusQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userGroupsNexusQuery));
      }
      Long count = this.queryCount(countSql, userGroupsNexusQuery, Long.class);
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
  public String getNotUniqueErrorMessage(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    return this.getNotUniqueErrorMsg(COLUMNS, COLUMNS_PARAMETER, userGroupsNexusQuery).toString();
  }

  @Override
  public UserGroupsNexusVO getUserGroupsNexusVOByPk(java.lang.String nexusId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.getUserGroupsNexusVOByPk ");
      log.debug("parameter nexusId is : " + nexusId);
    }
    try {
      if (ToolUtil.isNullStr(nexusId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " nexusId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, nexusId);
        }
      }
      Collection<UserGroupsNexusVO> userGroupsNexusVOSet = this.query(querySql, mapSqlParameterSource, UserGroupsNexusVO.class);
      return ToolUtil.isNotEmpty(userGroupsNexusVOSet) ? userGroupsNexusVOSet.iterator().next() : null;
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
  public Collection<UserGroupsNexusVO> getAllUserGroupsNexusVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.getAllUserGroupsNexusVO ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, UserGroupsNexusVO.class);
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
  public Paging<UserGroupsNexusVO> pagingGetUserGroupsNexusVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.pagingGetUserGroupsNexusVO ");
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
      Paging<UserGroupsNexusVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<UserGroupsNexus> userGroupsNexusSet = this.query(querySql, UserGroupsNexus.class);
        if (ToolUtil.isNotEmpty(userGroupsNexusSet)) {
          Set<String> inNexusId = new LinkedHashSet<>();
          for (UserGroupsNexus userGroupsNexus : userGroupsNexusSet) {
            inNexusId.add(userGroupsNexus.getNexusId());
          }
          UserGroupsNexusQuery userGroupsNexusQuery = new UserGroupsNexusQuery();
          userGroupsNexusQuery.setNexusIdAndin(new ArrayList<>(inNexusId));
          Collection<UserGroupsNexusVO> rUserGroupsNexusVOSet = this.queryUserGroupsNexusVO(userGroupsNexusQuery);
          if (ToolUtil.isNotEmpty(rUserGroupsNexusVOSet)) {
            paging.setData(rUserGroupsNexusVOSet);
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
  public Collection<UserGroupsNexusVO> queryUserGroupsNexusVO(UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.queryUserGroupsNexusVO ");
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(userGroupsNexusQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userGroupsNexusQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, UserGroupsNexusVO.class, userGroupsNexusQuery);
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
  public Paging<UserGroupsNexusVO> pagingQueryUserGroupsNexusVO(Parameter parameter, UserGroupsNexusQuery userGroupsNexusQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusPersistent.pagingQueryUserGroupsNexusVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
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
      Paging<UserGroupsNexusVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, userGroupsNexusQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<UserGroupsNexus> userGroupsNexusSet = this.query(querySql, UserGroupsNexus.class, userGroupsNexusQuery);
        if (ToolUtil.isNotEmpty(userGroupsNexusSet)) {
          Set<String> inNexusId = new LinkedHashSet<>();
          for (UserGroupsNexus userGroupsNexus : userGroupsNexusSet) {
            inNexusId.add(userGroupsNexus.getNexusId());
          }
          UserGroupsNexusQuery rUserGroupsNexusQuery = new UserGroupsNexusQuery();
          rUserGroupsNexusQuery.setNexusIdAndin(new ArrayList<>(inNexusId));
          Collection<UserGroupsNexusVO> rUserGroupsNexusVOSet = this.queryUserGroupsNexusVO(rUserGroupsNexusQuery);
          if (ToolUtil.isNotEmpty(rUserGroupsNexusVOSet)) {
            paging.setData(rUserGroupsNexusVOSet);
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
