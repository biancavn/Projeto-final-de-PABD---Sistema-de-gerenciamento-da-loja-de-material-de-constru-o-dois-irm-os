/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Bianca
 */
public class PaginaPrincipalController implements Initializable {

    @FXML
    private StackPane pilhaPainel;
    
   @FXML
    private ImageView buttonDeposito;

    @FXML
    private ImageView buttonFrotaVeiculos;

    @FXML
    private ImageView buttonFuncionarios;
    
 //metodo para carregar as diferentes paginas no stack panel
    private void carregarPagina(String name){
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/" +name+ ".fxml")); 
        } catch (IOException ex) {
            Logger.getLogger(PaginaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
       pilhaPainel.getChildren().clear();
       pilhaPainel.getChildren().add(root); //root é o painel que vai ser carregado
 }

       @Override
    public void initialize(URL url, ResourceBundle rb) {
    //comando dos botões(imagens) para carregar as paginas
    buttonDeposito.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
          carregarPagina("pagina1");
          });
    buttonFrotaVeiculos.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
          carregarPagina("pagina2");
          });
}
}


