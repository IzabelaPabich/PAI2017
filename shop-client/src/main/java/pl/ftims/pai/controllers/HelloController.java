package pl.ftims.pai.controllers;

/**
 * Created by Alebazi on 2018-01-14.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by saurabh on 2/10/17.
 */

@Controller
public class HelloController {

    @RequestMapping("/")
    public String greetings(){
        return "redirect:/hello";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        return "index";
    }
}