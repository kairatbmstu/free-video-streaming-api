package com.free.freevideostreamingapi.mobile.main;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mobile")
public class MainPageController {

    @GetMapping("/main-page")
    public MainPage getMainPage() {
        return new MainPage();
    }

}
