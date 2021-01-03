package dev.drugowick.hotwirespringbootthymeleafsample.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TurboFramesController {

    private long johns = 1L;
    private long beverages = 1L;

    @RequestMapping(path = "/person/any")
    public String getPerson(Model model) {
        model.addAttribute("person", new Person(++johns, "New John from server"));
        return "turbo-fragments/person";
    }

    @PostMapping(path = "/beverages/any")
    public String getBeverage(Model model) {
        model.addAttribute("beverage", new Person(++beverages, "Coffee"));
        return "turbo-fragments/stream_beverage";
    }

    @Data @AllArgsConstructor class Person { private long id; private String name; }
    @Data @AllArgsConstructor class Beverage { private long id; private String name; }
}
