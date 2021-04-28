package com.company;

import java.util.Objects;

/**
 * Class stores the set of: characters, word length and the number of occurrences of repeated characters
 */
public class ResultContainer implements Comparable<ResultContainer> {
    private String string;
    private int wordLenght;
    private int amountOccurrences;

    public ResultContainer(String string, int wordLenght,int amountOccurrences) {
        this.string = string;
        this.wordLenght = wordLenght;
        this.amountOccurrences=amountOccurrences;
    }


    @Override
    public String toString() {
        return "{("+string+"),"+wordLenght+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultContainer that = (ResultContainer) o;
        return wordLenght == that.wordLenght && string.equals(that.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, wordLenght);
    }


    @Override
    public int compareTo(ResultContainer o) {
        if(string.equals(o.string) && wordLenght==o.wordLenght)
            return 0;
        else if(amountOccurrences>o.amountOccurrences)
            return 1;
        else
            return -1;
    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getWordLenght() {
        return wordLenght;
    }

    public void setWordLenght(int wordLenght) {
        this.wordLenght = wordLenght;
    }

    public int getAmountOccurrences() {
        return amountOccurrences;
    }

    public void setAmountOccurrences(int amountOccurrences) {
        this.amountOccurrences = amountOccurrences;
    }

}
