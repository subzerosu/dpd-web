package cane.brothers.spring.dpd.proxy;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("proxy")
public class ProxyProperties {
	
	private String host;
	private String port;
	
	public String getHost() {
		return host;
	}
	public void setHost(String proxyHost) {
		this.host = proxyHost;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String proxyPort) {
		this.port = proxyPort;
	}
	
	
}
