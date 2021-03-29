package sample;

public class Company
{
    private int companyID;
    private String name;
    private String address;

    public Company(int companyID, String name)
    {
        this.companyID = companyID;
        this.name = name;
    }

    public int getCompanyId()
    {
        return this.companyID;
    }

    public String getName()
    {
        return this.name;
    }
}
