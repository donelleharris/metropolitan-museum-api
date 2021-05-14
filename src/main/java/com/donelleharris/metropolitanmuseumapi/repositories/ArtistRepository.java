package com.donelleharris.metropolitanmuseumapi.repositories;

import com.donelleharris.metropolitanmuseumapi.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist getArtist();
}
