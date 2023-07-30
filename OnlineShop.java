import java.util.Scanner;

public class OnlineShop {

    public static void main(String[] args){

        Store store= new Store();
        ShoppingCart shoppingCart= new ShoppingCart();
        Customer customer = new Customer();
        Scanner scanner= new Scanner(System.in);
        boolean wantToOrder = false;
        int selectedOption;
        int selectedproduct;

        System.out.println("Welcome to the online shop");
        System.out.print("Enter your name : ");
        customer.setName(scanner.nextLine());
        System.out.print("Enter your mobile : ");
        customer.setMobileNumber(scanner.nextLine());
        System.out.print("Enter your email : ");
        customer.setEmail(scanner.nextLine());
        System.out.print("Enter your address : ");
        customer.setAddress(scanner.nextLine());


        System.out.println("\nCustomer created successfully.\n--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------\n");

        System.out.println("your cart created successfully please select one of the below :");
        do{
            System.out.println("1- Show cart products");
            System.out.println("2- Add product");
            System.out.println("3- Remove product");
            System.out.println("4- Clear the cart");
            System.out.println("5- place order");
            System.out.print("Enter option number : ");
            selectedOption = scanner.nextInt();
            switch (selectedOption){
                case 1:
                    if(shoppingCart.getCartItemsCount()==0)
                        System.out.println("Cart is empty.");
                    else
                        shoppingCart.showCartItems();
                    System.out.println("--------------------------------------------------------------------");
                    break;
                case 2:
                    store.showStoreProducts();
                    System.out.print("Enter Product number : ");
                    selectedproduct=scanner.nextInt();
                    if(selectedproduct>0&&selectedproduct<=10)
                        shoppingCart.addItem(store,(selectedproduct-1));
                    else
                        System.out.println("Wrong product number.");
                    System.out.println("--------------------------------------------------------------------");
                    break;
                case 3:
                    if(shoppingCart.getCartItemsCount()==0)
                        System.out.println("Cart is empty.");
                    else {
                        shoppingCart.showCartItems();
                        System.out.print("Enter Product number : ");
                        selectedproduct=scanner.nextInt();
                        shoppingCart.removeItem(store,(selectedproduct-1));
                    }
                    System.out.println("--------------------------------------------------------------------");
                    break;
                case 4:
                    if(shoppingCart.getCartItemsCount()==0)
                        System.out.println("Cart is empty.");
                    else
                        shoppingCart.clearCart();
                    System.out.println("--------------------------------------------------------------------");
                    break;
                case 5:
                    if(shoppingCart.getCartItemsCount()==0)
                        System.out.println("Cart is empty.");
                    else
                        wantToOrder = true;
                    System.out.println("--------------------------------------------------------------------");
                    break;

                default:
                    System.out.println("Enter Correct option");
                    System.out.println("--------------------------------------------------------------------");
            }
            if(wantToOrder)
                break;
        }while(true);
        OrderProcessor orderProcessor=new OrderProcessor();
        orderProcessor.placeOrder(shoppingCart,customer);
    }
}
