package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Candidatures;

public interface CandidatureRepository extends JpaRepository<Candidatures, Long> {

}
