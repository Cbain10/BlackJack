package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

class Main {

    public static int upperBound = 0;

    public static void main(String[] args) {

        System.out.println("Welcome to BLACKJACK!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you ready to play? y/n ");
        String userInput = scanner.nextLine();

        Random rand = new Random();
        int card;
        int dealerCard;
        int total;
        int dealerTotal;

        while (userInput.equals("y")) {
            System.out.println("Shuffling deck...");

            Vector<Integer> deck = new Vector<Integer>();
            for (int i = 1; i <= 11; i++) {
                for (int j = 0; j < 4; j++) {
                    deck.add(i);
                    if (i == 10) {
                        deck.add(i);
                        deck.add(i);
                    }
                }
            }

            Vector<Integer> myCards = new Vector<Integer>();
            Vector<Integer> dealerHand = new Vector<Integer>();
            upperBound = deck.size();
            total = 0;

            card = dealNewCard(deck, rand, upperBound);
            myCards.add(card);
            total += card;
            upperBound--;
            dealerCard = dealNewCard(deck, rand, upperBound);
            dealerHand.add(dealerCard);
            upperBound--;
            card = dealNewCard(deck, rand, upperBound);
            myCards.add(card);
            total += card;
            upperBound--;

            if (myCards.get(0) == 11 && myCards.get(1) == 11) {
                total = 12;
                myCards.set(0,1);
            }
            if (myCards.contains(11) && total > 21) {
                total = checkAce(myCards);
            }
            printResults(myCards, total, dealerCard);

            if (total < 21) {
                System.out.println("Hit? y/n ");
                userInput = scanner.nextLine();
            } else if (total == 21) {
                System.out.println("Your total is 21!");
                userInput = "n";
            }
            while (userInput.equals("y") && (total < 21)) {
                card = dealNewCard(deck, rand, upperBound);
                myCards.add(card);
                upperBound--;
                total += card;
                if (myCards.contains(11) && total > 21) {
                    total = checkAce(myCards);
                }
                printResults(myCards, total, dealerCard);
                if (total > 21) {
                    if (myCards.contains(11)) {
                        boolean aceFound = false;
                        int aceTotal = 0;
                        for (int i = 0; i < myCards.size(); i++) {
                            aceTotal += myCards.get(i);
                            if ((myCards.get(i) == 11) && (!aceFound)) {
                                myCards.set(i, 1);
                                aceFound = true;
                            }
                        }
                        total = aceTotal;
                    } else {
                        System.out.println("YOU BROKE!");
                        userInput = "n";
                    }
                } else if (total == 21) {
                    userInput = "n";
                } else {
                    System.out.println("Hit? y/n ");
                    userInput = scanner.nextLine();
                }
            }

            if (total <= 21) {
                dealerTotal = dealerCard;
                while (dealerTotal < 17) {
                    card = dealNewCard(deck, rand, upperBound);
                    dealerHand.add(card);
                    dealerTotal += card;
                    if (dealerTotal > 16 && dealerHand.contains(11)) {
                        dealerTotal = checkAce(dealerHand);
                    }
                    upperBound--;
                }
                System.out.println("Dealer Total: " + dealerTotal);
                System.out.println("Your Total: " + total);
                System.out.println();
                if (dealerTotal > 21) {
                    System.out.println("Dealer Broke. YOU WIN!");
                } else if (dealerTotal == total) {
                    System.out.println("Tie! Dealer wins!");
                } else if (dealerTotal > total) {
                    System.out.println("Dealer Wins. YOU LOSE!");
                } else {
                    System.out.println("YOU WIN!!");
                }
            } else {
                System.out.println("YOU LOSE!");
            }

            System.out.println("*******************************************************************************");
            System.out.println("Play again? y/n ");
            userInput = scanner.nextLine();
        }
    }

    public static int checkAce(Vector<Integer> myCards) {
        int aceTotal = 0;
        boolean aceFound = false;
        for (int i = 0; i < myCards.size(); i++) {
            if (myCards.get(i) == 11 && !aceFound) {
                myCards.set(i, 1);
                aceFound = true;
            }
            aceTotal += myCards.get(i);
        }
        return aceTotal;
    }

    public static void printResults(Vector<Integer> myCards, int total, int dealerCard) {
        System.out.println("Dealer's hand: " + dealerCard);
        System.out.print("Your hand: ");
        for (Integer myCard : myCards) {
            System.out.print(myCard + " ");
        }
        System.out.println();
        System.out.println("Total: " + total);
    }

    public static int dealNewCard(Vector<Integer> deck, Random rand, int upperBound) {
        int randomIndex = rand.nextInt(upperBound);
        int card = deck.get(randomIndex);
        deck.remove(randomIndex);
        return card;
    }
}