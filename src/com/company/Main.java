package com.company;

/**
 * Main class - it runs the algorithm.
 * Here we can:
 * - put input text to the "inputText" variable and input characters to the "inputCharacters" variable,
 *  or put path to the .txt files with those inputs ( variables - "inputTextPath" and "inputCharactersPath")
 *  (if you put path you need to run ReadWriteData.readFile(path) to read file)
 *  - set number of digits after the decimal point in "format" variable.
 *  - create Object of the Algorithm class
 *  - call run function from the Algorithm
 *  - print results to the console or write them down to the .txt file
 */
public class Main {

    public static void main(String[] args) {
        //number of digits after the decimal
        int format=2;
        //here you provide input text and input characters
        String inputText="I love to work in global Logic!";
        String inputCharacters="LOGIC";

//        //these lines handle inputs read from .txt files
//        String inputTextPath="inputText.txt";
//        String inputCharactersPath="inputCharacters.txt";
//        String resultPath="output.txt";
//        inputText=ReadWriteData.readFile("inputText.txt");
//        inputCharacters=ReadWriteData.readFile("inputCharacters.txt");

        //these lines run the algorithm
        Algorithm algorithm=new Algorithm(inputCharacters,inputText);
        algorithm.run();
        String result=algorithm.generateOutput(format);

        //print result to the console
        System.out.println(result);

        //this line writes down the result to the .txt file only if the result path is uncommented
        //System.out.println("Result has been saved to .txt file? "+ReadWriteData.writeFile(resultPath,result));

    }


}
