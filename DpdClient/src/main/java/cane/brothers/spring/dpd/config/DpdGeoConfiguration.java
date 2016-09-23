package cane.brothers.spring.dpd.config;

import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import cane.brothers.spring.dpd.proxy.ICanProxy;
import cane.brothers.spring.dpd.proxy.ProxyConfiguration;
import ru.dpd.ws.geography._2012_04_17.Auth;
import ru.dpd.ws.geography._2012_04_17.DPDGeography;
import ru.dpd.ws.geography._2012_04_17.DPDGeographyService;

@Configuration
@Import(ProxyConfiguration.class)
public class DpdGeoConfiguration {

	private static final Logger log = LoggerFactory.getLogger(DpdGeoConfiguration.class);
	
	@Autowired
	private DpdAuthProperties authProperties;
	
	@Autowired(required = false)
	private ICanProxy systemProxy;

	@Bean
	public DPDGeography getGeo() {
		// TODO authconfig
		if (systemProxy != null) {
			systemProxy.configure();
		}

		DPDGeography geoPort = null;
		try {
			DPDGeographyService service = new DPDGeographyService();
			geoPort = service.getDPDGeographyPort();
		} catch (WebServiceException ex) {
			log.error("Do not have access to dpd service.", ex);
		}
		return geoPort;
	}

	@Bean
	public Auth getGeoAuth() {
		Auth auth = new Auth();
		auth.setClientKey(authProperties.getClientKey());
		auth.setClientNumber(authProperties.getClientNumber());
		return auth;
	}
}
