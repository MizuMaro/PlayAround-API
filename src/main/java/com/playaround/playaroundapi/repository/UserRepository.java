package com.playaround.playaroundapi.repository;

import com.playaround.playaroundapi.bo.UserPA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserPA, String> {
}
