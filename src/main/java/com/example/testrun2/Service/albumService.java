package com.example.testrun2.Service;

import com.example.testrun2.Dto.Response.GenericResponse;
import com.example.testrun2.Entity.Album;
import com.example.testrun2.Repo.albumRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class albumService {

    private final albumRepo albumRepo;

    public List<Album> getAllAlbum(){
        log.info("get all albums");
        return albumRepo.findAll();
    }

    public String addAlbum(Album request){
        log.info("add an album");
         var album = Album.builder()
                 .name(request.getName())
                 .genre(request.getGenre())
                 .yearOfCreation(request.getYearOfCreation())
                 .soldCopies(request.getSoldCopies())
                 .build();

        albumRepo.save(album);

        return "ADDED SUCCESSFULLY";
    }

    public String deleteAllAlbums(){
        log.info("delete all albums");
        albumRepo.deleteAll();
        return "ALL ALBUMS DELETED";
    }

    public String deleteAlbum(String name){
        log.info("delete album by name");
        var exist = albumRepo.findByName(name);

        if (exist != null){
            albumRepo.delete(exist);

            return "ALBUM DELETED SUCCESSFULLY";
        }
        return "ALBUM DOES NOT EXIST";
    }

    public GenericResponse updateAlbum(String name , Album request){
        log.info("update album details by name");
        var exist = albumRepo.findByName(name);

        if (exist != null){
            exist.setName(request.getName());
            exist.setArtist(request.getArtist());
            exist.setGenre(request.getGenre());
            exist.setYearOfCreation(request.getYearOfCreation());
            exist.setSoldCopies(request.getSoldCopies());

            albumRepo.save(exist);

            return new GenericResponse(
                    "00",
                    "UPDATED SUCCESSFULLY",
                    exist,
                    null
            );
        }
        return new GenericResponse(
                "11",
                "ALBUM NAME: "+ name.toUpperCase()+ "DOES NOT EXIST",
                null,
                null
        );
    }
}
