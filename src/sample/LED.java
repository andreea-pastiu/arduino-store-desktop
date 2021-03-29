package sample;

import java.math.BigDecimal;

public class LED extends Product
{
    private String color;
    private int diameter;
    private BigDecimal current;

    public LED(int productID, BigDecimal price, String company, String model, String color, int diameter, BigDecimal current)
    {
        super(productID, price, company, model);
        this.color = color;
        this.diameter = diameter;
        this.current = current;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public int getDiameter()
    {
        return diameter;
    }

    public void setDiameter(int diameter)
    {
        this.diameter = diameter;
    }

    public BigDecimal getCurrent()
    {
        return current;
    }

    public void setCurrent(BigDecimal current)
    {
        this.current = current;
    }
}