package com.company;

import java.util.*;

/**
 * Class stores the data needed to implement the algorithm and its main functions
 */
public class Algorithm {
    private String inputText;                       //ex. I love to work in global Logic!
    private String inputWord;                       //ex.LOGIC
    private String[] wordsInInputText;              //ex.7
    private int amountOfAllChars;                   //ex.24
    private int amountOfWordCharsinInput;           //ex.15
    List<ResultContainer> resultContainersList;     //ex.{(log),6},4


    public Algorithm(String inputWord,String inputText) {
        this.inputText = inputText;
        this.inputWord = inputWord;
        this.amountOfWordCharsinInput=0;
        this.resultContainersList= new ArrayList<>();
    }

    /**
     * Main function of the algorithm
     * At first it calls "changeInputs" function.
     * Then we check every word.
     * We iterate over chars in word and input characters and compare them,
     * if they are equal, we check if we didn't set it before as our found unique chars,
     * if not we add it to unique chars and we check if founded set of variables are already in the list of set,
     * if yes we update amounts of unique chars of this set
     *
     */
    public void run(){
        if(inputWord!=null && inputText!=null) {
            changeInputs();
            String sameChars,checkedCharsFromInputWord;
            int amountChars;

            for (String word : wordsInInputText) {
                sameChars ="";
                amountChars = 0;
                for (char cIn : inputWord.toCharArray()) {
                        for (char cW : word.toCharArray()) {
                            if (cIn == cW) {
                                amountChars++;
                                if (!sameChars.contains(String.valueOf(cW))) {
                                    sameChars = sameChars + cW;
                                }
                            }
                        }
                }
                amountOfWordCharsinInput += amountChars;
                if (!sameChars.isEmpty()) {
                    ResultContainer r = new ResultContainer(sameChars, word.length(), amountChars);
                    if (resultContainersList.contains(r)) {
                        int index = resultContainersList.indexOf(r);
                        r.setAmountOccurrences(r.getAmountOccurrences() + resultContainersList.get(index).getAmountOccurrences());
                        resultContainersList.set(index, r);
                    } else
                        resultContainersList.add(r);
                }
            }
            Collections.sort(resultContainersList);
        }
    }

    /**
     * Function prepares data (ex. resizes every char to lowercase, deletes special chars,
     * delete repeated chars in input word etc.)
     */
    private void changeInputs(){
        inputText = inputText.toLowerCase().replaceAll("[^a-z 0-9]","");
        inputWord = inputWord.toLowerCase().replaceAll("[^a-z0-9]","");
        wordsInInputText=inputText.split(" ");
        amountOfAllChars=inputText.replaceAll(" ","").length();
        String inputWordNotRepeatedChars="";
        for (char cIn : inputWord.toCharArray()) {
            if (!inputWordNotRepeatedChars.contains(String.valueOf(cIn)))
                inputWordNotRepeatedChars += cIn;
        }
        inputWord=inputWordNotRepeatedChars;
    }


    /**
     * Function formats output text to a desired form.
     * @param rounding - number of digits after the decimal point
     * @return - The string contains the output of the requested format
     */
    public String generateOutput(int rounding ){
        String output=new String();
        if(rounding>=0) {
            if (amountOfWordCharsinInput > 0) {
                double frequency;
                String format = "%." + rounding + "f";

                for (ResultContainer r : resultContainersList) {
                    frequency = (double) r.getAmountOccurrences() / (double) amountOfWordCharsinInput;
                    output += r + "=" + String.format(format, frequency) +
                            " (" + r.getAmountOccurrences() + "/" + amountOfWordCharsinInput + ")\n";
                }

                double totalFrequency = (double) amountOfWordCharsinInput / (double) amountOfAllChars;
                output += "TOTAL Frequency: " + String.format(format, totalFrequency) +
                        " (" + amountOfWordCharsinInput + "/" + amountOfAllChars + ") \n";
            }
            else
                output = "Not found any chars";
        }
        else
            output = "format must be >0";

        return output;
    }
}
