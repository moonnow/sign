package com.pro.sign.vo;

/**
 * [用户]VO类, 表名[PRO_USER].
 */
public class UserVO implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String userId; // 用户编号

  protected java.lang.String userKey; // 用户标识

  protected java.lang.String userName; // 用户名称

  public java.lang.String getUserId() {
    return userId;
  }

  public void setUserId(java.lang.String userId) {
    this.userId = userId;
  }

  public java.lang.String getUserKey() {
    return userKey;
  }

  public void setUserKey(java.lang.String userKey) {
    this.userKey = userKey;
  }

  public java.lang.String getUserName() {
    return userName;
  }

  public void setUserName(java.lang.String userName) {
    this.userName = userName;
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
