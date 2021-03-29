package sample;

import java.math.BigDecimal;

public class Motor extends Product
{
    private BigDecimal voltage;
    private BigDecimal current;
    private BigDecimal rotationSpeed;

    public Motor(int productID, BigDecimal price, String company, String model, BigDecimal voltage, BigDecimal current, BigDecimal rotationSpeed)
    {
        super(productID, price, company, model);
        this.voltage = voltage;
        this.current = current;
        this.rotationSpeed = rotationSpeed;
    }

    public BigDecimal getVoltage()
    {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage)
    {
        this.voltage = voltage;
    }

    public BigDecimal getCurrent()
    {
        return current;
    }

    public void setCurrent(BigDecimal current)
    {
        this.current = current;
    }

    public BigDecimal getRotationSpeed()
    {
        return rotationSpeed;
    }

    public void setRotationSpeed(BigDecimal rotationSpeed)
    {
        this.rotationSpeed = rotationSpeed;
    }
}