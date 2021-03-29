package sample;

import java.math.BigDecimal;

public class WireSet extends Product
{
    private int length;
    private int wiresNo;

    public WireSet(int productID, BigDecimal price, String company, String model, int length, int wiresNo)
    {
        super(productID, price, company, model);
        this.length = length;
        this.wiresNo = wiresNo;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getWiresNo()
    {
        return wiresNo;
    }

    public void setWiresNo(int wiresNo)
    {
        this.wiresNo = wiresNo;
    }
}
