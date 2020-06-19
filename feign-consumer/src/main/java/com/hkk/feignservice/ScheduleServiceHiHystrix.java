package com.hkk.feignservice;

import org.springframework.stereotype.Component;

/**
 * @author kang
 * @since 2020/6/11
 */
@Component
public class ScheduleServiceHiHystrix implements ScheduleServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
