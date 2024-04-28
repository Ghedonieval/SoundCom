package com.example.testrun2.Repo;

import com.example.testrun2.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface albumRepo extends JpaRepository<Album, Integer> {

    public Album findByName(String name);
}
