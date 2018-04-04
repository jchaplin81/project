package com.jchaplin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }





    /**@RequestMapping("/insertPainting", method = RequestMethod.POST))
    public String welcome(Map<String, Object> form) {
        Painting painting = new Painting();
        painting.setName(form.getName())
                entityManager.persist(painting);
    } */
}