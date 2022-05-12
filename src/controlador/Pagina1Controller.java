/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ProdutosDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import model.Produto;


/**
 * FXML Controller class
 *
 * @author Bianca
 */
public class Pagina1Controller implements Initializable {
    
    @FXML
    private TableView<Produto> TabelaProduto;
    @FXML
    private TableColumn<?, ?> columnID;
    @FXML
    private TableColumn<?, ?> columnNome;
    @FXML
    private TableColumn<?, ?> columnCategoria;
    @FXML
    private TableColumn<?, ?> columnQuantidade;
    @FXML
    private TableColumn<?, ?> columnMarca;
    @FXML
    private TableColumn<?, ?> columnTamanho;
    
    @FXML
    private ImageView imgEditar;
    
    @FXML
    private ImageView imgAtualizar;
    
    @FXML
    private ImageView imgRemover;
    
    
    

    //abre o modal
    @FXML
    private void modal(ActionEvent event) throws IOException{
          Stage stage = new Stage();
          Parent root = FXMLLoader.load(ProdutoModalController.class.getResource("/view/ProdutoModal.fxml"));
          stage.setScene(new Scene(root));
          stage.setTitle("Tela de cadastro de produtos");
          stage.initModality(Modality.WINDOW_MODAL);
          stage.initOwner(
                ((Node)event.getSource()).getScene().getWindow());
          stage.show();
          
    }
    
    @FXML
    public void CarregarTabela(){
        TabelaProduto.getItems().clear();
        columnID.setCellValueFactory(new PropertyValueFactory<>("IDProduto")); 
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho")); 
        
       ArrayList<Produto> lista = ProdutosDAO.buscarTodos();
       System.out.println("Carregando informações");
       ObservableList<Produto> itensTabela = FXCollections.observableArrayList(lista);

       TabelaProduto.setItems(itensTabela); 
  
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          CarregarTabela();
            
          imgRemover.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
          ProdutosDAO dao = new ProdutosDAO();
          Produto produto = TabelaProduto.getSelectionModel().getSelectedItem();
          
          if(produto==null){
            Alert erroAlert = new Alert(Alert.AlertType.ERROR);
            erroAlert.setContentText("Selecione um produto para excluir");
            erroAlert.showAndWait();
          }else{
              dao.apagar( produto.getIDProduto() );
              CarregarTabela();
          }    
          });
            imgEditar.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            ProdutosDAO dao = new ProdutosDAO();
            Produto produto = TabelaProduto.getSelectionModel().getSelectedItem();
            
            if(produto==null){   // se nenhuma informação tiver sido selecionada aparece o codigo dizendo que precisa selecionar algo
                Alert erroAlert = new Alert(Alert.AlertType.ERROR);
                erroAlert.setContentText("Selecione um produto para editar");
                erroAlert.showAndWait();
             }else{
                
                // carregar a página o modal(abre o modal)
                FXMLLoader carregar = new FXMLLoader();
                carregar.setLocation( getClass().getResource("/view/ProdutoModal.fxml") );
                try {
                    carregar.load();
                } catch (IOException ex) {
                    Logger.getLogger(Pagina1Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ProdutoModalController controller = carregar.getController();
                
                controller.getTxtNome().setText( produto.getNome()); //set no formulario
                controller.getTxtCategoria().setText( produto.getCategoria() );
                controller.getTxtQuantidade().setText(Integer.toString((int) produto.getQuantidade()));
                controller.getTxtMarca().setText( produto.getMarca() );
                controller.getTxtTamanho().setText( produto.getTamanho() );
                controller.setAtualizar(Boolean.TRUE); //seta o atualizar em verdadeiro
                controller.setIdProdutos(produto.getIDProduto() ); //pega o id do produto para atualizar um já existente e não fazer do zero
                 
                Parent parent = carregar.getRoot();
                Stage stage = new Stage();
                stage.setScene( new Scene(parent));
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
                
             }
            
        });
        

          imgAtualizar.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
          CarregarTabela();
          Alert a = new Alert(Alert.AlertType.INFORMATION,"A tabela foi atualizada com sucesso", ButtonType.OK);
          a.show();
          });
            
                  }
         
}
                  



