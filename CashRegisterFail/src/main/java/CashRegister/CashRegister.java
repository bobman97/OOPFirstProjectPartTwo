package CashRegister;


import ItemOptions.ItemOptions;
import ReviewOptions.ReviewOptions;
import TransacHistory.TransacHistory;
/*import ReviewOptions.ReviewOptions;
import TransacHistory.TransacHistory;*/



public class CashRegister {
    static UserInput readIn;
    static ItemOptions shop;
    static ReviewOptions reviews;
    static TransacHistory trans;
    static SystemOutput printMenu;

    public static void main(String[] args) {
        runProgram();
    }

    static void runProgram()    {
        printMenu = new SystemOutput();
        readIn = new UserInput();
        trans = new TransacHistory();
        shop = new ItemOptions(trans);
        reviews = new ReviewOptions(shop);
        // Here were initializing the itemsData reference in TransacHistory and assigning it to already created object shop
        //trans.itemsData = shop;
        int menuChoice;

        /*
        ***************
        *  Main Menu  *
        ***************
        */

        // Menu will loop until program closes
        do {
            // Print main menu
            printMenu.mainMenu();

            // Ask user to select an option
            menuChoice = readIn.getUserOption(3, "Enter an option: ", "Invalid input!");

            switch(menuChoice)  {
                case 0:
                    exitProgram();
                    break;
                case 1:
                    itemOptions(); // This calls the item options menu
                    break;
                case 2:
                    reviewOptions(); // This calls the review options menu
                    break;
                case 3:
                    TransacHistory();
                    break;
                default:
                    callError();
            }
        }while(menuChoice != 0);
    }

    static void itemOptions()   {
        int menuChoice;
        do {
            printMenu.itemMenu();
            menuChoice = readIn.getUserOption(6,"Enter an option: ", "Incorrect value!");
            switch(menuChoice)  {
                case 0: // returns to main menu
                    break;
                case 1:
                    shop.addItem();
                    break;
                case 2:
                    shop.delItem();
                    break;
                case 3:
                    shop.printItems();
                    break;
                case 4:
                    shop.buyItem();
                    break;
                case 5:
                    shop.newItemName();
                    break;
                case 6:
                    shop.newItemPrice();
                    break;
                default:
                    callError();
                    break;
            }
        } while(menuChoice != 0);
    }

    static void reviewOptions(){
        /*int menuInput;
                do {
                    printMenu.reviewMenu();
                    menuInput = readIn.getUserOption(10,"Enter an option: ", "Incorrect value!");
                    switch (menuInput) {
                        case 0:
                            // main menu return
                            break;
                        case 1:
                            reviews.createReview();
                            break;
                        case 2:
                            reviews.printSpecificReview();
                            break;
                        case 3:
                            reviews.printAllRevItem();
                            break;
                        case 4:
                            reviews.printMeanGradeItem();
                            break;
                        case 5:
                            reviews.printAllCommentsItem();
                            break;
                        case 6:
                            reviews.printAllRegisteredRev();
                            break;
                        case 7:
                            reviews.printMostRevs();
                            break;
                        case 8:
                            reviews.printLeastRevs();
                            break;
                        case 9:
                            reviews.printBestMeanGrade();
                            break;
                        case 10:
                            reviews.printWorstMeanGrade();
                            break;
                        default:
                            callError();
                            break;
                    }
                }while (menuInput != 0);*/
    }

    static void TransacHistory()   {
        int choice;
        do{
            printMenu.transacMenu();
            choice=readIn.getUserOption(6,"Enter an option!","You geh");
            switch (choice){
                case 0:
                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    //trans.printAllTransac();
                    break;
                case 5:

                    break;
                case 6:
                    //trans.mostProfit();
                    break;

            }
        } while(choice!=0);

    }

    static void callError() {
        System.out.println("Something went wrong!");
        System.exit(1);
    }
    static void exitProgram()   {
        System.out.println("Thank you, com again!");
        readIn.closeScanner();
        System.exit(0);
    }
}
