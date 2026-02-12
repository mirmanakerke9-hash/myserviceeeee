package kz.aitu.myservicee.dbconnection;

import kz.aitu.myservicee.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ExamJpa extends JpaRepository<Exam, Long> {


}
