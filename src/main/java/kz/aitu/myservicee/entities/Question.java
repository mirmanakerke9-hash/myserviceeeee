package kz.aitu.myservicee.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private String answer;

    public Question() {
    }

    public Question(int id, String text, String answer) {
        this.id = id;
        this.text = text;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id &&
                Objects.equals(text, question.text) &&
                Objects.equals(answer, question.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
