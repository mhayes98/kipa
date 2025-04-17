package com.kipa.kipa.Service;

import com.kipa.kipa.Model.DiscogsMasterResponse;
import com.kipa.kipa.Model.DiscogsTrack;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@Service
public class DiscogsMasterService {

    private WebClient webClient;

    @Value("${discogs.token}")
    private String discogsToken;

    @Autowired
    public DiscogsMasterService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.discogs.com").build();
    }

    public Mono<List<DiscogsTrack>> getTracklistByMasterID(String masterID) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/masters/{id}")
                        .build(masterID))
                .header("User-Agent", "Kipa/1.0")
                .retrieve()
                .bodyToMono(DiscogsMasterResponse.class)
                .map(DiscogsMasterResponse::getTracklist);
    }

}
