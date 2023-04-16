package klauda.galgenmaennchen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Functions {
    public static char[] arr1 = new char[100];
    static List<String> letters = new ArrayList<>();
    static DrawHangman drawHangman = new DrawHangman();

    public static int randomNumber() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(20);
        return randomNumber;
    }
    public static void wordUnderlined(String word) {
        System.out.print("Wort: ");
        for (int i = 0; i < word.length(); i++) {
            arr1[i] = '_';
            System.out.print(arr1[i]);
        }
        System.out.println();
    }

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

    public static boolean wordSolved(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (arr1[i] == '_') {
                return false;
            }
        }
        return true;
    }
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

    public static void endGame(int counter, String word) {
        if (counter == 7) {
            System.out.println("Spiel verloren! Das Wort wäre " + word.toUpperCase() + " gewesen!");
        } else {
            System.out.println("Du hast das Wort " + word.toUpperCase() + " richtig erraten!");
        }
    }

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