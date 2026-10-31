package pe.edu.pucp.iweb.lab7.dao;

import

import java.sql.*;
import java.util.ArrayList;

import pe.edu.pucp.iweb.lab7.beans.EquipoRed;
import pe.edu.pucp.iweb.lab7.beans.Sede;

public class SedeDao extends BaseDao { // TODO 2a: debe heredar de BaseDao

    /**
     * Ejercicio 2c: retorna todas las sedes ordenadas por nombre.
     */
    public ArrayList<Sede> listar() {
        ArrayList<Sede> lista = new ArrayList<>();

        // TODO 2c
        String sql = "select * from Sede" + "order by nombre desc";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Sede sede = sede.getIdEquipo(rs);
                    lista.add(sede);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    /**
     * Apoyo para el Ejercicio 4: retorna la sede con el id indicado,
     * o null si no existe.
     */
    public Sede buscarPorId(int idSede) {
        // TODO 4
        return null;
    }
}
