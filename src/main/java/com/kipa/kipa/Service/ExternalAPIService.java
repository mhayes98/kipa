package com.kipa.kipa.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class ExternalAPIService {

    private WebClient webClient;

    @Value("${discogs.token}")
    private String discogs_token;


    public WebClient.ResponseSpec searchDiscogsByMaster(String search_query) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("https://api.discogs.com/database/search")
                        .queryParam("q", search_query)
                        .queryParam("type", "master")
                        .build())
                .header("Authorization", "Bearer " + discogs_token)
                .retrieve();
    }

    public WebClient.ResponseSpec searchDiscogsByArtist(String search_query) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("https://api.discogs.com/database/search")
                        .queryParam("q", search_query)
                        .queryParam("type", "artist")
                        .build())
                .header("Authorization", "Bearer " + discogs_token)
                .retrieve();
    }
}
