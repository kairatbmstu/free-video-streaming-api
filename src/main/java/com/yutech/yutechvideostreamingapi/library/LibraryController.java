package com.yutech.yutechvideostreamingapi.library;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LibraryController {

    @GetMapping("/library-page")
    public LibraryPage getLibraryPage(){
        return new LibraryPage();
    }

}
