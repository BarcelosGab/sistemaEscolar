
package sistemaescolar2.Pages;

//Imports sql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.geometry.Insets;


import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;  
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;


 public class Aluno {
      
     
     private static Pane alunoData = null;
     
    public static Pane IU_aluno(String cad){
        
        GridPane aluno_Grid = new GridPane();
       
        
        
        
        
        
        
             
        dados_perfil(cad);
        aluno_Grid.add(alunoData,0,0);
        aluno_Grid.getStyleClass().add("background-app");
        
        
        return aluno_Grid;
        
    }
     
     private static  void dados_perfil(String cadastro){
        try{ 
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost/validar_test","root","");
         
         Statement stt = con.createStatement();
         
         ResultSet resultado=stt.executeQuery("select * from perfil where cad_perfil = "+cadastro+";");
         
         
         while(resultado.next()){
             
               String nome = resultado.getString("nome");
               String sobrenome = resultado.getString("sobrenome");
               String turma = resultado.getString("turma");
               String turno = resultado.getString("turno");
               String sexo = resultado.getString("sexo");
               Byte idade = resultado.getByte("idade");
             
             alunoData  = aluno_Perfil(nome,sobrenome,turma,turno,sexo,idade);
             
             
             
             
         }

         
         
         
         
         
         
        }
        catch(ClassNotFoundException e){
            
            Alert classe_Driver = new Alert(AlertType.INFORMATION,"Classe mysql Driver não encontrado\n"+e);
            
            classe_Driver.show();
            
            
        }catch(SQLException e){
            
            Alert erro_Sql = new Alert(AlertType.INFORMATION,"Erro ao conectar com o banco de dados \n"+e);
            
            erro_Sql.show();
            
            
            
        }
         
         
         
         
     }
    private static Pane aluno_Perfil(String nome,String sobrenome,String turma,String turno,String sexo,int idade){
        
        Label Nome_LB = new Label("Nome : "+nome);
        Label Sobrenome_LB = new Label("Sobrenome : "+sobrenome);
        Label Turma_LB = new Label("Turma : "+turma);
        Label Turno_LB = new Label("Turno : "+turno);
        Label Sexo_LB = new Label("Sexo : "+sexo);
        Label Idade_LB = new Label("Idade : "+idade);
        
        GridPane Grid_alunoPerfil = new GridPane();
        
        Grid_alunoPerfil.addRow(1,Nome_LB,Sobrenome_LB);
        Grid_alunoPerfil.addRow(2,Turma_LB,Turno_LB);
        Grid_alunoPerfil.addRow(3,Sexo_LB,Idade_LB);
        
        
         
        return Grid_alunoPerfil;
    }
    
    
    
    
     
     
}
