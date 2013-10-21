package com.arcbees.stripe.client;

public class BankAccount {
    public static class Builder {
        private String country;
        private String routingNumber;
        private String acountNumber;

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder routingNumber(String routingNumber) {
            this.routingNumber = routingNumber;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.acountNumber = accountNumber;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }

    public static Builder with() {
        return new Builder();
    }

    private final Builder builder;

    private BankAccount(Builder builder) {
        this.builder = builder;
    }

    public String getCountry() {
        return builder.country;
    }

    public String getRoutingNumber() {
        return builder.routingNumber;
    }

    public String getAccountNumber() {
        return builder.acountNumber;
    }
}
