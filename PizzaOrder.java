import java.util.Scanner;

public class PizzaOrder
{
    void displayMenu()
    {
        System.out.println("Select the items to order");
        System.out.println("Sl No   Item Category");
        System.out.println("--------------------------");
        System.out.println("1) Pizza");
        System.out.println("   Price of One Regular Pizza : $9.99");
        System.out.println("   Price of One Medium Pizza  : $11.99");
        System.out.println("   Price of One Large Pizza   : $13.99");
        System.out.println("2) Garlic Bread");
        System.out.println("   Price of One Garlic Bread  : $5.99");
        System.out.println("3) Beverages");
        System.out.println("   Price of One Beverage      : $1.99");
    }

    public float getPriceOfPizzaBasedOnSize(int size)
    {
        switch (size) {
            case 1:
                return 9.99f;  // Regular
            case 2:
                return 11.99f; // Medium
            case 3:
                return 13.99f; // Large
            default:
                return 0.0f;  // Invalid size
        }
    }

    public float getPriceOfGarlicBread() {
        return 5.99f;
    }

    public float getPriceOfBeverage() {
        return 1.99f;
    }

    public float calculatePriceOfPizza(int noOfPizza, float priceOfPizza) {
        return noOfPizza*priceOfPizza;
    }

    public float calculatePriceOfGarlicBread(int noOfGarlicBread, float priceOfGarlicBread) {
        return noOfGarlicBread*priceOfGarlicBread;
    }

    public float calculatePriceOfBeverage(int noOfBeverages, float priceOfBeverage) {
        return noOfBeverages*priceOfBeverage;
    }

    public static float calculateTotalBill(float totalPizzaPrice, float totalGarlicBreadPrice, float totalBeveragePrice) {
        return totalPizzaPrice + totalGarlicBreadPrice + totalBeveragePrice;
    }

    public static float calculateDiscountAndReturnBillAmount(float totalBillAmount) {
        if(totalBillAmount > 50)
        {
            return totalBillAmount*0.9f;
        }
        else {
            return totalBillAmount;
        }
    }

    void displayCustomerDetails(String name, String email, long phoneNo, String address)
    {
        System.out.println("Customer Details");
        System.out.println("-----------------");
        System.out.println("Name of the Customer is : "+name);
        System.out.println("Email of the Customer is : "+email);
        System.out.println("Contact No of the Customer is : "+phoneNo);
        System.out.println("Address of the Customer is : "+address);
        System.out.println("---------------------------------------------");
    }

    public void displayOrderDetails(int noOfPizza,int noOfGarlicBread, int noOfBeverages,float totalPrice,float totalPriceAfterDiscount)
    {
        System.out.println("Order Details");
        System.out.println("----------------------------");
        System.out.println("The number of pizzas ordered   : " +noOfPizza);
        System.out.println("The number of garlic bread ordered : " +noOfGarlicBread);
        System.out.println("The number of beverages ordered   : " +noOfBeverages);
        System.out.println("----------------------------");
        System.out.println("The Total Bill Amount is    : $" +totalPrice);
        if(totalPriceAfterDiscount != totalPrice) {
            System.out.println("The Discounted Bill Amount is : $" +totalPriceAfterDiscount);
        }
        else {
            System.out.println("No Discount on Bill");
        }
    }

    public static void main(String[]agrs)
    {
        PizzaOrder pizzaOrdering = new PizzaOrder();

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome !!!!!");
        System.out.println("Please Enter your Details");
        System.out.println("Enter name :");
        String name = scan.nextLine();
        System.out.println("Enter email :");
        String email = scan.nextLine();
        System.out.println("Enter Address :");
        String address = scan.nextLine();
        System.out.println("Enter Phone: ");
        long phoneNo = scan.nextLong();

        int noOfPizza = 0, noOfGarlicBread = 0, noOfBeverages = 0;
        int totalNoOfPizza = 0;
        float totalPizzaBill = 0, totalGarlicBreadBill = 0, totalBeverageBill = 0;

        int size=0, ordered=1;

        do {
            pizzaOrdering.displayMenu();
            System.out.println("Enter 1 for Pizza, 2 for Garlic Bread and 3 for Beverages : ");
            int menu = scan.nextInt();

            if(menu < 1 || menu > 3) {
                System.out.println("Please enter the items on the menu");
                continue;
            }

            switch(menu) {

                case 1:
                    System.out.println("Enter the size of pizza you want to order, Enter 1 for Regular, 2 for Medium, 3 for Large");
                    size = scan.nextInt();
                    if(size < 1 || size > 3) {
                        System.out.println("Please enter the size from the menu : ");
                        size = scan.nextInt();
                    }
                    System.out.println("Please enter the number of pizza you want to order :");
                    noOfPizza = scan.nextInt();
                    totalNoOfPizza = noOfPizza;
                    float priceOfPizza = pizzaOrdering.getPriceOfPizzaBasedOnSize(size);
                    totalPizzaBill += pizzaOrdering.calculatePriceOfPizza(noOfPizza,priceOfPizza);
                    break;

                case 2:
                    System.out.println("Please enter the number of garlic bread you want to order :");
                    noOfGarlicBread = scan.nextInt();
                    float priceOfGarlicBread = pizzaOrdering.getPriceOfGarlicBread();
                    totalGarlicBreadBill += pizzaOrdering.calculatePriceOfGarlicBread(noOfGarlicBread,priceOfGarlicBread);
                    break;

                case 3:
                    System.out.println("Please enter the number of beverages you want to order :");
                    noOfBeverages = scan.nextInt();
                    float priceOfBeverage = pizzaOrdering.getPriceOfBeverage();
                    totalBeverageBill += pizzaOrdering.calculatePriceOfBeverage(noOfBeverages,priceOfBeverage);
                    break;

                default:
                    System.out.println("Please enter the items from the menu");
                    break;
            }
            System.out.println("Do you wish to add more items to the order ? Enter 1 to continue or 0 to exit");
            ordered = scan.nextInt();

        } while(ordered == 1);

        float totalBillAmount = pizzaOrdering.calculateTotalBill(totalPizzaBill, totalGarlicBreadBill, totalBeverageBill);

        // displaying the customer details
        pizzaOrdering.displayCustomerDetails(name,email,phoneNo,address);

        float totalBillAfterDiscount = pizzaOrdering.calculateDiscountAndReturnBillAmount(totalBillAmount);

        // displaying the order details
        pizzaOrdering.displayOrderDetails(noOfPizza,noOfGarlicBread,noOfBeverages,totalBillAmount,totalBillAfterDiscount);


    }
}
