package com.free.freevideostreamingapi.service;


import com.free.freevideostreamingapi.infrastucture.entity.LibraryEntity;
import com.free.freevideostreamingapi.infrastucture.repository.LibraryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Transactional
    public LibraryEntity save(LibraryEntity library) {
        return libraryRepository.save(library);
    }

    @Transactional
    public void deleteById(UUID id){
        libraryRepository.deleteById(id);
    }

}
