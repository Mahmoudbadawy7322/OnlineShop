public class Store {
    private final Product[] storeProducts;

    public Store(){
        this.storeProducts = new Product[10];
        for(int i=0;i<storeProducts.length;i++)
            storeProducts[i] = new Product("Product "+(i+1),5*(i+1),20);
    }

    public Product[] getStoreProducts() {
        return storeProducts;
    }

    public void incrementQuantity(int productIndex){
        storeProducts[productIndex].incrementQuantity();
    }
    public void decrementQuantity(int productIndex){
        storeProducts[productIndex].decrementQuantity();
    }

    public int getProductIndex(String name){
        int itemIndex = -1;
        for(int i=0;i<storeProducts.length;i++)
            if(storeProducts[i].getName().equalsIgnoreCase(name))
            {
                return i;
            }
        return itemIndex;
    }
}
