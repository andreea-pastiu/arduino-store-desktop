package sample;

import java.math.BigDecimal;

public class ArduinoBoard extends Product
{
    private BigDecimal supplyVoltage;
    private int digitalPins;
    private int analogPins;
    private BigDecimal flashMemory;
    private BigDecimal frequency;

    public ArduinoBoard(int productID, BigDecimal price, String company, String model, BigDecimal supplyVoltage, int digitalPins, int analogPins, BigDecimal flashMemory, BigDecimal frequency)
    {
        super(productID, price, company, model);
        this.supplyVoltage = supplyVoltage;
        this.digitalPins = digitalPins;
        this.analogPins = analogPins;
        this.flashMemory = flashMemory;
        this.frequency = frequency;
    }

    public BigDecimal getSupplyVoltage()
    {
        return supplyVoltage;
    }

    public int getDigitalPins()
    {
        return digitalPins;
    }

    public int getAnalogPins()
    {
        return analogPins;
    }

    public BigDecimal getFlashMemory()
    {
        return flashMemory;
    }

    public BigDecimal getFrequency()
    {
        return frequency;
    }

    public void setSupplyVoltage(BigDecimal supplyVoltage)
    {
        this.supplyVoltage = supplyVoltage;
    }

    public void setDigitalPins(int digitalPins)
    {
        this.digitalPins = digitalPins;
    }

    public void setAnalogPins(int analogPins)
    {
        this.analogPins = analogPins;
    }

    public void setFlashMemory(BigDecimal flashMemory)
    {
        this.flashMemory = flashMemory;
    }

    public void setFrequency(BigDecimal frequency)
    {
        this.frequency = frequency;
    }
}
