package cane.brothers.spring.dpd.service;

import java.util.List;

import cane.brothers.spring.dpd.web.DpdCalcVo;
import cane.brothers.spring.dpd.web.DpdFacilityVo;

/**
 * Created by cane on 11.09.16.
 */
public interface DpdCalcService {

    boolean calculateFacilities(DpdCalcVo form);

    List<DpdFacilityVo> getFacilities();
}
