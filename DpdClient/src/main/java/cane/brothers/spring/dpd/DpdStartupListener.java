package cane.brothers.spring.dpd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import cane.brothers.spring.dpd.exception.DpdConnectionException;
import cane.brothers.spring.dpd.service.DpdGeoService;

//ApplicationStartedEvent
// ContextStartedEvent
@Component
public class DpdStartupListener implements ApplicationListener<ApplicationStartedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(DpdStartupListener.class);

	@Autowired
	private DpdGeoService cityService;

	@Override
	public void onApplicationEvent(ApplicationStartedEvent arg0) {
		preloadCities();
	}

	private void preloadCities() {
		try {
			logger.info("preload cities");
			cityService.getCities(null);
		} catch (DpdConnectionException ex) {
			logger.error(ex.getMessage());
		}
	}
}
