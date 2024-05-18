package com.example.testrun2.Controller;

import com.example.testrun2.Dto.Response.GenericResponse;
import com.example.testrun2.Entity.RecordingCompany;
import com.example.testrun2.Service.recordCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/recordcompany")
public class RecordCompanyController {

    private final recordCompanyService service;

    @GetMapping
    public ResponseEntity<List<RecordingCompany>> getAllCompanies(){
        return ResponseEntity.ok(service.getAllCompanies());
    }

    @GetMapping("/name")
    public ResponseEntity<GenericResponse> getCompanyByName(@RequestParam("name") String name){
        return new ResponseEntity<>(service.getCompanyByName(name) , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody RecordingCompany request){
        return new ResponseEntity<>(service.addCompany(request), HttpStatus.OK);
    }

    @DeleteMapping("/name")
    public ResponseEntity<String> deleteCompany(@RequestParam("name") String name){
        return new ResponseEntity<>(service.deleteByName(name) , HttpStatus.OK);
    }

    @PutMapping("/name")
    public ResponseEntity<String> updateCompany(@RequestParam("name") String name, @RequestBody RecordingCompany request){
        return new ResponseEntity<>(service.updateByName(name, request) , HttpStatus.OK);
    }
}
