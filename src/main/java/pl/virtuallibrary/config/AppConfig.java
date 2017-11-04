package pl.virtuallibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.virtuallibrary.google.books.api.mapper.EbookInformationMapper;

@Configuration
public class AppConfig {

    @Bean
    public EbookInformationMapper ebookInformationMapper() {
        return new EbookInformationMapper();
    }
}
