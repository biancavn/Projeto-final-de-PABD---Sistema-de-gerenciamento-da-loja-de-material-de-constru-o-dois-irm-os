/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import model.FrotaVeiculos;
import DAO.FrotaVeiculosDAO;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Bianca
 */
public class Pagina2Controller implements Initializable {

    @FXML
    private ImageView ImgAtualizar;

    @FXML
    private ImageView ImgRemover;

    @FXML
    private TableView<FrotaVeiculos> TabelaFrotaVeiculos;

    @FXML
    private TableColumn<?, ?> columnDisponibilidade;

    @FXML
    private TableColumn<?, ?> columnFunção;

    @FXML
    private TableColumn<?, ?> columnID;

    @FXML
    private TableColumn<?, ?> columnMarca;

    @FXML
    private TableColumn<?, ?> columnNome;
    
    @FXML
    private Button btnCadastrar;
    
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoMarca;
    @FXML
    private TextField campoFunção;
    @FXML
    private TextField campoDisponibilidade;
    
    private Integer idFrotaVeiculos;
     
  @FXML
    private Button btEditar;

    /**
     * Initializes the controller class.
     */
   
     

    @FXML
    private void buttomCadastrar(ActionEvent event) {
        String nome = campoNome.getText();
        String marca = campoMarca.getText();
        String função = campoFunção.getText();
        String disponibilidade = campoDisponibilidade.getText();

        FrotaVeiculos veiculo = new FrotaVeiculos(nome, marca, função, disponibilidade);
        veiculo.setIDFrotaVeiculos(idFrotaVeiculos);
        FrotaVeiculosDAO dao = new FrotaVeiculosDAO();
        dao.criar(veiculo);

        limpar();

        atualizarTabela();
        Alert a = new Alert(Alert.AlertType.INFORMATION,"O produto foi cadastrado com sucesso", ButtonType.OK);
          a.show();

    }

    public void atualizarTabela() {

        TabelaFrotaVeiculos.getItems().clear();
        columnID.setCellValueFactory(new PropertyValueFactory<>("IDFrotaVeiculos")); 
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nomeVeiculo"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnFunção.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        columnDisponibilidade.setCellValueFactory(new PropertyValueFactory<>("disponibilidade"));

        ArrayList<FrotaVeiculos> lista = FrotaVeiculosDAO.buscarTodos();

        ObservableList<FrotaVeiculos> itensTabela = FXCollections.observableArrayList(lista);

        TabelaFrotaVeiculos.setItems(itensTabela);

    }

    public void limpar() {
        campoNome.setText("");
        campoMarca.setText("");
        campoFunção.setText("");
        campoDisponibilidade.setText("");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            atualizarTabela();
            
          ImgRemover.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
          FrotaVeiculosDAO dao = new FrotaVeiculosDAO();
          FrotaVeiculos veiculo = TabelaFrotaVeiculos.getSelectionModel().getSelectedItem();
          
          if(veiculo==null){
            Alert erroAlert = new Alert(Alert.AlertType.ERROR);
            erroAlert.setContentText("Selecione um veiculo para excluir");
            erroAlert.showAndWait();
          }else{
              dao.apagar( veiculo.getIDFrotaVeiculos() );
              atualizarTabela();
          }    
          });
            
        ImgAtualizar.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
        String nomeVeiculo = campoNome.getText();
        String marca = campoMarca.getText();
        String funcao = campoFunção.getText();
        String disponibilidade = campoDisponibilidade.getText();


        FrotaVeiculos a = new FrotaVeiculos(nomeVeiculo, marca, funcao, disponibilidade);
        a.setIDFrotaVeiculos(idFrotaVeiculos);

        FrotaVeiculosDAO dao = new FrotaVeiculosDAO();
        dao.atualizar(a);

        limpar();

        atualizarTabela();
          
          Alert c = new Alert(Alert.AlertType.INFORMATION,"A tabela foi atualizada com sucesso", ButtonType.OK);
          c.show();
          });
          
          }
     @FXML
        private void buttomEditar(ActionEvent event) {
        FrotaVeiculos veiculo = TabelaFrotaVeiculos.getSelectionModel().getSelectedItem();
        campoNome.setText(veiculo.getNomeVeiculo());
        campoMarca.setText(veiculo.getMarca());
        campoFunção.setText(veiculo.getFuncao());
        campoDisponibilidade.setText(veiculo.getDisponibilidade());
        

        }
                  }
