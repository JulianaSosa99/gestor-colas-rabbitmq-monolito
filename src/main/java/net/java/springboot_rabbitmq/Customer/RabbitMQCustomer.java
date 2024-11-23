package net.java.springboot_rabbitmq.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQCustomer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQCustomer.class);
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consumer(String mensaje)
    {
        LOGGER.info(String.format("Mensaje Recibido -> %s", mensaje));
    }
}
