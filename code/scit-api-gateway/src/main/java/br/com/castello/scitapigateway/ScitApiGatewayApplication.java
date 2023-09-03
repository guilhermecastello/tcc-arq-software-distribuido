package br.com.castello.scitapigateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class ScitApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScitApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get**")
                        .filters(f -> {
                            log.info("acessando rota /get");
                            return f.addRequestHeader("Hello", "World");
                        })
                        .uri("http://localhost:8081/infracoes/smoke"))
                .build();
    }
}
