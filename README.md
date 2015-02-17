# GWT Stripe
A simple [Stripe.js](https://stripe.com/docs/stripe.js) wrapper for GWT.

##Adding it to your project
1. Add Maven dependency to your POM: 

    ```xml
        <dependency>
            <groupId>com.arcbees.stripe</groupId>
            <artifactId>gwt</artifactId>
            <version>${core.version}</version>
        </dependency>
    ```

2. Inherit the required GWT module

    ```xml
    <inherits name="com.arcbees.stripe.GwtStripe"/>
    ```

##Using it with Gin
1. Install the required Gin module:

    ```java
    install(new StripeModule());
    ```
    
2. Inject and use the `Stripe` interface:

    ```java
    @Inject
    MyClass(Stripe stripe) {
        //...
    }
    ```
    
##Using it with StripeFactory
Use `StripeFactory.get()` to get a `Stripe` instance:

```java
Stripe stripe = StripeFactory.get();
```
    
You can call `StripeFactory.get()` at any time, since the Stripe instance you'll receive is stateless.


##Running the sample
1. Clone the repo
2. `cd` to root folder
3. `mvn clean install`
4. `cd sample`
5. `mvn clean gwt:run`

##Running integration tests
0. Make sure chromedriver is on your PATH
1. `cd` to root folder
2. `mvn clean verify -Pintegration-tests`

##Thanks to
[![Arcbees.com](http://i.imgur.com/HDf1qfq.png)](http://arcbees.com)

[![Atlassian](http://i.imgur.com/BKkj8Rg.png)](https://www.atlassian.com/)

[![IntelliJ](https://lh6.googleusercontent.com/--QIIJfKrjSk/UJJ6X-UohII/AAAAAAAAAVM/cOW7EjnH778/s800/banner_IDEA.png)](http://www.jetbrains.com/idea/index.html)
