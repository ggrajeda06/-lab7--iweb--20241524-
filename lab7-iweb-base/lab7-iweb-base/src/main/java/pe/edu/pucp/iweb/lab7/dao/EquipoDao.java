package pe.edu.pucp.iweb.lab7.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.iweb.lab7.beans.EquipoRed;
import java.sql.*;

public class EquipoDao extends BaseDao{ // TODO 2a: debe heredar de BaseDao

    /**
     * Ejercicio 2c: retorna los equipos de la sede indicada, ordenados por sede y modelo.
     * Si idSede es 0, retorna todos los equipos.
     *
     * Según la columna tipo, cree un objeto EquipoSwitch ('SWITCH') o EquipoAP ('AP').
     * Use PreparedStatement.
     */
    public ArrayList<EquipoRed> listarPorSede(int idSede) {
        ArrayList<EquipoRed> lista = new ArrayList<>();
        // TODO 2c

        String sql = "Select * from EquipoRed e " + "Where e.idSede = ?" + "Order by e.idSede desc";
        try (Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idSede);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    EquipoRed equipoRed = equipoRed.getIdEquipo(rs);
                    lista.add(equipoRed);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
