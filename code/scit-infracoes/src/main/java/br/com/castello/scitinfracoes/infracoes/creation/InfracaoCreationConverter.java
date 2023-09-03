package br.com.castello.scitinfracoes.infracoes.creation;

import com.google.gson.Gson;
import org.springframework.amqp.core.Message;

import java.util.Objects;

public class InfracaoCreationConverter {

    public static InfracaoCreationMessage convert(Message message) {
        if (Objects.isNull(message) || Objects.isNull(message.getBody()) || message.getBody().length == 0) {
            throw new RuntimeException("Message is empty or null");
        }

        return new Gson().fromJson(new String(message.getBody()), InfracaoCreationMessage.class);
    }

}
