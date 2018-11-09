package com.pro.sign.entity;

/**
 * [用户]实体类, 表名[PRO_USER].
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "PRO_USER")
@org.hibernate.annotations.GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @javax.persistence.Id
  @javax.persistence.GeneratedValue(generator = "jpa-uuid")
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
