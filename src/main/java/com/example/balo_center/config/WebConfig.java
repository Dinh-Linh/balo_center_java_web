package com.example.balo_center.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

        @Bean
        public ViewResolver viewResolver() {
                InternalResourceViewResolver resolver = new InternalResourceViewResolver();
                resolver.setViewClass(JstlView.class);
                resolver.setPrefix("/WEB-INF/view/");
                resolver.setSuffix(".jsp");
                return resolver;
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/resources/**")
                                .addResourceLocations("/resources/", "/src/main/webapp/resources/");

                registry.addResourceHandler("/assets/**")
                                .addResourceLocations("/resources/assets/");

                registry.addResourceHandler("/vendor/**")
                                .addResourceLocations("/resources/assets/vendor/");

                registry.addResourceHandler("/css/**")
                                .addResourceLocations("/resources/assets/css/");

                registry.addResourceHandler("/js/**")
                                .addResourceLocations("/resources/assets/js/");

                registry.addResourceHandler("/images/**")
                                .addResourceLocations("/resources/assets/img/");

                registry.addResourceHandler("/fonts/**")
                                .addResourceLocations("/resources/assets/fonts/");

                registry.addResourceHandler("/template/**")
                                .addResourceLocations("/resources/template/", "/src/main/webapp/resources/template/");

                registry.addResourceHandler("/webjars/**")
                                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
}
