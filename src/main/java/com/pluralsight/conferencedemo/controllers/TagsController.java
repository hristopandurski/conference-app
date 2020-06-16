package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Tag;
import com.pluralsight.conferencedemo.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
public class TagsController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<Tag> list() { return tagRepository.findAll(); }
}
