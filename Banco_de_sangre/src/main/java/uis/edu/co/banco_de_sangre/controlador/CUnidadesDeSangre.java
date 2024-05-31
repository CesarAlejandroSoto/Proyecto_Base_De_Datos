
package uis.edu.co.banco_de_sangre.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uis.edu.co.banco_de_sangre.modelo.UnidadesDeSangre;

public class CUnidadesDeSangre {
    public UnidadesDeSangre consultarUnidadDeSangrePorId(int idUnidad) {
    try {
        // Crear una sentencia SQL parametrizada para seleccionar una unidad de sangre por su ID
        String sql = "SELECT * FROM unidades_de_sangre WHERE id_unidades_sangre = ?";
        
        // Preparar la sentencia
        PreparedStatement statement = Conexion.getConect().prepareStatement(sql);
        statement.setInt(1, idUnidad); // Establecer el ID de la unidad como parámetro
        
        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();
        
        // Verificar si se encontró un resultado
        if (resultSet.next()) {
            // Si se encontró un resultado, crear un objeto UnidadDeSangre con la información recuperada de la base de datos
            int id = resultSet.getInt("id_unidades_sangre");
            int donacion = resultSet.getInt("donacion");
            int tipoComponenteId = resultSet.getInt("tipo_componente_sanguineo_id");
            int estadoId = resultSet.getInt("estado_unidades_id");
            String fechaProcesamiento = resultSet.getString("fecha_procesamiento");
            
            // Crear y devolver el objeto UnidadDeSangre
            return new UnidadesDeSangre(id, donacion, tipoComponenteId, estadoId, fechaProcesamiento);
        } else {
            // Si no se encontró ningún resultado, devolver null
            return null;
        }
    } catch (SQLException ex) {
        Logger.getLogger(CUnidadesDeSangre.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al consultar la unidad de sangre por ID: " + ex.getMessage());
        return null;
    }
}
public void cargarUnidadEnTabla(JTable tabla, UnidadesDeSangre unidad) {
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

    // Agregar los títulos de las columnas
    modelo.setColumnIdentifiers(new Object[]{"ID de la Unidad", "Donación", "Tipo Componente", "Estado", "Fecha Procesamiento"});

    if (unidad != null) {
        // Obtener los datos de la unidad de sangre
        int id = unidad.getIdUnidadesSangre();
        int donacion = unidad.getDonacion();
        String tipoComponente = obtenerTipoComponenteSanguineo(unidad.getTipoComponenteSanguineoId());
        String estado = obtenerEstadoUnidades(unidad.getEstadoUnidadesId());
        String fechaProcesamiento = unidad.getFechaProcesamiento();

        // Agregar una fila con los datos obtenidos
        modelo.addRow(new Object[]{id, donacion, tipoComponente, estado, fechaProcesamiento});
    }
}

public String obtenerTipoComponenteSanguineo(int tipoComponenteId) {
    try {
        // Crear una sentencia SQL parametrizada para obtener el nombre del tipo de componente sanguíneo por su ID
        String sql = "SELECT nombre_tipo_componente FROM tipo_componente_sanguineo WHERE id_tipo_componente = ?";
        
        // Preparar la sentencia
        PreparedStatement statement = Conexion.getConect().prepareStatement(sql);
        statement.setInt(1, tipoComponenteId); // Establecer el ID del tipo de componente como parámetro
        
        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();
        
        // Verificar si se encontró un resultado
        if (resultSet.next()) {
            // Si se encontró un resultado, obtener el nombre del tipo de componente
            return resultSet.getString("nombre_tipo_componente");
        } else {
            // Si no se encontró ningún resultado, devolver un mensaje indicando que no se encontró el tipo de componente
            return "Tipo de componente no encontrado";
        }
    } catch (SQLException ex) {
        Logger.getLogger(CUnidadesDeSangre.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al obtener el tipo de componente sanguíneo: " + ex.getMessage());
        return null;
    }
}

public String obtenerEstadoUnidades(int estadoId) {
    try {
        // Crear una sentencia SQL parametrizada para obtener el estado de las unidades por su ID
        String sql = "SELECT estado FROM estado_unidades WHERE id_estado_unidades = ?";
        
        // Preparar la sentencia
        PreparedStatement statement = Conexion.getConect().prepareStatement(sql);
        statement.setInt(1, estadoId); // Establecer el ID del estado como parámetro
        
        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();
        
        // Verificar si se encontró un resultado
        if (resultSet.next()) {
            // Si se encontró un resultado, obtener el estado de las unidades
            return resultSet.getString("estado");
        } else {
            // Si no se encontró ningún resultado, devolver un mensaje indicando que no se encontró el estado de las unidades
            return "Estado de unidades no encontrado";
        }
    } catch (SQLException ex) {
        Logger.getLogger(CUnidadesDeSangre.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al obtener el estado de las unidades: " + ex.getMessage());
        return null;
    }
}

  // Método para registrar una nueva unidad de sangre
    public boolean registrarUnidadDeSangre(UnidadesDeSangre unidad) {
        try {
            Connection connection = Conexion.getConect();
            String sql = "INSERT INTO unidades_de_sangre (donacion, tipo_componente_sanguineo_id, estado_unidades_id, fecha_procesamiento) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, unidad.getDonacion());
            statement.setInt(2, unidad.getTipoComponenteSanguineoId());
            statement.setInt(3, unidad.getEstadoUnidadesId());
            statement.setString(4, unidad.getFechaProcesamiento());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar la unidad de sangre: " + ex.getMessage());
            return false;
        }
    }

    // Método para cargar todas las unidades de sangre en la tabla
 // Método para cargar todas las unidades de sangre en la tabla
public void cargarTodasLasUnidadesEnTabla(JTable tblUnidades) {
    try {
        Connection connection = Conexion.getConect();
        String sql = "SELECT us.id_unidades_sangre, d.nombre, d.apellido, tcs.nombre_tipo_componente, eu.estado, us.fecha_procesamiento " +
                     "FROM unidades_de_sangre us " +
                     "JOIN donantes d ON us.donacion = d.id_donante " +
                     "JOIN tipo_componente_sanguineo tcs ON us.tipo_componente_sanguineo_id = tcs.id_tipo_componente " +
                     "JOIN estado_unidades eu ON us.estado_unidades_id = eu.id_estado_unidades " +
                     "ORDER BY us.id_unidades_sangre"; // Ordenar por ID de unidades de sangre
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        DefaultTableModel modelo = (DefaultTableModel) tblUnidades.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        while (resultSet.next()) {
            int id = resultSet.getInt("id_unidades_sangre");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String tipoComponente = resultSet.getString("nombre_tipo_componente");
            String estado = resultSet.getString("estado");
            String fechaProcesamiento = resultSet.getString("fecha_procesamiento");

            modelo.addRow(new Object[]{id, nombre, apellido, tipoComponente, estado, fechaProcesamiento});
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar las unidades de sangre: " + ex.getMessage());
    }
}

    
    // En tu clase de controlador CUnidadesDeSangre

public boolean eliminarUnidadDeSangre(int idUnidad) {
    try {
        // Crear una sentencia SQL parametrizada para eliminar una unidad de sangre por su ID
        String sql = "DELETE FROM unidades_de_sangre WHERE id_unidades_sangre = ?";
        
        // Preparar la sentencia
        PreparedStatement statement = Conexion.getConect().prepareStatement(sql);
        statement.setInt(1, idUnidad); // Establecer el ID de la unidad como parámetro
        
        // Ejecutar la sentencia
        int rowsDeleted = statement.executeUpdate();
        
        // Verificar si se eliminó correctamente la unidad de sangre
        if (rowsDeleted > 0) {
            // Si se eliminó correctamente, cargar nuevamente todas las unidades en la tabla
            
            return true;
        } else {
            return false;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar la unidad de sangre: " + ex.getMessage());
        return false;
    }
}

}

