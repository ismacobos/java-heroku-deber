package DAO;

import modelo.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsuarioDAO extends Conexion {

    public ArrayList<Registro> listar() {
        ArrayList<Registro> usuarios = new ArrayList();

        try (Connection connection = connectToDB()) {
            String query = "SELECT * FROM registro"; //sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Registro user = new Registro(
                        Integer.valueOf(rs.getString("id")),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email")
                );
                usuarios.add(user);
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            // TODO: handle exception
        }
        return usuarios;
    }
    //Guardar un nuevo usuario
    public void insertarRegistro(Registro usuario) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "insert into registro (nombre, apellido,email) values (?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Actualizar  un usuario
    public void actualizarRegistro (Registro usuario) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "update registro set nombre = ?, apellido = ?, email = ? where id =?"; //ojo no olvidarsse del where
            ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4,  usuario.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error:"+e.getMessage() );
            //estos errores guardar ennun archivo
        }
    }
    //Eliminar  un usuario
    public void eliminarRegistro (int id) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "delete from usuario where uid =? ";///ojo con el where
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
