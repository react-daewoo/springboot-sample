package com.example.sample;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("/test-basic")
    public String testBasic(Model model) {
        model.addAttribute("data", "<b>Hello Spring</b>");

        return "basic/text-basic";
    }

    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("UserA", 10);
        User userB = new User("UserB", 20);

        List<User> list = new ArrayList<>(Arrays.asList(userA, userB));

        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);
        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "basic/variable";
    }

    @GetMapping("/basic-objects")
    public String basicObject(
            HttpServletRequest request,
            HttpSession httpSession,
            Model model
    ) {
        httpSession.setAttribute("sessionData", "Hello Session");
        model.addAttribute("request", request);
        return "basic/basic-objects";
    }

    @Data
    static class User {
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    @Component("helloBean")
    static class HelloBean {
        public String hello(String data) {
            return "Hello 12341234" + data;
        }
    }

    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";
    }

    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");

        return "basic/link";
    }
}
