package com.example.testrun2.Repo;

import com.example.testrun2.Entity.RecordingCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface recordCompanyRepo extends JpaRepository<RecordingCompany, Integer> {

    public RecordingCompany findByName(String name);
}
