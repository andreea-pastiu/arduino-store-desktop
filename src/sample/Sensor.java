package sample;

import java.math.BigDecimal;

public class Sensor extends Product
{
    private String type;
    private BigDecimal voltage;
    private Boolean digitalPin;
    private Boolean analogPin;

    public Sensor(int productID, BigDecimal price, String company, String model, String type, BigDecimal voltage, Boolean digitalPin, Boolean analogPin)
    {
        super(productID, price, company, model);
        this.type = type;
        this.voltage = voltage;
        this.digitalPin = digitalPin;
        this.analogPin = analogPin;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public BigDecimal getVoltage()
    {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage)
    {
        this.voltage = voltage;
    }

    public Boolean getDigitalPin()
    {
        return digitalPin;
    }

    public void setDigitalPin(Boolean digitalPin)
    {
        this.digitalPin = digitalPin;
    }

    public Boolean getAnalogPin()
    {
        return analogPin;
    }

    public void setAnalogPin(Boolean analogPin)
    {
        this.analogPin = analogPin;
    }
}
