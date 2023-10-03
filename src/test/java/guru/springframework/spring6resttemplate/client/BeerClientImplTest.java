package guru.springframework.spring6resttemplate.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
