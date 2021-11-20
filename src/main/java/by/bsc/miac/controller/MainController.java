package by.bsc.miac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping
    public String showMainPage(Model model){
        return "index";
    }


}
/*

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping
    public String showMainPage(Model model){
        return "index";
    }

}
*/
