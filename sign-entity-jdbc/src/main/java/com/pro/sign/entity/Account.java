package com.pro.sign.entity;

/**
 * [账号]实体类, 表名[PRO_ACCOUNT].
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "PRO_ACCOUNT")
@org.hibernate.annotations.GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Account implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @javax.persistence.Id
  @javax.persistence.GeneratedValue(generator = "jpa-uuid")
  protected java.lang.String accountId; // 账号编号

  protected java.lang.String account; // 账号

  protected java.lang.String password; // 密码

  protected java.lang.String loginKey; // 登录标识

  protected java.lang.String permissionKey; // 权限标识

  protected java.lang.String userId; // 用户编号

  public java.lang.String getAccountId() {
    return accountId;
  }

  public void setAccountId(java.lang.String accountId) {
    this.accountId = accountId;
  }

  public java.lang.String getAccount() {
    return account;
  }

  public void setAccount(java.lang.String account) {
    this.account = account;
  }

  public java.lang.String getPassword() {
    return password;
  }

  public void setPassword(java.lang.String password) {
    this.password = password;
  }

  public java.lang.String getLoginKey() {
    return loginKey;
  }

  public void setLoginKey(java.lang.String loginKey) {
    this.loginKey = loginKey;
  }

  public java.lang.String getPermissionKey() {
    return permissionKey;
  }

  public void setPermissionKey(java.lang.String permissionKey) {
    this.permissionKey = permissionKey;
  }

  public java.lang.String getUserId() {
    return userId;
  }

  public void setUserId(java.lang.String userId) {
    this.userId = userId;
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
