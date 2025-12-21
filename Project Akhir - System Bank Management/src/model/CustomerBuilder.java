package model;

public class CustomerBuilder {

    int customerId;
    String name;
    String phone;
    String email;
    String tier;

    public CustomerBuilder setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public CustomerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder setTier(String tier) {
        this.tier = tier;
        return this;
    }

    public Customer build() {
        return new Customer(this);
    }
}
