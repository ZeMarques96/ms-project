package com.example.hr_worker.resources;

import com.example.hr_worker.entities.Worker;
import com.example.hr_worker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

        @Autowired
        private WorkerRepository workerRepository;

        @GetMapping
        public ResponseEntity<List<Worker>> findAll(){
            List<Worker> list = workerRepository.findAll();

            return ResponseEntity.ok(list);
        }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = workerRepository.findById(id).get();

        return ResponseEntity.ok(worker);
    }
}
