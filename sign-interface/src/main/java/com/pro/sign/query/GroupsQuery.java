package com.pro.sign.query;

/**
 * [组]查询类, 表名[PRO_GROUPS].
 */
public class GroupsQuery implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String groupsId; // 组编号

  protected java.lang.String groupsKey; // 组标识

  protected java.lang.String groupsName; // 组名称

  protected java.lang.String description; // 描述

  protected java.util.List<java.lang.String> groupsIdAndin; // 组编号Andin查询

  protected java.lang.String groupsKeyAndeq; // 组标识Andeq查询

  protected java.lang.String groupsKeyAndKeyLike; // 组标识AndKeyLike查询

  protected java.lang.String groupsNameOrKeyLike; // 组名称OrKeyLike查询

  protected java.lang.String descriptionOrKeyLike; // 描述OrKeyLike查询

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

  public java.util.List<java.lang.String> getGroupsIdAndin() {
    return groupsIdAndin;
  }

  public void setGroupsIdAndin(java.util.List<java.lang.String> groupsIdAndin) {
    this.groupsIdAndin = groupsIdAndin;
  }

  public java.lang.String getGroupsKeyAndeq() {
    return groupsKeyAndeq;
  }

  public void setGroupsKeyAndeq(java.lang.String groupsKeyAndeq) {
    this.groupsKeyAndeq = groupsKeyAndeq;
  }

  public java.lang.String getGroupsKeyAndKeyLike() {
    return groupsKeyAndKeyLike;
  }

  public void setGroupsKeyAndKeyLike(java.lang.String groupsKeyAndKeyLike) {
    this.groupsKeyAndKeyLike = groupsKeyAndKeyLike;
  }

  public java.lang.String getGroupsNameOrKeyLike() {
    return groupsNameOrKeyLike;
  }

  public void setGroupsNameOrKeyLike(java.lang.String groupsNameOrKeyLike) {
    this.groupsNameOrKeyLike = groupsNameOrKeyLike;
  }

  public java.lang.String getDescriptionOrKeyLike() {
    return descriptionOrKeyLike;
  }

  public void setDescriptionOrKeyLike(java.lang.String descriptionOrKeyLike) {
    this.descriptionOrKeyLike = descriptionOrKeyLike;
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
