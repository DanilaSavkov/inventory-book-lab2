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

    public boolean equals(Fabricator fabricator) {
        return (this.name.equals(fabricator.name) && this.payerAccountNumber == fabricator.payerAccountNumber);
    }

    @Override
    public String toString() {
        return "Fabricator{" +
                "name='" + name + '\'' +
                ", payerAccountNumber=" + payerAccountNumber +
                '}';
    }
}
