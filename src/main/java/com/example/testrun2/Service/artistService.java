package com.example.testrun2.Service;

import com.example.testrun2.Entity.Artist;
import com.example.testrun2.Repo.artistRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class artistService {

    private final artistRepo artistRepo;

    public List<Artist> getAllArtist(){
        return artistRepo.findAll();
    }

    public String addArtist(Artist request){

        var exist = artistRepo.findByStageName(request.getStageName());

        if (exist == null) {

            var artist = Artist.builder()
                    .name(request.getName())
                    .stageName(request.getStageName())
                    .build();

            artistRepo.save(artist);

            return "ARTIST ADDED SUCCESSFULLY";
        }
        return "ARTIST WITH "+request.getStageName()+"ALREADY EXIST, PLS CHANGE STAGENAME";
    }

    public String deleteAllArtist(){

        artistRepo.deleteAll();

        return "ALL ARTIST DELETED SUCCESSFULLY";
    }

    public String deleteByStagename(String stagename){

        var exist = artistRepo.findByStageName(stagename);

        if (exist != null){
            artistRepo.delete(exist);
            return "Artist "+stagename+" successfully deleted";
        }
        return "ARTIST"+stagename+" DOES NOT EXIST";
    }

    public String updateStagename(String stagename , Artist request){

        var exist = artistRepo.findByStageName(stagename);

        if (exist != null){
            exist.setName(request.getName());
            exist.setStageName(request.getStageName());

            artistRepo.save(exist);

            return "UPDATED SUCCESSFULLY";
        }
        return "ARTIST "+ stagename + "DOES NOT EXIST";
    }

    public String updateByName(String name , Artist request){

        var exist = artistRepo.findByStageName(name);

        if (exist != null){
            exist.setName(request.getName());
            exist.setStageName(request.getStageName());

            artistRepo.save(exist);

            return "UPDATED SUCCESSFULLY";
        }
        return "ARTIST "+ name + "DOES NOT EXIST";
    }

}
