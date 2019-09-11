package Group;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Registration<price> {

    protected static WebDriver driver;

    public String genratEmail(String startvalue) {
        String email = startvalue.concat(new Date().toString());
        return email;
    }

    public static String randomDate() {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }


    @BeforeMethod
    public void openbrowser() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BroserDriver\\chromedriver.exe");

        //open the browser
        driver = new ChromeDriver();

        //maximise the browser window screen
        driver.manage().window().fullscreen();

        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void closebrowser() {
        driver.quit();
    }

    @Test(priority = 0)
    public void userShouldBeAbleToRegisterSuccessfully() {
        //open the website
        driver.get("https://demo.nopcommerce.com");

        //click on register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();


        //enter the first name
        driver.findElement(By.id("FirstName")).sendKeys("Purvi");

        //enter the lastname
        driver.findElement(By.xpath("//input[@name ='LastName']")).sendKeys("Patel");

        //Enter Email
        driver.findElement(By.name("Email")).sendKeys("testtest" + randomDate() + "@test56.com");

        //enter the password
        driver.findElement(By.xpath("//input[contains(@name, 'Password')]")).sendKeys("lucky1");

        //enter the confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("lucky1");

        //click on Register
        driver.findElement(By.id("register-button")).click();

        //Assert
        String expectgetMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals(actualMessage, expectgetMessage);

        //click on continue
        driver.findElement(By.xpath("//input[@class=\"button-1 register-continue-button\"]")).click();

    }

    @Test(priority = 1)
    public void userShouldBeAbleToReferAProductToEmailAFriend() {
        //open the website
        driver.get("https://demo.nopcommerce.com");
        //click on register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();


        //enter the first name
        driver.findElement(By.id("FirstName")).sendKeys("Purvi");

        //enter the lastname
        driver.findElement(By.xpath("//input[@name ='LastName']")).sendKeys("Patel");

        //Enter Email
        driver.findElement(By.name("Email")).sendKeys("testtest" + randomDate() + "@test56.com");

        //enter the password
        driver.findElement(By.xpath("//input[contains(@name, 'Password')]")).sendKeys("lucky1");

        //enter the confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("lucky1");

        //click on Register
        driver.findElement(By.id("register-button")).click();

        //click on continue
        driver.findElement(By.xpath("//input[@class=\"button-1 register-continue-button\"]")).click();

        //click on Electrical
        driver.findElement(By.xpath("//h2/a[@title=\"Show products in category Electronics\"]")).click();

        //click on Apple
        driver.findElement(By.linkText("Apple")).click();

        //click on AppleMacBook Pro 13-inch
        driver.findElement(By.xpath("//h2/a[@href=\"/apple-macbook-pro-13-inch\"]")).click();

        //Click on Email a friend
        driver.findElement(By.xpath("//div[@class=\"email-a-friend\"]")).click();

        //input the friend email address
        driver.findElement(By.className("friend-email")).sendKeys("purvippatel80@gmail.com");

        //Enter the personal message
        driver.findElement(By.id("PersonalMessage")).sendKeys("do you want this MacBook Pro");

        //click on send email
        driver.findElement(By.xpath("//div/input[contains(@type, 'submit')]")).click();

        //Assert
        String expectgetMessage = "Your message has been sent.";
        String actualMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals(actualMessage, expectgetMessage);
    }

    @Test(priority = 2)
    public void userShouldBeNavigateCameraAndPhotoPage() {

        //open the website
        driver.get("https://demo.nopcommerce.com");

        //click on companylogo
        // driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));

        //click on Electrical
        driver.findElement(By.xpath("//h2/a[@title=\"Show products in category Electronics\"]")).click();

        //click on camera and photo
        driver.findElement(By.xpath(" //h2/a[@href=\"/camera-photo\"]")).click();

        //Assert
        String expectresult = "Camera & photo";
        String actualresult = driver.findElement(By.xpath("//div/div[@class=\"page-title\"]")).getText();
        Assert.assertEquals(actualresult, expectresult);
    }

    @Test(priority = 3)
    public void userShouldBeSelectTheJewelleryByFilter$700to$3000() {

        //open the website
        driver.get("https://demo.nopcommerce.com");
        //click on jewellery
        driver.findElement(By.linkText("Jewelry")).click();
        //assert
        String expectedTitle = "Jewelry";
        String actualTitle = driver.findElement(By.linkText("Jewelry")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);

        //System.out.println("$2,100".substring(1).replace(",", ""));


        //click on price$700-$3000
        driver.findElement(By.xpath("//a[@href=\"//demo.nopcommerce.com/jewelry?price=700-3000\"]")).click();

        //assert
        String expectedvalue = "$2,100.00";
        //String actualvalue = (driver.findElement(By.xpath("//span[@class='item']")).getText());
        String actualvalue = (driver.findElement(By.xpath("//span[@class='price actual-price']")).getText());
                Assert.assertEquals(actualvalue,expectedvalue);}



             @Test (priority = 4)
             public void userShouldBeAbleToAddTwoBooksInTheBasket(){
                 //open the website
                 driver.get("https://demo.nopcommerce.com");

            //click on Books
            driver.findElement(By.linkText("Books")).click();

            //click on Fahrenheit 451 by Ray Bradbury
            driver.findElement(By.linkText("Fahrenheit 451 by Ray Bradbury")).click();

            //click on Add to Cart
                 driver.findElement(By.id("add-to-cart-button-37")).click();
            //click on  book
            driver.findElement(By.linkText("Books")).click();
            //click on First Prize Pies
             driver.findElement(By.linkText("First Prize Pies")).click();
             //click on Add to Cart
             driver.findElement(By.id("add-to-cart-button-38")).click();
             //click on Shopping Cart
                 driver.findElement(By.className("cart-label")).click();
                 //assert
                 String expectedCart = "SKU";
                 String actualCart = driver.findElement(By.xpath("//th[@class=\"sku\"]")).getText();
                 Assert.assertEquals(actualCart, expectedCart);


                }
}

