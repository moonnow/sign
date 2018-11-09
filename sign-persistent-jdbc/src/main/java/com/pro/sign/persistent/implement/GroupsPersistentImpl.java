package com.pro.sign.persistent.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.pro.sign.entity.Groups;
import com.pro.sign.exception.SignException;
import com.pro.sign.persistent.IGroupsPersistent;
import com.pro.sign.query.GroupsQuery;
import com.pro.sign.vo.GroupsVO;
import com.pro.tool.persistent.implement.ToolPersistent;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Repository("com.pro.sign.GroupsPersistent")
public class GroupsPersistentImpl extends ToolPersistent implements IGroupsPersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(GroupsPersistentImpl.class);

  public static final String TABLE_ALIAS = "groups";

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
  public void saveGroups(Groups groups) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.saveGroups ");
      log.debug("parameter groups is : " + groups);
    }
    try {
      if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
      }
      this.insert(INSERT_SQL, groups);
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
  public void batchSaveGroups(Collection<Groups> groupss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.batchSaveGroups ");
      log.debug("parameter groupss is : " + groupss);
    }
    try {
      if (ToolUtil.isEmpty(groupss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupss ");
      }
      this.insert(INSERT_SQL, groupss);
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
  public void updateGroups(Groups groups) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.updateGroups ");
      log.debug("parameter groups is : " + groups);
    }
    try {
      if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
      }
      this.update(UPDATE_SQL, groups);
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
  public void batchUpdateGroups(Collection<Groups> groupss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.batchUpdateGroups ");
      log.debug("parameter groupss is : " + groupss);
    }
    try {
      if (ToolUtil.isEmpty(groupss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupss ");
      }
      this.update(UPDATE_SQL, groupss);
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
  public void removeGroups(Groups groups) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.removeGroups ");
      log.debug("parameter groups is : " + groups);
    }
    try {
      if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, groups.getGroupsId());
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
  public void batchRemoveGroups(Collection<Groups> groupss) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.batchRemoveGroups ");
      log.debug("parameter groupss is : " + groupss);
    }
    try {
      if (ToolUtil.isEmpty(groupss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupss ");
      }
      this.del(DEL_SQL_BY_PK, groupss);
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
  public Long getCountGroups(GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.getCountGroups ");
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(groupsQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, groupsQuery));
      }
      return this.queryCount(countSql, groupsQuery, Long.class);
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
  public Groups getGroupsByPk(java.lang.String groupsId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.getGroupsByPk ");
      log.debug("parameter groupsId is : " + groupsId);
    }
    try {
      if (ToolUtil.isNullStr(groupsId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupsId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, groupsId);
        }
      }
      Collection<Groups> groupsSet = this.query(querySql, mapSqlParameterSource, Groups.class);
      return ToolUtil.isNotEmpty(groupsSet) ? groupsSet.iterator().next() : null;
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
  public Collection<Groups> getAllGroups() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.getAllGroups ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, Groups.class);
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
  public Paging<Groups> pagingGetGroups(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.pagingGetGroups ");
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
      Paging<Groups> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<Groups> groupsSet = this.query(querySql, Groups.class);
        if (ToolUtil.isNotEmpty(groupsSet)) {
          Set<String> inGroupsId = new LinkedHashSet<>();
          for (Groups groups : groupsSet) {
            inGroupsId.add(groups.getGroupsId());
          }
          GroupsQuery groupsQuery = new GroupsQuery();
          groupsQuery.setGroupsIdAndin(new ArrayList<>(inGroupsId));
          Collection<Groups> rGroupsSet = this.queryGroups(groupsQuery);
          if (ToolUtil.isNotEmpty(rGroupsSet)) {
            paging.setData(rGroupsSet);
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
  public Collection<Groups> queryGroups(GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.queryGroups ");
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(groupsQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, groupsQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, Groups.class, groupsQuery);
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
  public Paging<Groups> pagingQueryGroups(Parameter parameter, GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.pagingQueryGroups ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groupsQuery is : " + groupsQuery);
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
      Paging<Groups> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, groupsQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<Groups> groupsSet = this.query(querySql, Groups.class, groupsQuery);
        if (ToolUtil.isNotEmpty(groupsSet)) {
          Set<String> inGroupsId = new LinkedHashSet<>();
          for (Groups groups : groupsSet) {
            inGroupsId.add(groups.getGroupsId());
          }
          GroupsQuery rGroupsQuery = new GroupsQuery();
          rGroupsQuery.setGroupsIdAndin(new ArrayList<>(inGroupsId));
          Collection<Groups> rGroupsSet = this.queryGroups(rGroupsQuery);
          if (ToolUtil.isNotEmpty(rGroupsSet)) {
            paging.setData(rGroupsSet);
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
  public boolean isUnique(GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.isUnique ");
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(groupsQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, groupsQuery));
      }
      Long count = this.queryCount(countSql, groupsQuery, Long.class);
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
  public String getNotUniqueErrorMessage(GroupsQuery groupsQuery) throws SignException {
    return this.getNotUniqueErrorMsg(COLUMNS, COLUMNS_PARAMETER, groupsQuery).toString();
  }

  @Override
  public GroupsVO getGroupsVOByPk(java.lang.String groupsId) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.getGroupsVOByPk ");
      log.debug("parameter groupsId is : " + groupsId);
    }
    try {
      if (ToolUtil.isNullStr(groupsId)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupsId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, groupsId);
        }
      }
      Collection<GroupsVO> groupsVOSet = this.query(querySql, mapSqlParameterSource, GroupsVO.class);
      return ToolUtil.isNotEmpty(groupsVOSet) ? groupsVOSet.iterator().next() : null;
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
  public Collection<GroupsVO> getAllGroupsVO() throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.getAllGroupsVO ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, GroupsVO.class);
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
  public Paging<GroupsVO> pagingGetGroupsVO(Parameter parameter) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.pagingGetGroupsVO ");
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
      Paging<GroupsVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<Groups> groupsSet = this.query(querySql, Groups.class);
        if (ToolUtil.isNotEmpty(groupsSet)) {
          Set<String> inGroupsId = new LinkedHashSet<>();
          for (Groups groups : groupsSet) {
            inGroupsId.add(groups.getGroupsId());
          }
          GroupsQuery groupsQuery = new GroupsQuery();
          groupsQuery.setGroupsIdAndin(new ArrayList<>(inGroupsId));
          Collection<GroupsVO> rGroupsVOSet = this.queryGroupsVO(groupsQuery);
          if (ToolUtil.isNotEmpty(rGroupsVOSet)) {
            paging.setData(rGroupsVOSet);
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
  public Collection<GroupsVO> queryGroupsVO(GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.queryGroupsVO ");
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(groupsQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, groupsQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, GroupsVO.class, groupsQuery);
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
  public Paging<GroupsVO> pagingQueryGroupsVO(Parameter parameter, GroupsQuery groupsQuery) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsPersistent.pagingQueryGroupsVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groupsQuery is : " + groupsQuery);
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
      Paging<GroupsVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, groupsQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<Groups> groupsSet = this.query(querySql, Groups.class, groupsQuery);
        if (ToolUtil.isNotEmpty(groupsSet)) {
          Set<String> inGroupsId = new LinkedHashSet<>();
          for (Groups groups : groupsSet) {
            inGroupsId.add(groups.getGroupsId());
          }
          GroupsQuery rGroupsQuery = new GroupsQuery();
          rGroupsQuery.setGroupsIdAndin(new ArrayList<>(inGroupsId));
          Collection<GroupsVO> rGroupsVOSet = this.queryGroupsVO(rGroupsQuery);
          if (ToolUtil.isNotEmpty(rGroupsVOSet)) {
            paging.setData(rGroupsVOSet);
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
