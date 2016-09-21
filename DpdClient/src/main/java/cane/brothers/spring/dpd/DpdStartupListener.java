package cane.brothers.spring.dpd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cane.brothers.spring.dpd.config.ProxyConfiguration;
import cane.brothers.spring.dpd.exception.DpdConnectionException;
import cane.brothers.spring.dpd.service.DpdGeoService;

@Component
public class DpdStartupListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(DpdStartupListener.class);

	@Autowired
	private ProxyConfiguration proxyConf;
	
	@Autowired
	private DpdGeoService cityService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		proxyConf.setProxy();
		
		preloadCities();
	}

	private void preloadCities() {
		try {
			logger.info("предзагрузка городов...");
			cityService.getCities(null);
		} catch (DpdConnectionException ex) {
			logger.error(ex.getMessage());
		}
	}
}
