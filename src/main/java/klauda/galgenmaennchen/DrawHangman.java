package klauda.galgenmaennchen;

public class DrawHangman {
    //Funktion, welche dazu da ist auf der Konsole ein Galgenmännchen zu malen
    public static void gallow(int mistakes){
        if(mistakes == 0){
            System.out.println("_________");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println();
        }else if (mistakes == 1) {
            System.out.println("_________");
            System.out.println("|       |");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println();
        } else if (mistakes == 2) {
            System.out.println("_________");
            System.out.println("|       |");
            System.out.println("|       O");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println();
        } else if (mistakes == 3) {
            System.out.println("_________");
            System.out.println("|       |");
            System.out.println("|       O");
            System.out.println("|       |");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println();
        } else if (mistakes == 4) {
            System.out.println("_________");
            System.out.println("|       |");
            System.out.println("|       O");
            System.out.println("|      /|");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println();
        } else if (mistakes == 5) {
            System.out.println("_________");
            System.out.println("|       |");
            System.out.println("|       O");
            System.out.println("|      /|\\");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println();
        } else if (mistakes == 6) {
            System.out.println("_________");
            System.out.println("|       |");
            System.out.println("|       O");
            System.out.println("|      /|\\");
            System.out.println("|      / ");
            System.out.println("|        ");
            System.out.println();
        } else if (mistakes == 7) {
            System.out.println("_________");
            System.out.println("|       |");
            System.out.println("|       O");
            System.out.println("|      /|\\");
            System.out.println("|      / \\");
            System.out.println("|        ");
            System.out.println();
        }
    }
}