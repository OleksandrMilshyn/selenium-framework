package data;

import model.Customer;

public final class TestDataFactory {

    private TestDataFactory() {
    }

    public static Customer validCustomer() {
        return new Customer(
                "Alex",
                "Tester",
                "00-001"
        );
    }
}
