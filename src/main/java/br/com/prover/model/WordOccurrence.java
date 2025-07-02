package br.com.prover.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "word_occurrence")
public class WordOccurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

    private int quantityWordOccurrence;

    private LocalDateTime dateCreatedAt;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantityWordOccurrence() {
        return quantityWordOccurrence;
    }

    public void setQuantityWordOccurrence(int quantityWordOccurrence) {
        this.quantityWordOccurrence = quantityWordOccurrence;
    }

    public LocalDateTime getDateCreatedAt() {
        return dateCreatedAt;
    }

    public void setDateCreatedAt(LocalDateTime dateCreatedAt) {
        this.dateCreatedAt = dateCreatedAt;
    }
}