package cane.brothers.spring.dpd.service;

import java.util.List;

import ru.dpd.ws.geography._2012_04_17.City;

/**
 * Created by cane on 12.09.16.
 */
public interface DpdGeoService {

    List<City> getCities(String query);
}
