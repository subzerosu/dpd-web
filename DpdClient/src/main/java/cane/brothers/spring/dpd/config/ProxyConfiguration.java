package cane.brothers.spring.dpd.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

//import org.apache.commons.httpclient.HostConfiguration;

@Configuration
public class ProxyConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(ProxyConfiguration.class);

	@Value("${proxy.host}")
	private String proxyHost;

	@Value("${proxy.port}")
	private String proxyPort;

	public void setProxy() {
		logger.info("настраиваем прокси через системные свойства");
		System.setProperty("http.proxyHost", proxyHost);
		System.setProperty("http.proxyPort", proxyPort);
	}

	// public void configure() {
	// HostConfiguration myHostConfig = new HostConfiguration();
	// //Setting proxy server host and port onto host config
	// myHostConfig.setProxy("192.168.1.111",8080)
	// //Setting hostconfig onto http client
	// httpClient.setHostConfiguration(myHostConfig);
	// }
}
