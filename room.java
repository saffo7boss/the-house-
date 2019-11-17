import java.util.ArrayList;
import java.util.Scanner;

// A game with one big scary room ...
// the game finishs only when player gets the item.

public class Main {

  public static void main(String[] args) {
    ArrayList<String> itemsNames = new ArrayList<String>();
    ArrayList<String> itemsDesc = new ArrayList<String>();

    itemsNames.add("ring");
    itemsDesc.add("a glowing stone with a round shape holding it");

    itemsNames.add("mirror");
    itemsDesc.add("a scary thing that looks exactly like you abd moves like you!!");

    itemsNames.add("carpet");
    itemsDesc.add("something lying on the ground, made of cotton, but it is too dark to figure out what is it");

    itemsNames.add("jacket (hmm.. this thing seems to be heavy?...)");
    itemsDesc.add("a brown thick thing?, it seem to have arms.");

    itemsNames.add("chair");
    itemsDesc.add("a wooden object, suitable for someone to set on!!");

    itemsNames.add("phone");
    itemsDesc.add("something that is electronic and no body can live without it!!");

    itemsNames.add("button");
    itemsDesc.add("something red and can be pushed to activate something or open a door maybe?");

    intro();
    room(itemsNames, itemsDesc);
  }

  public static void room(ArrayList<String> itemsNames, ArrayList<String> itemsDesc) {
    int winningItemIndex = 5;
    int losingItemIndex = 2;
    while (true) {
      int dir = getInteger("which direction do you want to search, front(0), right(1), left(2) or back(3) ?");

      int pickedItemIndex = 0;
      if (dir == 0) {
        pickedItemIndex = 1;
      } else if (dir == 1) {
        pickedItemIndex = 2;
      } else if (dir == 2) {
        pickedItemIndex = 3;
      } else {
        pickedItemIndex = 0;
      }
      debug("dir=" + dir + "pickedItemIndex=" + pickedItemIndex);

      printLine("you see " + itemsDesc.get(pickedItemIndex));
      if (getBoolean("do you want to pick it up (y/n)?")) {
        printLine("You got a  " + itemsNames.get(pickedItemIndex));
        if (pickedItemIndex == winningItemIndex) {
          GameWon();
          break;
        }
      }
      if (pickedItemIndex == 3) {
        if (getBoolean("do you want to search  it (y/n)?")) {
          printLine("you found something electronic that's nessesary and no human can live without!!");
          if (getBoolean("do you want to pick it up (y/n)?")) {
            if (pickedItemIndex == winningItemIndex) {
              GameWon();
              break;

            }
          }
        }
      }
      if (pickedItemIndex == 2) {
        if (getBoolean("do you want to search it (y/n)?")) {
          printLine(
              "you found a secret button im sure it does something may be open a door so i can get my phone from there?!!");
          if (getBoolean("do you want to press it? (y/n)?")) {
            printLine("fffvvvvfffff hmm... it seems a door really opened?!! pooffv");

            gamelost();
            break;
          }
        }
      }
    }
  }

  public static boolean getBoolean(String msg) {
    printLine(msg);

    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.next();
    debug(userInput);
    return userInput.equals("y");
  }

  public static int getInteger(String msg) {
    printLine(msg);

    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public static void printLine(String line) {
    System.out.println(line);
  }

  public static void GameWon() {
    printLine("congratulations you got ur phone :)");
  }

  public static void gamelost() {
    printLine("congratulations you died -_-");
  }

  public static void intro() {
    printLine(
        "once upon a time u got invited to a party where u forgot ur phone, u need to find it befor it gets stollen!!");

    printLine(
        "You entered the house, big as it was, you start searching at the middle for the phone. it may be in front of you, on your left, at the back, or maybe on the right.");

    printLine(
        "then u heard something says u have left?!! i cant quit understand what is says i'll keep that in mind..");
  }

  // when isDebugMode is set to true, this function would print, otherwise does
  // nothing
  // usefull when the program is not working, and you want to discover what is
  // happening
  public static void debug(String msg) {
    boolean isDebugMode = false;
    if (isDebugMode) {
      printLine(msg);
    }
  }
}
