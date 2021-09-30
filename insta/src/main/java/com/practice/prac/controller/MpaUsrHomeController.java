package com.practice.prac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MpaUsrHomeController {
    @RequestMapping("/mpaUsr/home/main")
    @ResponseBody
    public String showMain() {
        return "안녕";
    }
    
    @RequestMapping("/mpaUsr/home/main2")
    @ResponseBody
    public String showMain2() {
        return "잘가";
    }

    @RequestMapping("/mpaUsr/home/main3")
    // http://localhost:8024/mpaUsr/home/main3?a=10&b=30 으로, 주소 뒤에 물음표와 함께 값 입력
    @ResponseBody
    public int showMain3(int a, int b) {
        return a + b;
    }
}
