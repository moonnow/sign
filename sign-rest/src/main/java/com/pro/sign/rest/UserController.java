package com.pro.sign.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.sign.entity.User;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.UserQuery;
import com.pro.sign.service.ISignService;
import com.pro.sign.vo.UserVO;
import com.pro.tool.rest.ToolController;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.Responses;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "pro/sign/user" })
public class UserController extends ToolController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UserController.class);

  @javax.annotation.Resource(name = "com.pro.sign.SignService")
  private ISignService signService;

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  @ResponseBody
  public Responses<User> save(Parameter parameter, @RequestBody User user) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.save ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter user is : " + user);
    }
    Responses<User> responses = new Responses<>();
    try {
      if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
      }
      signService.saveUser(user);
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
  public Responses<User> batchSave(Parameter parameter, @RequestBody List<User> users) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.batchSave ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter users is : " + users);
    }
    Responses<User> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(users)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " users ");
      }
      signService.batchSaveUser(users);
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
  public Responses<User> update(Parameter parameter, @RequestBody User user) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.update ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter user is : " + user);
    }
    Responses<User> responses = new Responses<>();
    try {
      if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
      }
      signService.updateUser(user);
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
  public Responses<User> batchUpdate(Parameter parameter, @RequestBody List<User> users) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.batchUpdate ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter users is : " + users);
    }
    Responses<User> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(users)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " users ");
      }
      signService.batchUpdateUser(users);
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
  public Responses<User> remove(Parameter parameter, @RequestBody User user) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.remove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter user is : " + user);
    }
    Responses<User> responses = new Responses<>();
    try {
      if (user == null || ToolUtil.isNullEntityAllFieldValue(user)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " user ");
      }
      signService.removeUser(user);
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
  public Responses<User> batchRemove(Parameter parameter, @RequestBody List<User> users) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.batchRemove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter users is : " + users);
    }
    Responses<User> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(users)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " users ");
      }
      signService.batchRemoveUser(users);
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
  public Responses<User> getByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.getByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<User> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userId ");
      }
      responses.setData(signService.getUserByPk(parameter.getPrimaryKey()));
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
  public Responses<User> get(Parameter parameter, @RequestBody UserQuery userQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.get ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userQuery is : " + userQuery);
    }
    Responses<User> responses = new Responses<>(parameter);
    try {
      if (userQuery == null || ToolUtil.isNullEntityAllFieldValue(userQuery)) {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.getAllUser());
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetUser(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.queryUser(userQuery));
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryUser(parameter, userQuery));
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
  public Responses<UserVO> getVOByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.getVOByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<UserVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userId ");
      }
      responses.setData(signService.getUserVOByPk(parameter.getPrimaryKey()));
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
  public Responses<UserVO> getVO(Parameter parameter, @RequestBody UserQuery userQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserController.getVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userQuery is : " + userQuery);
    }
    Responses<UserVO> responses = new Responses<>(parameter);
    try {
      if (userQuery == null || ToolUtil.isNullEntityAllFieldValue(userQuery)) {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.getAllUserVO());
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetUserVO(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.queryUserVO(userQuery));
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryUserVO(parameter, userQuery));
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
