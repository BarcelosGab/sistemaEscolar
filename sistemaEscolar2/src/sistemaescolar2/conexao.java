// Classe para conexao com o banco de dados
package sistemaescolar2;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 *
 * @author Gabriel
 */
public class conexao {
Connection con = null;

public conexao(String tipoUsuario,String usuario,String senha){
    try{
    
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost/validar_test","root","");
        
        Statement stt = con.createStatement();
        
        Boolean pass = false;
        
        ResultSet resultadoQuery = stt.executeQuery("select * from "+tipoUsuario+";");
        
        while(resultadoQuery.next()){
            
            if(usuario.equals(resultadoQuery.getString("cad")) && senha.equals(resultadoQuery.getString("senha")))
            
            {
            
                pass = true;
                
                switch (tipoUsuario){
                    
                    case "Aluno" : 
                        String cad = resultadoQuery.getString("cad");
                        SistemaEscolar2.cena.setRoot(sistemaescolar2.Pages.Aluno.IU_aluno(cad));
                    break;
                    default :
                        Alert quaquerCoisa = new Alert(AlertType.INFORMATION,"QualquerCoisa");
                        
                        quaquerCoisa.show();
                        break;
                    
                }
                
                
                break;
            
            }
            else{ continue;}
            
            
        }
        
        
        String Conectado = (pass)?"Conexao bem sucedida":"Falha ao se conectar";
        Alert conexaoAlert = new Alert(AlertType.INFORMATION,Conectado);
        
        conexaoAlert.show();
        
        
        
    
    }catch(ClassNotFoundException e){
        
        System.out.println(e);
        
        
    }
    catch(SQLException a){
        System.out.print(a);
    }
    
}


    
}
