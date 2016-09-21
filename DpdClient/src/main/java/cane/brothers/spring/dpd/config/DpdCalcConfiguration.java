package cane.brothers.spring.dpd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.dpd.ws.calculator._2012_03_20.Auth;
import ru.dpd.ws.calculator._2012_03_20.DPDCalculator;
import ru.dpd.ws.calculator._2012_03_20.DPDCalculatorService;

@Configuration
public class DpdCalcConfiguration {

    @Value("${dpd.auth.clientkey}")
    private String clientKey;

    @Value("${dpd.auth.clientnumber}")
    private Long clientNumber;
    
    @Bean
    public DPDCalculator getCalc() {
		DPDCalculatorService service = new DPDCalculatorService();
		return service.getDPDCalculatorPort();
    }
    
    @Bean
	public Auth getCalcAuth() {
		Auth auth = new Auth();
		auth.setClientKey(clientKey);
		auth.setClientNumber(clientNumber);
		return auth;
	}
}
