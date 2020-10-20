package pl.coderslab.taxesOperation;

public class TaxesOperation {

    public double calculateVat(double price, int vat) {
        double vatToPay = (price * vat/100);

        return vatToPay;
    }
}
