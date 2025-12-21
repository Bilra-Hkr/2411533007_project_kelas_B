package model;

public class Customer {

    private int customerId;
    private String name;
    private String phone;
    private String email;
    private String tier;

    // Constructor untuk DAO (data dari database)
    public Customer(int customerId, String name,
                    String phone, String email, String tier) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.tier = tier;
    }

    // Constructor untuk Builder (REGISTER)
    public Customer(CustomerBuilder builder) {
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.phone = builder.phone;
        this.email = builder.email;
        this.tier = builder.tier;
    }

    // Getter
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getTier() {
        return tier;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
