package cane.brothers.spring.dpd.service;

import cane.brothers.spring.dpd.exception.DpdConnectionException;
import ru.dpd.ws.geography._2012_04_17.City;

import java.util.List;

/**
 * Created by cane on 12.09.16.
 */
public interface DpdGeoService {

    List<City> getCities(String query) throws DpdConnectionException;
}
