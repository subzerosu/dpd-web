package cane.brothers.spring.dpd.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnProperty(prefix = "proxy", name = "host")
@EnableConfigurationProperties(ProxyProperties.class)
public class ProxyConfiguration {

	private static final Logger log = LoggerFactory.getLogger(ProxyConfiguration.class);

	@Autowired
	private ProxyProperties properties;
	
	@Bean
	public ICanProxy getSystemProxy() {
		return new ICanProxy() {
			@Override
			public void configure() {
				log.info("configure proxy via system properties");
				System.setProperty("http.proxyHost", properties.getHost());
				System.setProperty("http.proxyPort", properties.getPort());
			}
		};
	}
}
