package com.pro.sign.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.sign.entity.Session;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.SessionQuery;
import com.pro.sign.service.ISignService;
import com.pro.sign.vo.SessionVO;
import com.pro.tool.rest.ToolController;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.Responses;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "pro/sign/session" })
public class SessionController extends ToolController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(SessionController.class);

  @javax.annotation.Resource(name = "com.pro.sign.SignService")
  private ISignService signService;

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  @ResponseBody
  public Responses<Session> save(Parameter parameter, @RequestBody Session session) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SessionController.save ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter session is : " + session);
    }
    Responses<Session> responses = new Responses<>();
    try {
      if (session == null || ToolUtil.isNullEntityAllFieldValue(session)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " session ");
      }
      signService.saveSession(session);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  @ResponseBody
  public Responses<Session> batchSave(Parameter parameter, @RequestBody List<Session> sessions) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SessionController.batchSave ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter sessions is : " + sessions);
    }
    Responses<Session> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(sessions)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessions ");
      }
      signService.batchSaveSession(sessions);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.PUT }, params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  @ResponseBody
  public Responses<Session> update(Parameter parameter, @RequestBody Session session) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SessionController.update ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter session is : " + session);
    }
    Responses<Session> responses = new Responses<>();
    try {
      if (session == null || ToolUtil.isNullEntityAllFieldValue(session)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " session ");
      }
      signService.updateSession(session);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.PUT }, params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  @ResponseBody
  public Responses<Session> batchUpdate(Parameter parameter, @RequestBody List<Session> sessions) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SessionController.batchUpdate ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter sessions is : " + sessions);
    }
    Responses<Session> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(sessions)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessions ");
      }
      signService.batchUpdateSession(sessions);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.DELETE }, params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  @ResponseBody
  public Responses<Session> remove(Parameter parameter, @RequestBody Session session) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SessionController.remove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter session is : " + session);
    }
    Responses<Session> responses = new Responses<>();
    try {
      if (session == null || ToolUtil.isNullEntityAllFieldValue(session)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " session ");
      }
      signService.removeSession(session);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.DELETE }, params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  @ResponseBody
  public Responses<Session> batchRemove(Parameter parameter, @RequestBody List<Session> sessions) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SessionController.batchRemove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter sessions is : " + sessions);
    }
    Responses<Session> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(sessions)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessions ");
      }
      signService.batchRemoveSession(sessions);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.GET }, params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  @ResponseBody
  public Responses<Session> getByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SessionController.getByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<Session> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessionId ");
      }
      responses.setData(signService.getSessionByPk(parameter.getPrimaryKey()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.POST })
  @ResponseBody
  public Responses<Session> get(Parameter parameter, @RequestBody SessionQuery sessionQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SessionController.get ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter sessionQuery is : " + sessionQuery);
    }
    Responses<Session> responses = new Responses<>(parameter);
    try {
      if (sessionQuery == null || ToolUtil.isNullEntityAllFieldValue(sessionQuery)) {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.getAllSession());
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetSession(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.querySession(sessionQuery));
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingQuerySession(parameter, sessionQuery));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.GET }, params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  @ResponseBody
  public Responses<SessionVO> getVOByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SessionController.getVOByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<SessionVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " sessionId ");
      }
      responses.setData(signService.getSessionVOByPk(parameter.getPrimaryKey()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(value = { "vo" }, method = { RequestMethod.POST })
  @ResponseBody
  public Responses<SessionVO> getVO(Parameter parameter, @RequestBody SessionQuery sessionQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SessionController.getVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter sessionQuery is : " + sessionQuery);
    }
    Responses<SessionVO> responses = new Responses<>(parameter);
    try {
      if (sessionQuery == null || ToolUtil.isNullEntityAllFieldValue(sessionQuery)) {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.getAllSessionVO());
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetSessionVO(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.querySessionVO(sessionQuery));
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingQuerySessionVO(parameter, sessionQuery));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

}
