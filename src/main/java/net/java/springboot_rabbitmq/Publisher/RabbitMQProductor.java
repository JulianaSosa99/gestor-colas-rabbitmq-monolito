package net.java.springboot_rabbitmq.Publisher;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:4.0.3-management

@Service
public class RabbitMQProductor {
    @Value("${rabbitmq.exchange.name}")
    private  String exchange;

    //creacion de LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProductor.class);
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQProductor(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public  void enviarMensaje(String mensaje)
    {
        LOGGER.info(String.format("Mensaje enviado ->%s", mensaje));
        rabbitTemplate.convertAndSend(exchange,"",mensaje);

    }
}
