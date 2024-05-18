package com.example.testrun2.Service;

import com.example.testrun2.Entity.Song;
import com.example.testrun2.Repo.songRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class songService {

    private final songRepo songRepo;

    public List<Song> getAllSongs(){
        return songRepo.findAll();
    }

    public String addSong(Song request){

        var song = Song.builder()
                .name(request.getName())
                .duration(request.getDuration())
                .build();

        songRepo.save(song);

        return "SONG IS SAVED SUCCESSFULLY";
    }

    public String deleteAllSongs(){
        songRepo.deleteAll();

        return "DELETED ALL SONGS SUCCESSFULLY";
    }

    public String deleteSong(String name){

        var exist = songRepo.findByName(name);

        if (exist != null){

            songRepo.delete(exist);
            return "deleted successfully";
        }
        return "song no dey here na";
    }
}
