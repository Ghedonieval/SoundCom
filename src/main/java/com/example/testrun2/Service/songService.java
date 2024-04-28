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

        Song song = new Song();
        song.setName(request.getName());
        song.setDuration(request.getDuration());

        songRepo.save(song);

        return "SONG IS SAVED SUCCESSFULLY";
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
