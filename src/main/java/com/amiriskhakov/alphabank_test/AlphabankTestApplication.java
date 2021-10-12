package com.amiriskhakov.alphabank_test;

import com.amiriskhakov.alphabank_test.feign_client.FeignCurrClient;
import com.amiriskhakov.alphabank_test.gif_client.FeignGifClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlphabankTestApplication {


    public static void main(String[] args) {
        SpringApplication.run(AlphabankTestApplication.class, args);

    }

}
