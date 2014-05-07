package com.arcbees.stripe.client;

public class CreditCard {
    public static class Builder {
        private String creditCardNumber;
        private String cvc;
        private Integer expirationMonth;
        private Integer expirationYear;
        private String name;
        private String addressLine1;
        private String addressLine2;
        private String addressCity;
        private String addressState;
        private String addressZip;
        private String addressCountry;

        public Builder creditCardNumber(String creditCardNumber) {
            this.creditCardNumber = creditCardNumber;
            return this;
        }

        public Builder cvc(String cvc) {
            this.cvc = cvc;
            return this;
        }

        public Builder expirationMonth(Integer expirationMonth) {
            this.expirationMonth = expirationMonth;
            return this;
        }

        public Builder expirationYear(Integer expirationYear) {
            this.expirationYear = expirationYear;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public Builder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public Builder addressCity(String addressCity) {
            this.addressCity = addressCity;
            return this;
        }

        public Builder addressState(String addressState) {
            this.addressState = addressState;
            return this;
        }

        public Builder addressZip(String addressZip) {
            this.addressZip = addressZip;
            return this;
        }

        public Builder addressCountry(String addressCountry) {
            this.addressCountry = addressCountry;
            return this;
        }

        public CreditCard build() {
            return new CreditCard(this);
        }
    }

    private final String creditCardNumber;
    private final String cvc;
    private final Integer expirationMonth;
    private final Integer expirationYear;
    private final String name;
    private final String addressLine1;
    private final String addressLine2;
    private final String addressCity;
    private final String addressState;
    private final String addressZip;
    private final String addressCountry;

    private CreditCard(Builder builder) {
        this.creditCardNumber = builder.creditCardNumber;
        this.cvc = builder.cvc;
        this.expirationMonth = builder.expirationMonth;
        this.expirationYear = builder.expirationYear;
        this.name = builder.name;
        this.addressLine1 = builder.addressLine1;
        this.addressLine2 = builder.addressLine2;
        this.addressCity = builder.addressCity;
        this.addressState = builder.addressState;
        this.addressZip = builder.addressZip;
        this.addressCountry = builder.addressCountry;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getName() {
        return name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressState() {
        return addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }
}
