package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions") // mapping url for the endpoints
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping // this endpoint is for get http method
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}") // path should have /id at the end
    public Session get(@PathVariable Long id) { // pull id http parameter from url and inject to method
        return sessionRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // returns 201 for this endpoint
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Also need to delete any existing children.
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

    @GetMapping("/sessionsByName")
    public Session getBySessionName(@RequestParam String name) { // pull id http parameter from url and inject to method
        return sessionRepository.findBySessionName(name);
    }

    @GetMapping("/sessionsByNameContaining")
    public Session getBySessionNameContaining(@RequestParam String name) { // pull id http parameter from url and inject to method
        return sessionRepository.findBySessionNameContainingIgnoreCase(name);
    }
}
