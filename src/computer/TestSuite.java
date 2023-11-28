package computer;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

import java.util.Random;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
//        1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//a[@href='/computers']"));
//        1.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
//        1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropdown(By.name("products-orderby"), "Name: Z to A");
//        1.4 Verify the Product will arrange in Descending order.
        verifyElements("Name: Z to A", "Name:Z to A : ", By.xpath("//option[contains(text(),'Name: Z to A')]"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

//2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//a[@href='/computers']"));
//            2.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
//2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropdown(By.name("products-orderby"), "Name: A to Z");
//            2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
//           2.5 Verify the Text "Build your own computer"
        verifyElements("Build your own computer", "Build your own computer", By.xpath("//h1[normalize-space()='Build your own computer']"));
//            2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropdown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
//2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropdown(By.id("id=product_attribute_2"), "8GB [+$60.00]");
//2.8 Select HDD radio "400 GB [+$100.00]"
        selectByVisibleTextFromDropdown(By.name("name=product_attribute_3_7"), "400 GB [+$100.00]");
//            2.9 Select OS radio "Vista Premium [+$60.00]"
        selectByVisibleTextFromDropdown(By.id("product_attribute_4_9"), "Vista Premium [+$60.00]");
//            2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander       [+$5.00]"
        selectByVisibleTextFromDropdown(By.id("id=product_attribute_5_12"), "Microsoft Office [+$50.00] & Total Commander [+$45.00");
//        2.11 Verify the price "$1,475.00"
        verifyElements("Error", "$1475.00", By.id("price-value-1"));
//        2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
//        2.13 Verify the Message "The product has been added to your shopping cart" on Top
        verifyTheStringMessage(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");
        // After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        // 2.15 Verify the message "Shopping cart"
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        String s = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//input[@class = 'qty-input']"), s);
        sendTextToElement(By.xpath("//input[@class = 'qty-input']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        // 2.17 Verify the Total"$2,950.00"
        verifyTheStringMessage(By.xpath("//span[@class='product-subtotal']"), "$2,950.00");
        // 2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.20 Verify the Text “Welcome, Please Sign In!”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"), "Welcome, Please Sign In!");
        // 2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        // 2.22 Fill the all mandatory field (First Name)
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Abcd");
        // 2.22 Fill the all mandatory field (Last Name)
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Xyz");
        // 2.22 Fill the all mandatory field (Email)
        Random random = new Random();
        random.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "abcd" + random.nextInt() + "@gmail.com");
        // 2.22 Fill the all mandatory field (Country)
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        // 2.22 Fill the all mandatory field (City)
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Harrow");
        // 2.22 Fill the all mandatory field (Address)
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "157, King Road");
        // 2.22 Fill the all mandatory field (Postcode)
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA1 1DB");
        // 2.22 Fill the all mandatory field (Contact No)
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "01245822274");
        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        // 2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // 2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        // Click on Continue button
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        // 2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        // 2.28 Fill all the details (Card Holder Name)
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Abcdxyz");
        // 2.28 Fill all the details (Card Number)
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5524154745414444");
        // 2.28 Fill all the details (Card Expiry Date)
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        // 2.28 Fill all the details (Card Expiry Year)
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        // 2.28 Fill all the details (Card Secure Code)
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        // 2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        // 2.30 Verify “Payment Method” is “Credit Card”
        verifyTheStringMessage(By.xpath("//span[normalize-space()='Credit Card']"), "Credit Card");
        // 2.32 Verify “Shipping Method” is “Next Day Air”
        verifyTheStringMessage(By.xpath("//span[normalize-space()='Next Day Air']"), "Next Day Air");
        // 2.33 Verify Total is “$2,950.00”
        verifyTheStringMessage(By.xpath("//td[@class='subtotal']"), "$2,950.00");
        // 2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        // 2.35 Verify the Text “Thank You”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Thank you']"), "Thank you");
        // 2.36 Verify the message “Your order has been successfully processed!”
        verifyTheStringMessage(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"), "Your order has been successfully processed!");
        // 2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        // 2.38 Verify the text “Welcome to our store”
        verifyTheStringMessage(By.xpath("//h2[normalize-space()='Welcome to our store']"), "Welcome to our store");

    }
}
