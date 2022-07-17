package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadAssignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		//Find the username  and enter the user  name value (demosalesmanager)
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		// Find the password field and enter the password (crmsfa)
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// click on login button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// click on Leads link
		driver.findElement(By.linkText("Leads")).click(); 
		
		// click on create lead link
		driver.findElement(By.linkText("Create Lead")).click();
		
		// Enter the companyname 
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("L&W");
		
		// Enter the Firstname 
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Avinash");
		
		// Enter the Latname 
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("T");
		
		//Enter the FirstName(Local) 
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Avi");
		
		// Enter the Dept
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Dept");
		
		//Enter the Description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("New lead creation");
		
		// Enter the e-mail
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("avinash.thamaraikannan25@gmail.com");
		
		// Finding and storing the element
		WebElement findElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		//Creating the Select class
		Select sel = new Select(findElement);
		sel.selectByVisibleText("New York");
		
		driver.findElement(By.className("smallSubmit")).click();
		
		String title = driver.getTitle();
        System.out.println(title);
        
        // Verifying if we are on the correct page using page title
        
        if(title.equals("View Lead | opentaps CRM"))
        {
        	System.out.println("Testcase ran successfully Lead got created");
        }
		
	}

}
