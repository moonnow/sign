package com.pro.sign.persistent;

import org.springframework.data.repository.CrudRepository;

import com.pro.sign.entity.UserGroupsNexus;

public interface IUserGroupsNexusJpaPersistent extends CrudRepository<UserGroupsNexus, Long> {

}
