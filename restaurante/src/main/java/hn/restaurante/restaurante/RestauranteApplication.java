package hn.restaurante.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class RestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}

		@Bean
	public OpenAPI personalizacioOpenAPI(){
		return new OpenAPI().info(new Info()
					.title("Api Restaurante")
					.version("1.0")
					.description("Manejo de un restaurante mediante servicios REST"));	
	}
	
}
