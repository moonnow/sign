package com.pro.sign.persistent;

import org.springframework.data.repository.CrudRepository;

import com.pro.sign.entity.User;

public interface IUserJpaPersistent extends CrudRepository<User, Long> {

}
