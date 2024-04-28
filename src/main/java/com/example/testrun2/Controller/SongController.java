package com.example.testrun2.Controller;

import com.example.testrun2.Entity.Song;
import com.example.testrun2.Repo.songRepo;
import com.example.testrun2.Service.songService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/song")
public class SongController {

    private final songService service;

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs(){
        return ResponseEntity.ok(service.getAllSongs());
    }

    @PostMapping
    public ResponseEntity<String> addSong(@RequestBody Song request){
        return new ResponseEntity<>(service.addSong(request) , HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteSong(@RequestParam String name){
        return ResponseEntity.ok(service.deleteSong(name));
    }
}
