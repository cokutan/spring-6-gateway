package guru.springframework.spring6gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalRouterConfig {
  @Bean
  public RouteLocator localeRouteConfig(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route(
            r ->
                r.path("beer", "/api/v1/beer/*", "/api/v1/beer*", "/api/v1/beerUpc/*")
                    .uri("https://localhost:8080"))
        .route(r -> r.path("beer-order", "/api/v1/customers/**").uri("https://localhost:8081"))
        .route(
            r ->
                r.path("beer-inventory", "/api/v1/beer/*/inventory")
                    .uri("http://localhost:8082"))
        .build();
  }
}
