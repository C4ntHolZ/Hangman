package klauda.galgenmaennchen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//Funktion zum Einlesen der Textdatei, in welcher die Wörter gespeichert wurden
//Textdatei ist unter "resources" zu finden
public class FileReader {
    public  static String fileReader(int row) throws IOException {
        URL url = FileReader.class.getClassLoader().getResource("woerter.txt");
        String datName = url.getPath();
        List<String> allWords = new ArrayList<>();
        File file = new File(datName);
        BufferedReader in = new BufferedReader(new java.io.FileReader(datName));
        String zeile = null;
        while ((zeile = in.readLine()) != null){
            allWords.add(zeile);
        }
        return allWords.get(row).toLowerCase();
    }
}