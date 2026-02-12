package kz.aitu.myservicee.service;

import kz.aitu.myservicee.entities.Candidate;
import kz.aitu.myservicee.dbconnection.CandidateJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateJpa repo;

    public List<Candidate> findAll() {
        return repo.findAll();
    }

    public Candidate findById(int id) {

        return repo.findById((long) id).orElse(null);
    }

    public Candidate save(Candidate candidate) {
        return repo.save(candidate);
    }
}