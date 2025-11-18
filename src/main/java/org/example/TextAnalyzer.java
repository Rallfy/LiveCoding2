package org.example;

import java.util.Arrays;
import java.util.Comparator;

public final class TextAnalyzer {
    public static int characterCountAnalyzer(String txt) {
        return Math.toIntExact(txt.chars().
                filter(character -> !Character.isWhitespace(character))
                .count());
    }


    public static int wordCoountAnalyzer(String txt) {
        return Math.toIntExact(Arrays.stream(txt.split("\\s"))
                .filter(word -> !word.isBlank())
                .count());
    }

    public static String longestWordCoountAnalyzer(String txt) {
        return Arrays.stream(txt.split("\\s"))
                .filter(word -> !word.isBlank())
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public static double AverageWordLengthAnalyzer(String txt) {
        return Arrays.stream(txt.split("\\s"))
                .filter(word -> !word.isBlank())
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
    }


    public static TextAnalysisResult analyze(String text) {
        if (text == null || text.isBlank())
            return new TextAnalysisResult(0, 0, null, 0);

        int wordCount = wordCoountAnalyzer(text);
        int characterCountExcludingWhitespace = characterCountAnalyzer(text);
        String longestWord = longestWordCoountAnalyzer(text);
        double averageWordLength = AverageWordLengthAnalyzer(text);

        return new TextAnalysisResult(wordCount, characterCountExcludingWhitespace, longestWord, averageWordLength);
    }

}