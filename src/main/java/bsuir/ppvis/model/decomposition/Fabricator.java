package bsuir.ppvis.model.decomposition;

public class Fabricator {
    private final String name;
    private final int payerAccountNumber;

    public Fabricator(String name, int payerAccountNumber) {
        this.name = name;
        this.payerAccountNumber = payerAccountNumber;
    }

    public String getName() {
        return name;
    }

    public int getPayerAccountNumber() {
        return payerAccountNumber;
    }
}
