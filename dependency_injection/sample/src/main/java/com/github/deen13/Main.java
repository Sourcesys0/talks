package com.github.deen13;

import org.controlsfx.control.Notifications;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.deen13.ui.NewsView;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;

@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {

	@Override
	public void init() throws Exception {
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread thread, Throwable throwable) {
				Notifications.create()
						.title("Error")
						.text(throwable.getMessage())
						.showError();
			}
		});
	}
	
	public static void main(String[] args) {
		launchApp(Main.class, NewsView.class, args);
	}
	
}
