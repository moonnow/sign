package com.pro.sign.vo;

/**
 * [登录日志]VO类, 表名[PRO_LOGIN_LOG].
 */
public class LoginLogVO implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String logId; // 登录日志编号

  protected java.lang.String accountId; // 账号编号

  protected java.lang.String account; // 账号

  protected java.lang.Long loginTimes; // 登录时间

  public java.lang.String getLogId() {
    return logId;
  }

  public void setLogId(java.lang.String logId) {
    this.logId = logId;
  }

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

  public java.lang.Long getLoginTimes() {
    return loginTimes;
  }

  public void setLoginTimes(java.lang.Long loginTimes) {
    this.loginTimes = loginTimes;
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
