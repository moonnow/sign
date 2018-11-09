package com.pro.sign.exception;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.pro.tool.exception.ErrorMessageUtilities;
import com.pro.tool.exception.ToolException;

public class SignException extends ToolException {

  private static final long serialVersionUID = 1L;

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(SignException.class);

  private final static Properties errorMessages = new Properties();
  private static volatile boolean isLoadMessage = false;

  /**
   * 加载异常资源文件：ErrorCode.properties，默认编码为GBK
   */
  private static synchronized void reload() {
    if (!isLoadMessage) {
      isLoadMessage = true;
      InputStream is = SignException.class.getResourceAsStream("ErrorCode.properties");
      if (is != null) {
        try {
          errorMessages.load(is);
          isLoadMessage = true;
        } catch (IOException ioe) {
          if (log.isErrorEnabled()) {
            log.error("ErrorCode.properties load is error !!!", ioe);
          }
        }
      }
    }
  }

  protected SignException(int errCode, String errMessage, Exception innerException) {
    super(errCode, errMessage, innerException);
  }

  public static SignException getException(int errCode) {
    return getException(null, errCode);
  }

  public static SignException getException(int errCode, String... lstPattern) {
    return getException(null, errCode, lstPattern);
  }

  public static SignException getException(Exception innerException, int errCode, String... lstPattern) {
    String errMessage = codeToMessage(errCode, lstPattern);
    return new SignException(errCode, errMessage, innerException);
  }

  private static String codeToMessage(int errCode, String... lstPattern) {
    reload();
    String errCodeStr = Integer.toString(errCode);
    String errorMessage = ErrorMessageUtilities.codeToMessage(errorMessages, errCode, lstPattern);
    if (errorMessage == null || errorMessage.equals(errCodeStr)) {
      errorMessage = ToolException.itselfCodeToMessage(errCode, lstPattern);
    }
    return errorMessage;
  }

}
