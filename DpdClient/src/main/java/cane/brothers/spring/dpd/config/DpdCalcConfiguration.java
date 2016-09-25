package cane.brothers.spring.dpd.config;

import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.dpd.ws.calculator._2012_03_20.Auth;
import ru.dpd.ws.calculator._2012_03_20.DPDCalculator;
import ru.dpd.ws.calculator._2012_03_20.DPDCalculatorService;


@Configuration
@EnableConfigurationProperties(DpdAuthProperties.class)
public class DpdCalcConfiguration {

	private static final Logger log = LoggerFactory.getLogger(DpdCalcConfiguration.class);
	
	@Autowired
	private DpdAuthProperties authProperties;
    
    @Bean
    public DPDCalculator getCalc() {
		DPDCalculator calcPort = null;
		try {
			DPDCalculatorService service = new DPDCalculatorService();
			calcPort = service.getDPDCalculatorPort();
		} catch (WebServiceException ex) {
			log.error("Do not have access to dpd service.", ex);
		}
		return calcPort;
    }
    
    @Bean
	public Auth getCalcAuth() {
		Auth auth = new Auth();
		auth.setClientKey(authProperties.getClientKey());
		auth.setClientNumber(authProperties.getClientNumber());
		return auth;
	}
}
