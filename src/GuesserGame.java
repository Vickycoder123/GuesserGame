import java.util.Scanner;

class Guesser{
    public int guessNum;

    int guessingNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guesser! kindly guess the number");
        guessNum = sc.nextInt();
        return guessNum;
    }
}

class Player{
    int guessNum;
    int playerAge;

    int playerAge() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kindly enter your age :");
        playerAge = sc.nextInt();
        return playerAge;
    }

    int guessingNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player! Kindly guess the number");
        guessNum = sc.nextInt();
        return guessNum;
    }
}

class Umpire{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    void entryPass() {
        int entryPass;
        int entryFees;
        Player p = new Player();
        entryPass = p.playerAge();
        if(entryPass > 10 && entryPass < 20 ) {
            System.out.println("Free EntryPass for you");
        }
        else if(entryPass > 20 && entryPass < 50) {
            System.out.println("No free pass for you pay 1$ to continue");
            Scanner sc = new Scanner(System.in);
            entryFees = sc.nextInt();
            if(entryFees == 1) {
                System.out.println("Hurray!!! you can proceed");
            }
            else {
                System.out.println("Sorry pay to continue");
            }
        }
        else {
            System.out.println("Old is gold free pass for you");
        }
    }

    void collectNumFromGuesser() {
        Guesser obj = new Guesser();
        numFromGuesser = obj.guessingNum();
    }

    void hint() {
        if(numFromGuesser > 0 && numFromGuesser < 10) {
            System.out.println("Hint: Guess 1 to 10");
        }
        else if(numFromGuesser > 10 && numFromGuesser < 1000 ) {
            System.out.println("Hint: Guess 11 to 999");
        }
        else {
            System.out.println("No hint try your luck!!");
        }
    }

    void collectNumFromPlayer(){
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();

        numFromPlayer1 = p1.guessingNum();
        numFromPlayer2 = p2.guessingNum();
        numFromPlayer3 = p3.guessingNum();
    }

    void reinitiate(){
        System.out.println("Again Game started");
        //entryPass();
        collectNumFromGuesser();
        hint();
        collectNumFromPlayer();
        compare();

    }

    void compare(){
        if(numFromGuesser == numFromPlayer1) {
            if(numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3) {
                System.out.println("Game Draw!!");
                reinitiate();
            }
            else if(numFromGuesser == numFromPlayer2) {
                System.out.println("Player1 and Player2 won the game");
                System.out.println("Game Over");
            }
            else if(numFromGuesser == numFromPlayer3){
                System.out.println("Player1 and Player3 won the game");
                System.out.println("Game Over");
            }
            else {
                System.out.println("Player1 won the game");
                System.out.println("Game Over");
            }
        }
        else if(numFromGuesser == numFromPlayer2) {
            if(numFromGuesser == numFromPlayer3) {
                System.out.println("Player 2 and Player3 won the game");
                System.out.println("Game Over");
            }
            else {
                System.out.println("Player2 won the game");
                System.out.println("Game Over");
            }
        }
        else if(numFromGuesser == numFromPlayer3) {
            System.out.println("Player3 won the game");
            System.out.println("Game Over");
        }
        else {
            System.out.println("All lost game . Better luck next time");
            System.out.println("Game Over");
        }
    }
}

public class GuesserGame {
    public static void main(String[] args) {
        System.out.println("Game Started!!");
        Umpire u = new Umpire();
        u.entryPass();
        u.collectNumFromGuesser();
        u.hint();
        u.collectNumFromPlayer();
        u.compare();
    }
}
