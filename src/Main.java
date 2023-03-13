import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * run program
 * @author Moein Zanjirian Zadeh
 * @version 1.0.12
 * @Project Start date 2023/03/05
 * This program is a game called Tic_Tac_Toe . This game can be played by one or two people .
 */
public class Main {
    //******************************************************************************************************************
    /**
     * Change the color of the output text
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_Purple = "\u001B[35m";
    public static final String ANSI_Blue = "\u001B[34m";
    public static final String ANSI_Red = "\u001B[31m";
    public static final String ANSI_Green = "\u001B[32m";
    //******************************************************************************************************************
    /**
     *This is the main method.
     * @param args
     */
    public static void main(String[] args){
        String input;
        while("1".equals("1"))
        {
            System.out.print("\033[H\033[2J");//This is the command to clear the screen
            printMenu();
            input = inputInMenu();
            System.out.print("\033[H\033[2J");//This is the command to clear the screen
            if (input.equals("3") || input.equals("EXIT"))
            {
                break;
            }
            else
            {
                if (input.equals("2") || input.equals("INFO"))
                {
                    info();
                }
                else
                {
                    if(input.equals("1") || input.equals("START GAME")) {
                        game();
                    }
                }
            }
        }
    }
    //******************************************************************************************************************
    /**
     * Print Menu
     */
    public static void printMenu(){
        System.out.print("Enter your command: \n1- Start Game\n2- Info\n3- Exit\n>>");
    }
    //******************************************************************************************************************
    /**
     * @return an entry for the menu
     */
    public static String inputInMenu(){
        Scanner input0 = new Scanner(System.in);
        String input = new String();
        while (1==1) {
            input = input0.next().toUpperCase();
            if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("START GAME") || input.equals("INFO") || input.equals("EXIT")){
                return input;
            }
            System.out.print(ANSI_Red+"Please check your command:(\n>> "+ANSI_RESET);
        }
    }
    //******************************************************************************************************************
    /**
     * توضیحات درباره برنامه
     */
    public static void info(){
        System.out.print(ANSI_Red+"Info:"+ANSI_Green+"\nTic Tac Toe game\nThis game can be played single or double.\n" +
                ANSI_Blue+"Author : Moein Zanjirian zadeh\nmoeinz9322@gmail.com\n" +
                ANSI_Purple+"I hope you enjoy this game ." +ANSI_RESET+
                "\nPlease enter a character to return to the menu:)\n>> "+ANSI_RESET);
        Scanner input0 = new Scanner(System.in);
        String input = input0.next();
    }
    //******************************************************************************************************************
    public static void printStartGame(){
        System.out.print("Enter your command: \n1- Play with computer(computer)\n2- Play with player(human)\n>> ");
    }
    //******************************************************************************************************************

    /**
     * The game start
     */
    public static void game() {

        Scanner input0 = new Scanner(System.in);
        Random random = new Random();
        String input1 = "R" , input;
        ArrayList<Integer> array3= new ArrayList<>();//This array is to control the number of empty houses
        int number;

        printStartGame();

        while (1==1){
            input= input0.next();
            if (input.equals("1") || input.equals("2")){
                break;
            }
            System.out.print(ANSI_Red+"Please check your command:(\n>> "+ANSI_RESET);
        }

        if (input.equals("1")){

            // For this be played again after the end of the game with the comment R
            while (input1.equals("R")) {

                String[][] array = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
                array3 = new ArrayList<>();

                for (int i = 0; i < 16; i++) {
                    array3.add(i+1);
                }

                // For locked randomly
                for (int i = 0; i < 3; i++) {
                    number = random.nextInt(array3.size());
                    foundHouse(array , array3.get(number).toString(),"#");
                    array3.remove(number);
                }

                String numberselect = new String();
                int flag=0;
                int player =1;


                while (flag == 0){
                    if(player ==1){
                        System.out.print("\033[H\033[2J");
                        printGame(array);
                        while (1==1){
                            numberselect= input0.next();
                            if (isNumberTrue(array3 , numberselect) == true){
                                break;
                            }
                            System.out.print(ANSI_Red+"Please check your command:(\n>> "+ANSI_RESET);
                        }

                        System.out.print("\033[H\033[2J");
                        array3.remove((Integer)Integer.parseInt(numberselect));
                        flag=areWin(array,"X",numberselect);
                        foundHouse(array,numberselect,"X");
                        player =2;
                        printGame(array);
                        if (flag == 1){
                            System.out.println(ANSI_Purple + "\nX win :)" + ANSI_Red + "\nO_O" + ANSI_RESET);
                        }
                    }
                    else{
                        number = random.nextInt(array3.size());
                        numberselect = String.valueOf(array3.get(number));
                        array3.remove(number);
                        flag=areWin(array,"O",numberselect);
                        foundHouse(array,numberselect,"O");
                        player =1;
                        System.out.print("\033[H\033[2J");
                        printGame(array);
                        if (flag==1){
                            System.out.print("\033[H\033[2J");
                            printGame(array);
                            System.out.println(ANSI_Purple+"\nO win :)"+ ANSI_Red +"\nX_X"+ANSI_RESET);
                        }
                    }
                    if (array3.size() == 0 && flag == 0){
                        System.out.print("\033[H\033[2J");
                        printGame(array);
                        System.out.println("\nThe game equalised !");
                        break;
                    }
                }
                System.out.print("if you want play again enter R else enter other char.\n>> ");
                input1 = input0.next();
            }
        }
        else {
            while (input1.equals("R")) {

                String[][] array = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
                array3 = new ArrayList<>();
                for (int i = 0; i < 16; i++) {
                    array3.add(i+1);
                }
                for (int i = 0; i < 3; i++) {
                    number = random.nextInt(array3.size());
                    foundHouse(array , array3.get(number).toString(),"#");
                    array3.remove(number);
                }
                String numberselect = new String();
                int flag=0;
                int player =1;

                while (flag == 0){

                    System.out.print("\033[H\033[2J");
                    printGame(array);

                    while (1==1){
                        System.out.print("Player "+player +" : ");
                        numberselect= input0.next();
                        if (isNumberTrue(array3 , numberselect) == true){
                            break;
                        }
                        System.out.print(ANSI_Red+"Please check your command:(\n>> "+ANSI_RESET);
                    }

                    array3.remove((Integer)Integer.parseInt(numberselect));
                    System.out.print("\033[H\033[2J");

                    if(player ==1){
                            flag=areWin(array,"X",numberselect);
                            foundHouse(array,numberselect,"X");
                            player =2;
                            printGame(array);
                            if (flag == 1){
                                System.out.println(ANSI_Purple+"\nX win :)"+ ANSI_Red +"\nO_O"+ANSI_RESET);
                            }
                        }
                    else{
                        flag=areWin(array,"O",numberselect);
                        foundHouse(array,numberselect,"O");
                        printGame(array);
                        player =1;
                        if (flag==1){
                            System.out.println(ANSI_Purple+"\nO win :)"+ ANSI_Red +"\nX_X"+ANSI_RESET);
                        }
                    }

                    if (array3.size() == 0 && flag == 0){
                        System.out.print("\033[H\033[2J");
                        printGame(array);
                        System.out.println("\nThe game equalised !");
                        flag=1;
                    }
                }
                System.out.print("if you want play again enter R else enter other char.\n>> ");
                input1 = input0.next();
            }
        }
    }
    //******************************************************************************************************************

    /**
     * Checks whether the input number is correct or not
     * @param array
     * @param number
     * @return
     */
    public static boolean isNumberTrue(ArrayList<Integer> array , String number){
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == Integer.parseInt(number)){
                return true;
            }
        }
        return false;
    }
    //******************************************************************************************************************
    /**
     * @param array
     */
    public static void printGame(String array[][]){
        for (int i = 0; i < 4; i++) {
            System.out.print(ANSI_Red+"====================="+ANSI_RESET);
            System.out.print(ANSI_Red+"\n|"+ANSI_RESET);
            for (int j = 0; j < 4; j++) {
                System.out.printf(ANSI_Blue+" %-2s "+ANSI_RESET , array[i][j]);
                System.out.print(ANSI_Red+"|"+ANSI_RESET);
            }
            System.out.print("\n");
        }
        System.out.printf(ANSI_Red+"=====================\n"+ANSI_RESET);
    }
    //******************************************************************************************************************
    /**
     * First, it finds the chosen number then It fills the house with icons
     * @param array
     * @param playerIcon
     */
    public static void foundHouse(String array[][],String playerIcon , String icon){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].equals(playerIcon)){
                    array[i][j]=icon;
                }
            }
        }
    }
    //******************************************************************************************************************
    /**
     * First, it finds the chosen number, then checks around it to find out whether three consecutive houses are filled or not
     * @param array
     * @param playerIcon
     * @param numberSelect
     * @return Did win
     */
    public static int areWin(String array[][] , String playerIcon, String numberSelect){
        int x=0 , y=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].equals(numberSelect)){
                    x=i;
                    y=j;
                }
            }
        }
        if (x<=1 && array[x+1][y].equals(playerIcon) && array[x+2][y].equals(playerIcon)){
            return 1;
        }
        if (x>1 && array[x-1][y].equals(playerIcon) && array[x-2][y].equals(playerIcon)){
            return 1;
        }
        if (y<=1 && array[x][y+1].equals(playerIcon) && array[x][y+2].equals(playerIcon)){
            return 1;
        }
        if (y>1 && array[x][y-1].equals(playerIcon) && array[x][y-2].equals(playerIcon)){
            return 1;
        }
        if (x<=1 && y<=1 && array[x+1][y+1].equals(playerIcon) && array[x+2][y+2].equals(playerIcon)){
            return 1;
        }
        if (x>1 && y>1 && array[x-1][y-1].equals(playerIcon) && array[x-2][y-2].equals(playerIcon)){
            return 1;
        }
        if (x<=1 && y>1 && array[x+1][y-1].equals(playerIcon) && array[x+2][y-2].equals(playerIcon)){
            return 1;
        }
        if (x>1 && y<=1 && array[x-1][y+1].equals(playerIcon) && array[x-2][y+2].equals(playerIcon)){
            return 1;
        }
        if (1<=x && x<=2 && array[x+1][y].equals(playerIcon) && array[x-1][y].equals(playerIcon)){
            return 1;
        }
        if (1<=y && y<=2 && array[x][y+1].equals(playerIcon) && array[x][y-1].equals(playerIcon)){
            return 1;
        }
        if (1<=x && x<=2 && 1<=y && y<=2 && array[x-1][y+1].equals(playerIcon) && array[x+1][y-1].equals(playerIcon)){
            return 1;
        }
        if (1<=x && x<=2 && 1<=y && y<=2 && array[x-1][y-1].equals(playerIcon) && array[x+1][y+1].equals(playerIcon)){
            return 1;
        }
        return 0;
    }
    //******************************************************************************************************************
}