package cane.brothers.spring.dpd.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cane.brothers.spring.dpd.exception.DpdConnectionException;
import ru.dpd.ws.geography._2012_04_17.Auth;
import ru.dpd.ws.geography._2012_04_17.City;
import ru.dpd.ws.geography._2012_04_17.DPDGeography;
import ru.dpd.ws.geography._2012_04_17.WSFault_Exception;

/**
 * Created by cane on 12.09.16.
 */
@Service
public class DpdGeoServiceImpl implements DpdGeoService {

	private static final Logger log = LoggerFactory.getLogger(DpdGeoServiceImpl.class);

	@Autowired
	private DPDGeography geo;

	@Autowired
	private Auth geoAuth;

	private static List<City> cities = null;

	public List<City> getCities(String query) {
		if (cities == null) {
			try {
				log.debug("Запросили города");
				cities = geo.getCitiesCashPay(geoAuth);
				log.debug("Получили список из {} городов", cities.size());

			} catch (WSFault_Exception e) {
				log.error(e.getMessage());
				throw new DpdConnectionException(e.getMessage());
			}
		}

		return filterCities(cities, query);
	}

	private List<City> filterCities(List<City> cities, String query) {
		if (query == null || query.isEmpty()) {
			return cities;
		}

		List<City> filteredCities = new ArrayList<>();

		for (City city : cities) {
			if (city.getCityName().toLowerCase().contains(query.toLowerCase())
					|| city.getRegionName().toLowerCase().contains(query.toLowerCase())) {
				filteredCities.add(city);
			}
		}

		return filteredCities;
	}
}
