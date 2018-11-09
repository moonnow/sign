package com.pro.sign.query;

/**
 * [会话]查询类, 表名[PRO_SESSION].
 */
public class SessionQuery implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String sessionId; // 会话编号

  protected java.lang.String accountId; // 账号编号

  protected java.lang.String loginKey; // 登录标识

  protected java.lang.Long currentTimes; // 当前时间

  protected java.util.List<java.lang.String> sessionIdAndin; // 会话编号Andin查询

  protected java.lang.String accountIdAndeq; // 账号编号Andeq查询

  protected java.lang.String loginKeyAndeq; // 登录标识Andeq查询

  protected java.lang.String accountIdAndKeyLike; // 账号编号AndKeyLike查询

  protected java.lang.String loginKeyOrKeyLike; // 登录标识OrKeyLike查询

  protected java.lang.Long currentTimesAndle;

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

  public java.util.List<java.lang.String> getSessionIdAndin() {
    return sessionIdAndin;
  }

  public void setSessionIdAndin(java.util.List<java.lang.String> sessionIdAndin) {
    this.sessionIdAndin = sessionIdAndin;
  }

  public java.lang.String getAccountIdAndeq() {
    return accountIdAndeq;
  }

  public void setAccountIdAndeq(java.lang.String accountIdAndeq) {
    this.accountIdAndeq = accountIdAndeq;
  }

  public java.lang.String getLoginKeyAndeq() {
    return loginKeyAndeq;
  }

  public void setLoginKeyAndeq(java.lang.String loginKeyAndeq) {
    this.loginKeyAndeq = loginKeyAndeq;
  }

  public java.lang.String getAccountIdAndKeyLike() {
    return accountIdAndKeyLike;
  }

  public void setAccountIdAndKeyLike(java.lang.String accountIdAndKeyLike) {
    this.accountIdAndKeyLike = accountIdAndKeyLike;
  }

  public java.lang.String getLoginKeyOrKeyLike() {
    return loginKeyOrKeyLike;
  }

  public void setLoginKeyOrKeyLike(java.lang.String loginKeyOrKeyLike) {
    this.loginKeyOrKeyLike = loginKeyOrKeyLike;
  }

  public java.lang.Long getCurrentTimesAndle() {
    return currentTimesAndle;
  }

  public void setCurrentTimesAndle(java.lang.Long currentTimesAndle) {
    this.currentTimesAndle = currentTimesAndle;
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
