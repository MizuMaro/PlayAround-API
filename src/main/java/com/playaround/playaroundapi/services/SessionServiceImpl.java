package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.SessionPA;
import com.playaround.playaroundapi.bo.UserPA;
import com.playaround.playaroundapi.repository.SessionRepository;
import com.playaround.playaroundapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    private SessionRepository sessionRepository;

    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository){ this.sessionRepository= sessionRepository;}


    @Override
    public Iterable<SessionPA> getAllSessions() { return this.sessionRepository.findAll(); }

    @Override
    public void createSession(SessionPA session) {

    }

    @Override
    public SessionPA getSession(int id) {
        var sessions = this.sessionRepository.findAll();
        for (SessionPA u : sessions){
            if(u.getId() == id){
                return u;
            }
        }

        return null;
    }

    @Override
    public void deleteSession(String id) {

    }
}
