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
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private final String V1_BEER = "/api/v1/beer";
    private final String V1_BEER_BY_ID = "/api/v1/beer/{beerId}";

    public Page<BeerDTO> listBeers(String beerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromPath(V1_BEER);
        if (beerName != null) componentsBuilder.queryParam("beerName", beerName);
        ResponseEntity<BeerPageImpl> beerPageResponse = restTemplate.getForEntity(componentsBuilder.toUriString(), BeerPageImpl.class);
        System.out.println(beerPageResponse);
        return beerPageResponse.getBody();
    }

    @Override
    public BeerDTO getBeerById(UUID beerId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForObject(V1_BEER_BY_ID, BeerDTO.class, beerId);
    }
}
