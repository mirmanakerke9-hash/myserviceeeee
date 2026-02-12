package kz.aitu.myservicee.controllers;

import kz.aitu.myservicee.dbconnection.CandidateJpa;
import kz.aitu.myservicee.dbconnection.DbConnection;
import kz.aitu.myservicee.entities.Candidate;
import kz.aitu.myservicee.entities.Question;
import kz.aitu.myservicee.entities.Exam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class MyController {
    @Autowired
    ObjectMapper obMapper;
    @Autowired
    CandidateJpa candidateJpa;


    @GetMapping("/index")
    public String listener1() {
        return "AMELI (Online Exam System) - Server is running!";
    }

    @GetMapping("/index/allCandidates")
    public String getAllCandidates() {
        DbConnection myConnection = new DbConnection();
        Connection con = null;
        ArrayList<Candidate> candidates = new ArrayList<Candidate>();
        try {
            con = myConnection.connect();
            candidates = myConnection.getAllCandidatesRS(con);
        } catch (Exception e) {
            System.out.println("Database error during candidate list retrieval: " + e);
        }

        String jsonData = null;
        try {
            jsonData = obMapper.writeValueAsString(candidates);
        } catch (JsonProcessingException e) {
            System.out.println("JSON Conversion failed for candidates: " + e);
        }
        return jsonData;
    }

    @PostMapping("/index/createCandidate")
    public String createCandidate(@RequestParam String fullname, @RequestParam int age, @RequestParam int id) {
        DbConnection myConnection = new DbConnection();
        Connection con = null;
        Candidate c1 = new Candidate(id, fullname, age);
        String jsonData = null;
        try {
            con = myConnection.connect();
            myConnection.createCandidate(con, c1);
        } catch (Exception e) {
            System.out.println("Failed to insert candidate into database: " + e);
        }

        try {
            jsonData = obMapper.writeValueAsString(c1);
        } catch (JsonProcessingException e) {
            System.out.println("JSON format error for created candidate: " + e);
        }
        return jsonData;
    }

    @GetMapping("/index/allQuestions")
    public String getAllQuestions() {
        DbConnection myConnection = new DbConnection();
        Connection con = null;
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            con = myConnection.connect();
            questions = myConnection.getAllQuestionsRS(con);
        } catch (Exception e) {
            System.out.println("Database error during question list retrieval: " + e);
        }

        String jsonData = null;
        try {
            jsonData = obMapper.writeValueAsString(questions);
        } catch (JsonProcessingException e) {
            System.out.println("JSON Conversion failed for questions: " + e);
        }
        return jsonData;
    }

    @PostMapping("/index/createQuestion")
    public String createQuestion(@RequestParam String text, @RequestParam String answer, @RequestParam int id) {
        DbConnection myConnection = new DbConnection();
        Connection con = null;
        Question q1 = new Question(id, text, answer);
        String jsonData = null;
        try {
            con = myConnection.connect();
            myConnection.createQuestion(con, q1);
        } catch (Exception e) {
            System.out.println("Failed to insert question into database: " + e);
        }

        try {
            jsonData = obMapper.writeValueAsString(q1);
        } catch (JsonProcessingException e) {
            System.out.println("JSON format error for created question: " + e);
        }
        return jsonData;
    }

    @GetMapping("/index/allExams")
    public String getAllExams() {
        DbConnection myConnection = new DbConnection();
        Connection con = null;
        ArrayList<Exam> exams = new ArrayList<Exam>();
        try {
            con = myConnection.connect();
            exams = myConnection.getAllExamsRS(con);
        } catch (Exception e) {
            System.out.println("Database error during exam list retrieval: " + e);
        }

        String jsonData = null;
        try {
            jsonData = obMapper.writeValueAsString(exams);
        } catch (JsonProcessingException e) {
            System.out.println("JSON Conversion failed for exams: " + e);
        }
        return jsonData;
    }

    @PostMapping("/index/createExam")
    public String createExam(@RequestParam String title, @RequestParam int duration, @RequestParam int id) {
        DbConnection myConnection = new DbConnection();
        Connection con = null;
        Exam e1 = new Exam(id, title, duration);
        String jsonData = null;
        try {
            con = myConnection.connect();
            myConnection.createExam(con, e1);
        } catch (Exception e) {
            System.out.println("Failed to insert exam into database: " + e);
        }

        try {
            jsonData = obMapper.writeValueAsString(e1);
        } catch (JsonProcessingException e) {
            System.out.println("JSON format error for created exam: " + e);
        }
        return jsonData;
    }
}