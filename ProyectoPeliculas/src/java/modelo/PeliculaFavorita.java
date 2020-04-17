/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modelo.DBConection.getConnection;

/**
 *
 * @author Equipo
 */
public class PeliculaFavorita {

    PreparedStatement ps;
    ResultSet rs;
    Connection c = getConnection();
    private String nombrePelicula;
    private String nombreUsuario;
    
    public PeliculaFavorita(String nombrePelicula, String nombreUsuario) {
        this.nombrePelicula = nombrePelicula;
        this.nombreUsuario = nombreUsuario;
    }

    public void insertarPeliFav() {
        try {
            ps = c.prepareStatement("INSERT INTO peliculasfavoritas (nombreUsuario,nombrePelicula) VALUES (?,?)");
            ps.setString(1, nombreUsuario);
            ps.setString(2, nombrePelicula);
            ps.executeUpdate();
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaFavorita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarPelisFav() {

    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

}
