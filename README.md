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

##Thanks to
[![Arcbees.com](http://arcbees-ads.appspot.com/ad.png)](http://arcbees.com)

[![githalytics.com alpha](https://cruel-carlota.pagodabox.com/54c2ffbc1d29d1594bd73744ca3b1ec3 "githalytics.com")](http://githalytics.com/ArcBees/gwt-stripe)
