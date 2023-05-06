package NASA.OmegaCentauri.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LocService {

    private final WebClient webClient;

    private static final String baseUrl = "https://www.loc.gov/books";

    public LocService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getResults(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("fo", "json")
                        .queryParam("at", "results")
                        .queryParam("q", query)
                        .build()
                ).retrieve()
                .bodyToMono(String.class)
                .block();
    }

}