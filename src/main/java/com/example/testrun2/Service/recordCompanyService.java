package com.example.testrun2.Service;

import com.example.testrun2.Entity.RecordingCompany;
import com.example.testrun2.Repo.recordCompanyRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class recordCompanyService {

    private final recordCompanyRepo companyRepo;

    public List<RecordingCompany> getAllCompanies(){

        return companyRepo.findAll();

    }

    public String addCompany(RecordingCompany request){

        var exist = companyRepo.findByName(request.getName());

        if (exist == null) {

            RecordingCompany company = new RecordingCompany();
            company.setName(request.getName());
            company.setAddress(request.getAddress());
            company.setOwner(request.getOwner());

            companyRepo.save(company);

            return "COMPANY ADDED SUCCESSFULLY";

        }

        return "COMPANY "+request.getName()+"ALREADY EXIST";

    }

    public String deleteByName(String name){

        var exist = companyRepo.findByName(name);

        if (exist != null){

            companyRepo.delete(exist);

            return "COMPANY NAME: "+name+" DELETED SUCCESSFULLY";

        }

        return "COMPANY NAME: "+name+" DOES NOT EXIST";

    }

    public String updateByName(String name, RecordingCompany request){

        var exist = companyRepo.findByName(name);

        if (exist != null){

            exist.setName(request.getName());
            exist.setAddress(request.getAddress());
            exist.setOwner(request.getOwner());

            companyRepo.save(exist);

            return "UPDATED SUCCESSFULLY";

        }

        return "COMPANY: "+name+" DOES NOT EXIST";

    }
}
