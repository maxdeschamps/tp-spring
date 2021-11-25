package com.tpspring.services;

import com.tpspring.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
}