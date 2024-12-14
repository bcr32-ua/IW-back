package com.IW.back.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.IW.back.model.Service;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/")
public class StatusController {

    @GetMapping
    public Map<String, String> getStatus(){
        Map<String, String> dictionary = new HashMap<String, String>();

        dictionary.put("status", "ok");

        return dictionary;
    }

}
