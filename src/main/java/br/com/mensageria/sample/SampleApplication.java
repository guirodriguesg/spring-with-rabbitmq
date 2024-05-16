package br.com.mensageria.sample;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleApplication {

	static final String queueName = "sms_notification";
	static final String topicExchangeName = "sms_exchange";
	static final String routingkey = "sms_routingkey";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	/**
	 * @DirectExchange é útil para roteamento de mensagens de um-para-um onde a correspondência exata da chave de roteamento é necessária,
	 * @TopicExchange é útil para roteamento de mensagens de um-para-muitos onde você deseja selecionar mensagens com base em padrões de chave de roteamento.
	 * @return
	 */
	@Bean
	DirectExchange exchange() {
//		return new TopicExchange(topicExchangeName);
		return new DirectExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingkey);
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
											 MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Consumer receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
