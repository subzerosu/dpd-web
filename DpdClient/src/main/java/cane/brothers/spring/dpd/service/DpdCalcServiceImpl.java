package cane.brothers.spring.dpd.service;


import cane.brothers.spring.dpd.web.DpdCalcVo;
import cane.brothers.spring.dpd.web.DpdFacilityVo;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.PropertyMap;
import ru.dpd.ws.calculator._2012_03_20.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cane on 11.09.16.
 */
@Service
public class DpdCalcServiceImpl implements DpdCalcService {

	private static final Logger log = LoggerFactory.getLogger(DpdCalcServiceImpl.class);

    @Value("${dpd.auth.clientkey}")
    private String clientKey;

    @Value("${dpd.auth.clientnumber}")
    private Long clientNumber;

    public List<DpdFacilityVo> calculateFacilities(DpdCalcVo form) {
        if(form == null) {
            new IllegalArgumentException("form object cann't be null");
        }
        List<DpdFacilityVo> facilityList = new ArrayList<>();

        DPDCalculatorService service = new DPDCalculatorService();
        DPDCalculator calc = service.getDPDCalculatorPort();

        Auth auth = getAuth();

        CityRequest pickup = getPickupCity(form);
        CityRequest delivery = getDeliveryCity(form);

        ServiceCostParcelsRequest request = createCostRequest(auth, form, pickup, delivery);
        addParcels(request, form);

        try {
//            ModelMapper modelMapper = new ModelMapper();
//            modelMapper.addMappings(orderMap);

            List<ServiceCost> resp = calc.getServiceCostByParcels2(request);
            for(ServiceCost cost : resp) {
                // convert to vo's
//                DpdFacilityVo facility = modelMapper.map(cost, DpdFacilityVo.class);
                DpdFacilityVo facility = new DpdFacilityVo();
                facility.setFacilityName(cost.getServiceName());
                facility.setCost(cost.getCost());
                facility.setDelivery(cost.getDays());

                log.info(facility.toString());
                facilityList.add(facility);
            }

        } catch (ServiceCostFault2_Exception e) {
            log.error(e.getMessage());
        }


        return facilityList;
    }

//    private PropertyMap<ServiceCost, DpdFacilityVo> orderMap = new PropertyMap<ServiceCost, DpdFacilityVo>() {
//        protected void configure() {
//            map().setFacilityName(source.getServiceName());
//            map().setDelivery(source.getDays());
//        }
//    };

    private Auth getAuth() {
        Auth auth = new Auth();
        auth.setClientKey(clientKey);
        auth.setClientNumber(clientNumber);
        return auth;
    }

    // город отправления
    private CityRequest getPickupCity(DpdCalcVo form) {
        CityRequest city = new CityRequest();
        city.setCityId(form.getCityPickupId());
        //pickup.setCityId(49694102L);
        //pickup.setIndex(140012);
//        pickup.setRegionCode(77);
        //pickup.setRegionCode(36);
        //pickup.setCityName("Воронеж");
        //pickup.setCountryCode("RU");
        return city;
    }

    //
    private CityRequest getDeliveryCity(DpdCalcVo form) {
        CityRequest city = new CityRequest();
        city.setCityId(form.getCityDeliveryId());
        //delivery.setCityId(49265227L);
        //delivery.setRegionCode(74);
        //delivery.setCityName("Петропавловск-Камчатский");
        //delivery.setCountryCode("RU");
        return city;
    }

    private ServiceCostParcelsRequest createCostRequest(Auth auth, DpdCalcVo form, CityRequest pickup, CityRequest delivery) {
        ServiceCostParcelsRequest request = new ServiceCostParcelsRequest();
        request.setAuth(auth);

        request.setPickup(pickup);
        request.setSelfPickup(form.getCityPickupType());

        request.setDelivery(delivery);
        request.setSelfDelivery(form.getCityDeliveryType());

        return request;
    }

    private void addParcels(ServiceCostParcelsRequest request, DpdCalcVo form) {
        ParcelRequest p1 = new ParcelRequest();
//        p1.setWeight(1.5);
//        p1.setLength(50);
//        p1.setWeight(36);
//        p1.setHeight(18);
        p1.setWeight(form.getWeight());
        p1.setHeight(form.getHeight());
        p1.setLength(form.getLength());
        p1.setWidth(form.getWidth());
        p1.setQuantity(form.getQuantity());

        request.getParcel().add(p1);
    }
}
