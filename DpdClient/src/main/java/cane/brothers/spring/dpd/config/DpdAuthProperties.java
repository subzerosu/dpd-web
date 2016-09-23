package cane.brothers.spring.dpd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("dpd.auth")
public class DpdAuthProperties {

	private String clientKey;

	private Long clientNumber;
	
	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public Long getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(Long clientNumber) {
		this.clientNumber = clientNumber;
	}
}
