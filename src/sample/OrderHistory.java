package sample;

import java.math.BigDecimal;

public class OrderHistory
{
    private int OrderId;
    private BigDecimal Total;

    public OrderHistory(int orderId, BigDecimal total)
    {
        OrderId = orderId;
        Total = total;
    }

    public int getOrderId()
    {
        return OrderId;
    }

    public BigDecimal getTotal()
    {
        return Total;
    }

    public void setOrderId(int orderId)
    {
        OrderId = orderId;
    }

    public void setTotal(BigDecimal total)
    {
        Total = total;
    }
}
