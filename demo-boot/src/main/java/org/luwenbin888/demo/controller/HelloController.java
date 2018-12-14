package org.luwenbin888.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String hello() {
        logger.info("Receive request");
        return "Hello world";
    }
}
