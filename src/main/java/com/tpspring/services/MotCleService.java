package com.tpspring.services;

import com.tpspring.repositories.MotCleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MotCleService {
    @Autowired
    private MotCleRepository motCleRepository;
}