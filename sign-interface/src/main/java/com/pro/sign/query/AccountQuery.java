package com.pro.sign.query;

/**
 * [账号]查询类, 表名[PRO_ACCOUNT].
 */
public class AccountQuery implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String accountId; // 账号编号

  protected java.lang.String account; // 账号

  protected java.lang.String password; // 密码

  protected java.lang.String loginKey; // 登录标识

  protected java.lang.String permissionKey; // 权限标识

  protected java.lang.String userId; // 用户编号

  protected java.util.List<java.lang.String> accountIdAndin; // 账号编号Andin查询

  protected java.lang.String accountAndeq; // 账号Andeq查询

  protected java.lang.String accountAndKeyLike; // 账号AndKeyLike查询

  protected java.lang.String passwordOrKeyLike; // 密码OrKeyLike查询

  protected java.lang.String loginKeyOrKeyLike; // 登录标识OrKeyLike查询

  protected java.lang.String permissionKeyOrKeyLike; // 权限标识OrKeyLike查询

  protected java.lang.String userIdOrKeyLike; // 用户编号OrKeyLike查询

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

  public java.util.List<java.lang.String> getAccountIdAndin() {
    return accountIdAndin;
  }

  public void setAccountIdAndin(java.util.List<java.lang.String> accountIdAndin) {
    this.accountIdAndin = accountIdAndin;
  }

  public java.lang.String getAccountAndeq() {
    return accountAndeq;
  }

  public void setAccountAndeq(java.lang.String accountAndeq) {
    this.accountAndeq = accountAndeq;
  }

  public java.lang.String getAccountAndKeyLike() {
    return accountAndKeyLike;
  }

  public void setAccountAndKeyLike(java.lang.String accountAndKeyLike) {
    this.accountAndKeyLike = accountAndKeyLike;
  }

  public java.lang.String getPasswordOrKeyLike() {
    return passwordOrKeyLike;
  }

  public void setPasswordOrKeyLike(java.lang.String passwordOrKeyLike) {
    this.passwordOrKeyLike = passwordOrKeyLike;
  }

  public java.lang.String getLoginKeyOrKeyLike() {
    return loginKeyOrKeyLike;
  }

  public void setLoginKeyOrKeyLike(java.lang.String loginKeyOrKeyLike) {
    this.loginKeyOrKeyLike = loginKeyOrKeyLike;
  }

  public java.lang.String getPermissionKeyOrKeyLike() {
    return permissionKeyOrKeyLike;
  }

  public void setPermissionKeyOrKeyLike(java.lang.String permissionKeyOrKeyLike) {
    this.permissionKeyOrKeyLike = permissionKeyOrKeyLike;
  }

  public java.lang.String getUserIdOrKeyLike() {
    return userIdOrKeyLike;
  }

  public void setUserIdOrKeyLike(java.lang.String userIdOrKeyLike) {
    this.userIdOrKeyLike = userIdOrKeyLike;
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
