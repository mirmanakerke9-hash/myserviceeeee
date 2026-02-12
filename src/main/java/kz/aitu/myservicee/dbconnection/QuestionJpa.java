package kz.aitu.myservicee.dbconnection;

import kz.aitu.myservicee.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface QuestionJpa extends JpaRepository<Question, Long>{


}
