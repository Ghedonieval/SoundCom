package com.example.testrun2.Controller;

import com.example.testrun2.Entity.Artist;
import com.example.testrun2.Service.artistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/artist")
public class ArtistController {

    private final artistService service;

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtist(){
        return ResponseEntity.ok(service.getAllArtist());
    }

    @PostMapping
    public ResponseEntity<String> addArtist(@RequestBody Artist request){
        return new ResponseEntity<>(service.addArtist(request), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllArtist(){
        return ResponseEntity.ok(service.deleteAllArtist());
    }

    @DeleteMapping("/stagename")
    public ResponseEntity<String> deleteByStagename(@RequestParam("stageName") String stagename){
        return new ResponseEntity<>(service.deleteByStagename(stagename), HttpStatus.OK);
    }

    @PutMapping("/name")
    public ResponseEntity<String> updateByName(@RequestParam("name") String name , @RequestBody Artist request){
        return new ResponseEntity<>(service.updateByName(name , request) , HttpStatus.OK);
    }

    @PutMapping("/stageName")
    public ResponseEntity<String> updateStageName(@RequestParam("stageName") String stagename , @RequestBody Artist request){
        return new ResponseEntity<>(service.updateStagename(stagename, request) , HttpStatus.OK);
    }
}
