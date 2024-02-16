package kr.aling.filegateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

/**
 * File API Header 검사 하는 Custom Filter.
 *
 * @author 박경서
 * @since 1.0
 **/
@Component
public class FileHeaderFilter extends AbstractGatewayFilterFactory<FileHeaderFilter.Config> {

    private static final String X_FILE_SAVE_LOCATION = "X-File-Save-Location";
    private static final String OBJECT_STORAGE = "OBJECT_STORAGE";

    /**
     * FileHeaderFilter 적용 메서드. <br>
     * Front 에서 X-File-Save-Location 헤더가 없으면 기본 으로 OBJECT_STORAGE 값을 추가합니다.
     *
     * @param config FileHeaderFilter Config
     * @return GatewayFilter
     */
    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            if (existFileSaveLocationHeader(request)) {

                request.mutate()
                        .header(X_FILE_SAVE_LOCATION, OBJECT_STORAGE)
                        .build();
            }

            return chain.filter(exchange);
        });
    }

    /**
     * X-File-Save-Location 헤더가 있는지 검사 하는 메서드.
     *
     * @param request ServerHttpRequest
     * @return 헤더가 없다면 true, 있다면 false
     */
    private static boolean existFileSaveLocationHeader(ServerHttpRequest request) {
        return !request.getHeaders().containsKey(X_FILE_SAVE_LOCATION);
    }

    /**
     * HeaderFilter Config.
     */
    public interface Config {
    }

}
