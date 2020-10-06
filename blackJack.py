from cards import cards
import random

print("Welcome to BlackJack!")

playAgain = 'y'
while playAgain == 'y':
  print("\n")
  myCards = []
  dealerCard = random.choice(cards)
  print("Dealers Card:", dealerCard)
  card1 = random.choice(cards)
  # card1 = 11
  card2 = random.choice(cards)
  myCards.append(card1)
  myCards.append(card2)
  total = card1 + card2
  print("Here are your cards: ")
  print(*myCards, sep=" ")
  print("Total:", total)
  hit = input("Hit? y/n ")
  while total < 21 and hit == 'y':
    total = 0
    print("Here are your cards: ")
    card1 = random.choice(cards)
    myCards.append(card1)
    for card in myCards:
      total += card
    if total > 21:
      if 11 in myCards:
        total = 0
        for i in range(len(myCards)):
          if myCards[i] == 11:
            myCards[i] = 1
        for card in myCards:
          total += card
      else:
        hit = 'n'
    
    print(*myCards, sep=" ")
    print("Total", total)
    print("\n")
    if total == 21:
      hit = 'n'
    else:
      hit = input("Hit? y/n ")

  print("Your final total is:", total)
  dealerTotal = dealerCard
  broke = False
  while not broke:
    if dealerTotal < 17:
      newCard = random.choice(cards)
      dealerTotal += newCard
    if dealerTotal > 16:
      broke = True
  print("Dealer Total:", dealerTotal)
  
  if total > 21:
    print("You broke! You lost!")
  elif dealerTotal > 21:
    print("Dealer broke! YOU WIN!!")
  elif total > dealerTotal:
    print("YOU WIN!")
  else: 
    print("You lost!")


  playAgain = input("Play again? y/n ")