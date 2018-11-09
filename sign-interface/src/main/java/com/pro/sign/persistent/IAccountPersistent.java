package com.pro.sign.persistent;

import java.util.Collection;

import com.pro.sign.entity.Account;
import com.pro.sign.exception.SignException;
import com.pro.sign.query.AccountQuery;
import com.pro.sign.vo.AccountVO;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

public interface IAccountPersistent {

  public static final String TABLE_NAME = "PRO_ACCOUNT";

  public void saveAccount(Account account) throws SignException;

  public void batchSaveAccount(Collection<Account> accounts) throws SignException;

  public void updateAccount(Account account) throws SignException;

  public void batchUpdateAccount(Collection<Account> accounts) throws SignException;

  public void removeAccount(Account account) throws SignException;

  public void batchRemoveAccount(Collection<Account> accounts) throws SignException;

  public Long getCountAccount(AccountQuery accountQuery) throws SignException;

  public Account getAccountByPk(java.lang.String accountId) throws SignException;

  public Collection<Account> getAllAccount() throws SignException;

  public Paging<Account> pagingGetAccount(Parameter parameter) throws SignException;

  public Collection<Account> queryAccount(AccountQuery accountQuery) throws SignException;

  public Paging<Account> pagingQueryAccount(Parameter parameter, AccountQuery accountQuery) throws SignException;

  public boolean isUnique(AccountQuery accountQuery) throws SignException;

  public String getNotUniqueErrorMessage(AccountQuery accountQuery) throws SignException;

  public AccountVO getAccountVOByPk(java.lang.String accountId) throws SignException;

  public Collection<AccountVO> getAllAccountVO() throws SignException;

  public Paging<AccountVO> pagingGetAccountVO(Parameter parameter) throws SignException;

  public Collection<AccountVO> queryAccountVO(AccountQuery accountQuery) throws SignException;

  public Paging<AccountVO> pagingQueryAccountVO(Parameter parameter, AccountQuery accountQuery) throws SignException;

}
