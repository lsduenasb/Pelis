package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modelo.DBConection.getConnection;

public class Persona {

    PreparedStatement ps;
    ResultSet rs;
    Connection c = getConnection();
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private int edad;
    private String contrasena;
    private String correo;

    //Registro
    public Persona(String nombreUsuario, String contrasena, String nombre, String apellido, int edad, String correo) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
    }

    //Iniciar Sesion
    public Persona(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public boolean registro(String nombreUsuario, String contrasena, String nombre, String apellido, int edad, String correo) {
        boolean decide = false;
        try {
            ps = c.prepareStatement("SELECT nombreUsuario FROM usuario WHERE nombreUsuario=?");
            ps.setString(1, nombreUsuario);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                //ya estaria creado el usuario en la BD 
                decide = false;
            } else {
                try {
                    //no esta creado, entonces lo registra en la BD
                    ps = c.prepareStatement("INSERT INTO usuario(nombreUsuario, contrasena, nombre, apellido,edad,correo) VALUES(?,?,?,?,?,?)");
                    ps.setString(1, nombreUsuario);
                    ps.setString(2, contrasena);
                    ps.setString(3, nombre);
                    ps.setString(4, apellido);
                    ps.setInt(5, edad);
                    ps.setString(6, correo);
                    ps.executeUpdate();
                    c.close();
                    decide = true;

                } catch (SQLException ex) {
                    //  Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        } catch (SQLException ex) {
            //   Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decide;
    }
    

    public void login(String nombreUsuario, String contrasena) {

        try {
            ps = c.prepareStatement("SELECT nombreUsuario, contrasena FROM usuario where nombreUsuario=? and contrasena=?");
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            if (rs.next()) {
                //Dejar al usuario iniciar sesion
            } else {
                //Usuario y contraseña incorrectos en otra vista
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

}
