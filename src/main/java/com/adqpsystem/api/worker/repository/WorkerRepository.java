package com.adqpsystem.api.worker.repository;

import com.adqpsystem.api.worker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, UUID> {

    public List<Worker> findAllByActiveIsTrue();
    public List<Worker> findAllByActiveIsFalse();
    public List<Worker> findAllByTitle(String title);
}
