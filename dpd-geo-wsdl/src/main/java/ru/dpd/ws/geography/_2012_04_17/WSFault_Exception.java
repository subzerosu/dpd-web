
package ru.dpd.ws.geography._2012_04_17;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "WSFault", targetNamespace = "http://dpd.ru/ws/geography/2012-04-17")
public class WSFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private WSFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public WSFault_Exception(String message, WSFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public WSFault_Exception(String message, WSFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ru.dpd.ws.geography._2012_04_17.WSFault
     */
    public WSFault getFaultInfo() {
        return faultInfo;
    }

}