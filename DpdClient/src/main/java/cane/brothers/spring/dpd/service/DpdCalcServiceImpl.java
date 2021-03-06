package cane.brothers.spring.dpd.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cane.brothers.spring.dpd.exception.DpdCalculationException;
import cane.brothers.spring.dpd.web.DpdCalcVo;
import cane.brothers.spring.dpd.web.DpdFacilityVo;
import ru.dpd.ws.calculator._2012_03_20.Auth;
import ru.dpd.ws.calculator._2012_03_20.CityRequest;
import ru.dpd.ws.calculator._2012_03_20.DPDCalculator;
import ru.dpd.ws.calculator._2012_03_20.ParcelRequest;
import ru.dpd.ws.calculator._2012_03_20.ServiceCost;
import ru.dpd.ws.calculator._2012_03_20.ServiceCostFault2_Exception;
import ru.dpd.ws.calculator._2012_03_20.ServiceCostParcelsRequest;

/**
 * Created by cane on 11.09.16.
 */
@Service
public class DpdCalcServiceImpl implements DpdCalcService {

	private static final Logger log = LoggerFactory.getLogger(DpdCalcServiceImpl.class);

	@Autowired
	private DPDCalculator calc;

	@Autowired
	private Auth calcAuth;
	
	private List<DpdFacilityVo> facilityList = new ArrayList<>();

	@Override
	public DpdCalcVo calculateFacilities(DpdCalcVo form) {
		if (form == null) {
			new IllegalArgumentException("form object cann't be null");
		}
		facilityList.clear();

		CityRequest pickup = getPickupCity(form);
		CityRequest delivery = getDeliveryCity(form);

		ServiceCostParcelsRequest request = createCostRequest(calcAuth, form, pickup, delivery);
		addParcels(request, form);

		try {
			List<ServiceCost> resp = calc.getServiceCostByParcels2(request);
			for (ServiceCost cost : resp) {
				// convert to vo's
				DpdFacilityVo facility = new DpdFacilityVo();
				facility.setFacilityName(cost.getServiceName());
				facility.setCost(cost.getCost());
				facility.setDelivery(cost.getDays());

				log.info(facility.toString());
				facilityList.add(facility);
			}

		} catch (ServiceCostFault2_Exception e) {
			log.error(e.getMessage());
			throw new DpdCalculationException(e.getMessage(), null);
		}

		//
		return (facilityList.size() > 0 ? form : null);
	}

	@Override
	public List<DpdFacilityVo> getFacilities() {
		return facilityList;
	}

	// город отправления
	private CityRequest getPickupCity(DpdCalcVo form) {
		CityRequest city = new CityRequest();
		city.setCityId(form.getCityPickupId());
		return city;
	}

	//
	private CityRequest getDeliveryCity(DpdCalcVo form) {
		CityRequest city = new CityRequest();
		city.setCityId(form.getCityDeliveryId());
		return city;
	}

	private ServiceCostParcelsRequest createCostRequest(Auth auth, DpdCalcVo form, CityRequest pickup,
			CityRequest delivery) {
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
		p1.setWeight(form.getWeight());
		p1.setHeight(form.getHeight());
		p1.setLength(form.getLength());
		p1.setWidth(form.getWidth());
		p1.setQuantity(form.getQuantity());

		request.getParcel().add(p1);
	}

}
