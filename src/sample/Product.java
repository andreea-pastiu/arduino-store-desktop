package sample;

import java.math.BigDecimal;

public class Product
{
    private int productID;
    private BigDecimal price;
    private String company;
    private String model;

    public Product(int productID, BigDecimal price, String company, String model)
    {
        this.productID = productID;
        this.price = price;
        this.company = company;
        this.model = model;
    }

    public int getProductID()
    {
        return productID;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String getCompany()
    {
        return company;
    }

    public String getModel()
    {
        return model;
    }

    public void setProductID(int productID)
    {
        this.productID = productID;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public void setModel(String model)
    {
        this.model = model;
    }
}
