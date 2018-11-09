package com.pro.sign.persistent;

import org.springframework.data.repository.CrudRepository;

import com.pro.sign.entity.Groups;

public interface IGroupsJpaPersistent extends CrudRepository<Groups, Long> {

}
