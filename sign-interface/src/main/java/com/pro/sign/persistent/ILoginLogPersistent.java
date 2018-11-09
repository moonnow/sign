package com.pro.sign.persistent;

import java.util.Collection;

import com.pro.sign.entity.LoginLog;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.LoginLogQuery;
import com.pro.sign.vo.LoginLogVO;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

public interface ILoginLogPersistent {

  public static final String TABLE_NAME = "PRO_LOGIN_LOG";

  public void saveLoginLog(LoginLog loginLog) throws SignException;

  public void batchSaveLoginLog(Collection<LoginLog> loginLogs) throws SignException;

  public void updateLoginLog(LoginLog loginLog) throws SignException;

  public void batchUpdateLoginLog(Collection<LoginLog> loginLogs) throws SignException;

  public void removeLoginLog(LoginLog loginLog) throws SignException;

  public void batchRemoveLoginLog(Collection<LoginLog> loginLogs) throws SignException;

  public Long getCountLoginLog(LoginLogQuery loginLogQuery) throws SignException;

  public LoginLog getLoginLogByPk(java.lang.String logId) throws SignException;

  public Collection<LoginLog> getAllLoginLog() throws SignException;

  public Paging<LoginLog> pagingGetLoginLog(Parameter parameter) throws SignException;

  public Collection<LoginLog> queryLoginLog(LoginLogQuery loginLogQuery) throws SignException;

  public Paging<LoginLog> pagingQueryLoginLog(Parameter parameter, LoginLogQuery loginLogQuery) throws SignException;

  public boolean isUnique(LoginLogQuery loginLogQuery) throws SignException;

  public String getNotUniqueErrorMessage(LoginLogQuery loginLogQuery) throws SignException;

  public LoginLogVO getLoginLogVOByPk(java.lang.String logId) throws SignException;

  public Collection<LoginLogVO> getAllLoginLogVO() throws SignException;

  public Paging<LoginLogVO> pagingGetLoginLogVO(Parameter parameter) throws SignException;

  public Collection<LoginLogVO> queryLoginLogVO(LoginLogQuery loginLogQuery) throws SignException;

  public Paging<LoginLogVO> pagingQueryLoginLogVO(Parameter parameter, LoginLogQuery loginLogQuery) throws SignException;

}
