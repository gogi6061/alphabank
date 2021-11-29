package com.amiriskhakov.alphabank_test;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:web.properties")
public class Utils {

    @Value("${gif.rich}")
    public String richUrl;

    @Value("${gif.broke}")
    public String brokeUrl;

    @Value("${gif.api_key}")
    public String gifApiKey;

    @Value("${curr.url}")
    public String currUrl;

    @Value("${curr.app_id}")
    public String currAppId;
}
