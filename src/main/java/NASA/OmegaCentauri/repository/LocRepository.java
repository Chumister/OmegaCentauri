package NASA.OmegaCentauri.repository;


import NASA.OmegaCentauri.repository.dto.LocResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class LocRepository {
    private final WebClient webClient;

    private static final String baseUrl = "https://www.loc.gov/books";

    public LocRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }
    public LocRepository(WebClient webClientMock) {
        this.webClient = webClientMock;
    }
    public LocResponse getResults(String query) {
        return (LocResponse) webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("fo", "json")
                        .queryParam("at", "results")
                        .queryParam("q", query)
                        .build()
                ).retrieve()
                .bodyToMono(LocResponse.class)
                .block()
                .getResults();
    }


}