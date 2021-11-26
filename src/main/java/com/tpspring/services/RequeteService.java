package com.tpspring.services;

import com.tpspring.entities.Requete;
import com.tpspring.repositories.RequeteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class RequeteService {
    @Autowired
    private RequeteRepository requeteRepository;
}