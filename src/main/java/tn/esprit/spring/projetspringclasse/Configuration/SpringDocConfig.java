package tn.esprit.spring.projetspringclasse.Configuration;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }


    public Contact contactAPI() {
        return new Contact().name("Equipe ASI II")
                .email("chahnez.sardouk@esprit.tn")
                .url("https://www.linkedin.com/in/**********/");
    }

//    @Bean
//    public GroupedOpenApi chambreApi() {
//        return GroupedOpenApi.builder()
//                .group("Only Chambre Management API")
//                .pathsToMatch("/api/chambres/**")
//                .pathsToExclude("**")
//                .build();
//    }
    @Bean
    public GroupedOpenApi blocApi() {
        return GroupedOpenApi.builder()
                .group("Only inscription Management API")
                .pathsToMatch("/inscription/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi skieurApi() {
        return GroupedOpenApi.builder()
                .group("Only skieur Management API")
                .pathsToMatch("/skieurs/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi moniteurApi() {
        return GroupedOpenApi.builder()
                .group("Only moniteurs Management API")
                .pathsToMatch("/moniteurs/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi pisteApi() {
        return GroupedOpenApi.builder()
                .group("Only piste Management API")
                .pathsToMatch("/pistes/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi coursApi() {
        return GroupedOpenApi.builder()
                .group("Only cours Management API")
                .pathsToMatch("/cours/**")
                .pathsToExclude("**")
                .build();
    }

}
