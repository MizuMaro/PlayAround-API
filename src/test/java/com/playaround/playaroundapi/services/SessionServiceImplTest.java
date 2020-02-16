package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.SessionPA;
import com.playaround.playaroundapi.repository.SessionRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SessionServiceImplTest {

    @Test
    void getAllSessions_shouldCallTheRepository() {
        var sessionRepo = mock(SessionRepository.class);
        var sessionService = new SessionServiceImpl(sessionRepo);

        sessionService.getAllSessions();

        verify(sessionRepo).findAll();
    }

    @Test
    void createSession_shouldCallTheRepository() {
        var sessionRepo = mock(SessionRepository.class);
        var sessionService = new SessionServiceImpl(sessionRepo);

        var sess = new SessionPA();
        sessionService.createSession(sess);

        verify(sessionRepo).save(sess);
    }

}
