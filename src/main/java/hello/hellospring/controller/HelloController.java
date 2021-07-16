package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello"; //hello.html 뷰 이름 return값을 맞춰주고 그곳으로 데이터랑 함께 넘기기
    }
}

