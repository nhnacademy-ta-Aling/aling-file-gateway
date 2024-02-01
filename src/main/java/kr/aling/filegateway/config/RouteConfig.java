package kr.aling.filegateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 라우터 설정 class.
 *
 * @author : 박경서
 * @since : 1.0
 **/
@Configuration
public class RouteConfig {

    /**
     * RouteLocator 정보 설정.
     *
     * @param builder RouteLocatorBuilder
     * @return RouteLocator
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .build();
    }
}
