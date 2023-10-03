package guru.springframework.spring6resttemplate.client;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private final String V1_BEER = "/api/v1/beer";

    public Page<BeerDTO> listBeers(String beerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromPath(V1_BEER);
        if (beerName != null) componentsBuilder.queryParam("beerName", beerName);
        ResponseEntity<BeerPageImpl> beerPageResponse = restTemplate.getForEntity(componentsBuilder.toUriString(), BeerPageImpl.class);
        System.out.println(beerPageResponse);
        return beerPageResponse.getBody();
    }
}
