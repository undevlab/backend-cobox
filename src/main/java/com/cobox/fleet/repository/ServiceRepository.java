package com.cobox.fleet.repository;

import com.cobox.fleet.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {
    List<Service> findByDate(String date);
    List<Service> findByStatus(String status);
    List<Service> findByDriver(String driver);
    List<Service> findByPlate(String plate);
}
