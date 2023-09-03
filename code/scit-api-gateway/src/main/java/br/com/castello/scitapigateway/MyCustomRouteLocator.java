package br.com.castello.scitapigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyCustomRouteLocator {


//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("routeInfracoes", r -> r.host("http://localhost:8080/*")
//                        .and()
//                        .path("/infracoes")
//                        .uri("http://localhost:8081/infracoes/smoke") )
//                .build();
//    }
}
