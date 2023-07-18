package com.hxy.video.controller;

import com.hxy.video.util.DatetimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/video")
public class VideoController {
    private static final String START_DATE_TIME = "2023-04-25";
    private static final int DAYS = 15;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/index")
    public String index() {
        String endDateTime = DatetimeUtil.format(new Date(), DatetimeUtil.YYYY_MM_DD);
        int diffDays = DatetimeUtil.daysBetween(START_DATE_TIME, endDateTime);
        log.info("diffDays = {} | days = {}", diffDays, DAYS);
        if (diffDays > DAYS) {
            return "views/info";
        }
        return "views/index";
    }
}
