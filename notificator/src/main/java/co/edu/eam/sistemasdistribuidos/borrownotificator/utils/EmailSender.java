package co.edu.eam.sistemasdistribuidos.borrownotificator.utils;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

  @Value("${email.from}")
  private String from;

  @Value("${email.apikey}")
  private String API_KEY;

  public void sendEmail(String subject,String to, String message) throws Exception {
    Email mailFrom = new Email(from);
    Email mailTo = new Email(to);
    Content content = new Content("text/plain", message);
    Mail mail = new Mail(mailFrom, subject, mailTo, content);

    SendGrid sg = new SendGrid(API_KEY);
    Request request = new Request();

    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
    request.setBody(mail.build());
    Response response = sg.api(request);
    System.out.println(response.getStatusCode());
    System.out.println(response.getBody());
    System.out.println(response.getHeaders());
  }
}
