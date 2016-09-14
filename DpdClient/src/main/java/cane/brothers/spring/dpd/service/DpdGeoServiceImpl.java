package cane.brothers.spring.dpd.service;


import cane.brothers.spring.dpd.exception.DpdConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.dpd.ws.geography._2012_04_17.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cane on 12.09.16.
 */
@Service
public class DpdGeoServiceImpl implements DpdGeoService {

    private Logger log = LoggerFactory.getLogger(DpdGeoServiceImpl.class);

    @Value("${dpd.auth.clientkey}")
    private String clientKey;

    @Value("${dpd.auth.clientnumber}")
    private Long clientNumber;

    private static List<City> cities = null;

    public List<City> getCities(String query) throws DpdConnectionException {
        if (cities == null) {
            DPDGeography geo = getGeo();

            try {
                log.debug("Запросили города");
                cities = geo.getCitiesCashPay(getAuth());
                log.debug("Получили список из {} городов", cities.size());

            } catch (WSFault_Exception e) {
                log.error(e.getMessage());
                throw new DpdConnectionException(e.getMessage());
            }
        }

        return filterCities(cities, query);
    }

    private List<City> filterCities(List<City> cities, String query) {
        if(query == null || query.isEmpty()) {
            return cities;
        }

        List<City> filteredCities = new ArrayList<>();

        for (City city: cities) {
           if(city.getCityName().toLowerCase().contains(query.toLowerCase())
                   || city.getRegionName().toLowerCase().contains(query.toLowerCase())) {
               filteredCities.add(city);
           }
        }

        return filteredCities;
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
