package example;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

@Listeners(MyListener.class)
public class SampleTest  extends BaseTest{
	
	@Test
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
    }
	
	@Test
    public void testFailExample() {
        driver.get("https://www.google.com");
        driver.findElement(By.id("non-existent-element")); // will fail
    }



}
