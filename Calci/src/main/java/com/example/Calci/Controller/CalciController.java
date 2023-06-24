package com.example.Calci.Controller;

import com.example.Calci.Entity.ReqParamaters;
import com.example.Calci.Entity.ResponseBody;
import com.example.Calci.Service.CalciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/add")
public class CalciController {
    @Autowired
    CalciService calciService;
    @Autowired
    ResponseBody responseBody;

    @PostMapping
    public ResponseEntity<ResponseBody> add(@RequestBody ReqParamaters reqParamaters){
        int result = calciService.add(reqParamaters.getA(),reqParamaters.getB());
        responseBody.setA(reqParamaters.getA());
        responseBody.setB(reqParamaters.getB());
        responseBody.setResult(result);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
