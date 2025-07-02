package br.com.prover.service;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class PhraseAnalyzerService {

    public Map<String, Integer> analyze(String phrase) {
        Map<String, Integer> map = new HashMap<>();

        if (phrase != null && !phrase.trim().isEmpty()) {
            String[] words = phrase.toLowerCase().split("\\W+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }

        return map;
    }
}
