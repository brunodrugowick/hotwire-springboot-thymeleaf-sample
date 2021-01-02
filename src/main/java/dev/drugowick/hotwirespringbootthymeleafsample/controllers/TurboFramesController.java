package dev.drugowick.hotwirespringbootthymeleafsample.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TurboFramesController {

    private long johns = 1L;

    @RequestMapping(path = "/person/any")
    public String getPerson(Model model) {
        model.addAttribute("person", new Person(johns++, "New John from server"));
        return "turbo-fragments/person";
    }

    @Data @AllArgsConstructor
    class Person {
        private long id;
        private String name;
    }
}
