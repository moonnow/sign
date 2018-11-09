package com.pro.sign.business.task;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pro.sign.entity.Session;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.SessionQuery;
import com.pro.sign.service.ISignService;
import com.pro.tool.util.ToolUtil;

@Component
public class RemoveExpireSession {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(RemoveExpireSession.class);

  @Value("${proconfig.cookies-times-effect}")
  private Long cookiesTimesEffect;

  @javax.annotation.Resource(name = "com.pro.sign.SignService")
  private ISignService signService;

  @Scheduled(cron = "0 */1 * * * ?")
  public void RemoveExpireSessionRecord() throws Exception {
    if (log.isInfoEnabled()) {
      log.info("======================= RemoveExpireSessionRecord =======================");
    }
    try {
      Long times = System.currentTimeMillis();
      SessionQuery sessionQuery = new SessionQuery();
      sessionQuery.setCurrentTimesAndle(times - cookiesTimesEffect);
      Collection<Session> sessionSet = signService.querySession(sessionQuery);
      if (ToolUtil.isNotEmpty(sessionSet)) {
        signService.batchRemoveSession(sessionSet);
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
