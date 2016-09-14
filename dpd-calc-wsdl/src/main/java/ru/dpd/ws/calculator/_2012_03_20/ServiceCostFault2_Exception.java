
package ru.dpd.ws.calculator._2012_03_20;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ServiceCostFault2", targetNamespace = "http://dpd.ru/ws/calculator/2012-03-20")
public class ServiceCostFault2_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ServiceCostFault2 faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ServiceCostFault2_Exception(String message, ServiceCostFault2 faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ServiceCostFault2_Exception(String message, ServiceCostFault2 faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ru.dpd.ws.calculator._2012_03_20.ServiceCostFault2
     */
    public ServiceCostFault2 getFaultInfo() {
        return faultInfo;
    }

}
