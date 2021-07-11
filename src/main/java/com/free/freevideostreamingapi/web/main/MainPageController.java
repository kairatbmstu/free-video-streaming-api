package com.free.freevideostreamingapi.web.main;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1")
public class MainPageController {

    @GetMapping("/main-page")
    public MainPage getMainPage() {
        return new MainPage();
    }

}
