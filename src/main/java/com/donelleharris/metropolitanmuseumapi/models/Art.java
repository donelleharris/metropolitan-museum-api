package com.donelleharris.metropolitanmuseumapi.models;

import com.donelleharris.metropolitanmuseumapi.models.Artist;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name = "artwork")
public class Art {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn()
    private Artist artist;

    @Column(nullable = false)
    private String category;

    @Column
    private Year year;

    public Art() {}

    public Art(String title, String artist, String category, Year year) {
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.year = year;
    }

    public Art(Long id, String title, String artist, String category, Year year) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.year = year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
