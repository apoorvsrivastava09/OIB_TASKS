import java.util.Scanner;

 class NUMBER_GUESSING_GAME{

    
    public static void main() 
    {
        System.out.println("Let's play a game. I'll pick a number between");
        System.out.println("1 and 50, and you try to guess it.");

        
        Scanner in = new Scanner(System.in); 

        boolean playAgain;

       
        do {
            
            playGame();  

            
            System.out.println("Would you like to play again? Y/N");

            
            String playAgainStr = in.next();
            playAgain = playAgainStr.equalsIgnoreCase("Y");
        } while (playAgain);

        
        System.out.println("Thanks for playing. Goodbye.");
    }

    
    static void playGame() {
        int computersNumber; 
        int usersGuess;      
        int guessCount;      

        
        computersNumber = (int)(50 * Math.random()) + 1;

        
        guessCount = 0;

        System.out.println();
        System.out.println("What is your first guess?");

        
        Scanner in= new Scanner(System.in);   

        
        while (true) {
            usersGuess = in.nextInt(); 

            
            guessCount++;

            
            if (usersGuess == computersNumber) {
                System.out.println("You got it in " + guessCount + " guesses! My number was " + computersNumber);
                break;  
            }

            
            if (guessCount == 6) {
                System.out.println("You didn't get the number in 6 guesses.");
                System.out.println("You lose. My number was " + computersNumber);
                break;  
            }

            
            if (usersGuess < computersNumber) {
                System.out.println("Your number is too low. Try again:");
            }

            
            else if (usersGuess > computersNumber) {
                System.out.println("Your number is too high. Try again:");
            }
        }

        System.out.println();
    } 
}