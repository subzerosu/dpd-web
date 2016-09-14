package cane.brothers.spring.dpd.service;


import ru.dpd.ws.calculator._2012_03_20.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cane on 11.09.16.
 */
@Service
public class DpdCalcServiceImpl implements DpdCalcService {

    Logger log = LoggerFactory.getLogger(DpdCalcServiceImpl.class);

    @Value("${dpd.auth.clientkey}")
    private String clientKey;

    @Value("${dpd.auth.clientnumber}")
    private Long clientNumber;

    public void getData() {
        DPDCalculatorService service = new DPDCalculatorService();
        DPDCalculator calc = service.getDPDCalculatorPort();

        Auth auth = new Auth();
        auth.setClientKey(clientKey);
        auth.setClientNumber(clientNumber);

        // город отправления
        CityRequest pickup = new CityRequest();
        //pickup.setCityId(49694102L);
        //pickup.setIndex(140012);
//        pickup.setRegionCode(77);
        pickup.setRegionCode(36);
        pickup.setCityName("Воронеж");
        pickup.setCountryCode("RU");

        CityRequest delivery = new CityRequest();
        //delivery.setCityId(49265227L);
        //delivery.setRegionCode(74);
        delivery.setCityName("Петропавловск-Камчатский");
        delivery.setCountryCode("RU");

        ServiceCostParcelsRequest request = new ServiceCostParcelsRequest();
        request.setAuth(auth);

        request.setPickup(pickup);
        request.setSelfPickup(true);

        request.setDelivery(delivery);
        request.setSelfDelivery(true);

        List<ParcelRequest> parsels = request.getParcel();
        ParcelRequest p1 = new ParcelRequest();
        p1.setWeight(1.5);
        p1.setLength(50);
        p1.setWeight(36);
        p1.setHeight(18);
        parsels.add(p1);

        try {
            List<ServiceCost> resp = calc.getServiceCostByParcels2(request);

            for(ServiceCost cost : resp) {
                log.info(cost.toString());
            }

        } catch (ServiceCostFault2_Exception e) {
            log.error(e.getMessage());
        }

    }

}
