package com.microservices.microservices.Controller;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
