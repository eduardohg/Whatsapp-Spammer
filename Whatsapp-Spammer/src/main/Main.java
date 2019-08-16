package main;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	private WebDriver driver;
	public static final String CONTATO = "Gui Comp";//CONTATO OU GRUPO DESEJADO
	public static final String MSG = "SAIA, SAIA DO ZAP AGORA";//MENSAGEM A SER ENVIADA
	public static final int QNT = 10; //QUANTIDADE DE MENSAGENS A SEREM ENVIADAS
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver","D:/chrome/chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://web.whatsapp.com/");
	}

	@Test
	public void spammer() throws IOException {
		//ESPERA PARA LER O QR CODE
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//PROCURA CONTATO OU GRUPO
		WebElement contato = driver.findElement(By.cssSelector("span[title='"+CONTATO+"']"));
		contato.click();
		
		//LOOP PARA ENVIAR MENSAGENS
		for(int i=0;i<QNT;i++) {
			WebElement txt = driver.findElement(By.cssSelector("div[class='_3u328 copyable-text selectable-text'"));
			txt.sendKeys(MSG);
			WebElement send = driver.findElement(By.cssSelector("span[data-icon='send']"));
			send.click();
		}
	
	}
	
	public void finaliza() {
		driver.close();
	}
	
}
