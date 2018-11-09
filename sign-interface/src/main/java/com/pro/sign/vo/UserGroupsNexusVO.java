package com.pro.sign.vo;

/**
 * [用户组关系]VO类, 表名[PRO_USER_GROUPS_NEXUS].
 */
public class UserGroupsNexusVO implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String nexusId; // 用户组关系编号

  protected java.lang.String userId; // 用户编号

  protected java.lang.String groupsId; // 组编号

  public java.lang.String getNexusId() {
    return nexusId;
  }

  public void setNexusId(java.lang.String nexusId) {
    this.nexusId = nexusId;
  }

  public java.lang.String getUserId() {
    return userId;
  }

  public void setUserId(java.lang.String userId) {
    this.userId = userId;
  }

  public java.lang.String getGroupsId() {
    return groupsId;
  }

  public void setGroupsId(java.lang.String groupsId) {
    this.groupsId = groupsId;
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
