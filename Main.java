import java.util.Scanner;

public class Main {
    private static Cards[][] cards = new Cards[4][4];
    
    public static void guess() {
        //This metod is the main method for guess part and checks the values from the user.
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("First guess (Enter the i and j values by space):");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();
        
        cards[i1][j1].setGuess(true);
        gameboard();
        
        System.out.print("Second guess (Enter the i and j values by space):");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();
        
        if (cards[i1][j1].getValue() == cards[i2][j2].getValue()) {
            //if user guess is true it should keep the correct carts open.
            cards[i2][j2].setGuess(true);
        }
        
        else {
            //if user guess is false it should close cards that was opened before.
            cards[i2][j2].setGuess(false);
        }
    }
    
    public static boolean is_game_over() {
        //To check the player guess the all cards correctly, I defined this method.

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (cards[i][j].isGuess()== false){
                    return false;
                }
            }
        }
        return true;        
    }
    
    public static void gameboard() {
        //This metod is design the gameboard of mind game.
        for (int i = 0; i < 4; i++){
            System.out.println("_____________________________");
            for (int j = 0; j < 4; j++){
                if (cards[i][j].isGuess()){
                    System.out.print(" |" + cards[i][j].getValue()+ "| ");
                }
                
                else{
                    System.out.print(" | | ");
                }
            }
            System.out.println("");
        }
        System.out.println("_____________________________");
    }        
    
    public static void main(String[] args) {
        
        //Our correct gameboard will look something like that.
        cards[0][0] = new Cards("E");
        cards[0][1] = new Cards("A");
        cards[0][2] = new Cards("B");
        cards[0][3] = new Cards("F");
        cards[1][0] = new Cards("G");
        cards[1][1] = new Cards("A");
        cards[1][2] = new Cards("D");
        cards[1][3] = new Cards("H");
        cards[2][0] = new Cards("F");
        cards[2][1] = new Cards("C");
        cards[2][2] = new Cards("D");
        cards[2][3] = new Cards("H");
        cards[3][0] = new Cards("E");
        cards[3][1] = new Cards("G");
        cards[3][2] = new Cards("B");
        cards[3][3] = new Cards("C");
        
        while (is_game_over() == false) {
            //until the user guess all cards correctly the game should be open.
            gameboard();
            guess();
            
        }
    }
}
