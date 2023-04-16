package klauda.galgenmaennchen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Functions {
    public static char[] arr1 = new char[100];
    static List<String> letters = new ArrayList<>();
    static DrawHangman drawHangman = new DrawHangman();

    //Gibt eine zufällige Zahl zwischen 1-20 aus, um die Zeile aus der Textdatei auszuwählen
    public static int randomNumber() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(20);
        return randomNumber;
    }

   //Gibt das Wort mit unterstrichen aus
    public static void wordUnderlined(String word) {
        System.out.print("Wort: ");
        for (int i = 0; i < word.length(); i++) {
            arr1[i] = '_';
            System.out.print(arr1[i]);
        }
        System.out.println();
    }

    //Überprüft den eingegebenen Buchstaben, ob dieser im Wort enthalten ist
    //Falls der Buchstabe enthalten ist, wird dieser in das Wort eingesetzt
    //und der Strich an der Stelle durch den Buchstaben ersetzt
    //Des Weiteren wird in der Funktion "saveLetters" überprüft, ob der Buchstabe
    //bereits benutzt wurde. Falls ja, erfolgt eine Ausgabe, ansonsten wird dieser eingespeichert
    public static boolean enterLetterAndCheckInWord(String word) {
        String letter;
        do {
            System.out.println("Gebe einen Buchstaben ein: ");
            Scanner sc = new Scanner(System.in);
            letter = sc.next();
        } while (saveLetters(letter));
        boolean letterIn = false;
        char myLetter = letter.toLowerCase().charAt(0);
        System.out.print("Wort: ");
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == myLetter) {
                letterIn = true;
                arr1[i] = myLetter;
            }
            System.out.print(arr1[i]);
        }
        System.out.println();
        if (!letterIn) {
            System.out.println("Buchstabe ist im Wort nicht enthalten!");
        }
        return letterIn;
    }

    //Prüfen auf die Anzahl der Striche, falls das Array keine Striche mehr enthält, wird "true" zurückgegeben
    public static boolean wordSolved(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (arr1[i] == '_') {
                return false;
            }
        }
        return true;
    }

    //Hauptfunktion, welche die "Spielzüge" solange durchführt, bis entweder das Wort
    //gelöst ist, oder die Anzahl der maximalen Versuche erreicht wurde.
    public static void repeatTurn(String word) {
        int counter = 0;
        drawHangman.gallow(counter);
        wordUnderlined(word);
        while (counter != 7 && !wordSolved(word)) {
            if (!enterLetterAndCheckInWord(word)) {
                counter++;
                drawHangman.gallow(counter);
            }
        }
        endGame(counter, word);
    }

    //Prüft den Spielstand darauf, ob das Spiel verloren wurde (counter == 7) oder ob das Wort fertig
    //erraten wurde
    public static void endGame(int counter, String word) {
        if (counter == 7) {
            System.out.println("Spiel verloren! Das Wort wäre " + word.toUpperCase() + " gewesen!");
        } else {
            System.out.println("Du hast das Wort " + word.toUpperCase() + " richtig erraten!");
        }
    }

    //Funktion zum Speichern der eingegebenen Buchstaben und überprüfen, ob ein Buchstabe bereits eingegeben wurde
    public static boolean saveLetters(String letter){
        boolean letterUsed = false;
        if(letters.contains(letter)){
            letterUsed = true;
            System.out.println("Der Buchstabe wurde schon benutzt");
        }else{
            letters.add(letter);
        }
        return letterUsed;
    }
}