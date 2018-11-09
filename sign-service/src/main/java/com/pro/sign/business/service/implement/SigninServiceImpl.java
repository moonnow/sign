package com.pro.sign.business.service.implement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;

import com.pro.sign.business.service.ISigninService;
import com.pro.sign.business.vo.AccountInfoVO;
import com.pro.sign.entity.Account;
import com.pro.sign.entity.LoginLog;
import com.pro.sign.entity.Session;
import com.pro.sign.exception.SignException;
import com.pro.sign.persistent.IAccountPersistent;
import com.pro.sign.persistent.ILoginLogPersistent;
import com.pro.sign.persistent.ISessionPersistent;
import com.pro.sign.query.AccountQuery;
import com.pro.sign.query.SessionQuery;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Service("com.pro.sign.SigninService")
@org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = java.lang.Exception.class)
public class SigninServiceImpl implements ISigninService {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(SigninServiceImpl.class);
  
  @Value("${proconfig.cookies-times-effect}")
  private Long cookiesTimesEffect;

  @javax.annotation.Resource(name = "com.pro.sign.AccountPersistent")
  private IAccountPersistent accountPersistent;
  
  @javax.annotation.Resource(name = "com.pro.sign.SessionPersistent")
  private ISessionPersistent sessionPersistent;
  
  @javax.annotation.Resource(name = "com.pro.sign.LoginLogPersistent")
  private ILoginLogPersistent loginLogPersistent;

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public AccountInfoVO login(Account account) throws SignException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call SigninService.login ");
      log.debug("parameter account is : " + account);
    }
    try {
      if (account == null || ToolUtil.isNullEntityAllFieldValue(account)) {
        throw SignException.getException(SignException.FW_PARAMETER_IS_NULL_ERROR, " account ");
      }
      // 登录标识 Browser 浏览器 App 手机app端 WeChat 微信
      Long times = System.currentTimeMillis();
      String token = ToolUtil.getUUID();
      AccountInfoVO accountInfoVO = new AccountInfoVO();
      AccountQuery accountQuery = new AccountQuery();
      accountQuery.setAccount(account.getAccount());
      Collection<Account> rAccountSet = accountPersistent.queryAccount(accountQuery);
      if (ToolUtil.isNotEmpty(rAccountSet)) {
        Account rAccount = rAccountSet.iterator().next();
        if (rAccount.getPassword() != null && rAccount.getPassword().equals(account.getPassword())) {
          SessionQuery sessionQuery = new SessionQuery();
          sessionQuery.setLoginKey(account.getLoginKey());
          sessionQuery.setAccountId(rAccount.getAccountId());
          Collection<Session> rSessionSet = sessionPersistent.querySession(sessionQuery);
          if (ToolUtil.isNotEmpty(rSessionSet)) {
            Session rSession = rSessionSet.iterator().next();
            // 要动主键 只能先删除再保存
            sessionPersistent.removeSession(rSession);
            Session saveSession = new Session();
            saveSession.setSessionId(token);
            saveSession.setAccountId(rAccount.getAccountId());
            saveSession.setLoginKey(account.getLoginKey());
            saveSession.setCurrentTimes(times);
            sessionPersistent.saveSession(saveSession);
            LoginLog saveLoginLog = new LoginLog();
            saveLoginLog.setLogId(ToolUtil.getUUID());
            saveLoginLog.setAccount(rAccount.getAccount());
            saveLoginLog.setAccountId(rAccount.getAccountId());
            saveLoginLog.setLoginTimes(times);
            loginLogPersistent.saveLoginLog(saveLoginLog);
            accountInfoVO.setMsg("登录成功.");
            accountInfoVO.setToken(token);
            accountInfoVO.setCookiesExpireTimes(times + cookiesTimesEffect);
            return accountInfoVO;
          } else {
            Session saveSession = new Session();
            saveSession.setSessionId(token);
            saveSession.setAccountId(rAccount.getAccountId());
            saveSession.setLoginKey(account.getLoginKey());
            saveSession.setCurrentTimes(times);
            sessionPersistent.saveSession(saveSession);
            LoginLog saveLoginLog = new LoginLog();
            saveLoginLog.setLogId(ToolUtil.getUUID());
            saveLoginLog.setAccount(rAccount.getAccount());
            saveLoginLog.setAccountId(rAccount.getAccountId());
            saveLoginLog.setLoginTimes(times);
            loginLogPersistent.saveLoginLog(saveLoginLog);
            accountInfoVO.setMsg("登录成功.");
            accountInfoVO.setToken(token);
            accountInfoVO.setCookiesExpireTimes(times + cookiesTimesEffect);
            return accountInfoVO;
          }
        } else {
          throw SignException.getException(SignException.FW_ERROR, " 密码错误. ");
        }
      } else {
        throw SignException.getException(SignException.FW_ERROR, " 账号不存在. ");
      }
    } catch (SignException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw SignException.getException(e, SignException.FW_ERROR, e.getMessage());
    }
  }

}
