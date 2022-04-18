package org.zerock.mreview.controller;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.*;

@Controller

class UploadControllerTest {

    @GetMapping("/uploadEX")
    public void uploadFile() {

    }
}