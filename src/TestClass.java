import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TestClass extends BaseDriver{

    /**
     TESTI BIRDEN FAZLA KEZ CALISTIRACAKSAN HER CALISTIRMADAN ONCE 36. VE 195. SATIRDAKI E-MAIL'IN SON SAYISINI 1 ARTTIR
     */
    @Test
    public void test1(){
        driver.navigate().to("https://demowebshop.tricentis.com/");

        WebElement registerNav = driver.findElement(By.linkText("Register"));
        registerNav.click();

        WebElement genderM = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gender-male"))));
        genderM.click();

        WebElement nameInput = driver.findElement(By.id("FirstName"));
        nameInput.sendKeys("Erdem");

        WebElement surnameInput = driver.findElement(By.id("LastName"));
        surnameInput.sendKeys("Buke");

        WebElement mailInput = driver.findElement(By.id("Email"));
        mailInput.sendKeys("erdem29@gmail.com");

        WebElement pwInput = driver.findElement(By.id("Password"));
        pwInput.sendKeys("Erdem123");

        WebElement pwInput2 = driver.findElement(By.id("ConfirmPassword"));
        pwInput2.sendKeys("Erdem123");

        WebElement registerBtn = driver.findElement(By.id("register-button"));
        registerBtn.click();

        WebElement regResult = wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.cssSelector("div[class='result']"))));

        Assert.assertTrue(regResult.isDisplayed());

    }

    @Test
    public void test2(){

        driver.navigate().to("https://demowebshop.tricentis.com/");

        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable
                (driver.findElement(By.linkText("Log out"))));
        logout.click();

        WebElement registerNav = wait.until(ExpectedConditions.elementToBeClickable
                (driver.findElement(By.linkText("Register"))));
        registerNav.click();

        WebElement genderM = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gender-male"))));
        genderM.click();

        WebElement nameInput = driver.findElement(By.id("FirstName"));
        nameInput.sendKeys("Erdem");

        WebElement surnameInput = driver.findElement(By.id("LastName"));
        surnameInput.sendKeys("Buke");

        WebElement mailInput = driver.findElement(By.id("Email"));
        mailInput.sendKeys("erdem@gmail.com");

        WebElement pwInput = driver.findElement(By.id("Password"));
        pwInput.sendKeys("Erdem123");

        WebElement pwInput2 = driver.findElement(By.id("ConfirmPassword"));
        pwInput2.sendKeys("Erdem123");

        WebElement registerBtn = driver.findElement(By.id("register-button"));
        registerBtn.click();

        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.cssSelector("div[class='validation-summary-errors']"))));

        Assert.assertTrue(errorMsg.getText().toLowerCase().contains("already exists"));

    }

    @Test
    public void test3(){
        driver.navigate().to("https://demowebshop.tricentis.com/");

        WebElement loginNav = driver.findElement(By.linkText("Log in"));
        loginNav.click();

        WebElement mailInput = wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.id("Email"))));
        mailInput.sendKeys("erdem@gmail.com");

        WebElement pwInput = driver.findElement(By.id("Password"));
        pwInput.sendKeys("Erdem123");

        WebElement loginBtn = driver.findElement(By.cssSelector("input[value='Log in']"));
        loginBtn.click();

        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable
                (driver.findElement(By.linkText("Log out"))));
        logout.click();

        WebElement loginMenuTus = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Log in']"))));
        Assert.assertTrue(loginMenuTus.isDisplayed());


    }

    @Test
    public void test4(){
        driver.navigate().to("https://demowebshop.tricentis.com/");

        WebElement loginNav = driver.findElement(By.linkText("Log in"));
        loginNav.click();

        WebElement mailInput = wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.id("Email"))));
        mailInput.sendKeys("erdem@gmail.com");

        WebElement pwInput = driver.findElement(By.id("Password"));
        pwInput.sendKeys("Erdem123");

        WebElement loginBtn = driver.findElement(By.cssSelector("input[value='Log in']"));
        loginBtn.click();

        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable
                (driver.findElement(By.linkText("Log out"))));

        Assert.assertTrue(logout.isDisplayed());

        logout.click();

    }

    @Test
    public void test5(){
        driver.navigate().to("https://demowebshop.tricentis.com/");

        // scenario a)
        WebElement loginNav = driver.findElement(By.linkText("Log in"));
        loginNav.click();

        WebElement loginBtn = driver.findElement(By.cssSelector("input[value='Log in']"));
        loginBtn.click();

        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.cssSelector("div[class='validation-summary-errors']"))));

        Assert.assertTrue(errorMsg.getText().toLowerCase().contains("login was unsuccessful"));

        // scenario b)
        WebElement mailInput = driver.findElement(By.id("Email"));
        mailInput.sendKeys("erdem@gmail.com");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='validation-summary-errors']"))
                .getText().toLowerCase().contains("login was unsuccessful"));

        //scenario c)
        driver.findElement(By.id("Email")).clear();
        WebElement pwInput = driver.findElement(By.id("Password"));
        pwInput.sendKeys("Erdem123");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='validation-summary-errors']"))
                .getText().toLowerCase().contains("login was unsuccessful"));


        //scenario d)
        driver.findElement(By.id("Password")).sendKeys("gecersizsifre");
        driver.findElement(By.id("Email")).sendKeys("gecersizmail@gmail.com");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='validation-summary-errors']"))
                .getText().toLowerCase().contains("login was unsuccessful"));

    }

    @Test
    public void test6(){
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("erdem29@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Erdem123");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        MyFunc.Bekle(1);

        WebElement laptop = driver.findElement(By.linkText("14.1-inch Laptop")); // text ini alacagim
        String laptopName = laptop.getText(); // assertion icin ürün adını aldım

        WebElement addtoCartLaptop = driver.findElement(By.xpath("(//input[@value='Add to cart'])[2]"));
        addtoCartLaptop.click();

        WebElement linkTextShoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("shopping cart")));
        WebElement message = driver.findElement(By.cssSelector("p[class='content']"));
        Assert.assertTrue(message.getText().toLowerCase().contains("added"));
        linkTextShoppingCart.click();

        WebElement productName2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='product-name']")));
        Assert.assertEquals(laptopName, productName2.getText()); // ürün adı sepettekiyle ayni mi assert'i

        WebElement country = driver.findElement(By.id("CountryId"));
        WebElement state = driver.findElement(By.id("StateProvinceId"));
        Select countrySelect = new Select(country);
        Select stateSelect = new Select(state);
        countrySelect.selectByValue("77");
        stateSelect.selectByValue("0");

        WebElement zipCode = driver.findElement(By.id("ZipPostalCode"));
        zipCode.sendKeys("34825");

        WebElement checkbox = driver.findElement(By.id("termsofservice"));
        checkbox.click();

        WebElement checkOut = driver.findElement(By.id("checkout"));
        checkOut.click();

        WebElement companyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingNewAddress_Company")));
        companyName.sendKeys("TechnoStudy");

        WebElement country2 = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select countrySelect2 = new Select(country2);
        countrySelect2.selectByValue("77");

        WebElement cityName = driver.findElement(By.id("BillingNewAddress_City"));
        cityName.sendKeys("Istanbul");

        WebElement address1 = driver.findElement(By.id("BillingNewAddress_Address1"));
        address1.sendKeys("Sancaktepe Samandıra Eyup Sultan Mahallesi");

        WebElement address2 = driver.findElement(By.id("BillingNewAddress_Address2"));
        address2.sendKeys("Atik Cikmazi No1");

        WebElement zipCode2 = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        zipCode2.sendKeys("34825");

        WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phoneNumber.sendKeys("05350187437");

        WebElement faxNumber = driver.findElement(By.id("BillingNewAddress_FaxNumber"));
        faxNumber.sendKeys("17");

        // 5 adet continue button u var ve bunlar icin list olusturdum
        List<WebElement> continueBtn = new ArrayList<>(driver.findElements(By.xpath("//input[@value='Continue']")));
        continueBtn.get(0).click();

        WebElement checkbox2 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("PickUpInStore"))));
        WebElement addressSelect = driver.findElement(By.id("shipping-address-select"));
        checkbox2.click();

        Assert.assertFalse(addressSelect.isDisplayed());
        continueBtn.get(1).click();

        wait.until(ExpectedConditions.elementToBeClickable(continueBtn.get(3)));
        continueBtn.get(3).click();

        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/p")));
        Assert.assertTrue(text.getText().toLowerCase().contains("cod"));
        continueBtn.get(4).click();

        List<WebElement> productPrices = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("span[class='product-price']"))));

        int beforetotal = 0;
        int total;

        for (int i = 0; i < productPrices.size(); i++) {
            if(i == 0){
                beforetotal += Integer.parseInt(productPrices.get(0).getText().substring(0,4));
            }else beforetotal += Integer.parseInt(productPrices.get(i).getText().substring(0,1));
        }

        WebElement totalPrice = driver.findElement(By.cssSelector("span[class='product-price order-total']"));
        total = Integer.parseInt(totalPrice.getText().substring(0,4));
        Assert.assertEquals(beforetotal, total); // Urun fiyatı ve ekstraların toplami, toplam fiyata esit mi ?

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        MyFunc.Bekle(1);
        WebElement confirmBtn = driver.findElement(By.cssSelector("input[value='Confirm']"));
        confirmBtn.click();

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='title']")));
        Assert.assertTrue(successMsg.getText().toLowerCase().contains("successfully"));

        WebElement continueButton = driver.findElement(By.cssSelector("input[class='button-2 order-completed-continue-button']"));
        continueButton.click();

        Assert.assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());
    }

    @Test
    public void test7(){
        WebElement poll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='block block-poll']")));
        Assert.assertTrue(poll.isDisplayed());

        WebElement pollAnswerExcellent = driver.findElement(By.id("pollanswers-1"));
        pollAnswerExcellent.click();

        WebElement voteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("vote-poll-1")));
        voteBtn.click();

        WebElement pollResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='poll-results']")));
        Assert.assertTrue(pollResults.getText().toLowerCase().contains("excellent") &&
                pollResults.getText().toLowerCase().contains("good") &&
                pollResults.getText().toLowerCase().contains("poor") &&
                pollResults.getText().toLowerCase().contains("very bad") &&
                pollResults.getText().toLowerCase().contains("vote(s)"));
    }

    @Test
    public void test8(){
        Actions actions = new Actions(driver);

        WebElement computersTab = driver.findElement(By.xpath("(//ul[@class='top-menu']/li)[2]"));
        Action action1 = actions.moveToElement(computersTab).build();
        action1.perform();

        WebElement notebooks = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("(//ul[@class='sublist firstLevel active']/li)[2]")));
        notebooks.click();

        WebElement addtoCart = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("input[value='Add to cart']")));
        String productName = driver.findElement(By.linkText("14.1-inch Laptop")).getText(); // assertion icin
        addtoCart.click();

        WebElement shoppingCart = driver.findElement(By.linkText("shopping cart"));
        shoppingCart.click();

        WebElement product = driver.findElement(By.cssSelector("a[class='product-name']"));
        Assert.assertEquals(productName , product.getText());

        WebElement couponBtn = driver.findElement(By.name("applydiscountcouponcode"));
        couponBtn.click();

        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div[class='message']")));

        Assert.assertTrue(errorMsg.getText().toLowerCase().contains("couldn't be applied"));

        WebElement giftcardBtn = driver.findElement(By.name("applygiftcardcouponcode"));
        giftcardBtn.click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='message']"))
                .getText().toLowerCase().contains("couldn't be applied"));

        WebElement country = driver.findElement(By.id("CountryId"));
        WebElement state = driver.findElement(By.id("StateProvinceId"));
        Select countrySelect = new Select(country);
        Select stateSelect = new Select(state);
        countrySelect.selectByValue("77");
        stateSelect.selectByValue("0");

        WebElement zipCode = driver.findElement(By.id("ZipPostalCode"));
        zipCode.sendKeys("34825");

        WebElement checkbox = driver.findElement(By.id("termsofservice"));
        checkbox.click();

        WebElement checkOut = driver.findElement(By.id("checkout"));
        checkOut.click();

        // 5 adet continue button u var ve bunlar icin list olusturdum
        List<WebElement> continueBtn = new ArrayList<>(driver.findElements(By.xpath("//input[@value='Continue']")));
        continueBtn.get(0).click();

        WebElement checkbox2 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("PickUpInStore"))));
        WebElement addressSelect = driver.findElement(By.id("shipping-address-select"));
        checkbox2.click();

        Assert.assertFalse(addressSelect.isDisplayed());
        continueBtn.get(1).click();

        wait.until(ExpectedConditions.elementToBeClickable(continueBtn.get(3)));
        continueBtn.get(3).click();

        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/p")));
        Assert.assertTrue(text.getText().toLowerCase().contains("cod"));
        continueBtn.get(4).click();

        List<WebElement> productPrices = new ArrayList<>(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("span[class='product-price']"))));

        int beforetotal = 0;
        int total;

        for (int i = 0; i < productPrices.size(); i++) {
            if(i == 0){
                beforetotal += Integer.parseInt(productPrices.get(0).getText().substring(0,4));
            }else beforetotal += Integer.parseInt(productPrices.get(i).getText().substring(0,1));
        }

        WebElement totalPrice = driver.findElement(By.cssSelector("span[class='product-price order-total']"));
        total = Integer.parseInt(totalPrice.getText().substring(0,4));
        Assert.assertEquals(beforetotal, total); // Urun fiyatı ve ekstraların toplami, toplam fiyata esit mi ?

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        MyFunc.Bekle(1);
        WebElement confirmBtn = driver.findElement(By.cssSelector("input[value='Confirm']"));
        confirmBtn.click();

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='title']")));
        Assert.assertTrue(successMsg.getText().toLowerCase().contains("successfully"));

        WebElement continueButton = driver.findElement(By.cssSelector("input[class='button-2 order-completed-continue-button']"));
        continueButton.click();

        Assert.assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());

        bekleVeKapat();
    }

}
