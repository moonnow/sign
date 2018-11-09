package com.pro.sign.persistent;

import org.springframework.data.repository.CrudRepository;

import com.pro.sign.entity.Session;

public interface ISessionJpaPersistent extends CrudRepository<Session, Long> {

}
