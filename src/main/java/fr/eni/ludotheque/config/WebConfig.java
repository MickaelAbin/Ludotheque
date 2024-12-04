package fr.eni.ludotheque.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import fr.eni.ludotheque.converter.StringToGenreConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final StringToGenreConverter stringToGenreConverter;

    public WebConfig(StringToGenreConverter stringToGenreConverter) {
        this.stringToGenreConverter = stringToGenreConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToGenreConverter);
    }
}
