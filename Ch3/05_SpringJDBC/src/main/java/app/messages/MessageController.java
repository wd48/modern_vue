package app.messages;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller // 클래스를 실제 스프링 MVC 컨트롤러로 만든다
@RequestMapping("/messages")   // URI 패턴과 일치하는 요청을 처리하도록 컨트롤러를 매핑함
public class MessageController {
  private MessageService messageService;

  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }
    @GetMapping("/welcome") // URI 패턴 (/messages/welcom)과 일치하는 요청 처리하는 메소드를 매핑함
    public String welcome(Model model) {
      model.addAttribute("message", "Hello, welcome to Spring boot!");
      return "welcome";
    }

    @PostMapping("/messages")
    @ResponseBody
    public ResponseEntity<Message> saveMessage(@RequestBody MessageData data) {
      Message saved = messageService.save(data.getText());
      if (saved == null) {
        return ResponseEntity.status(500).build();
      }
      return ResponseEntity.ok(saved);
    }

}
