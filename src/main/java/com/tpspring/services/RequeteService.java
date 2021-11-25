package com.tpspring.services;

import com.tpspring.repositories.RequeteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RequeteService {
    @Autowired
    private RequeteRepository requeteRepository;
}