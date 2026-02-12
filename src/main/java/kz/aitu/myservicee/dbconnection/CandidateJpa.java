package kz.aitu.myservicee.dbconnection;

import kz.aitu.myservicee.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CandidateJpa extends JpaRepository<Candidate, Long> {


}
