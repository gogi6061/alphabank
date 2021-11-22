package com.amiriskhakov.alphabank_test;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:web.properties")
public class Utils {
    @Value("${gif.broke}")
    public String brokeUrl;


    @Value("${gif.rich}")
    public  String richUrl;
}
