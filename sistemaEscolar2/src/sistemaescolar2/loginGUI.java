
package sistemaescolar2;

/**
 *
 * @author Gabriel
 */
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

//importando as classes responsáveis  pelos eventos

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;

public class loginGUI {
    
    
    private GridPane painelLogin = new GridPane();
    private ChoiceBox user_CB = new ChoiceBox();
    private TextField user_TF = new TextField();
    private Label senha_LB = new Label("Senha");
    private PasswordField senha_PF = new PasswordField();
    private Button validar_Btn = new Button("Entrar");
    
    public loginGUI(){

        
        ObservableList<String> val_User =  FXCollections.observableArrayList("Professor","Aluno");
        user_CB.setValue("Professor");
        user_CB.setItems(val_User);
        
        validar_Btn.setOnAction(event ->{
            
            String tipoUsuario = user_CB.getSelectionModel().getSelectedItem().toString();
            String user = user_TF.getText();
            String senha = senha_PF.getText();
            
            conexao cone = new conexao(tipoUsuario,user,senha);
            
            
            
        
        
        });
        
        
        GridPane.setMargin(user_CB, new Insets(10,10,10,10));
        GridPane.setMargin(user_TF, new Insets(10,10,10,10));
        GridPane.setMargin(validar_Btn,new Insets(10,10,10,10));
        
        
        painelLogin.getStyleClass().add("background-app");
        
        painelLogin.add(user_CB,0,0);
        painelLogin.add(user_TF, 1,0);
        painelLogin.add(senha_LB, 0, 1);
        painelLogin.add(senha_PF, 1, 1);
        painelLogin.add(validar_Btn,0,2);
        
        
        
    }
    
    public Pane getLogin(){
        
        return painelLogin;
    }
    
    
    
}
