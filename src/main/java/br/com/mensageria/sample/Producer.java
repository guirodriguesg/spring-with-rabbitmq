package br.com.mensageria.sample;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Producer implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args){
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(SampleApplication.topicExchangeName, SampleApplication.routingkey, "Hello from RabbitMQ!");
    }
}
