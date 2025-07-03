package br.com.prover.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PhraseAnalyzerServiceTest {

    private PhraseAnalyzerService service;

    @BeforeEach
    void setUp() {
        service = new PhraseAnalyzerService();
    }

    @Test
    void testAnalyzeWithNormalPhrase() {
        String phrase = "O sol nasce para todos mas brilha mais para quem acorda cedo";
        Map<String, Integer> result = service.analyze(phrase);

        Assertions.assertEquals(11, result.size());
        Assertions.assertEquals(2, result.get("para"));
        Assertions.assertEquals(1, result.get("sol"));
        Assertions.assertEquals(1, result.get("quem"));
    }

    @Test
    void testAnalyzeWithEmptyString() {
        Map<String, Integer> result = service.analyze("");
        assertTrue(result.isEmpty());
    }

    @Test
    void testAnalyzeWithNull() {
        Map<String, Integer> result = service.analyze(null);
        assertTrue(result.isEmpty());
    }

    @Test
    void testAnalyzeIgnoresPunctuation() {
        String phrase = "Olá, mundo! Olá?";
        Map<String, Integer> result = service.analyze(phrase);

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(2, result.get("olá"));
        Assertions.assertEquals(1, result.get("mundo"));
    }

    @Test
    void testAnalyzeCaseInsensitive() {
        String phrase = "Java java JAVA";
        Map<String, Integer> result = service.analyze(phrase);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(3, result.get("java"));
    }
}
