package kz.aitu.myservicee.dbconnection;

import kz.aitu.myservicee.entities.Candidate;
import kz.aitu.myservicee.entities.Question;
import kz.aitu.myservicee.entities.Exam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;

public class DbConnection {
    private final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private String username = "postgres";
    private String password = "nursaya";

    public Connection connect() throws Exception {
        return DriverManager.getConnection(URL, username, password);
    }

    public ArrayList<Candidate> getAllCandidatesRS(Connection con) throws SQLException {
        String query = "SELECT * FROM candidates";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Candidate> list = new ArrayList<>();
        while (rs.next()) {
            Candidate c = new Candidate(rs.getInt("id"), rs.getString("fullname"), rs.getInt("age"));
            list.add(c);
        }
        st.close();
        return list;
    }

    public void createCandidate(Connection con, Candidate c) throws SQLException {
        String query = "INSERT INTO candidates (id, fullname, age) VALUES (?, ?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, c.getId());
        st.setString(2, c.getFullname());
        st.setInt(3, c.getAge());
        st.executeUpdate();
        st.close();
    }

    public ArrayList<Question> getAllQuestionsRS(Connection con) throws SQLException {
        String query = "SELECT * FROM questions";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Question> list = new ArrayList<>();
        while (rs.next()) {
            Question q = new Question(rs.getInt("id"), rs.getString("text"), rs.getString("answer"));
            list.add(q);
        }
        st.close();
        return list;
    }

    public void createQuestion(Connection con, Question q) throws SQLException {
        String query = "INSERT INTO questions (id, text, answer) VALUES (?, ?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, q.getId());
        st.setString(2, q.getText());
        st.setString(3, q.getAnswer());
        st.executeUpdate();
        st.close();
    }

    public ArrayList<Exam> getAllExamsRS(Connection con) throws SQLException {
        String query = "SELECT * FROM exams";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Exam> list = new ArrayList<>();
        while (rs.next()) {
            Exam e = new Exam(rs.getInt("id"), rs.getString("title"), rs.getInt("duration"));
            list.add(e);
        }
        st.close();
        return list;
    }
    public void createExam(Connection con, Exam e) throws SQLException {
        String query = "INSERT INTO exams (id, title, duration) VALUES (?, ?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, e.getId());
        st.setString(2, e.getTitle());
        st.setInt(3, e.getDuration());
        st.executeUpdate();
        st.close();
    }
}
