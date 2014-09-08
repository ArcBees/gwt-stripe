/**
 * Copyright 2014 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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
