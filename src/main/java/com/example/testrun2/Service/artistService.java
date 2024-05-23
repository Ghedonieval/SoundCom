package com.example.testrun2.Service;

import com.example.testrun2.Entity.Artist;
import com.example.testrun2.Repo.artistRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class artistService {

    private final artistRepo artistRepo;

    public List<Artist> getAllArtist(){
        log.info("show all artists");
        return artistRepo.findAll();
    }

    public String addArtist(Artist request){
        log.info("add an artist");
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
        log.info("delete all artists");
        artistRepo.deleteAll();

        return "ALL ARTIST DELETED SUCCESSFULLY";
    }

    public String deleteByStagename(String stagename){
        log.info("delete artist by stage name");
        var exist = artistRepo.findByStageName(stagename);

        if (exist != null){
            artistRepo.delete(exist);
            return "Artist "+stagename+" successfully deleted";
        }
        return "ARTIST"+stagename+" DOES NOT EXIST";
    }

    public String updateStagename(String stagename , Artist request){
        log.info("update artist details by stage name");
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
        log.info("update artist details by name");
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
