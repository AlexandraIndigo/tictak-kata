package com.tictak;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @RequestMapping("/game")
    public String hello(Model model) {
        model.addAttribute("name", "TicTak");
        return "game";
    }



}
