package dev.drugowick.hotwirespringbootthymeleafsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.nio.charset.StandardCharsets;

@Configuration
public class ThymeleafConfig {

    /**
     * It was a bit complicated to understand how this works. I ended up registering a ThymeleafViewResolver that
     * handles only templates with `stream` on their names. Other templates use the default view resolver. This was
     * necessary to make turbo-frame and turbo-stream work together.
     *
     * This creates the need for the developer to remember to name a template with `stream` in part of the name if one
     * wants to use it as a turbo-stream.
     *
     * Since the turbo-stream content-type is always sent by the turbo client, this is, for now, the ideal solution that
     * I have.
     *
     * @param templateEngine
     * @return a custom ThymeleafViewResolver for views that have a turbo-stream tag.
     */
    @Bean
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        viewResolver.setContentType("text/vnd.turbo-stream.html");
        viewResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        viewResolver.setOrder(0);
        viewResolver.setViewNames(new String[] { "*stream*" });
        viewResolver.setTemplateEngine(templateEngine);

        return viewResolver;
    }
}
