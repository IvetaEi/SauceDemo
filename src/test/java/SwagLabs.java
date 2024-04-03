import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwagLabs {
    public static boolean assertEquals(String actual, String expected) {
        return actual.equals(expected);
    }

    @Test
    public void TS1SwagLabsTC1() {
        String cart = "Your Cart";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        WebElement cartText = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        Assert.assertEquals(cartText.getText(),cart);
    }

    @Test
    public void TS1SwagLabsTC2() {
        String noInfo = "Error: First Name is required";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("continue")).click();
        WebElement checkoutText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3"));
        Assert.assertEquals(checkoutText.getText(),noInfo);
    }

    @Test
    public void TS1SwagLabsTC3() {
        String nameOnly = "Error: Last Name is required";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Maja");
        driver.findElement(By.id("continue")).click();
        WebElement checkoutText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3"));
        Assert.assertEquals(checkoutText.getText(),nameOnly);
    }

    @Test
    public void TS1SwagLabsTC4() {
        String surnameOnly = "Error: First Name is required";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("last-name")).sendKeys("Maja Maja");
        driver.findElement(By.id("continue")).click();
        WebElement checkoutText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3"));
        Assert.assertEquals(checkoutText.getText(),surnameOnly);
    }

    @Test
    public void TS1SwagLabsTC5() {
        String zipCodeOnly = "Error: First Name is required";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        WebElement checkoutText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3"));
        Assert.assertEquals(checkoutText.getText(),zipCodeOnly);
    }

    @Test
    public void TS1SwagLabsTC6() {
        String zipCodeWSpecChar = "Error: No special characters in Zip/Postal Code allowed";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Maja");
        driver.findElement(By.id("last-name")).sendKeys("Maja Maja");
        driver.findElement(By.id("postal-code")).sendKeys("!2@45");
        driver.findElement(By.id("continue")).click();
        WebElement checkoutText = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        Assert.assertEquals(checkoutText.getText(),zipCodeWSpecChar);
    }

    @Test
    public void TS1SwagLabsTC7() {
        String emptyCartOrder = "Error: Your cart is empty";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Maja");
        driver.findElement(By.id("last-name")).sendKeys("Maja Maja");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        WebElement checkoutText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2"));
        Assert.assertEquals(checkoutText.getText(),emptyCartOrder);
    }

    @Test
    public void TS1SwagLabsTC8() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String backpack = "Sauce Labs Backpack";
//        WebElement backpack = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div"));
        String backpackPrice = "$29.99";
//        WebElement backpackPrice = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div"));
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        String bikeLight = "Sauce Labs Bike Light";
        String bikeLightPrice = "$9.99";
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        String boltShirt = "Sauce Labs Bolt T-Shirt";
        String boltShirtPrice = "$15.99";
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        String jacket = "Sauce Labs Fleece Jacket";
        String jacketPrice = "$49.99";
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        String onesie = "Sauce Labs Onesie";
        String onesiePrice = "$7.99";
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        String redShirt = "Test.allTheThings() T-Shirt (Red)";
        String redShirtPrice = "$15.99";

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement cartItem1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div"));
        Assert.assertEquals(cartItem1.getText(), backpack);
        WebElement cartItem1Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem1Price.getText(), backpackPrice);

        WebElement cartItem2 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div"));
        Assert.assertEquals(cartItem2.getText(), bikeLight);
        WebElement cartItem2Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem2Price.getText(), bikeLightPrice);

        WebElement cartItem3 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[5]/div[2]/a/div"));
        Assert.assertEquals(cartItem3.getText(), boltShirt);
        WebElement cartItem3Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[5]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem3Price.getText(), boltShirtPrice);

        WebElement cartItem4 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[6]/div[2]/a/div"));
        Assert.assertEquals(cartItem4.getText(), jacket);
        WebElement cartItem4Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[6]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem4Price.getText(), jacketPrice);

        WebElement cartItem5 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[7]/div[2]/a/div"));
        Assert.assertEquals(cartItem5.getText(), onesie);
        WebElement cartItem5Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[7]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem5Price.getText(), onesiePrice);

        WebElement cartItem6 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[8]/div[2]/a/div"));
        Assert.assertEquals(cartItem6.getText(), redShirt);
        WebElement cartItem6Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[8]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem6Price.getText(), redShirtPrice);
    }

    @Test
    public void TS1SwagLabsTC9() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[1]")).sendKeys("2");
    }

    @Test
    public void TS1SwagLabsTC10() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
        driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
        driver.findElement(By.id("continue-shopping")).click();
    }

    @Test
    public void TS1SwagLabsTC11() {
        String checkout = "Checkout: Complete!";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();

        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Maja");
        driver.findElement(By.id("last-name")).sendKeys("Maja Maja");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        WebElement fullCartOrder = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        Assert.assertEquals(fullCartOrder.getText(), checkout);
    }

    @Test
    public void TS1SwagLabsTC12() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[1]")).click();
    }

    @Test
    public void TS1SwagLabsTC13() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[2]")).click();
    }

    @Test
    public void TS1SwagLabsTC14() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[3]")).click();
    }

    @Test
    public void TS1SwagLabsTC15() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select/option[4]")).click();
    }

    @Test
    public void TS1SwagLabsTC16() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("")).click();
    }

    @Test
    public void TS1SwagLabsTC17() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @Test
    public void TS1SwagLabsTC18() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("react-burger-menu-btn")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("inventory_sidebar_link")).click();
    }

    @Test
    public void TS2SwagLabsTC1() {
        String backpack = "Sauce Labs Backpack";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).click();
        WebElement isItTheSame = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[1]"));
        Assert.assertEquals(isItTheSame.getText(), backpack);
    }

    @Test
    public void TS2SwagLabsTC2() {
        String jacket = "Sauce Labs Fleece Jacket";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[4]/div[2]/div[1]/a/div")).click();
        WebElement isItTheSame = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[1]"));
        Assert.assertEquals(isItTheSame.getText(), jacket);
    }

    @Test
    public void TS2SwagLabsTC3() {
        String jacketAddToCart = "Remove";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[4]/div[2]/div[2]/button")).click();
        WebElement isItTheSame = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[4]/div[2]/div[2]/button"));
        Assert.assertEquals(isItTheSame.getText(), jacketAddToCart);
    }

    @Test
    public void TS2SwagLabsTC4() {
        String cart = "Your Cart";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[4]/div[2]/div[1]/a/div")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/button")).click();
        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        WebElement inTheCart = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        Assert.assertEquals(inTheCart.getText(), cart);
    }

    @Test
    public void TS2SwagLabsTC5() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String backpack = "Sauce Labs Backpack";
        String backpackPrice = "$29.99";
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        String bikeLight = "Sauce Labs Bike Light";
        String bikeLightPrice = "$9.99";
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        String boltShirt = "Sauce Labs Bolt T-Shirt";
        String boltShirtPrice = "$15.99";
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        String jacket = "Sauce Labs Fleece Jacket";
        String jacketPrice = "$49.99";
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        String onesie = "Sauce Labs Onesie";
        String onesiePrice = "$7.99";
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        String redShirt = "Test.allTheThings() T-Shirt (Red)";
        String redShirtPrice = "$15.99";

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement cartItem1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div"));
        Assert.assertEquals(cartItem1.getText(), backpack);
        WebElement cartItem1Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem1Price.getText(), backpackPrice);

        WebElement cartItem2 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div"));
        Assert.assertEquals(cartItem2.getText(), bikeLight);
        WebElement cartItem2Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem2Price.getText(), bikeLightPrice);

        WebElement cartItem3 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[5]/div[2]/a/div"));
        Assert.assertEquals(cartItem3.getText(), boltShirt);
        WebElement cartItem3Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[5]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem3Price.getText(), boltShirtPrice);

        WebElement cartItem4 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[6]/div[2]/a/div"));
        Assert.assertEquals(cartItem4.getText(), jacket);
        WebElement cartItem4Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[6]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem4Price.getText(), jacketPrice);

        WebElement cartItem5 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[7]/div[2]/a/div"));
        Assert.assertEquals(cartItem5.getText(), onesie);
        WebElement cartItem5Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[7]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem5Price.getText(), onesiePrice);

        WebElement cartItem6 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[8]/div[2]/a/div"));
        Assert.assertEquals(cartItem6.getText(), redShirt);
        WebElement cartItem6Price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[8]/div[2]/div[2]/div"));
        Assert.assertEquals(cartItem6Price.getText(), redShirtPrice);
    }

    @Test
    public void TS2SwagLabsTC6() {
        String cart = "Your Cart";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        WebElement inTheCart = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        Assert.assertEquals(inTheCart.getText(), cart);
    }

    @Test
    public void TS2SwagLabsTC7() {
        String nameOnly = "Error: Last Name is required";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Maja");
        driver.findElement(By.id("continue")).click();
        WebElement checkoutText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3"));
        Assert.assertEquals(checkoutText.getText(),nameOnly);
    }

    @Test
    public void TS2SwagLabsTC8() {
        String surnameOnly = "Error: First Name is required";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("last-name")).sendKeys("Maja Maja");
        driver.findElement(By.id("continue")).click();
        WebElement checkoutText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3"));
        Assert.assertEquals(checkoutText.getText(),surnameOnly);
    }

    @Test
    public void TS2SwagLabsTC9() {
        String postCodeOnly = "Error: First Name is required";
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        WebElement checkoutText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3"));
        Assert.assertEquals(checkoutText.getText(),postCodeOnly);
    }

    @Test
    public void TS2SwagLabsTC10() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("")).click();
    }

    @Test
    public void TS2SwagLabsTC11() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @Test
    public void TS2SwagLabsTC12() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("react-burger-menu-btn")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("inventory_sidebar_link")).click();
    }

    @Test
    public void TS2SwagLabsTC13() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]"));
        cartButton.click();

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
        driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
        driver.findElement(By.id("continue-shopping")).click();
    }

//_globalDriver.switchTo().frame("fancybox-frame");
//_globalDriver.findElement(By.id("cbCheckAll")).click();

//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
}
