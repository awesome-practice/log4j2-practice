package com.practice.springboot.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luo Bao Ding
 * @since 2018/5/16
 */
@RestController
public class LogController {


    @RequestMapping("/log")
    public String rootLog() {
        Logger myLog = LogManager.getLogger("myLog");
        myLog.warn("hello world");

        Logger logger = LogManager.getLogger();//the log name is : com.practice.springboot.log4j2.LogController
        logger.warn("default logger hello world");
        logger.info("default logger hello world");

        try {
            throw new RuntimeException("fake exception");
        } catch (Exception e) {
            myLog.error("top exception ",e);
        }

        return "log: hello world";
    }

}
