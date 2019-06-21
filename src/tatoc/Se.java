package tatoc;

import java.awt.Desktop.Action;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.Cookie;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Se {

	public static void main(String[] args) throws InterruptedException {
		String url = "http://10.0.1.86/tatoc";
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.cssSelector("div.greenbox[onclick=\"passthru();\"]")).click();
		driver.switchTo().frame("main");
		String b1 = driver.findElement(By.id("answer")).getAttribute("class");
		// System.out.println(b1);
		String b2;

		do {
			driver.findElement(By.linkText("Repaint Box 2")).click();
			driver.switchTo().frame("child");
			b2 = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			// System.out.println(b2);

		} while (!(b1.equals(b2)));

		driver.findElement(By.linkText("Proceed")).click();
		WebElement x = driver.findElement(By.cssSelector("div.ui-draggable"));
		WebElement y = driver.findElement(By.cssSelector("div#dropbox"));

		Actions builder = new Actions(driver);
		builder.dragAndDrop(x, y).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
		driver.findElement(By.linkText("Launch Popup Window")).click();

		String MainWindow = driver.getWindowHandle();
		// System.out.println(MainWindow);
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				/*
				 * b2 = driver.getTitle(); System.out.println(b2);
				 * System.out.println(ChildWindow);
				 */
			}
		}

		driver.findElement(By.id("name")).sendKeys("rohit");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		driver.switchTo().window(MainWindow);
		driver.findElement(By.linkText("Proceed")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Generate Token")).click();
		Thread.sleep(1000);
		String token = driver.findElement(By.xpath("//*[@id=\"token\"]")).getText();
		token = token.substring(7);
		System.out.println(token);

		/*
		 * Cookie name=new Cookie("mycookie",token); driver.manage().addCookie(name);
		 * Set cookiesList = driver.manage().getCookies(); for(Cookies getcookies
		 * :cookiesList) { System.out.println(getcookies); }
		 */
		 
		 
	}

}
