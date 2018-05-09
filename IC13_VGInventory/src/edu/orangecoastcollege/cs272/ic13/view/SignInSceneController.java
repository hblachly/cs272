package edu.orangecoastcollege.cs272.ic13.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class SignInSceneController {
    private static Controller controller = Controller.getInstance();
	@FXML
	private TextField emailAdressTF;
	@FXML
	private TextField passwordTF;
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label passwordErrorLabel;
	@FXML
	private Button signInButton;
	@FXML
	private Label signUpLabel;
	@FXML
	private Label signInErrorLabel;

	// Event Listener on Button[#signInButton].onAction
	@FXML
	public boolean signIn(ActionEvent event) {
	    String email = emailAdressTF.getText();
	    String password = passwordTF.getText();

	    emailErrorLabel.setVisible(email.isEmpty());
	    passwordErrorLabel.setVisible(password.isEmpty());
	    if (emailErrorLabel.isVisible() || passwordErrorLabel.isVisible())
	        return false;

	    String result = controller.signInUser(email, password);
	    if (!result.equals("SUCCESS"))
	    {
	        signInErrorLabel.setText(result);
	        signInErrorLabel.setVisible(true);
	        return false;
	    }
	    ViewNavigator.loadScene("Video Games List", ViewNavigator.VIDEO_GAME_LIST_SCENE);
        return true;
	}
	// Event Listener on Label[#signUpLabel].onMouseClicked
	@FXML
	public void loadSignUp(MouseEvent event) {
		ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
	}
}
