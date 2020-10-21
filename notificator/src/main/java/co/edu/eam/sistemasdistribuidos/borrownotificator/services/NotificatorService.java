package co.edu.eam.sistemasdistribuidos.borrownotificator.services;

import co.edu.eam.sistemasdistribuidos.borrownotificator.models.UserNotificationData;
import co.edu.eam.sistemasdistribuidos.borrownotificator.producers.ProcessorQueueProducer;
import co.edu.eam.sistemasdistribuidos.borrownotificator.repositories.UserNotificationDataRepository;
import co.edu.eam.sistemasdistribuidos.borrownotificator.utils.EmailSender;
import co.edu.eam.sistemasdistribuidos.borrownotificator.utils.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificatorService {

  @Autowired
  private UserNotificationDataRepository UserNotificationDataRepository;

  @Autowired
  private ProcessorQueueProducer processorQueueProducer;

  @Autowired
  private EmailSender emailSender;

  @Autowired
  private SmsSender smsSender;
  /**
   * metodo para notificar al usuario un mensaje.
   * tener en cuenta que si el usuario no tiene correo no se le debe enviar correo,
   * si no tiene celular, no se le debe enviar celular.
   */
  public void notifyBorrowRequestToUser(long id,String mensaje, String asunto, Long borrow_request_id) throws Exception {
    UserNotificationData datos = UserNotificationDataRepository.findById(id).get();
    String email = datos.getEmail();
    String numero = datos.getMobileNumber();


    System.out.println("este es el email y el numero "+email+" "+numero);
    //if(email.length()>0){
      //System.out.println("enviando correo");
    //try {
      //emailSender.sendEmail(asunto, email, mensaje);
    //}catch (Exception e){
      //System.out.println("no se pudo enviar email"+e);
    //}
    //}
    System.out.println("el numero no esta vacio ? "+!numero.isEmpty());
    //funciona solo con numeros que esten verificados en Twilio si no estan no funciona
    if(!numero.isEmpty()){
      System.out.println("enviando sms");
      try {
        smsSender.send(numero, mensaje);
      }catch (Exception e){
        System.out.println("no se pudo enviar sms"+e);
      }
    }
    processorQueueProducer.notifyBorrowRequestNotification(borrow_request_id);


  }

}
