package com.pro.sign.business.service;

import com.pro.sign.business.vo.AccountInfoVO;
import com.pro.sign.entity.Account;
import com.pro.sign.exception.SignException;

public interface ISigninService {

  public AccountInfoVO login(Account account) throws SignException;

}
