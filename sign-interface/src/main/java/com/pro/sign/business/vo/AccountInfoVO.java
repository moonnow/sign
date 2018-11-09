package com.pro.sign.business.vo;

public class AccountInfoVO implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String msg;

  protected java.lang.String token;
  
  protected java.lang.Long cookiesExpireTimes;

  public java.lang.String getMsg() {
    return msg;
  }

  public void setMsg(java.lang.String msg) {
    this.msg = msg;
  }

  public java.lang.String getToken() {
    return token;
  }

  public void setToken(java.lang.String token) {
    this.token = token;
  }

  public java.lang.Long getCookiesExpireTimes() {
    return cookiesExpireTimes;
  }

  public void setCookiesExpireTimes(java.lang.Long cookiesExpireTimes) {
    this.cookiesExpireTimes = cookiesExpireTimes;
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
