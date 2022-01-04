package at.ac.fhsalzburg.swd.spring.services;

public interface PaymentServiceInterface {

    // public abstract Payment addPayment(int amount);

    public abstract String updatePayment();

    public abstract void receivePaymentInfos();

    public abstract boolean processPayment();

}
