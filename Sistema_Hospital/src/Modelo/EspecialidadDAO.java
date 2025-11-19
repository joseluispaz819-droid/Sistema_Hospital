/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import java.sql.*;
import java.util.*;

/**
 *
 * @author USUARIO
 */
public class EspecialidadDAO {
     Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean agregar(Especialidad esp) {
        String sql = "INSERT INTO med_especialidades (med_esp_nombre, med_esp_descripcion ) VALUES (?, ?, ?)";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, esp.getMed_esp_nombre());
            ps.setString(2, esp.getMed_esp_descripcion());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e);
            return false;
             }
    }

    public List<Especialidad> listar() {
        List<Especialidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM med_especialidades";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidad esp = new Especialidad();
                esp.setMed_esp_id(rs.getInt("id"));
               esp.setMed_esp_nombre(rs.getString("nombre"));
                esp.setMed_esp_descripcion(rs.getString("descricion"));
                lista.add(esp);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e);
        }
        return lista;
  }

    public boolean actualizar(Especialidad esp) {
        String sql = "UPDATE med_especialidades SET med_esp_nombre=?, med_esp_descripcion=?, WHERE id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, esp.getMed_esp_nombre());
            ps.setString(2, esp.getMed_esp_descripcion());
            ps.setInt(3, esp.getMed_esp_id());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e);
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM med_especialidades WHERE id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e);
            return false;
        }
    }
    
}
