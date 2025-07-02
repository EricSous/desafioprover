package br.com.prover.bean;

import br.com.prover.dao.WordOccurrenceDAO;
import br.com.prover.model.WordOccurrence;
import br.com.prover.service.PhraseAnalyzerService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Named("phraseBean")
@SessionScoped
public class PhraseBean implements Serializable {

    private String inputPhrase;
    private Map<String, Integer> result;
    private int distinctWordCount;

    @Inject
    private PhraseAnalyzerService analyzerService;

    @Inject
    private WordOccurrenceDAO dao;

    @PostConstruct
    public void init() {
        result = new HashMap<>();
    }

    public void analyze() {
        if (inputPhrase != null && !inputPhrase.trim().isEmpty()) {
            result = analyzerService.analyze(inputPhrase);
            distinctWordCount = result.size();

            result.forEach((word, count) -> {
                WordOccurrence occurrence = new WordOccurrence();
                occurrence.setWord(word);
                occurrence.setQuantityWordOccurrence(count);
                occurrence.setDateCreatedAt(LocalDateTime.now());
                dao.save(occurrence);
            });
        } else {
            result.clear();
            distinctWordCount = 0;
        }
    }

    public String getInputPhrase() {
        return inputPhrase;
    }

    public void setInputPhrase(String inputPhrase) {
        this.inputPhrase = inputPhrase;
    }

    public Map<String, Integer> getResult() {
        return result;
    }

    public void setResult(Map<String, Integer> result) {
        this.result = result;
    }

    public int getDistinctWordCount() {
        return distinctWordCount;
    }

    public void setDistinctWordCount(int distinctWordCount) {
        this.distinctWordCount = distinctWordCount;
    }

    public PhraseAnalyzerService getAnalyzerService() {
        return analyzerService;
    }

    public void setAnalyzerService(PhraseAnalyzerService analyzerService) {
        this.analyzerService = analyzerService;
    }

    public WordOccurrenceDAO getDao() {
        return dao;
    }

    public void setDao(WordOccurrenceDAO dao) {
        this.dao = dao;
    }
}
