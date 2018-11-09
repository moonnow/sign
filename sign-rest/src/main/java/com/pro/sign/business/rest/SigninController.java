package com.pro.sign.business.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.sign.business.service.ISigninService;
import com.pro.sign.business.vo.AccountInfoVO;
import com.pro.sign.entity.Account;
import com.pro.sign.exception.SignException;
import com.pro.tool.rest.ToolController;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.Responses;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "pro/login" })
public class SigninController extends ToolController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(SigninController.class);

  @javax.annotation.Resource(name = "com.pro.sign.SigninService")
  private ISigninService signinService;

  @RequestMapping(method = { RequestMethod.POST })
  @ResponseBody
  public Responses<AccountInfoVO> login(Parameter parameter, @RequestBody Account account) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SigninController.login ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter account is : " + account);
    }
    Responses<AccountInfoVO> responses = new Responses<>();
    try {
      if (account == null || ToolUtil.isNullEntityAllFieldValue(account)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " account ");
      }
      responses.setData(signinService.login(account));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

}
