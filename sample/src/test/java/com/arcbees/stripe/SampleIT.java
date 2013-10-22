package com.arcbees.stripe;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleIT {
    private static final String ROOT = "http://localhost:8080/sample";

    private final WebDriver webDriver = new ChromeDriver();

    @Test
    public void sampleTest() throws Throwable {
        webDriver.get(ROOT);

        assertPageContains("isInjected: false");
        assertPageContains("Injecting Stripe.JS ...");
        assertPageContains("Stripe.JS injected successfully");
        assertPageContains("isInjected: true");
        assertPageContains("Status: 200");
        assertPageContains("Response.livemode: false");
        assertPageContains("Response.type: card");
        assertPageContains("Response.object: token");
        assertPageContains("Response.used: false");
        assertPageContains("Response.used: false");
        assertPageContains("Response.card.name: John Smith");
        assertPageContains("Response.card.address_line1: 1093 Charleston rd");
        assertPageContains("Response.card.address_line2: apt. 3");
        assertPageContains("Response.card.address_city: Los Angeles");
        assertPageContains("Response.card.address_state: CA");
        assertPageContains("Response.card.address_zip: 91257");
        assertPageContains("Response.card.address_country: United States");
        assertPageContains("Response.card.country: US");
        assertPageContains("Response.card.exp_month: 9");
        assertPageContains("Response.card.exp_year: 2014");
        assertPageContains("Response.card.last4: 4242");
        assertPageContains("Response.card.fingerprint: EZ5rfzYGZgOKLARM");
        assertPageContains("Response.card.object: card");
        assertPageContains("Response.card.type: Visa");
        assertPageContains("Validating card number 4242424242424242 : true");
        assertPageContains("Validating card number 4242-4242-4242-4242 : true");
        assertPageContains("Validating card number 4242 4242 4242 4242 : true");
        assertPageContains("Validating card number 4242-1111-1111-1111 : false");
        assertPageContains("Validating card number 12345678 : false");
        assertPageContains("Validating card number mistake : false");
        assertPageContains("Validating card expiry 02/15 : false");
        assertPageContains("Validating card expiry 02/2015 : true");
        assertPageContains("Validating card expiry 02/10 : false");
        assertPageContains("Validating card expiry 02/2020 : true");
        assertPageContains("Validating card expiry 2/2020 : true");
        assertPageContains("Validating card cvc 123 : true");
        assertPageContains("Validating card cvc  : false");
        assertPageContains("Find card type for number 4242-4242-4242-4242 : Visa");
        assertPageContains("Find card type for number 378282246310005 : American Express");
        assertPageContains("Find card type for number 1234 : Unknown");
        assertPageContains("Response.type: bank_account");
        assertPageContains("Response.type: bank_account");
        assertPageContains("Response.object: token");
        assertPageContains("Response.used: false");
        assertPageContains("Response.bank_account.country: US");
        assertPageContains("Response.bank_account.bank_name: BANK OF AMERICA, N.A.");
        assertPageContains("Response.bank_account.last4: 6789");
        assertPageContains("Response.bank_account.validated: false");
        assertPageContains("Response.bank_account.fingerprint: 3rzcjlholrBZEDdx");
        assertPageContains("Response.bank_account.object: bank_account");
        assertPageContains("Validating routing number 111000025, US : true");
        assertPageContains("Validating routing number 11111-111, CA : true");
        assertPageContains("Validating routing number 990000000, US : true");
        assertPageContains("Validating routing number 12345, US : false");
        assertPageContains("Validating routing number mistake, CA : false");
        assertPageContains("Validating account number 000123456789, US : true");
        assertPageContains("Validating account number mistake, US : false");
    }

    @After
    public void after() {
        webDriver.quit();
    }

    private WebElement assertPageContains(String text) {
        return webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='" + text + "']")));
    }

    private WebDriverWait webDriverWait() {
        return new WebDriverWait(webDriver, 20);
    }
}
