package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click(); 
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("L&W");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Avinash");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("T");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Avi");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Dept");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("New lead creation");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("avinash.thamaraikannan25@gmail.com");
		WebElement findElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sel = new Select(findElement);
		sel.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		String title = driver.getTitle();
        System.out.println(title);
        
        driver.findElement(By.linkText("Duplicate Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).clear();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("SG");
        driver.findElement(By.id("createLeadForm_firstName")).clear();
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("AvinT");
        driver.findElement(By.className("smallSubmit")).click();
        String title1 = driver.getTitle();
        System.out.println(title1);
        
        if(title1.equals("View Lead | opentaps CRM"))
        {
            	System.out.println("Testcase ran successfully Lead got created");      		
        }  
	}
}
