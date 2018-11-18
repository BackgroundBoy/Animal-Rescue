package application;

import javafx.scene.layout.AnchorPane;
import javafx.scene.SubScene;

public class MenuSubscene extends SubScene {

	
	// load Background
	// need to find new panel image (this one seem to be too small)
	private final String BACKGROUND_PATH = ClassLoader.getSystemResource("images/grey_panel.png").toString();
	
	
	// constructor
	public MenuSubscene() {
		// TODO Auto-generated constructor stub
		super(new AnchorPane(),600,600);
		
		AnchorPane root = (AnchorPane) this.getRoot();
		
		root.setStyle("-fx-background-color: transparent; " + "-fx-background-image: url(" + BACKGROUND_PATH + "); "
						+ "-fx-background-size: cover; ");
		
	}
	
	
	
}
