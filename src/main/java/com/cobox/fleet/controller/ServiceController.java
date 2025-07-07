package com.cobox.fleet.controller;

import com.cobox.fleet.entity.Service;
import com.cobox.fleet.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/services")
@CrossOrigin(allowedHeaders = "*", allowCredentials = "false")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceRepository.findAll();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable String id) {
        Optional<Service> service = serviceRepository.findById(id);
        return service.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        try {
            Service savedService = serviceRepository.save(service);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedService);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable String id, @RequestBody Service serviceDetails) {
        Optional<Service> optionalService = serviceRepository.findById(id);
        
        if (optionalService.isPresent()) {
            Service service = optionalService.get();
            service.setDate(serviceDetails.getDate());
            service.setRoute(serviceDetails.getRoute());
            service.setDriver(serviceDetails.getDriver());
            service.setPlate(serviceDetails.getPlate());
            service.setDepartureTime(serviceDetails.getDepartureTime());
            service.setStatus(serviceDetails.getStatus());
            
            Service updatedService = serviceRepository.save(service);
            return ResponseEntity.ok(updatedService);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable String id) {
        if (serviceRepository.existsById(id)) {
            serviceRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}