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
    public SessionServiceImpl(SessionRepository sessionRepository){
        this.sessionRepository= sessionRepository;}


    @Override
    public Iterable<SessionPA> getAllSessions() { return this.sessionRepository.findAll(); }

    @Override
    public SessionPA createSession(SessionPA session) {
        return this.sessionRepository.save(session);
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
    public SessionPA updateSession(SessionPA session) {
        this.sessionRepository.deleteById(session.getId());
        return this.sessionRepository.save(session);
    }

    @Override
    public void deleteSession(int id) {
        this.sessionRepository.deleteById(id);
    }
}
