package sample;

import java.math.BigDecimal;

public class Breadboard extends Product
{
    private int width;
    private int length;
    private int tiePoints;

    public Breadboard(int productID, BigDecimal price, String company, String model, int width, int length, int tiePoints)
    {
        super(productID, price, company, model);
        this.width = width;
        this.length = length;
        this.tiePoints = tiePoints;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getTiePoints()
    {
        return tiePoints;
    }

    public void setTiePoints(int tiePoints)
    {
        this.tiePoints = tiePoints;
    }
}
