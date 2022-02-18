package com.labs.project.persistance.admin;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface AdminRepository extends JpaRepositoryImplementation<PersistentAdmin, Long> {
}
