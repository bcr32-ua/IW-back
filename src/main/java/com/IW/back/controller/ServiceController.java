package com.IW.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.IW.back.model.Service;
import com.IW.back.repository.ServiceRepository;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public List<Service> getAllServices(){
        return serviceRepository.findAll();
    }

    @PostMapping
    public Service createService(@RequestBody Service service){
        return serviceRepository.save(service);
    }

    @PutMapping
    public Service updateService(@RequestBody Service service){
        return serviceRepository.save(service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id){
        serviceRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Service getServiceById(@PathVariable Long id){
        return serviceRepository.findById(id).orElse(null);
    }
}
