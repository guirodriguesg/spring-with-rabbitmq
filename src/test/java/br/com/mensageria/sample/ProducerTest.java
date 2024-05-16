package br.com.mensageria.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProducerTest {

    @MockBean
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testRun() {
        verify(rabbitTemplate, times(1)).convertAndSend(SampleApplication.topicExchangeName, SampleApplication.routingkey, "Hello from RabbitMQ!");
    }
}