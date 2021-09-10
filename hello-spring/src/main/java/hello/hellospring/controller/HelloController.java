package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // hello 주소로 접근할 경우 매핑해주겠다. return ~~~
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   //html 바디 태그가 아니라, http 통신 프로토콜 헤더/바디 중 바디부분에 이 내용을 직접 넣어주겠다.
    // 템플릿 엔진 방식과의 차이는 뷰가 없다. 바로 클라이언트로 보내준다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody   // 기본으로 JSON으로 반환함. 요새는 JSON이 거의 표준.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   //객체를 Api로 넘기면 기본으로 JSON 방식으로 데이터를 만들어서 HTTP 응답에 반환하겠다.
    }

    static class Hello {
        private String name;
        // getter, setter 단축키 Alt + insert

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
