package com.pro.sign.persistent;

import org.springframework.data.repository.CrudRepository;

import com.pro.sign.entity.UserInfo;

public interface IUserInfoJpaPersistent extends CrudRepository<UserInfo, Long> {

}
