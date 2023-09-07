
package sistemaescolar2;

/**
 *
 * @author Gabriel
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public  class SistemaEscolar2 extends Application{

    
    public static Pane painel = null;
   
   public static Scene cena = null;
    
    @Override
    public void start(Stage palco){
        loginGUI log = new loginGUI();
         painel = log.getLogin();
        
        
         cena = new Scene(painel);
         cena.getStylesheets().add(SistemaEscolar2.class.getResource("CssProgram.css").toString());
        palco.setTitle("Sistema Escolar");
        palco.setScene(cena);
       
        palco.show();
        
        
    }
    

    public static void main(String[] args) {
      
        
        launch(args);
        
        
    }
    
}
