package cane.brothers.spring.dpd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.dpd.ws.geography._2012_04_17.Auth;
import ru.dpd.ws.geography._2012_04_17.DPDGeography;
import ru.dpd.ws.geography._2012_04_17.DPDGeographyService;

@Configuration
public class DpdGeoConfiguration {

    @Value("${dpd.auth.clientkey}")
    private String clientKey;

    @Value("${dpd.auth.clientnumber}")
    private Long clientNumber;
    
    @Bean
    public DPDGeography getGeo() {
        DPDGeographyService service = new DPDGeographyService();
        return service.getDPDGeographyPort();
    }

    @Bean
    public Auth getGeoAuth() {
        Auth auth = new Auth();
        auth.setClientKey(clientKey);
        auth.setClientNumber(clientNumber);
        return auth;
    }
}
