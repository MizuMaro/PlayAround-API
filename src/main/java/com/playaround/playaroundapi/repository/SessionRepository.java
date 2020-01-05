package com.playaround.playaroundapi.repository;

import com.playaround.playaroundapi.bo.SessionPA;
import com.playaround.playaroundapi.bo.UserPA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<SessionPA, String> {
}
