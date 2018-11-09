package com.pro.sign.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pro.sign.entity.Session;
import com.pro.sign.exception.SignException;
import com.pro.sign.service.ISignService;
import com.pro.tool.util.ToolContextData;
import com.pro.tool.vo.TokenTimesEffect;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(AuthorizationInterceptor.class);
  
  @Value("${proconfig.cookies-times-effect}")
  private Long cookiesTimesEffect;
  
  @javax.annotation.Resource(name = "com.pro.sign.SignService")
  private ISignService signService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (log.isInfoEnabled()) {
      log.info("======================= AuthorizationInterceptor preHandle =======================");
    }
    try {
      Map<String, String[]> parameterMap = request.getParameterMap();
      if (parameterMap.containsKey("token")) {
        Long times = System.currentTimeMillis();
        String token = parameterMap.get("token")[0];
        Session session = signService.getSessionByPk(token);
        if (session != null) {
          session.setCurrentTimes(times);
          signService.updateSession(session);
          ToolContextData.removeTokenTimesEffect();
          TokenTimesEffect tokenTimesEffect = new TokenTimesEffect();
          tokenTimesEffect.setToken(token);
          tokenTimesEffect.setCookiesExpireTimes(times + cookiesTimesEffect);
          ToolContextData.setTokenTimesEffect(tokenTimesEffect);
        } else {
          response.sendError(401, "token 无效");
          return false;
        }
      } else { 
        response.sendError(401, "token 无效");
        return false;
      }
      return true;
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

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    if (log.isInfoEnabled()) {
      log.info("======================= AuthorizationInterceptor postHandle =======================");
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    if (log.isInfoEnabled()) {
      log.info("======================= AuthorizationInterceptor afterCompletion =======================");
    }
  }

}
