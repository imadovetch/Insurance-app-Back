package com.programming.techie.Controller;

import com.programming.techie.Dao.JpaDao;
import com.programming.techie.Model.*;
import com.programming.techie.Services.AssuranceService;
import com.programming.techie.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AssuranceController {


    @Autowired
    private UserService userService = new UserService();


    @Autowired
    private AssuranceService assuranceService;

    @PostMapping("addAutomobileAssuration")
    public AssuranceAutomobile  addAssuranceAutomobile(@RequestBody AssuranceAutomobile assuranceAutomobile,
                                                       @RequestHeader HttpHeaders headers){

        String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);


        Long userId = Long.valueOf(authorizationHeader);

        User user = userService.findById(userId);
        assuranceAutomobile.setUser(user);
        assuranceService.addAssuranceAutomobile(assuranceAutomobile);

        return assuranceAutomobile;
    }
    @GetMapping("/Getassurances")
    public Map<String, List<?>>  getAssurancesByUserId() {
        Long userId = 1L; // Replace with the actual user ID or make it dynamic as needed


        // Return the list of assurances as JSON
        return assuranceService.getAssurancesOfUser(userId);
    }

    @PostMapping("addHabiationAssuration")
    public AssuranceHabitation addAssuranceHabitation(@RequestBody AssuranceHabitation assuranceHabitation,
                                                      @RequestHeader HttpHeaders headers){

        String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);


        Long userId = Long.valueOf(authorizationHeader);

        User user = userService.findById(userId);
        assuranceHabitation.setUser(user);
        assuranceService.addAssuranceHabitation(assuranceHabitation);

        return assuranceHabitation;
    }
    @PostMapping("addSanteAssuration")
    public AssuranceSante addAssuranceSante(@RequestBody AssuranceSante assuranceSante,
                                            @RequestHeader HttpHeaders headers){

        String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);


        Long userId = Long.valueOf(authorizationHeader);

        User user = userService.findById(userId);
        assuranceSante.setUser(user);
        assuranceService.addAssuranceSante(assuranceSante);

        return assuranceSante;
    }
}
