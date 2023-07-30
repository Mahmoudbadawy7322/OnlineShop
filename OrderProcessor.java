public class OrderProcessor {
    private int orderId;
    private double orderTotalAmount;
    private Product[] orderItems;
    private int orderItemsQuantity;

    private Customer customer;

    public OrderProcessor(){
        this.orderId = (int)Math.floor(Math.random() * (100 - 50 + 1) + 50);
        orderTotalAmount=0.0;
        orderItems = new Product[10];
        orderItemsQuantity=0;
        customer = null;
    }

    public void placeOrder(ShoppingCart shoppingCart,Customer customer){
        this.customer=customer;
        orderItemsQuantity=shoppingCart.getCartItemsCount();
        orderTotalAmount= shoppingCart.calcCartTotalCost();
        orderItems = shoppingCart.getCartProducts().clone();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Product added successfully.");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Your order details\n------------------");
        showOrderDetails();
    }

    public void showOrderDetails(){

        System.out.println("Mr/Ms : "+customer.getName()+"\t\t\tEmail: "+customer.getEmail());
        System.out.println("Mobile : "+customer.getMobileNumber()+"\t\t\tAddress: "+customer.getAddress());
        System.out.println("--------------------------------------------------------------------");
        System.out.println("\t\t\t\tOrder Number : "+orderId);
        System.out.println("--------------------------------------------------------------------\nOrder Items\n-----------");
        for (int i=0;i<orderItems.length;i++)
            if(orderItems[i] != null)
                System.out.println((i+1) +" ProductName : "+orderItems[i].getName() +"  Price : "+orderItems[i].getPrice()+"  quantity : "+orderItems[i].getQuantity());
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Order items count : "+orderItemsQuantity+"\t\t\tTotal amount : "+orderTotalAmount);
    }
}
