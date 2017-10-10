package com.github.deen13.ui;

import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.deen13.rest.entities.Article;
import com.github.deen13.rest.service.NewsService;

import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

@FXMLController
public class NewsController {

	@FXML private ListView<Article> news;
	@Autowired private NewsService service;

	private ListProperty<Article> binding = new SimpleListProperty<>();

	@FXML
	void initialize() {
		assert news != null : "fx:id=\"news\" was not injected: check your FXML file 'helloworld.fxml'.";
		assert service != null : "No rest news service was injected";

		try {
			binding.set(service.getLatestArticle());
			news.itemsProperty().bind(binding);
		} catch (Exception restException) {
			Notifications.create()
					.title("Rest communcation error")
					.text(restException.getMessage())
					.showError();
		}
	}

}
