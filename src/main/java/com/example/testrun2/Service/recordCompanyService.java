package com.example.testrun2.Service;

import com.example.testrun2.Dto.Response.GenericResponse;
import com.example.testrun2.Entity.RecordingCompany;
import com.example.testrun2.Repo.recordCompanyRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class recordCompanyService {

    private final recordCompanyRepo companyRepo;

    public List<RecordingCompany> getAllCompanies(){
        log.info("show all companies");
        return companyRepo.findAll();
    }

    public GenericResponse getCompanyByName(String name){
        log.info("show company by name");
        var exist = companyRepo.findByName(name);

        if (exist != null){

            return new GenericResponse(
                    "00",
                    "THIS IS THE COMPANY DETAILS",
                    exist,
                    null
            );
        }
        return new GenericResponse(
                "11",
                name.toUpperCase() +" COMPANY DOES NOT EXIST",
                null,
                null
        );
    }

    public String addCompany(RecordingCompany request){
        log.info("add a company");
        var exist = companyRepo.findByName(request.getName());

        if (exist == null) {

            var company = RecordingCompany.builder()
                    .name(request.getName())
                    .address(request.getAddress())
                    .owner(request.getOwner())
                    .build();

            companyRepo.save(company);

            return "COMPANY ADDED SUCCESSFULLY";
        }
        return "COMPANY "+request.getName()+"ALREADY EXIST";
    }

    public String deleteByName(String name){
        log.info("delete company by name");
        var exist = companyRepo.findByName(name);

        if (exist != null){

            companyRepo.delete(exist);

            return "COMPANY NAME: "+name.toUpperCase()+" DELETED SUCCESSFULLY";
        }
        return "COMPANY NAME: "+name.toUpperCase()+" DOES NOT EXIST";
    }

    public String updateByName(String name, RecordingCompany request){
        log.info("update company by name");
        var exist = companyRepo.findByName(name);

        if (exist != null){

            exist.setName(request.getName());
            exist.setAddress(request.getAddress());
            exist.setOwner(request.getOwner());

            companyRepo.save(exist);

            return "UPDATED SUCCESSFULLY";
        }
        return "COMPANY: "+name.toUpperCase()+" DOES NOT EXIST";
    }
}
