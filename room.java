import java.util.ArrayList;
import java.util.Scanner;

// A game with one big scary room ...
// the game finishs only when player gets the item.
        
public class Main {

    public static void main(String[] args){
        ArrayList<String> itemsNames= new ArrayList<String>();
        ArrayList<String> itemsDesc= new ArrayList<String>();

        itemsNames.add("ring");
        itemsDesc.add("a glowing green stone with a round shape holding it");

        itemsNames.add("mirror");
        itemsDesc.add("a scary thing, someone that looks exactly like you. They move as you do!!");

        itemsNames.add("carpet");
        itemsDesc.add("a beautiful drawing lying on the ground, but it is too dark to figure out what it is drawn on");

        itemsNames.add("jacket");
        itemsDesc.add("a brown thick object, it seem to have arms, but it is not an alive thing!!");

        itemsNames.add("chair");
        itemsDesc.add("a wooden object, suitable for someone to set on!!");

        intro();
        room(itemsNames, itemsDesc);
    }

    public static void room(ArrayList<String> itemsNames, ArrayList<String> itemsDesc){
        int winningItemIndex= 0;
        while(true){
            int dir= getInteger("which direction do you want to search, front(0), right(1) or left(2) ?");

            int pickedItemIndex= 0;
            if(dir== 0) {
                pickedItemIndex= 1;
            }
            else if(dir == 1){
                pickedItemIndex= 2;
            }
            else{
                pickedItemIndex= 0;
            }
            debug("dir="+dir+"pickedItemIndex="+pickedItemIndex);

            printLine("you see " + itemsDesc.get(pickedItemIndex));
            if( getBoolean("do you want to pick it up (y/n)?")){
                printLine("You've got the  "+ itemsNames.get(pickedItemIndex));
                if(pickedItemIndex == winningItemIndex){
                    GameWon();
                    break;
                }
            }

        }
    }

    public static boolean getBoolean(String msg) {
        printLine(msg);

        Scanner scanner = new Scanner(System.in);
        String userInput= scanner.next();
        debug(userInput);
        return userInput.equals("y");
    }

    public static int getInteger(String msg) {
        printLine(msg);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printLine(String line){
        System.out.println(line);
    }

        
    public static void GameWon(){
        printLine("congratulations you won the game");
    }

    public static void intro(){
        printLine("Once a upon a time there was an evil king, he once visited a big luxury house where he lost his ring. He called upon you, and asked you to search the room where he has lost it.. Find it or else, he says !!");

        printLine("You entered the room, big as it was, it had only 3 sides where the ring could have fallen. Either in front of you, on your left, or maybe on the right it was..");

        printLine("Scared but determenant, you hear a voice calling you from a far, it says ...");
    }

        
    // when isDebugMode is set to true, this function would print, otherwise does nothing
    // usefull when the program is not working, and you want to discover what is happening
    public static void debug(String msg){
        boolean isDebugMode= false;
        if(isDebugMode){
            printLine(msg);
        }
    }
}
