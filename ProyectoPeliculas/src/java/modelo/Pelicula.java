package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modelo.DBConection.getConnection;

public class Pelicula {

    private String nombrePelicula;
    private String director;
    private int añoEstreno;
    private String genero;
    PreparedStatement ps;
    ResultSet rs;
    Connection c = getConnection();

    public Pelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;

    }

    public void consultarDatos(String nombrePelicula) {
        try {
            
            ps = c.prepareStatement("select * from peliculasdisponibles inner join genero on peliculasdisponibles.idGenero=genero.id where nombrePelicula=?");

            ps.setString(1, nombrePelicula);
            rs = ps.executeQuery();
            rs.next();
            director = rs.getString("director");
            añoEstreno = rs.getInt("anoEstreno");
            genero=rs.getString("tipo");
     
        } catch (SQLException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public String getDirector() {
        return director;
    }

    public int getAñoEstreno() {
        return añoEstreno;
    }

    public String getGenero() {
        return genero;
    }

}
