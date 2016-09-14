package cane.brothers.spring.dpd.web;

import cane.brothers.spring.dpd.service.DpdCalcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cane on 11.09.16.
 */
@RestController
@RequestMapping("/rest/calc")
public class DpdCalcFormController {

    Logger log = LoggerFactory.getLogger(DpdCalcFormController.class);

    @Autowired
    private DpdCalcService dpdService;

    @RequestMapping(method = RequestMethod.GET)
    public DpdCalcVo getCalcForm() {
        log.info("get new calc form");
        return new DpdCalcVo();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public DpdCalcVo workCalcForm(@RequestBody DpdCalcVo form) {
        log.info("calc form: " + form);

        dpdService.getData();
        return form;
    }
}