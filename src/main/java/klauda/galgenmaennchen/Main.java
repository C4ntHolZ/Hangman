package klauda.galgenmaennchen;

import java.io.IOException;

import static klauda.galgenmaennchen.FileReader.fileReader;
import static klauda.galgenmaennchen.Functions.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String word = fileReader(randomNumber());
        repeatTurn(word);
    }
}