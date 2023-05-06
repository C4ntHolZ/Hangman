package klauda.galgenmaennchen;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static klauda.galgenmaennchen.Functions.randomNumber;

//Funktion zum Einlesen der Textdatei, in welcher die Wörter gespeichert wurden.
//Textdatei ist unter "src/main/resources" zu finden
//Aufrufen der Random Funktion, damit hier die Anzahl der Zeilen gelesen werden kann und somit die Liste der Wörter
//auf eine beliebige Anzahl erhöht werden kann, ohne den Code dafür anzupassen.
public class FileReader {
    public  static String fileReader() throws IOException {
        int rowCounter = 0;
        URL url = FileReader.class.getClassLoader().getResource("woerter.txt");
        String datName = url.getPath();
        List<String> allWords = new ArrayList<>();
        BufferedReader in = new BufferedReader(new java.io.FileReader(datName));
        String zeile = null;
        while ((zeile = in.readLine()) != null){
            allWords.add(zeile);
            rowCounter++;
        }
        return allWords.get(randomNumber(rowCounter)).toLowerCase();
    }
}