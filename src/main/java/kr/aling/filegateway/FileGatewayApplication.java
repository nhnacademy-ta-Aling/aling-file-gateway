package kr.aling.filegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * File Gateway Application.
 *
 * @author : 박경서
 * @since : 1.0
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class FileGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileGatewayApplication.class, args);
	}

}
