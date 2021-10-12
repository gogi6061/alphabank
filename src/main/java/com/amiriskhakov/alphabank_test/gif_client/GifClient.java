package com.amiriskhakov.alphabank_test.gif_client;

import feign.RequestLine;

public interface GifClient {
    String API_KEY = "ITXQNpcYwlYL5dBQnwkwe8HwLDNk2psr";

    @RequestLine("GET /random?api_key=ITXQNpcYwlYL5dBQnwkwe8HwLDNk2psr&tag=broke")
    Object getBrokeGif();
}
