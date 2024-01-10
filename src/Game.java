//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//public class Game {
//    //Nulify constructor
//    public Game() {
//        //
//    }
//
//    public static void main(String[] args) throws FileNotFoundException {
//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            if (args.length == 1){
////assuming if there is 1 argument on the command line
//// it is the name of a file to use for testing
////input = new Scanner(new File(args[0]));
//                  sc = new Scanner(new File(args[0]));
//            }
////            else {
////                Scanner sc = new Scanner(System.in);
////            }
//            System.out.println("Please type number of rows");
//            int rows = sc.nextInt();
//
//            System.out.println("Please type number of columns");
//            int col = sc.nextInt();
//            MineSweeper ms = new MineSweeper(col, rows);
//            ms.fillBoard();
//            ms.calculateBoard();
//            ms.printBoard();
//        }
//    }
//}
