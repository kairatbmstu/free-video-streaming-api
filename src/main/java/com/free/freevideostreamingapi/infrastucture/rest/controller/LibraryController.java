package com.free.freevideostreamingapi.infrastucture.rest.controller;


import com.free.freevideostreamingapi.infrastucture.entity.LibraryEntity;
import com.free.freevideostreamingapi.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @PostMapping(value = "/library")
    @Transactional
    public LibraryEntity post(LibraryEntity library) {
        return libraryService.save(library);
    }

    @PutMapping(value = "/library")
    @Transactional
    public LibraryEntity put(LibraryEntity library) {
        return libraryService.save(library);
    }

    @Transactional
    public void deleteById(UUID id) {
        libraryService.deleteById(id);
    }
}
