package com.pro.sign.query;

/**
 * [用户]查询类, 表名[PRO_USER].
 */
public class UserQuery implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String userId; // 用户编号

  protected java.lang.String userKey; // 用户标识

  protected java.lang.String userName; // 用户名称

  protected java.util.List<java.lang.String> userIdAndin; // 用户编号Andin查询

  protected java.lang.String userKeyAndeq; // 用户标识Andeq查询

  protected java.lang.String userKeyAndKeyLike; // 用户标识AndKeyLike查询

  protected java.lang.String userNameOrKeyLike; // 用户名称OrKeyLike查询

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

  public java.util.List<java.lang.String> getUserIdAndin() {
    return userIdAndin;
  }

  public void setUserIdAndin(java.util.List<java.lang.String> userIdAndin) {
    this.userIdAndin = userIdAndin;
  }

  public java.lang.String getUserKeyAndeq() {
    return userKeyAndeq;
  }

  public void setUserKeyAndeq(java.lang.String userKeyAndeq) {
    this.userKeyAndeq = userKeyAndeq;
  }

  public java.lang.String getUserKeyAndKeyLike() {
    return userKeyAndKeyLike;
  }

  public void setUserKeyAndKeyLike(java.lang.String userKeyAndKeyLike) {
    this.userKeyAndKeyLike = userKeyAndKeyLike;
  }

  public java.lang.String getUserNameOrKeyLike() {
    return userNameOrKeyLike;
  }

  public void setUserNameOrKeyLike(java.lang.String userNameOrKeyLike) {
    this.userNameOrKeyLike = userNameOrKeyLike;
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
