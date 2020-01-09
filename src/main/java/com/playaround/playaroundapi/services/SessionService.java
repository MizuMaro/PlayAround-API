package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.SessionPA;

import java.util.List;

public interface SessionService {

    Iterable<SessionPA> getAllSessions();
    SessionPA createSession(SessionPA session);
    SessionPA getSession(int id);
    SessionPA updateSession(SessionPA session);
    void deleteSession(int id);
    List<Integer> getUserSessions(int id);
}
