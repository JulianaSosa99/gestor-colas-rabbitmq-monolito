package net.java.springboot_rabbitmq.Controller;

import net.java.springboot_rabbitmq.Publisher.RabbitMQProductor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MensajeController {

    private RabbitMQProductor productor;

    public MensajeController(RabbitMQProductor productor) {
        this.productor = productor;
    }

    @GetMapping("/publicar")
    public ResponseEntity<String> enviarMensaje(@RequestParam("mensaje")String mensaje)
    {
       productor.enviarMensaje(mensaje);
       return ResponseEntity.ok("Mensaje enviado a RabbitMQ...");
    }

}
