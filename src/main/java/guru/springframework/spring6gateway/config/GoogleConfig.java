package guru.springframework.spring6gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("google")
@Configuration
public class GoogleConfig {
  @Bean
  public RouteLocator googleRouteConfig(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route(
            r ->
                r.path("google", "/googlesearch2")
                    .filters(f -> f.rewritePath("/googlesearch2(?<segment>/?.*)", "/${segment}"))
                    .uri("https://www.google.com"))
        .build();
  }
}
