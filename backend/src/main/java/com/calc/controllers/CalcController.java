package com.calc.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;
/**
 * Implemeting the Calculator Controller with http verbs
 *
 * */
@RestController
@RequestMapping("/api")
public class CalcController {
    @CrossOrigin
    @PostMapping("/add")
    @ResponseBody
    public Double add(@RequestParam(name = "num1") Double num1, @RequestParam(name="num2") Double num2) {
        //Simuler le temps de calcul
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return num1+num2;
    }

    /**
     * Testing API
     * */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosBySimplePath() {
        return "Its working";
    }

}

