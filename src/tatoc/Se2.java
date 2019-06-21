package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Se2 {
	public static void main(String[] args) throws InterruptedException {
		String url = "http://10.0.1.86/tatoc";
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Advanced Course")).click();
		WebElement menu2=driver.findElement(By.cssSelector("span.menutitle"));
		Actions action=new Actions(driver);
		action.moveToElement(menu2).build().perform();
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[5]")).click();
}
}