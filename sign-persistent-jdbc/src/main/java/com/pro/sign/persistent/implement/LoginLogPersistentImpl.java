package com.pro.sign.persistent.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.pro.sign.entity.LoginLog;
import com.pro.sign.exception.SignException;
import com.pro.sign.persistent.ILoginLogPersistent;
import com.pro.sign.query.LoginLogQuery;
import com.pro.sign.vo.LoginLogVO;
import com.pro.tool.persistent.implement.ToolPersistent;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Repository("com.pro.sign.LoginLogPersistent")
public class LoginLogPersistentImpl extends ToolPersistent implements ILoginLogPersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(LoginLogPersistentImpl.class);

  public static final String TABLE_ALIAS = "loginLog";

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
  public void saveLoginLog(LoginLog loginLog) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.saveLoginLog ");
      log.debug("parameter loginLog is : " + loginLog);
    }
    try {
      if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
      }
      this.insert(INSERT_SQL, loginLog);
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
  public void batchSaveLoginLog(Collection<LoginLog> loginLogs) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.batchSaveLoginLog ");
      log.debug("parameter loginLogs is : " + loginLogs);
    }
    try {
      if (ToolUtil.isEmpty(loginLogs)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLogs ");
      }
      this.insert(INSERT_SQL, loginLogs);
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
  public void updateLoginLog(LoginLog loginLog) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.updateLoginLog ");
      log.debug("parameter loginLog is : " + loginLog);
    }
    try {
      if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
      }
      this.update(UPDATE_SQL, loginLog);
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
  public void batchUpdateLoginLog(Collection<LoginLog> loginLogs) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.batchUpdateLoginLog ");
      log.debug("parameter loginLogs is : " + loginLogs);
    }
    try {
      if (ToolUtil.isEmpty(loginLogs)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLogs ");
      }
      this.update(UPDATE_SQL, loginLogs);
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
  public void removeLoginLog(LoginLog loginLog) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.removeLoginLog ");
      log.debug("parameter loginLog is : " + loginLog);
    }
    try {
      if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, loginLog.getLogId());
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
  public void batchRemoveLoginLog(Collection<LoginLog> loginLogs) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.batchRemoveLoginLog ");
      log.debug("parameter loginLogs is : " + loginLogs);
    }
    try {
      if (ToolUtil.isEmpty(loginLogs)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLogs ");
      }
      this.del(DEL_SQL_BY_PK, loginLogs);
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
  public Long getCountLoginLog(LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.getCountLoginLog ");
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(loginLogQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, loginLogQuery));
      }
      return this.queryCount(countSql, loginLogQuery, Long.class);
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
  public LoginLog getLoginLogByPk(java.lang.String logId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.getLoginLogByPk ");
      log.debug("parameter logId is : " + logId);
    }
    try {
      if (ToolUtil.isNullStr(logId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " logId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, logId);
        }
      }
      Collection<LoginLog> loginLogSet = this.query(querySql, mapSqlParameterSource, LoginLog.class);
      return ToolUtil.isNotEmpty(loginLogSet) ? loginLogSet.iterator().next() : null;
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
  public Collection<LoginLog> getAllLoginLog() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.getAllLoginLog ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, LoginLog.class);
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
  public Paging<LoginLog> pagingGetLoginLog(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.pagingGetLoginLog ");
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
      Paging<LoginLog> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<LoginLog> loginLogSet = this.query(querySql, LoginLog.class);
        if (ToolUtil.isNotEmpty(loginLogSet)) {
          Set<String> inLogId = new LinkedHashSet<>();
          for (LoginLog loginLog : loginLogSet) {
            inLogId.add(loginLog.getLogId());
          }
          LoginLogQuery loginLogQuery = new LoginLogQuery();
          loginLogQuery.setLogIdAndin(new ArrayList<>(inLogId));
          Collection<LoginLog> rLoginLogSet = this.queryLoginLog(loginLogQuery);
          if (ToolUtil.isNotEmpty(rLoginLogSet)) {
            paging.setData(rLoginLogSet);
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
  public Collection<LoginLog> queryLoginLog(LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.queryLoginLog ");
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(loginLogQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, loginLogQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, LoginLog.class, loginLogQuery);
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
  public Paging<LoginLog> pagingQueryLoginLog(Parameter parameter, LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.pagingQueryLoginLog ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
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
      Paging<LoginLog> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, loginLogQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<LoginLog> loginLogSet = this.query(querySql, LoginLog.class, loginLogQuery);
        if (ToolUtil.isNotEmpty(loginLogSet)) {
          Set<String> inLogId = new LinkedHashSet<>();
          for (LoginLog loginLog : loginLogSet) {
            inLogId.add(loginLog.getLogId());
          }
          LoginLogQuery rLoginLogQuery = new LoginLogQuery();
          rLoginLogQuery.setLogIdAndin(new ArrayList<>(inLogId));
          Collection<LoginLog> rLoginLogSet = this.queryLoginLog(rLoginLogQuery);
          if (ToolUtil.isNotEmpty(rLoginLogSet)) {
            paging.setData(rLoginLogSet);
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
  public boolean isUnique(LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.isUnique ");
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(loginLogQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, loginLogQuery));
      }
      Long count = this.queryCount(countSql, loginLogQuery, Long.class);
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
  public String getNotUniqueErrorMessage(LoginLogQuery loginLogQuery) throws SignException {
    return this.getNotUniqueErrorMsg(COLUMNS, COLUMNS_PARAMETER, loginLogQuery).toString();
  }

  @Override
  public LoginLogVO getLoginLogVOByPk(java.lang.String logId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.getLoginLogVOByPk ");
      log.debug("parameter logId is : " + logId);
    }
    try {
      if (ToolUtil.isNullStr(logId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " logId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, logId);
        }
      }
      Collection<LoginLogVO> loginLogVOSet = this.query(querySql, mapSqlParameterSource, LoginLogVO.class);
      return ToolUtil.isNotEmpty(loginLogVOSet) ? loginLogVOSet.iterator().next() : null;
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
  public Collection<LoginLogVO> getAllLoginLogVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.getAllLoginLogVO ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, LoginLogVO.class);
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
  public Paging<LoginLogVO> pagingGetLoginLogVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.pagingGetLoginLogVO ");
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
      Paging<LoginLogVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<LoginLog> loginLogSet = this.query(querySql, LoginLog.class);
        if (ToolUtil.isNotEmpty(loginLogSet)) {
          Set<String> inLogId = new LinkedHashSet<>();
          for (LoginLog loginLog : loginLogSet) {
            inLogId.add(loginLog.getLogId());
          }
          LoginLogQuery loginLogQuery = new LoginLogQuery();
          loginLogQuery.setLogIdAndin(new ArrayList<>(inLogId));
          Collection<LoginLogVO> rLoginLogVOSet = this.queryLoginLogVO(loginLogQuery);
          if (ToolUtil.isNotEmpty(rLoginLogVOSet)) {
            paging.setData(rLoginLogVOSet);
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
  public Collection<LoginLogVO> queryLoginLogVO(LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.queryLoginLogVO ");
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(loginLogQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, loginLogQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, LoginLogVO.class, loginLogQuery);
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
  public Paging<LoginLogVO> pagingQueryLoginLogVO(Parameter parameter, LoginLogQuery loginLogQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogPersistent.pagingQueryLoginLogVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
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
      Paging<LoginLogVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, loginLogQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<LoginLog> loginLogSet = this.query(querySql, LoginLog.class, loginLogQuery);
        if (ToolUtil.isNotEmpty(loginLogSet)) {
          Set<String> inLogId = new LinkedHashSet<>();
          for (LoginLog loginLog : loginLogSet) {
            inLogId.add(loginLog.getLogId());
          }
          LoginLogQuery rLoginLogQuery = new LoginLogQuery();
          rLoginLogQuery.setLogIdAndin(new ArrayList<>(inLogId));
          Collection<LoginLogVO> rLoginLogVOSet = this.queryLoginLogVO(rLoginLogQuery);
          if (ToolUtil.isNotEmpty(rLoginLogVOSet)) {
            paging.setData(rLoginLogVOSet);
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
