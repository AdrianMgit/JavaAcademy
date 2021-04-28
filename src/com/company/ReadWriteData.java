package com.company;

import java.io.*;

/**
 * Class reads or writes data from/to .txt file
 */
public class ReadWriteData {
    /**
     * Function reads text from txt file and saves it to the String and returns the variable at the end
     * @param path - full path to the .txt file
     * @return - return string that we want to be written to the file, it can be empty if file is not found or file is empty
     */
    public static String readFile(String path) {
        String readLine,inputString = new String();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
              readLine = bufferedReader.readLine();
              while (readLine!=null) {
                inputString += readLine+"\n";
                readLine=bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        return inputString;
    }

    /**
     * Function writes down string to the .txt file
     * @param path - full path to the .txt where we want to save data,if it exists, it is overwritten
     * @param text - string to be written to the file
     * @return - true If saving process is completed or false if path is wrong
     */
    public static boolean writeFile(String path,String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)))) {
            bufferedWriter.write(text);
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}


