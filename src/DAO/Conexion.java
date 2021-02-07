package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Connection connectToDB() {
        Connection connection = null;
        try {
            //Class.forName("org.postgresql.Driver");//localhost
            //connection = DriverManager.getConnection("jdbc:postgresql://engicoders:5432/dbusuario","postgres", "postgres");
            // Por favor conectate a la otra base de datos *****ojo
            connection = DriverManager.getConnection("jdbc:postgresql://ec2-52-71-107-99.compute-1.amazonaws.com:5432/dio77eergg5th","ykkqanqrlayhjx", "b6adeeaa8f9580c84387d0030439fdebdb06519a64bc073aa7b0903107d14fdf");
            if (connection != null) {
                System.out.println("Se estableció la conexión :)");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al conectar a la base.");
            e.printStackTrace();
        }finally {
            return connection;
        }

    }


}