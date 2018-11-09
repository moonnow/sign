package com.pro.sign.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.sign.entity.UserInfo;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.UserInfoQuery;
import com.pro.sign.service.ISignService;
import com.pro.sign.vo.UserInfoVO;
import com.pro.tool.rest.ToolController;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.Responses;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "pro/sign/userInfo" })
public class UserInfoController extends ToolController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UserInfoController.class);

  @javax.annotation.Resource(name = "com.pro.sign.SignService")
  private ISignService signService;

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  @ResponseBody
  public Responses<UserInfo> save(Parameter parameter, @RequestBody UserInfo userInfo) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoController.save ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfo is : " + userInfo);
    }
    Responses<UserInfo> responses = new Responses<>();
    try {
      if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
      }
      signService.saveUserInfo(userInfo);
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
  public Responses<UserInfo> batchSave(Parameter parameter, @RequestBody List<UserInfo> userInfos) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoController.batchSave ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfos is : " + userInfos);
    }
    Responses<UserInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(userInfos)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfos ");
      }
      signService.batchSaveUserInfo(userInfos);
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
  public Responses<UserInfo> update(Parameter parameter, @RequestBody UserInfo userInfo) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoController.update ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfo is : " + userInfo);
    }
    Responses<UserInfo> responses = new Responses<>();
    try {
      if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
      }
      signService.updateUserInfo(userInfo);
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
  public Responses<UserInfo> batchUpdate(Parameter parameter, @RequestBody List<UserInfo> userInfos) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoController.batchUpdate ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfos is : " + userInfos);
    }
    Responses<UserInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(userInfos)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfos ");
      }
      signService.batchUpdateUserInfo(userInfos);
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
  public Responses<UserInfo> remove(Parameter parameter, @RequestBody UserInfo userInfo) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoController.remove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfo is : " + userInfo);
    }
    Responses<UserInfo> responses = new Responses<>();
    try {
      if (userInfo == null || ToolUtil.isNullEntityAllFieldValue(userInfo)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfo ");
      }
      signService.removeUserInfo(userInfo);
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
  public Responses<UserInfo> batchRemove(Parameter parameter, @RequestBody List<UserInfo> userInfos) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoController.batchRemove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfos is : " + userInfos);
    }
    Responses<UserInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(userInfos)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfos ");
      }
      signService.batchRemoveUserInfo(userInfos);
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
  public Responses<UserInfo> getByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoController.getByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<UserInfo> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfoId ");
      }
      responses.setData(signService.getUserInfoByPk(parameter.getPrimaryKey()));
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
  public Responses<UserInfo> get(Parameter parameter, @RequestBody UserInfoQuery userInfoQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoController.get ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    Responses<UserInfo> responses = new Responses<>(parameter);
    try {
      if (userInfoQuery == null || ToolUtil.isNullEntityAllFieldValue(userInfoQuery)) {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.getAllUserInfo());
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetUserInfo(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.queryUserInfo(userInfoQuery));
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryUserInfo(parameter, userInfoQuery));
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
  public Responses<UserInfoVO> getVOByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoController.getVOByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<UserInfoVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userInfoId ");
      }
      responses.setData(signService.getUserInfoVOByPk(parameter.getPrimaryKey()));
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
  public Responses<UserInfoVO> getVO(Parameter parameter, @RequestBody UserInfoQuery userInfoQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserInfoController.getVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userInfoQuery is : " + userInfoQuery);
    }
    Responses<UserInfoVO> responses = new Responses<>(parameter);
    try {
      if (userInfoQuery == null || ToolUtil.isNullEntityAllFieldValue(userInfoQuery)) {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.getAllUserInfoVO());
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetUserInfoVO(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.queryUserInfoVO(userInfoQuery));
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryUserInfoVO(parameter, userInfoQuery));
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
