package com.pro.sign.vo;

/**
 * [会话]VO类, 表名[PRO_SESSION].
 */
public class SessionVO implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String sessionId; // 会话编号

  protected java.lang.String accountId; // 账号编号

  protected java.lang.String loginKey; // 登录标识

  protected java.lang.Long currentTimes; // 当前时间

  public java.lang.String getSessionId() {
    return sessionId;
  }

  public void setSessionId(java.lang.String sessionId) {
    this.sessionId = sessionId;
  }

  public java.lang.String getAccountId() {
    return accountId;
  }

  public void setAccountId(java.lang.String accountId) {
    this.accountId = accountId;
  }

  public java.lang.String getLoginKey() {
    return loginKey;
  }

  public void setLoginKey(java.lang.String loginKey) {
    this.loginKey = loginKey;
  }

  public java.lang.Long getCurrentTimes() {
    return currentTimes;
  }

  public void setCurrentTimes(java.lang.Long currentTimes) {
    this.currentTimes = currentTimes;
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
