package kz.tshamelov.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MVCController {
    @GetMapping("/hello")
    public String helloPage(){
        return "helloworld";
    }
    @GetMapping("/goodbye")
    public String goodByePage(){
        return "second/goodbye";
    }

    @GetMapping("/modeltesting")
    public String testingModel(@RequestParam("name") String name,
                               @RequestParam(name = "password", required = false) String password,
                               Model model){
        model.addAttribute("message", "Hello" + name);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calcOperation(@RequestParam("firstInt") Double firstInt,
                                 @RequestParam("secondInt") Double secondInt,
                                 @RequestParam("operation") String operation,
                                 Model model){
        double ans = 0;
        if(operation.equals("multiplication")){
            ans = firstInt*secondInt;
        } else if(operation.equals("sum")){
            ans = firstInt+secondInt;
        } else if(operation.equals("substraction")){
            ans = firstInt-secondInt;
        } else if(operation.equals("division")){
            ans = firstInt/secondInt;
        }
        model.addAttribute("answer", ans);

        return "first/calculator";
    }
}
