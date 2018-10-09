/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_onkar_singh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Onkar
 */
public class Assignment1_Onkar_Singh extends Application {
    
    static Stage stage1 = new Stage();
    static Stage stage2 = new Stage();
    static Stage stage3 = new Stage();
    
    //static
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("Page1.fxml"));
        Parent root2 = FXMLLoader.load(getClass().getResource("Page2.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("Page3.fxml"));

        Scene scene1 = new Scene(root1);
        Scene scene2 = new Scene(root2);
        Scene scene3 = new Scene(root3);
        
        stage1.setScene(scene1);
        stage2.setScene(scene2);
        stage3.setScene(scene3);
        
        show1();        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void show1(){
        stage1.show();
        stage2.hide();
        stage3.hide();
    }
    public static void show2(){
        stage2.show();
        stage1.hide();
        stage3.hide();
    }
    public static void show3(){
        stage3.show();
        stage1.hide();
        stage2.hide();
    }
    
    
}
