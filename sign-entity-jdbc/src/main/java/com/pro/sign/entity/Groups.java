package com.pro.sign.entity;

/**
 * [组]实体类, 表名[PRO_GROUPS].
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "PRO_GROUPS")
@org.hibernate.annotations.GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Groups implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @javax.persistence.Id
  @javax.persistence.GeneratedValue(generator = "jpa-uuid")
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
