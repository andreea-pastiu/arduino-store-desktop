package sample;

public class Customer
{

    private static int accountId;
    private static boolean isPremium;

    public static int getAccountId()
    {
        return accountId;
    }

    public static void setAccountId(int accountId)
    {
        Customer.accountId = accountId;
    }

    public static boolean isIsPremium()
    {
        return isPremium;
    }

    public static void setIsPremium(boolean isPremium)
    {
        Customer.isPremium = isPremium;
    }
}
