package app.messages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 클래스를 실제 스프링 MVC 컨트롤러로 만든다
@RequestMapping("/messages")   // URI 패턴과 일치하는 요청을 처리하도록 컨트롤러를 매핑함
public class MessageController {

  @GetMapping("/welcome") // URI 패턴 (/messages/welcom)과 일치하는 요청 처리하는 메소드를 매핑함
  @ResponseBody // 반환값을 HTTP 응답의 본문으로 처리하고, 이에 대응하는 HttpMessageConverter를 찾아 응답에 값을 쓴다.
  public String welcome() {
    return "Hello, welcome to Spring boot!";
  }
}
