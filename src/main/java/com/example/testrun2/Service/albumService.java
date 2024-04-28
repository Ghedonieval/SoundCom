package com.example.testrun2.Service;

import com.example.testrun2.Entity.Album;
import com.example.testrun2.Repo.albumRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class albumService {

    private final albumRepo albumRepo;

    public List<Album> getAllAlbum(){

        return albumRepo.findAll();
    }

    public String addAlbum(Album request){

        Album album = new Album();
        album.setName(request.getName());
        album.setGenre(request.getGenre());
        album.setYearOfCreation(request.getYearOfCreation());
        album.setSoldCopies(request.getSoldCopies());

        albumRepo.save(album);

        return "ADDED SUCCESSFULLY";
    }

    public String deleteAllAlbums(){

        albumRepo.deleteAll();
        return "ALL ALBUMS DELETED";
    }

    public String deleteAlbum(String name){

        var exist = albumRepo.findByName(name);

        if (exist != null){
            albumRepo.delete(exist);

            return "ALBUM DELETED SUCCESSFULLY";
        }

        return "ALBUM DOES NOT EXIST";
    }
}
