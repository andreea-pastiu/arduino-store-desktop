package sample;

import java.math.BigDecimal;

public class CartItem extends Product
{
    private int count;

    public CartItem(int productID, BigDecimal price, String company, String model, int count)
    {
        super(productID, price, company, model);
        this.count = count;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }
}
