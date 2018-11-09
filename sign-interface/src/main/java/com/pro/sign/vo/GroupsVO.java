package com.pro.sign.vo;

/**
 * [组]VO类, 表名[PRO_GROUPS].
 */
public class GroupsVO implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String groupsId; // 组编号

  protected java.lang.String groupsKey; // 组标识

  protected java.lang.String groupsName; // 组名称

  protected java.lang.String description; // 描述

  public java.lang.String getGroupsId() {
    return groupsId;
  }

  public void setGroupsId(java.lang.String groupsId) {
    this.groupsId = groupsId;
  }

  public java.lang.String getGroupsKey() {
    return groupsKey;
  }

  public void setGroupsKey(java.lang.String groupsKey) {
    this.groupsKey = groupsKey;
  }

  public java.lang.String getGroupsName() {
    return groupsName;
  }

  public void setGroupsName(java.lang.String groupsName) {
    this.groupsName = groupsName;
  }

  public java.lang.String getDescription() {
    return description;
  }

  public void setDescription(java.lang.String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }

  @Override
  public boolean equals(Object object) {
    return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, object);
  }

  @Override
  public int hashCode() {
    return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(this);
  }

}
