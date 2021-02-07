package sample;

import DAO.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modelo.Registro;

public class Controller {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEmail;
    @FXML
    private void onClick(ActionEvent event){
        try {
            Registro user = new Registro(txtNombre.getText(), txtApellido.getText(), txtEmail.getText());
                 UsuarioDAO insertar = new UsuarioDAO();
                 insertar.insertarRegistro(user);//lista.add(user1)

        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
        }
    }
}

