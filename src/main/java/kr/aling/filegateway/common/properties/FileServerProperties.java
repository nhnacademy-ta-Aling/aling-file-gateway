package kr.aling.filegateway.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * File Server 정보 Custom Properties.
 *
 * @author : 박경서
 * @since : 1.0
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "aling.file")
public class FileServerProperties {

    private String serverPath;
    private String serverUrl;

}
