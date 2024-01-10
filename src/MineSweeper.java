import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class MineSweeper {
    private int myCol;
    private int myRow;
    private int fieldCounter;
    private char myBoard[][];
    private ArrayList<Integer> mines;
    //private Scanner sc;
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Field #1:");
        while (true) {
            System.out.println("Field #1:");
            Scanner sc = new Scanner(System.in);
            if (args.length == 1){
                sc = new Scanner(new File(args[0]));
            }
            sc.useDelimiter(" ");

            //System.out.print("Please type number of rows");
            //int rows = sc.nextInt();
            String tempIn = sc.next();
            //sc.useDelimiter("");
            //int rows = Integer.parseInt(sc.next());
            //sc.useDelimiter("");
            int rows = Integer.parseInt(String.valueOf(tempIn.charAt(0)));
            //System.out.print("Please type number of columns");
            int col = Integer.parseInt(String.valueOf(tempIn.charAt(1)));
            //int col = sc.nextInt();
            //int col = Integer.parseInt(sc.next());
            MineSweeper ms = new MineSweeper(col, rows);
            ms.fillBoard(sc);
            ms.calculateBoard();
            ms.printBoard();
        }
    }
    public MineSweeper(final int theCol, final int theRow) {
        myCol = theCol;
        myRow = theRow;
        myBoard = new char[myCol][myRow];
        mines = new ArrayList<Integer>();
    }
    public void fillBoard(Scanner sc) {
        //Scanner sc = new Scanner(System.in);
        int counter = 0;
        String s = sc.next();
        for (int i = 0; i < myCol; i++) {
            for (int j = 0; j < myRow; j++) {
                char c = s.charAt(counter);
                //Scanner sc = new Scanner(System.in);
                //char c = sc.next().charAt(counter);
                counter++;
                //char c = sc.next().charAt(0);
                myBoard[i][j] = c;
                if (c == '*') {
                    mines.add(i);
                    mines.add(j);
                }
                if(counter > myRow * myCol) {
                    return;
                }
                //myBoard[i][j] = sc.next().charAt(0);
                //if ()
            }
            System.out.println();
        }
    }
    //Going to need to use manhattan distance alg
    // Just need to decide how to implement this
    //dist = |x_2 - x_1| + |y_2 - y_1|
    public void calculateBoard() {
        for (int i = 0; i < myCol; i++) {
            for (int j = 0; j < myRow; j++) {
                if(myBoard[i][j] != '*') {
                    for(int k = 0; k < mines.size() - 1; k+=2) {
                        int tempI = (Math.abs(mines.get(k) - i) + Math.abs(mines.get(k + 1) - j));
                        char tempC = (char)(tempI + 48);
                        myBoard[i][j] = tempC;
                        //myBoard[i][j] = (Math.abs(mines.get(k) - i) + Math.abs(mines.get(k + 1) - j))
                    }
                }
            }
        }
    }
    public void printBoard() {
        for (int i = 0; i < myCol; i++) {
            for (int j = 0; j < myRow; j++) {
                System.out.print(myBoard[i][j]);
            }
                System.out.println();
        }
    }
    @Override
    public String toString() {
        return myBoard.toString();
    }
}
