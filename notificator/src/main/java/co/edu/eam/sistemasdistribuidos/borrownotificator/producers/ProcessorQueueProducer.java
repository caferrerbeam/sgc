package co.edu.eam.sistemasdistribuidos.borrownotificator.producers;

import co.edu.eam.sistemasdistribuidos.borrownotificator.models.UserNotificationData;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProcessorQueueProducer {

  /**
   * MEtodo para notificar enviarle al procesador de solicitud que ya fue notificado al usuario
   * el resultado del estudio..
   *
   *
   * @param objeto con laifnromacion necesaria
   */
  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private DirectExchange directExchange;

  /*el tipo de dato lo definen uds aqui  UserNotificationData userNotificationData*/
  public void notifyBorrowRequestNotification( long dato ) throws Exception {
    //enviar como json el BorrowRequest
    //este metodo lo podria usar en el servicio que consulta los datos de la bd en notificatorService
    // con esta forma ProcessorQueueProducer.notifyBorrowRequestNotification(e ingresa el parametro del service);
    //el parametro se obtiene hay en el notificatorService

    //falta consultar en la bd y enviar notificaciones por email
    String json= "{'id_solicitud' :"+"'"+dato+"'"+"}";

    //envia los datos a una cola que indica que ya se mando la notificacion
    //ObjectMapper objectMapper = new ObjectMapper();
    //String userNotiDataJson = objectMapper.writeValueAsString(userNotificationData);

    rabbitTemplate.convertAndSend(directExchange.getName(),"notifications_result_queue",json);

  }
}
