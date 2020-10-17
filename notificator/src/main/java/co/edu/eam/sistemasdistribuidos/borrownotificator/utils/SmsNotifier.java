package co.edu.eam.sistemasdistribuidos.borrownotificator.utils;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsNotifier {

    @Value("${sms.from}")
    private String from;

    @Value("${sms.apikey}")
    private String accountSID;

    @Value("${sms.token}")
    private String authToken;


    public void send(String to, String message) {
        TwilioRestClient client = new TwilioRestClient.Builder(accountSID, authToken).build();
        new MessageCreator(
                new PhoneNumber(to),
                new PhoneNumber(from),
                message
        ).create(client);
    }
}