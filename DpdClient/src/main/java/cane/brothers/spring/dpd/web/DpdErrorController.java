package cane.brothers.spring.dpd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cane on 12.09.16.
 */
@RestController
public class DpdErrorController implements ErrorController {

    private static final String PATH = "/error";


    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }


    @Override
    public String getErrorPath() {
        return PATH;
    }

}