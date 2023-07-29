public class OnlineShop {

    public static void main(String[] args){
        Store store= new Store();
        Product[] storeProducts = store.getStoreProducts();
        ShoppingCart shoppingCart= new ShoppingCart();

        shoppingCart.addItem(store,0);
        shoppingCart.addItem(store,1);
        shoppingCart.addItem(store,2);
        shoppingCart.addItem(store,3);

        shoppingCart.showCartItems();
        System.out.println(shoppingCart.getCartItemsCount());

        shoppingCart.removeItem(store,0);
        shoppingCart.removeItem(store,2);

        System.out.println("---------------------------------------------------------");
        shoppingCart.showCartItems();
        System.out.println(shoppingCart.getCartItemsCount());
    }
}
