package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private final String BASE_URL = "http://localhost:8080";
    private final String V1_BEER = "/api/v1/beer";

    public Page<BeerDTO> listBeers() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> stringResponse =
                restTemplate.getForEntity(BASE_URL + V1_BEER, String.class);
        ResponseEntity<Map> mapResponse =
                restTemplate.getForEntity(BASE_URL + V1_BEER, Map.class);
        System.out.println(stringResponse);
        return null;
    }
}
