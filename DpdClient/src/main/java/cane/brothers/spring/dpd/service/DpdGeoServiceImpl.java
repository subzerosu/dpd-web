package cane.brothers.spring.dpd.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.dpd.ws.geography._2012_04_17.*;

import java.util.List;

/**
 * Created by cane on 12.09.16.
 */
@Service
public class DpdGeoServiceImpl implements DpdGeoService {

    Logger log = LoggerFactory.getLogger(DpdGeoServiceImpl.class);

    @Value("${dpd.auth.clientkey}")
    private String clientKey;

    @Value("${dpd.auth.clientnumber}")
    private Long clientNumber;

    public List<City> getCities() {
        List<City> cities = null;
        DPDGeography geo = getGeo();

        try {
            log.debug("Запросили города");
            cities = geo.getCitiesCashPay(getAuth());
            log.debug("Получили список из {} городов", cities.size());

        } catch (WSFault_Exception e) {
            log.error(e.getMessage());
        }

        return cities;
    }

    private DPDGeography getGeo() {
        DPDGeographyService service = new DPDGeographyService();
        return service.getDPDGeographyPort();
    }

    private Auth getAuth() {
        Auth auth = new Auth();
        auth.setClientKey(clientKey);
        auth.setClientNumber(clientNumber);
        return auth;
    }
}
