public class Hangman {

    public static void main(String[] args) {
        Game game = new Game("treehouse");
        Prompter prompter = new Prompter(game);

        while(game.getRemainingTries()>0 && !game.isWon()){
            prompter.displayProgress();
            prompter.promptForGuess();
        }

        System.out.println("Game Over");
    }
}