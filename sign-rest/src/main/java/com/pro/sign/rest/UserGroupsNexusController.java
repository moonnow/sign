package com.pro.sign.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.sign.entity.UserGroupsNexus;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.UserGroupsNexusQuery;
import com.pro.sign.service.ISignService;
import com.pro.sign.vo.UserGroupsNexusVO;
import com.pro.tool.rest.ToolController;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.Responses;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "pro/sign/userGroupsNexus" })
public class UserGroupsNexusController extends ToolController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UserGroupsNexusController.class);

  @javax.annotation.Resource(name = "com.pro.sign.SignService")
  private ISignService signService;

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  @ResponseBody
  public Responses<UserGroupsNexus> save(Parameter parameter, @RequestBody UserGroupsNexus userGroupsNexus) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusController.save ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexus is : " + userGroupsNexus);
    }
    Responses<UserGroupsNexus> responses = new Responses<>();
    try {
      if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
      }
      signService.saveUserGroupsNexus(userGroupsNexus);
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
  public Responses<UserGroupsNexus> batchSave(Parameter parameter, @RequestBody List<UserGroupsNexus> userGroupsNexuss) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusController.batchSave ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexuss is : " + userGroupsNexuss);
    }
    Responses<UserGroupsNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(userGroupsNexuss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexuss ");
      }
      signService.batchSaveUserGroupsNexus(userGroupsNexuss);
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
  public Responses<UserGroupsNexus> update(Parameter parameter, @RequestBody UserGroupsNexus userGroupsNexus) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusController.update ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexus is : " + userGroupsNexus);
    }
    Responses<UserGroupsNexus> responses = new Responses<>();
    try {
      if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
      }
      signService.updateUserGroupsNexus(userGroupsNexus);
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
  public Responses<UserGroupsNexus> batchUpdate(Parameter parameter, @RequestBody List<UserGroupsNexus> userGroupsNexuss) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusController.batchUpdate ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexuss is : " + userGroupsNexuss);
    }
    Responses<UserGroupsNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(userGroupsNexuss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexuss ");
      }
      signService.batchUpdateUserGroupsNexus(userGroupsNexuss);
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
  public Responses<UserGroupsNexus> remove(Parameter parameter, @RequestBody UserGroupsNexus userGroupsNexus) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusController.remove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexus is : " + userGroupsNexus);
    }
    Responses<UserGroupsNexus> responses = new Responses<>();
    try {
      if (userGroupsNexus == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexus)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexus ");
      }
      signService.removeUserGroupsNexus(userGroupsNexus);
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
  public Responses<UserGroupsNexus> batchRemove(Parameter parameter, @RequestBody List<UserGroupsNexus> userGroupsNexuss) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusController.batchRemove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexuss is : " + userGroupsNexuss);
    }
    Responses<UserGroupsNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(userGroupsNexuss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " userGroupsNexuss ");
      }
      signService.batchRemoveUserGroupsNexus(userGroupsNexuss);
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
  public Responses<UserGroupsNexus> getByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusController.getByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<UserGroupsNexus> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " nexusId ");
      }
      responses.setData(signService.getUserGroupsNexusByPk(parameter.getPrimaryKey()));
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
  public Responses<UserGroupsNexus> get(Parameter parameter, @RequestBody UserGroupsNexusQuery userGroupsNexusQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusController.get ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    Responses<UserGroupsNexus> responses = new Responses<>(parameter);
    try {
      if (userGroupsNexusQuery == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexusQuery)) {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.getAllUserGroupsNexus());
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetUserGroupsNexus(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.queryUserGroupsNexus(userGroupsNexusQuery));
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryUserGroupsNexus(parameter, userGroupsNexusQuery));
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
  public Responses<UserGroupsNexusVO> getVOByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusController.getVOByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<UserGroupsNexusVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " nexusId ");
      }
      responses.setData(signService.getUserGroupsNexusVOByPk(parameter.getPrimaryKey()));
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
  public Responses<UserGroupsNexusVO> getVO(Parameter parameter, @RequestBody UserGroupsNexusQuery userGroupsNexusQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call UserGroupsNexusController.getVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter userGroupsNexusQuery is : " + userGroupsNexusQuery);
    }
    Responses<UserGroupsNexusVO> responses = new Responses<>(parameter);
    try {
      if (userGroupsNexusQuery == null || ToolUtil.isNullEntityAllFieldValue(userGroupsNexusQuery)) {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.getAllUserGroupsNexusVO());
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetUserGroupsNexusVO(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.queryUserGroupsNexusVO(userGroupsNexusQuery));
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryUserGroupsNexusVO(parameter, userGroupsNexusQuery));
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
