package com.example.testrun2.Controller;

import com.example.testrun2.Dto.Response.GenericResponse;
import com.example.testrun2.Entity.Album;
import com.example.testrun2.Service.albumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/album")
public class AlbumController {

    private final albumService service;

    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums(){
        return ResponseEntity.ok(service.getAllAlbum());
    }

    @PostMapping
    public ResponseEntity<String> addAlbum(@RequestBody Album request) {
        return new ResponseEntity<>(service.addAlbum(request), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllAlbums(){
        return ResponseEntity.ok(service.deleteAllAlbums());
    }

    @DeleteMapping("/album")
    public ResponseEntity<String> deleteAlbum(@RequestParam("album") String album){
        return new ResponseEntity<>(service.deleteAlbum(album), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<GenericResponse> updateAlbum(@RequestParam("album_name") String name , @RequestBody Album request){
        return new ResponseEntity<>(service.updateAlbum(name, request) , HttpStatus.OK);
    }
}
