package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BeerClientImplTest {

    @Autowired
    BeerClient beerClient;
    @Test
    void BeerClientImpl_listBeers() {
        System.out.println(beerClient.listBeers(null).getTotalElements());
    }
    @Test
    void BeerClientImpl_listBeersByName() {
        System.out.println(beerClient.listBeers("ALE").getTotalElements());
    }

    @Test
    void BeerClientImpl_GetBeerById() {
        BeerDTO beerDTO = beerClient.getBeerById(UUID.fromString("8d8f9801-f99e-4e66-8cfd-bf86177614be"));
        assertThat(beerDTO.getBeerName()).isEqualTo("#001 Golden Amber Lager");
    }

    @Test
    void BeerClientImpl_CreateNewBeer_ReturnCreatedStatusCode() {
        BeerDTO beerDTO = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("12345")
                .build();
        assertThat(beerClient.createBear(beerDTO).getId()).isNotNull();
    }

}
