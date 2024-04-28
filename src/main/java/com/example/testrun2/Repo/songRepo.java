package com.example.testrun2.Repo;

import com.example.testrun2.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface songRepo extends JpaRepository<Song, Integer> {

    public Song findByName(String name);
}
