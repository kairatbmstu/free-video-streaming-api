package com.free.freevideostreamingapi.controller;


import com.free.freevideostreamingapi.entity.Library;
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
    public Library post(Library library) {
        return libraryService.save(library);
    }

    @PutMapping(value = "/library")
    @Transactional
    public Library put(Library library) {
        return libraryService.save(library);
    }

    @Transactional
    public void deleteById(UUID id) {
        libraryService.deleteById(id);
    }
}
