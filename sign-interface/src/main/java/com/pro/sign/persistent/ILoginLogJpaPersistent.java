package com.pro.sign.persistent;

import org.springframework.data.repository.CrudRepository;

import com.pro.sign.entity.LoginLog;

public interface ILoginLogJpaPersistent extends CrudRepository<LoginLog, Long> {

}
