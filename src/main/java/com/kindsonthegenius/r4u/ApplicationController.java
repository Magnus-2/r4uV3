package com.kindsonthegenius.r4u;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String goHome(){
        return "index";
    }

    @GetMapping("/Reservations")
    public String hr(){
        return "Reservations/index";
    }

    @GetMapping("/fleet")
    public String fleet(){
        return "fleet/index";
    }

    @GetMapping("/reservation")
    public String accounts(){
        return "reservation/index";
    }

    @GetMapping("/payroll")
    public String payroll(){
        return "payroll/index";
    }

    @GetMapping("/helpdesk")
    public String helpdesk(){
        return "helpdesk/index";
    }

    @GetMapping("/parameters")
    public String parameters(){
        return "parameters/index";
    }

    @GetMapping("/reports")
    public String reports(){
        return "reports/index";
    }

    @GetMapping("/security")
    public String security(){
        return "security/index";
    }

}
