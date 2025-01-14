package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface BeerClient {
    Page<BeerDTO> listBeers(String beerName);
    BeerDTO getBeerById(UUID id);

    BeerDTO createBear(BeerDTO beerDTO);
}
