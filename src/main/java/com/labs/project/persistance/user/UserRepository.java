package com.labs.project.persistance.user;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<PersistentUser, Long> {

    boolean existsByUsername(String username);

    boolean existsByPassword(String password);

//    Optional<PersistentUser> findByUsername(String username);
//
//    @Query(
//            value = "select pu from PersistentUser pu where " +
//                    "pu.username = :username "
//    )
//    PersistentUser getByUsername(@Param("username") String username);


}
