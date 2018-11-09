package com.pro.sign.query;

/**
 * [用户信息]查询类, 表名[PRO_USER_INFO].
 */
public class UserInfoQuery implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String userInfoId; // 用户信息编号

  protected java.lang.String labelName; // 标签

  protected java.lang.String content; // 内容

  protected java.lang.String userId; // 用户编号

  protected java.util.List<java.lang.String> userInfoIdAndin; // 用户信息编号Andin查询

  protected java.lang.String labelNameAndKeyLike; // 标签AndKeyLike查询

  protected java.lang.String contentOrKeyLike; // 内容OrKeyLike查询

  protected java.lang.String userIdOrKeyLike; // 用户编号OrKeyLike查询

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

  public java.util.List<java.lang.String> getUserInfoIdAndin() {
    return userInfoIdAndin;
  }

  public void setUserInfoIdAndin(java.util.List<java.lang.String> userInfoIdAndin) {
    this.userInfoIdAndin = userInfoIdAndin;
  }

  public java.lang.String getLabelNameAndKeyLike() {
    return labelNameAndKeyLike;
  }

  public void setLabelNameAndKeyLike(java.lang.String labelNameAndKeyLike) {
    this.labelNameAndKeyLike = labelNameAndKeyLike;
  }

  public java.lang.String getContentOrKeyLike() {
    return contentOrKeyLike;
  }

  public void setContentOrKeyLike(java.lang.String contentOrKeyLike) {
    this.contentOrKeyLike = contentOrKeyLike;
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
