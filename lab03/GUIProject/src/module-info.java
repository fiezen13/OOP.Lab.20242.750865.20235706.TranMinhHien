/**
 * 
 */
/**
 * 
 */
module GUIProject {
	 requires javafx.controls;
	 requires javafx.fxml;
	 requires javafx.graphics; 
	 requires javafx.media;
	 requires javafx.web;
	 requires javafx.swing;
	 requires javafx.base;
	 
	 opens hust.soict.hedspi.javafx to javafx.fxml;
	 exports hust.soict.hedspi.javafx;
}