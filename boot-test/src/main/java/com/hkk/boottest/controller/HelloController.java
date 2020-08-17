package com.hkk.boottest.controller;

import com.hkk.boottest.dto.City;
import com.hkk.boottest.dto.Country;
import com.hkk.boottest.resp.ListResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kang
 * @since 2020/8/9
 */
@RestController
@RequestMapping("/hello")
@Api
public class HelloController {

    @RequestMapping("/cityList")
    @ApiOperation("城市列表")
    public ListResp<City> cityList() {
        ListResp<City> resp = new ListResp<>();
        List<City> cities = new ArrayList<>();
        resp.setResult(cities);
        return resp;
    }

    @RequestMapping("/countryList")
    @ApiOperation("国家列表")
    public ListResp<Country> countryList() {
        ListResp<Country> resp = new ListResp<>();
        List<Country> countries = new ArrayList<>();
        resp.setResult(countries);
        return resp;
    }

}
