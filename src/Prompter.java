import java.util.*;

class Prompter{

    private Game game;


    public Prompter(Game game){
        this.game = game;
    }


    public boolean promptForGuess(){
        boolean isHit = false;
        boolean isAcceptable = false;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a letter: ");
            String guessInput = scanner.nextLine();

            try {
                isHit = game.applyGuess(guessInput);
                isAcceptable = true;
            } catch(IllegalArgumentException iae) {
                System.out.printf("%s. Please try again. %n",
                        iae.getMessage());
            }
        } while(! isAcceptable);

        return isHit;
    }


    public void displayProgress(){
        System.out.printf("You have %d tries left to solve: %s%n",
                game.getRemainingTries(),
                game.getCurrentProgress());
    }

}