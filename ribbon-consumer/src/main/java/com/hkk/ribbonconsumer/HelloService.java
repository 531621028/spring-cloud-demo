package com.hkk.ribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author kang
 * @since 2020/6/9
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/hi?name=" + name, String.class);
    }

    @HystrixCollapser(batchMethod = "getUserByIds")
    public Future<String> getUserById(String id) {
        return null;
    }

    @HystrixCommand
    public List<String> getUserByIds(List<String> ids) {
        List<String> users = new ArrayList<>();
        for (String id : ids) {
            users.add("name: " + id);
        }
        return users;
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }

}
