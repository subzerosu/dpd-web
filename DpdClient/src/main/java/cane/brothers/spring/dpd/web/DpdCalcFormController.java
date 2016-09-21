package cane.brothers.spring.dpd.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cane.brothers.spring.dpd.exception.DpdCalculationException;
import cane.brothers.spring.dpd.service.DpdCalcService;

/**
 * Created by cane on 11.09.16.
 */
@RestController
@RequestMapping("/rest/calc")
public class DpdCalcFormController {

	private static final Logger log = LoggerFactory.getLogger(DpdCalcFormController.class);

	@Autowired
	private DpdCalcService dpdService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DpdCalcVo getCalcForm(@PathVariable String id) {
		log.info("get new calc form");
		return new DpdCalcVo();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public DpdCalcVo workCalcForm(@RequestBody @Valid DpdCalcVo form, BindingResult result) {
		log.info("calc form: " + form);
		validateForm(result);
		return dpdService.calculateFacilities(form);
	}

	private void validateForm(BindingResult result) {
		if (result.hasErrors()) {
			throw new DpdCalculationException("fields may not be null", result);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<DpdFacilityVo> getFacilities() {
		log.info("get list of calculated facilities");
		return dpdService.getFacilities();
	}
}
