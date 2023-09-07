package cadastro_sistemaescolar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.control.ChoiceBox;


import javafx.scene.layout.Pane;



public class Cadastro_SistemaEscolar extends Application{
     
    
    
    private Pane root = new Pane();
    private Scene cena = new Scene(root);
  
    
    @Override
    public void start(Stage palco){
        
        root=Aluno_root();
        cena.setRoot(root);
        
        root.setStyle("-fx-background-color:black;");
      
        cena.getStylesheets().add(Cadastro_SistemaEscolar.class.getResource("CssProgram.css").toString());
                
                
                
                
                
                
                
           
        
        
        
      palco.setTitle("Secretaria");
      palco.setScene(cena);
      palco.show();       
        
      
        
      
      
    }
    
  
 
    
    
    
    
    
    
    
    
      private  GridPane Aluno_root(){
        
        
       
        Button btn_Professor = new Button("Professor"); 
        Button btn_Cadastrar = new Button("Cadastrar");
        
        
        Label LB_nome = new Label("Nome");
        Label LB_sobrenome = new Label("Sobrenome");
        Label LB_turma = new Label("Turma");
        Label LB_turno = new Label("Turno");
        Label LB_sexo = new Label("Sexo");
        Label LB_idade = new Label("Idade");
        
        
        
        TextField TF_nome = new TextField();
        TextField TF_sobrenome = new TextField();
        TextField TF_turma = new TextField();
        TextField TF_idade = new TextField();
        
        
        
        ChoiceBox CB_turno = new ChoiceBox();
        
        ObservableList<String> turno_OB = FXCollections.observableArrayList("Matutino","Vespertino","Noturno");
        
        CB_turno.setItems(turno_OB);
        CB_turno.setValue("Matutino");
        
        ChoiceBox CB_sexo = new ChoiceBox();
        
        
        ObservableList<String> OB_sexo = FXCollections.observableArrayList("M","F");
        
        CB_sexo.setItems(OB_sexo);
        CB_sexo.setValue("M");
        
        
        btn_Professor.setOnAction(event ->{
            
           
            cena.setRoot(getProfessor_root());
            
            
            
            
        });
        
        btn_Cadastrar.setOnAction(event->{
        Connection con = null;
            
            try{    
        String nome = TF_nome.getText();
        String sobrenome = TF_sobrenome.getText();
        String turma = TF_turma.getText();
        String turno = CB_turno.getSelectionModel().getSelectedItem().toString();
        String sexo = CB_sexo.getSelectionModel().getSelectedItem().toString();
        int idade = Integer.parseInt(TF_idade.getText());
        
        int x = (int) (Math.random()*10000);
        String senha = Integer.toString(x);
                
                
              
                
                Class.forName("com.mysql.cj.jdbc.Driver");
            
            
                 con = DriverManager.getConnection("jdbc:mysql://localhost/validar_test","root","");
            
                 Statement stt = con.createStatement();
                 
                  stt.execute("insert into aluno(senha) values('"+senha+"');");
                 stt.executeUpdate("insert into perfil(nome,sobrenome,turma,turno,sexo,idade) values('"+nome+"','"+sobrenome+"','"+turma+"','"+turno+"','"+sexo+"',"+idade+",);");
                 
                
                 
                 
                 
        
                 Alert alertaCad = new Alert(AlertType.INFORMATION,"Cadastro realizado com sucesso");
                 alertaCad.show();
                 
        
        
        
            }catch(ClassNotFoundException e){
            
                 System.out.print("Erro com o driver\n"+e);
            
            }
        catch(SQLException e){
            
            
                System.out.println("Erro de conexao ao banco de dados\n"+e);
            
            
        }
        
        
        
        
        
        
        });
        
        
        
        
        GridPane GD_cadAluno = new GridPane(); 
        
        GD_cadAluno.add(btn_Professor,0,0);
        
        GD_cadAluno.add(LB_nome,0,1);
        GD_cadAluno.add(TF_nome,1,1);
        GD_cadAluno.add(LB_sobrenome,2,1);
        GD_cadAluno.add(TF_sobrenome, 3, 1);
        
        GD_cadAluno.add(LB_turma, 0, 2);
        GD_cadAluno.add(TF_turma,1,2);
        GD_cadAluno.add(LB_turno,2,2);
        GD_cadAluno.add(CB_turno,3,2);
        
        GD_cadAluno.add(LB_sexo,0,3);
        GD_cadAluno.add(CB_sexo,1,3);
        GD_cadAluno.add(LB_idade,2,3);
        GD_cadAluno.add(TF_idade,3,3);


        GD_cadAluno.add(btn_Cadastrar, 0, 4);
      
        
        
        
        return GD_cadAluno;
        
        
       
        
    }
    
    private Pane getProfessor_root(){
        
           Button btn_Aluno = new Button("Aluno");
           
           
           Label LB_cad = new Label("CPF");
           Label LB_senha = new Label("senha");
           TextField TF_Cad = new TextField();
           TextField TF_senha =  new TextField();
           
           Button btn_cadastrar = new Button("Cadastrar");
           
           
           btn_Aluno.setOnAction(event->{
           
                cena.setRoot(Aluno_root());
           
           });
           
         
           
           btn_cadastrar.setOnAction(ev->{
               
               String cadastro = TF_Cad.getText();
               String senha = TF_senha.getText();
               try{
                   
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost/validar_test","root","");
                
                   Statement stt = con.createStatement();
                   
                   stt.execute("insert into professor(cad,senha) values('"+cadastro+"','"+senha+"');");
                   
                   Alert cad_Conclu = new Alert(AlertType.INFORMATION,"Cadastro concluido");
                   cad_Conclu.show();
                   
                   
               }catch(ClassNotFoundException e){
               
                    System.out.print(e);
                   
               }catch(SQLException e){
               
                System.out.print(e);
               
               }
               
               
           
           
           });
           
           
           
           
           
           HBox HB_root = new HBox();
           
           HB_root.getChildren().add(btn_Aluno);
           HB_root.getChildren().addAll(LB_cad,TF_Cad,LB_senha,TF_senha,btn_cadastrar); 
           
           
           
           
           
        
        return HB_root;
        
    }
    
    


    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
   
        launch(args);
        
        
    }
    
    
}