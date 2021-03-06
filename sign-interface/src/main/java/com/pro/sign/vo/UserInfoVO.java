package com.pro.sign.vo;

/**
 * [用户信息]VO类, 表名[PRO_USER_INFO].
 */
public class UserInfoVO implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String userInfoId; // 用户信息编号

  protected java.lang.String labelName; // 标签

  protected java.lang.String content; // 内容

  protected java.lang.String userId; // 用户编号

  public java.lang.String getUserInfoId() {
    return userInfoId;
  }

  public void setUserInfoId(java.lang.String userInfoId) {
    this.userInfoId = userInfoId;
  }

  public java.lang.String getLabelName() {
    return labelName;
  }

  public void setLabelName(java.lang.String labelName) {
    this.labelName = labelName;
  }

  public java.lang.String getContent() {
    return content;
  }

  public void setContent(java.lang.String content) {
    this.content = content;
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
