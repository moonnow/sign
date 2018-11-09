package com.pro.sign.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.sign.entity.Account;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.AccountQuery;
import com.pro.sign.service.ISignService;
import com.pro.sign.vo.AccountVO;
import com.pro.tool.rest.ToolController;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.Responses;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "pro/sign/account" })
public class AccountController extends ToolController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(AccountController.class);

  @javax.annotation.Resource(name = "com.pro.sign.SignService")
  private ISignService signService;

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  @ResponseBody
  public Responses<Account> save(Parameter parameter, @RequestBody Account account) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call AccountController.save ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter account is : " + account);
    }
    Responses<Account> responses = new Responses<>();
    try {
      if (account == null || ToolUtil.isNullEntityAllFieldValue(account)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " account ");
      }
      signService.saveAccount(account);
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
  public Responses<Account> batchSave(Parameter parameter, @RequestBody List<Account> accounts) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call AccountController.batchSave ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter accounts is : " + accounts);
    }
    Responses<Account> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(accounts)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accounts ");
      }
      signService.batchSaveAccount(accounts);
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
  public Responses<Account> update(Parameter parameter, @RequestBody Account account) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call AccountController.update ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter account is : " + account);
    }
    Responses<Account> responses = new Responses<>();
    try {
      if (account == null || ToolUtil.isNullEntityAllFieldValue(account)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " account ");
      }
      signService.updateAccount(account);
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
  public Responses<Account> batchUpdate(Parameter parameter, @RequestBody List<Account> accounts) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call AccountController.batchUpdate ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter accounts is : " + accounts);
    }
    Responses<Account> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(accounts)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accounts ");
      }
      signService.batchUpdateAccount(accounts);
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
  public Responses<Account> remove(Parameter parameter, @RequestBody Account account) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call AccountController.remove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter account is : " + account);
    }
    Responses<Account> responses = new Responses<>();
    try {
      if (account == null || ToolUtil.isNullEntityAllFieldValue(account)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " account ");
      }
      signService.removeAccount(account);
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
  public Responses<Account> batchRemove(Parameter parameter, @RequestBody List<Account> accounts) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call AccountController.batchRemove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter accounts is : " + accounts);
    }
    Responses<Account> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(accounts)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accounts ");
      }
      signService.batchRemoveAccount(accounts);
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
  public Responses<Account> getByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call AccountController.getByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<Account> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accountId ");
      }
      responses.setData(signService.getAccountByPk(parameter.getPrimaryKey()));
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
  public Responses<Account> get(Parameter parameter, @RequestBody AccountQuery accountQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call AccountController.get ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter accountQuery is : " + accountQuery);
    }
    Responses<Account> responses = new Responses<>(parameter);
    try {
      if (accountQuery == null || ToolUtil.isNullEntityAllFieldValue(accountQuery)) {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.getAllAccount());
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetAccount(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(signService.queryAccount(accountQuery));
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryAccount(parameter, accountQuery));
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
  public Responses<AccountVO> getVOByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call AccountController.getVOByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<AccountVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " accountId ");
      }
      responses.setData(signService.getAccountVOByPk(parameter.getPrimaryKey()));
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
  public Responses<AccountVO> getVO(Parameter parameter, @RequestBody AccountQuery accountQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call AccountController.getVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter accountQuery is : " + accountQuery);
    }
    Responses<AccountVO> responses = new Responses<>(parameter);
    try {
      if (accountQuery == null || ToolUtil.isNullEntityAllFieldValue(accountQuery)) {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.getAllAccountVO());
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingGetAccountVO(parameter));
        } else {
          throw SignException.getException(SignException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(signService.queryAccountVO(accountQuery));
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(signService.pagingQueryAccountVO(parameter, accountQuery));
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
