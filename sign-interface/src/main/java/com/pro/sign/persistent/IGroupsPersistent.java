package com.pro.sign.persistent;

import java.util.Collection;

import com.pro.sign.entity.Groups;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.GroupsQuery;
import com.pro.sign.vo.GroupsVO;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

public interface IGroupsPersistent {

  public static final String TABLE_NAME = "PRO_GROUPS";

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

  public boolean isUnique(GroupsQuery groupsQuery) throws SignException;

  public String getNotUniqueErrorMessage(GroupsQuery groupsQuery) throws SignException;

  public GroupsVO getGroupsVOByPk(java.lang.String groupsId) throws SignException;

  public Collection<GroupsVO> getAllGroupsVO() throws SignException;

  public Paging<GroupsVO> pagingGetGroupsVO(Parameter parameter) throws SignException;

  public Collection<GroupsVO> queryGroupsVO(GroupsQuery groupsQuery) throws SignException;

  public Paging<GroupsVO> pagingQueryGroupsVO(Parameter parameter, GroupsQuery groupsQuery) throws SignException;

}
