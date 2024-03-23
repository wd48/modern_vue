package app.messages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    // 3. 필드 기반의 주입
    @Autowired
    private MessageRepository repository;

    /**
     @Required -> setter method
     @Autowired -> constructor, method, field
     의존성 주입방법
     - 생성자 기반의 주입
     - 세터 기반/메소드 기반의 주입
     - 필드 기반의 주입
     */
    // 1. 생성자 기반 주입
    @Autowired
    public MessageService (MessageRepository repository) {
        this.repository = repository;
    }

    // 2. 세터 기반/메소드 기반의 주입
    @Required
    public void setRepository(MessageRepository repository) {
      this.repository = repository;
    }

    public void save(String text) {
          this.repository.saveMessage(new Message(text));
      }




}
