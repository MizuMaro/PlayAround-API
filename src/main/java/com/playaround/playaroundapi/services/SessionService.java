package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.SessionPA;

public interface SessionService {

    Iterable<SessionPA> getAllSessions();
    void createSession(SessionPA session);
    SessionPA getSession(int id);
    void deleteSession(int id);

}
