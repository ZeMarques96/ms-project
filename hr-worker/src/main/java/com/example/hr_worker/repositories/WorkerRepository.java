package com.example.hr_worker.repositories;

import com.example.hr_worker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
