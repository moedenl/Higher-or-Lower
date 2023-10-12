import java.util.Scanner;

class Main {
  public static boolean isNumeric(String str) { 
    try {  
      Integer.parseInt(str);  
      return true;
    }
    catch(NumberFormatException e) {  
      return false;  
    }
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean done = false;
    System.out.println("\nWelcome! This is game I like to call \"Higher or Lower!\" I have chosen a random number between 1 and 100 (inclusive), and your job is to try and guess that number! For each guess, I'll tell you if you're right, or if the number is higher or lower than what you guessed. \nIf you want to quit, just guess anything other than an integer. Let's begin!");
    while (!done) {
      boolean guess = false;
      int rightNum = (int) (Math.random() * (100)) + 1;
      int count = 0;
      while (!guess) {
        System.out.print("\nGuess: ");
        String response = scan.next();
        if (isNumeric(response)) {
          int guessNum = Integer.parseInt(response);
          if (guessNum < rightNum) {
            System.out.println("Guess a higher number!\n");
            count ++;
          }
          else if (guessNum > rightNum) {
            System.out.println("Guess a lower number!\n");
            count ++;
          }
          else {
            count ++;
            if (count == 1) {
              System.out.println("\nThat's right!\nYou got it in only " + count + " guess!\n");
            }
            else {
              System.out.println("That's right!\n\nYou got it in only " + count + " guesses!\n");
            }
            guess = true;
          }
        }
        else {
          System.out.print("\nQuitting... ");
          guess = true;
        }
      }
      System.out.println("Do you want to play again? (y / n)");
      String yesNo = scan.next();
      if (!yesNo.toLowerCase().startsWith("y")) {
        done = true;
      }
    }
    System.out.print("\nGoodbye!");
    scan.close();
  }
}