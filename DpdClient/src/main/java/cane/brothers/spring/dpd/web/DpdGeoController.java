package cane.brothers.spring.dpd.web;

import cane.brothers.spring.dpd.exception.DpdConnectionException;
import cane.brothers.spring.dpd.service.DpdGeoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dpd.ws.geography._2012_04_17.City;

import java.util.List;

/**
 * Created by cane on 12.09.16.
 */
@RestController
@RequestMapping("/rest/geo")
public class DpdGeoController {

    Logger log = LoggerFactory.getLogger(DpdCalcFormController.class);

    @Autowired
    private DpdGeoService dpdService;

//    @RequestMapping(method = RequestMethod.GET)
//    public List<City> getAllCities() throws DpdConnectionException {
//        log.debug("get all cities");
//        return dpdService.getCities(null);
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<City> getCities(@RequestParam String query) throws DpdConnectionException {
        log.debug("get cities by query");
        return dpdService.getCities(query);
    }

//    @RequestMapping(value="/{cityName}", method = RequestMethod.GET)
//    public List<City> getCitiesByName(@RequestParam(value="cityName") String cityName) {
//        log.debug("get cities by name");
//        return dpdService.getCities();
//    }
}
