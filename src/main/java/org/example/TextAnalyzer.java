package org.example;

public final class TextAnalyzer {
    public static int characterCountAnalyzer(String txt) {
        int charCount = 0;
        for (int i = 0; i < txt.length(); i++)
            if (!Character.isWhitespace(txt.charAt(i)))
                charCount++;
        return charCount;
    }


    public static int wordCoountAnalyzer(String txt) {
        String[] words = txt.split("\\s");
        int count = 0;
        for (String word : words) {
            count++;
        }
        return count;
    }

    public static String longerWordCoountAnalyzer(String txt) {
        String longestWord = "";
        String[] words = txt.split(" ");
        for (String word : words)
            if (word.length() > longestWord.length())
                longestWord = word;

        return longestWord;
    }

    public static double AverageWordLengthAnalyzer(String txt) {
        String[] words = txt.split(" ");
        double wordLength = 0;
        for (String word : words)
            wordLength += word.length();

        return wordLength / words.length;
    }


    public static TextAnalysisResult analyze(String text) {
        if (text == null || text.isBlank())
            return new TextAnalysisResult(0, 0, null, 0);

        int wordCount = wordCoountAnalyzer(text);
        int characterCountExcludingWhitespace = characterCountAnalyzer(text);
        String longestWord = longerWordCoountAnalyzer(text);
        double averageWordLength = AverageWordLengthAnalyzer(text);

        return new TextAnalysisResult(wordCount, characterCountExcludingWhitespace, longestWord, averageWordLength);
    }

}