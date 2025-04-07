package com.kipa.kipa.Service;

import com.kipa.kipa.Model.DiscogsSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DiscogsSearchService {

    private WebClient webClient;

    @Value("${discogs.token}")
    private String discogsToken;

    @Autowired
    public DiscogsSearchService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.discogs.com").build();
    }

    public List<DiscogsSearchResponse> searchDiscogsByMaster(String searchQuery) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/database/search")
                        .queryParam("q", searchQuery)
                        .queryParam("type", "master")
                        .build())
                .header("Authorization", "Discogs token=" + discogsToken)
                .header("User-Agent", "Kipa/1.0")
                .retrieve()
                .bodyToMono(DiscogsSearchResponse.class)
                .map(DiscogsSearchResponse::getResults)
                .block();
    }

    public List<DiscogsSearchResponse> searchDiscogsByArtist(String searchQuery) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/database/search")
                        .queryParam("q", searchQuery)
                        .queryParam("type", "artist")
                        .build())
                .header("Authorization", "Discogs token=" + discogsToken)
                .header("User-Agent", "Kipa/1.0")
                .retrieve()
                .bodyToMono(DiscogsSearchResponse.class)
                .map(DiscogsSearchResponse::getResults)
                .block();
    }
}
