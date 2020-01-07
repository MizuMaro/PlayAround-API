package com.playaround.playaroundapi.controller;

import com.playaround.playaroundapi.bo.SessionPA;
import com.playaround.playaroundapi.models.*;
import com.playaround.playaroundapi.services.SessionService;
import com.playaround.playaroundapi.util.JwtUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/sessions")
public class SessionController {
    private final SessionService sessionService;

    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @GetMapping
    Iterable<SessionPA> getAllSessions(){
        return this.sessionService.getAllSessions();
    }

    @GetMapping("/{sessionId}")
    SessionPA getSession(@PathVariable String id){
        return this.sessionService.getSession(Integer.parseInt(id));
    }
    @RequestMapping(value = "/newSession",method = RequestMethod.POST)
    public ResponseEntity<?> addSession(@RequestBody NewSessionRequest sessionRequest) throws Exception{
        SessionPA session = new SessionPA(sessionRequest.getAuthor(),sessionRequest.getName(),
                sessionRequest.getGameId(),sessionRequest.getDate(),sessionRequest.getPlace(),
                sessionRequest.isVisibility(),sessionRequest.getLimit(), sessionRequest.getType() );
        List<Integer> ids = new ArrayList<>();
        ids.add(Integer.parseInt(session.getUserId()));
        session.setIds(ids);
        session = this.sessionService.createSession(session);
        return ResponseEntity.ok(new NewSessionResponse(session.getId(),session.getName()));
    }

    @RequestMapping(value = "/editSession",method = RequestMethod.POST)
    public ResponseEntity<?> editSession(@RequestBody UpdateSessionRequest sessionRequest) throws Exception{
        String userId = jwtTokenUtil.extractUserId(sessionRequest.getToken());

        if(userId.equals(sessionRequest.getAuthor())) {
            SessionPA session = this.sessionService.getSession(sessionRequest.getId());
            session.setName(sessionRequest.getName());
            session.setDate(sessionRequest.getDate());
            session.setGame(sessionRequest.getGameId());
            session.setIds(sessionRequest.getUserIds());
            session.setVisibility(sessionRequest.isVisibility());
            session.setLimit(sessionRequest.getLimit());
            session.setType(sessionRequest.getType());
            session.setPlace(sessionRequest.getPlace());
            session = this.sessionService.updateSession(session);
            return ResponseEntity.ok(new UpdateSessionResponse(session.getId(), session.getName()));
        }else{
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @DeleteMapping("/delete")
    void deleteSession(@RequestBody DeleteSessionRequest deleteSessionRequest) throws  Exception {
        String userId = jwtTokenUtil.extractUserId(deleteSessionRequest.getToken());

        if(userId.equals(this.sessionService.getSession(deleteSessionRequest.getSessionId()).getUserId())) {
            this.sessionService.deleteSession(deleteSessionRequest.getSessionId());
        }
    }

}
