package com.example.testrun2.Repo;

import com.example.testrun2.Entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface artistRepo extends JpaRepository<Artist, Integer> {

    public Artist findByStageName(String stageName);

}
