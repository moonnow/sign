package com.pro.sign.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.sign.entity.Groups;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.GroupsQuery;
import com.pro.sign.service.ISignService;
import com.pro.sign.vo.GroupsVO;
import com.pro.tool.rest.ToolController;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.Responses;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "pro/sign/groups" })
public class GroupsController extends ToolController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(GroupsController.class);

  @javax.annotation.Resource(name = "com.pro.sign.SignService")
  private ISignService signService;

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  @ResponseBody
  public Responses<Groups> save(Parameter parameter, @RequestBody Groups groups) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsController.save ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groups is : " + groups);
    }
    Responses<Groups> responses = new Responses<>();
    try {
      if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
      }
      signService.saveGroups(groups);
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
  public Responses<Groups> batchSave(Parameter parameter, @RequestBody List<Groups> groupss) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsController.batchSave ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groupss is : " + groupss);
    }
    Responses<Groups> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(groupss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupss ");
      }
      signService.batchSaveGroups(groupss);
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
  public Responses<Groups> update(Parameter parameter, @RequestBody Groups groups) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsController.update ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groups is : " + groups);
    }
    Responses<Groups> responses = new Responses<>();
    try {
      if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
      }
      signService.updateGroups(groups);
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
  public Responses<Groups> batchUpdate(Parameter parameter, @RequestBody List<Groups> groupss) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsController.batchUpdate ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groupss is : " + groupss);
    }
    Responses<Groups> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(groupss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupss ");
      }
      signService.batchUpdateGroups(groupss);
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
  public Responses<Groups> remove(Parameter parameter, @RequestBody Groups groups) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsController.remove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groups is : " + groups);
    }
    Responses<Groups> responses = new Responses<>();
    try {
      if (groups == null || ToolUtil.isNullEntityAllFieldValue(groups)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groups ");
      }
      signService.removeGroups(groups);
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
  public Responses<Groups> batchRemove(Parameter parameter, @RequestBody List<Groups> groupss) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsController.batchRemove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groupss is : " + groupss);
    }
    Responses<Groups> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(groupss)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupss ");
      }
      signService.batchRemoveGroups(groupss);
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
  public Responses<Groups> getByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsController.getByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<Groups> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupsId ");
      }
      responses.setData(signService.getGroupsByPk(parameter.getPrimaryKey()));
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
  public Responses<Groups> get(Parameter parameter, @RequestBody GroupsQuery groupsQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsController.get ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    Responses<Groups> responses = new Responses<>(parameter);
    try {
      if (groupsQuery == null || ToolUtil.isNullEntityAllFieldValue(groupsQuery)) {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.getAllGroups());
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetGroups(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.queryGroups(groupsQuery));
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryGroups(parameter, groupsQuery));
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
  public Responses<GroupsVO> getVOByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsController.getVOByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<GroupsVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " groupsId ");
      }
      responses.setData(signService.getGroupsVOByPk(parameter.getPrimaryKey()));
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
  public Responses<GroupsVO> getVO(Parameter parameter, @RequestBody GroupsQuery groupsQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call GroupsController.getVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter groupsQuery is : " + groupsQuery);
    }
    Responses<GroupsVO> responses = new Responses<>(parameter);
    try {
      if (groupsQuery == null || ToolUtil.isNullEntityAllFieldValue(groupsQuery)) {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.getAllGroupsVO());
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetGroupsVO(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.queryGroupsVO(groupsQuery));
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryGroupsVO(parameter, groupsQuery));
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
