package com.example.balo_center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.io.IOException;

@SpringBootApplication
public class BaloCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaloCenterApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void openBrowser() {
		String url = "http://localhost:7071/view/auth/login";
		String os = System.getProperty("os.name").toLowerCase();
		Runtime runtime = Runtime.getRuntime();

		try {
			if (os.contains("win")) {
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} else if (os.contains("mac")) {
				runtime.exec("open " + url);
			} else if (os.contains("nix") || os.contains("nux")) {
				runtime.exec("xdg-open " + url);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
