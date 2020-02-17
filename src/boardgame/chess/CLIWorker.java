package boardgame.chess;

import java.util.Scanner;

public class CLIWorker {
    private Scanner clScanner;
    public CLIWorker() {
        clScanner = new Scanner(System.in);
    }
    public String getCommand() {
        return clScanner.nextLine();
    }
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.err.println(message);
    }


}
