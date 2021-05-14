package com.donelleharris.metropolitanmuseumapi.repositories;

import com.donelleharris.metropolitanmuseumapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long userId);
}
