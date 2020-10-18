package co.edu.eam.sistemasdistribuidos.borrownotificator;

import co.edu.eam.sistemasdistribuidos.borrownotificator.utils.EmailSender;
import co.edu.eam.sistemasdistribuidos.borrownotificator.utils.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * clase de prueba de los componentes de notificacions...
 */
@RestController
@RequestMapping("/notifications")
public class test {

  @Autowired
  private EmailSender emailSender;

  @Autowired
  private SmsSender smsSender;

  @PostMapping("/mail")
  public void mail(@RequestParam String to, @RequestParam String subject ,@RequestParam String body) throws Exception {
    emailSender.sendEmail(subject,to, body);
  }

  @PostMapping("/sms")
  public void sms(@RequestParam String to, @RequestParam String message) {
    smsSender.send("+" + to, message);
  }
}
