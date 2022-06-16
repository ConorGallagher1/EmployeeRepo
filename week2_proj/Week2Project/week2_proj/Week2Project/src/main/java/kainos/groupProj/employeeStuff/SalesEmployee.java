package kainos.groupProj.employeeStuff;

public class SalesEmployee extends Employee{
    private double CommissionRate;
    private double TotalSales;

    public SalesEmployee(double NewRate, double NewSales) {
        setCommissionRate(NewRate);
        setTotalSales(NewSales);
    }

    //CALC PAY METHOD (SPRINT B, US 5)
    @Override
    public double calcPay() { // calculate monthly pay in pence
        return (getCurrentSal() / 12) + getCommissionRate();
    }

    //GETTERS AND SETTERS
    public double getCommissionRate() {
        return CommissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        CommissionRate = commissionRate;
    }

    public double getTotalSales() {
        return TotalSales;
    }

    public void setTotalSales(double totalSales) {
        TotalSales = totalSales;
    }
}
