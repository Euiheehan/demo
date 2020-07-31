package com.euihee.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@AllArgsConstructor
public class PhotoGalleryController {


    @GetMapping("/")
    public String getPhotos(Model model) {
        return "index";
    }

}
