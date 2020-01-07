package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.SessionPA;

public interface SessionService {

    Iterable<SessionPA> getAllSessions();
    SessionPA createSession(SessionPA session);
    SessionPA getSession(int id);
    SessionPA updateSession(SessionPA session);
    void deleteSession(int id);

}
