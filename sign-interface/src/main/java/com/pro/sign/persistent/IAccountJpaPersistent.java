package com.pro.sign.persistent;

import org.springframework.data.repository.CrudRepository;

import com.pro.sign.entity.Account;

public interface IAccountJpaPersistent extends CrudRepository<Account, Long> {

}
