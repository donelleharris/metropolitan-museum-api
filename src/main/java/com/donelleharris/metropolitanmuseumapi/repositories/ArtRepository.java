package com.donelleharris.metropolitanmuseumapi.repositories;

import com.donelleharris.metropolitanmuseumapi.models.Art;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtRepository extends JpaRepository<Art, Long> {
    Art getAllByArtist(String Artist);

}
