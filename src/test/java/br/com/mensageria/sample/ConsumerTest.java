package br.com.mensageria.sample;

import org.junit.jupiter.api.Test;

public class ConsumerTest {

    @Test
    public void testReceiveMessage() {
        Consumer consumer = new Consumer();
        consumer.receiveMessage("Test message");
    }
}
