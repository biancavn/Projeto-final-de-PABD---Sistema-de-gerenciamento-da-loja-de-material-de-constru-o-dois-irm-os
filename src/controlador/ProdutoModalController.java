/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Produto;
import DAO.ProdutosDAO;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Bianca
 */
public class ProdutoModalController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtTamanho;

    private boolean atualizar; //auxiliar para saber se é para atualizar os valores ou criar um novo(se altera ou não)

    private int idProdutos;//para saber qual deve alterar (qual alterar)
    
    @FXML
    private ImageView btnCadastrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btnCadastrar.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
       String nome = txtNome.getText();
       String categoria = txtCategoria.getText();
       Integer quantidade = Integer.parseInt(txtQuantidade.getText());
       String marca =txtMarca.getText();
       String tamanho =txtTamanho.getText();
       
       Produto produto = new Produto(nome, categoria, quantidade, marca, tamanho);
       produto.setNome(nome);
       produto.setCategoria(categoria);
       produto.setQuantidade(quantidade);
       produto.setMarca(marca);
       produto.setTamanho(tamanho);
       
       ProdutosDAO  dao = new ProdutosDAO();
      if(atualizar){
            produto.setIDProduto(idProdutos);
            dao.atualizar(produto);
   
          Alert b = new Alert(Alert.AlertType.INFORMATION,"A tabela foi atualizada com sucesso. Para visualizar as alterações na tabela pressione o botão atualizar", ButtonType.OK);
          b.show();
        }else{
       dao.criar(produto);
       Alert a = new Alert(Alert.AlertType.CONFIRMATION,"O novo produto foi cadastrado com sucesso. Para visualizar as novas informações na tabela pressione o botão atualizar", ButtonType.OK);
       a.show();
        }
        
       fecharModal();
        
        });
    }    
        public void fecharModal(){
        Stage stage=(Stage) btnCadastrar.getScene().getWindow();
        stage.close();
    }

    public TextField getTxtCategoria() {
        return txtCategoria;
    }

    public void setTxtCategoria(TextField txtCategoria) {
        this.txtCategoria = txtCategoria;
    }

    public TextField getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(TextField txtMarca) {
        this.txtMarca = txtMarca;
    }

    public TextField getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(TextField txtNome) {
        this.txtNome = txtNome;
    }

    public TextField getTxtQuantidade() {
        return txtQuantidade;
    }

    public void setTxtQuantidade(TextField txtQuantidade) {
        this.txtQuantidade = txtQuantidade;
    }

    public TextField getTxtTamanho() {
        return txtTamanho;
    }

    public void setTxtTamanho(TextField txtTamanho) {
        this.txtTamanho = txtTamanho;
    }

    public boolean getAtualizar() {
        return atualizar;
    }

    public void setAtualizar(boolean atualizar) {
        this.atualizar = atualizar;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }
        
  
}
