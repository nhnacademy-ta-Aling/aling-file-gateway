package kr.aling.filegateway.config;

import kr.aling.filegateway.common.properties.FileServerProperties;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class RouteConfig {

    private final FileServerProperties fileServerProperties;

    /**
     * RouteLocator 정보 설정.
     *
     * @param builder RouteLocatorBuilder
     * @return RouteLocator
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                    .route("file-api-server", r -> r.path(fileServerProperties.getServerPath())
                            .filters(f -> f.rewritePath("/file/(?<path>.*)", "/${path}"))
                            .uri(fileServerProperties.getServerUrl()))
                .build();
    }
}
