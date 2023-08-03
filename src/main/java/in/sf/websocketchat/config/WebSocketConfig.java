package in.sf.websocketchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // enables websocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    // this interface provides configuration for websocket

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // The client will use this websocket endpoint to connect to websocket server
        registry.addEndpoint("/ws").withSockJS();
        // withStockJS enables a fallback option for browsers that do not support websocket

        // STOMP: Simple Text Oriented Messaging Protocol
        // This method comes from spring framework STOMP implementation
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // this configures a message broker that route messages from one client to another
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
