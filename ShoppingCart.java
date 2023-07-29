public class ShoppingCart {
    private Product[] cartProducts;
    private int cartItemsCount;

    public ShoppingCart(){
        this.cartProducts = new Product[10];
        this.cartItemsCount=0;
    }

    public Product[] getCartProducts() {
        return cartProducts;
    }

    public int getCartItemsCount() {
        return cartItemsCount;
    }

    public void addItem(Store store, int productIndex){
        Product[] storeProducts = store.getStoreProducts();
        for(int i=0;i<cartProducts.length;i++)
            if(cartProducts[i] == null){
                cartProducts[i] = new Product(storeProducts[productIndex].getName(),storeProducts[productIndex].getPrice(),1);
                cartItemsCount++;
                store.decrementQuantity(productIndex);
                break;
            }
    }

    public  void removeItem(Store store,int cartItemIndex){
        int storeProductIndex = store.getProductIndex(cartProducts[cartItemIndex].getName());
        cartProducts[cartItemIndex]=null;
        cartItemsCount--;
        store.incrementQuantity(storeProductIndex);
    }

    public void showCartItems(){
        for (int i=0;i<cartProducts.length;i++)
            if(cartProducts[i] != null)
                System.out.println((i+1) +" ProductName : "+cartProducts[i].getName() +"  Price : "+cartProducts[i].getPrice()+"  quantity : "+cartProducts[i].getQuantity());
    }


}
