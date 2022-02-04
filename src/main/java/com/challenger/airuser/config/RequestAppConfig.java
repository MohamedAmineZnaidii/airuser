package com.challenger.airuser.config;

import com.challenger.airuser.Interceptors.CustomRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created By ZNAIDI :)
 */
@Component
public class RequestAppConfig implements WebMvcConfigurer {

    /**
     * Add interceptor to log input, output and processing time
     * @param registry return registry that allows you optionally configure the registered
     *                 interceptor further for example adding URL patterns it should apply to.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomRequestInterceptor());
    }
}