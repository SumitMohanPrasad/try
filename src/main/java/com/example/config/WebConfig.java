package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewResolvers(ViewResolverRegistry registry) {
        // existing code remains the same
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer config) {
        // existing code remains the same
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // add the ReverseController to the interceptor chain
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
                // existing code remains the same
                return true;
            }
        });
    }
}