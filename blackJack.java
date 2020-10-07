import java.util.Random;
import java.util.Scanner;
import java.util.*;

class Main {

  public static void main(String[] args) {

    Vector deck = new Vector();

    for (int i = 1; i <= 11; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(i);
        if (i == 10) {
          deck.add(i);
          deck.add(i);
        }
      }
    }

    System.out.println("Welcome to BLACKJACK!");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Are you ready to play? y/n ");
    String userInput = scanner.nextLine();

    Random rand = new Random();
    int card1_index = 0;
    int card2_index = 0;
    int card1 = 0;
    int card2 = 0;
    int dealerCard = 0;
    
    while (userInput.equals("y")) {
      System.out.println("ENTER WHILE LOOP");
      Vector myCards = new Vector();
      int upperBound = deck.size();
      card1_index = rand.nextInt(upperBound);

      // card1 = deck.get(card1_index);
      deck.remove(card1_index);
      upperBound--;
      card2_index = rand.nextInt(upperBound);
      // card2 = deck.get(card2_index);
      deck.remove(card2_index);
      upperBound--;
      System.out.println("Dealer ")



      userInput = scanner.nextLine();





    }


    // 17 or higher stay
    // 16 or lower must hit
    // Scanner scanner = new Scanner(System.in);
    // String playAgain = "y";
    // while (playAgain == 'y') {
    //   // receive two cards
    //   Random rand = new Random();
    //   int upperBound = cards.size();
      



      






  }
}