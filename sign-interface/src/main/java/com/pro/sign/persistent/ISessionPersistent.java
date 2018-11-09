package com.pro.sign.persistent;

import java.util.Collection;

import com.pro.sign.entity.Session;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.SessionQuery;
import com.pro.sign.vo.SessionVO;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

public interface ISessionPersistent {

  public static final String TABLE_NAME = "PRO_SESSION";

  public void saveSession(Session session) throws SignException;

  public void batchSaveSession(Collection<Session> sessions) throws SignException;

  public void updateSession(Session session) throws SignException;

  public void batchUpdateSession(Collection<Session> sessions) throws SignException;

  public void removeSession(Session session) throws SignException;

  public void batchRemoveSession(Collection<Session> sessions) throws SignException;

  public Long getCountSession(SessionQuery sessionQuery) throws SignException;

  public Session getSessionByPk(java.lang.String sessionId) throws SignException;

  public Collection<Session> getAllSession() throws SignException;

  public Paging<Session> pagingGetSession(Parameter parameter) throws SignException;

  public Collection<Session> querySession(SessionQuery sessionQuery) throws SignException;

  public Paging<Session> pagingQuerySession(Parameter parameter, SessionQuery sessionQuery) throws SignException;

  public boolean isUnique(SessionQuery sessionQuery) throws SignException;

  public String getNotUniqueErrorMessage(SessionQuery sessionQuery) throws SignException;

  public SessionVO getSessionVOByPk(java.lang.String sessionId) throws SignException;

  public Collection<SessionVO> getAllSessionVO() throws SignException;

  public Paging<SessionVO> pagingGetSessionVO(Parameter parameter) throws SignException;

  public Collection<SessionVO> querySessionVO(SessionQuery sessionQuery) throws SignException;

  public Paging<SessionVO> pagingQuerySessionVO(Parameter parameter, SessionQuery sessionQuery) throws SignException;

}
