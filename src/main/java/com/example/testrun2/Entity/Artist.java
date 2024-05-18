package com.example.testrun2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String stageName;

    @ManyToOne
    @JoinColumn(name = "recordingCompany_id")
    private RecordingCompany recordingCompany;

    @OneToMany(mappedBy = "artist" , cascade = CascadeType.ALL)
    private List<Album> albums;
}
