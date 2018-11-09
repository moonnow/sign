package com.pro.sign.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.sign.entity.LoginLog;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.LoginLogQuery;
import com.pro.sign.service.ISignService;
import com.pro.sign.vo.LoginLogVO;
import com.pro.tool.rest.ToolController;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.Responses;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "pro/sign/loginLog" })
public class LoginLogController extends ToolController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(LoginLogController.class);

  @javax.annotation.Resource(name = "com.pro.sign.SignService")
  private ISignService signService;

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  @ResponseBody
  public Responses<LoginLog> save(Parameter parameter, @RequestBody LoginLog loginLog) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogController.save ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLog is : " + loginLog);
    }
    Responses<LoginLog> responses = new Responses<>();
    try {
      if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
      }
      signService.saveLoginLog(loginLog);
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
  public Responses<LoginLog> batchSave(Parameter parameter, @RequestBody List<LoginLog> loginLogs) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogController.batchSave ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLogs is : " + loginLogs);
    }
    Responses<LoginLog> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(loginLogs)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLogs ");
      }
      signService.batchSaveLoginLog(loginLogs);
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
  public Responses<LoginLog> update(Parameter parameter, @RequestBody LoginLog loginLog) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogController.update ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLog is : " + loginLog);
    }
    Responses<LoginLog> responses = new Responses<>();
    try {
      if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
      }
      signService.updateLoginLog(loginLog);
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
  public Responses<LoginLog> batchUpdate(Parameter parameter, @RequestBody List<LoginLog> loginLogs) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogController.batchUpdate ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLogs is : " + loginLogs);
    }
    Responses<LoginLog> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(loginLogs)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLogs ");
      }
      signService.batchUpdateLoginLog(loginLogs);
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
  public Responses<LoginLog> remove(Parameter parameter, @RequestBody LoginLog loginLog) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogController.remove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLog is : " + loginLog);
    }
    Responses<LoginLog> responses = new Responses<>();
    try {
      if (loginLog == null || ToolUtil.isNullEntityAllFieldValue(loginLog)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLog ");
      }
      signService.removeLoginLog(loginLog);
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
  public Responses<LoginLog> batchRemove(Parameter parameter, @RequestBody List<LoginLog> loginLogs) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogController.batchRemove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLogs is : " + loginLogs);
    }
    Responses<LoginLog> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(loginLogs)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " loginLogs ");
      }
      signService.batchRemoveLoginLog(loginLogs);
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
  public Responses<LoginLog> getByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogController.getByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<LoginLog> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " logId ");
      }
      responses.setData(signService.getLoginLogByPk(parameter.getPrimaryKey()));
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
  public Responses<LoginLog> get(Parameter parameter, @RequestBody LoginLogQuery loginLogQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogController.get ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    Responses<LoginLog> responses = new Responses<>(parameter);
    try {
      if (loginLogQuery == null || ToolUtil.isNullEntityAllFieldValue(loginLogQuery)) {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.getAllLoginLog());
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetLoginLog(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.queryLoginLog(loginLogQuery));
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryLoginLog(parameter, loginLogQuery));
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
  public Responses<LoginLogVO> getVOByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogController.getVOByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<LoginLogVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " logId ");
      }
      responses.setData(signService.getLoginLogVOByPk(parameter.getPrimaryKey()));
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
  public Responses<LoginLogVO> getVO(Parameter parameter, @RequestBody LoginLogQuery loginLogQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call LoginLogController.getVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter loginLogQuery is : " + loginLogQuery);
    }
    Responses<LoginLogVO> responses = new Responses<>(parameter);
    try {
      if (loginLogQuery == null || ToolUtil.isNullEntityAllFieldValue(loginLogQuery)) {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.getAllLoginLogVO());
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetLoginLogVO(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.queryLoginLogVO(loginLogQuery));
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryLoginLogVO(parameter, loginLogQuery));
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
