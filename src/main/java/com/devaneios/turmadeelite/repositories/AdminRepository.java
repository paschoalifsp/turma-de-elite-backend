package com.devaneios.turmadeelite.repositories;

import com.devaneios.turmadeelite.entities.UserCredentials;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends PagingAndSortingRepository<UserCredentials,Long> {
    public Optional<UserCredentials> findUserByEmailAndFirstAccessToken(String email, String firstAccessToken);

    Optional<UserCredentials> findByFirstAccessToken(String firstAccessToken);

    Optional<UserCredentials> findByAuthUuid(String authUuid);

    boolean existsByEmail(String email);

    @Query("FROM UserCredentials u WHERE u.role='ADMIN'")
    Page<UserCredentials> findAllAdmins(Pageable pageable);
}
