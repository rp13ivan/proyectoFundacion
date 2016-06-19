package conexionBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Empresa;

public class Conexion {
	private Connection cnn; // Concxion la bd
	private Statement state; // ejecutar una query
	private ResultSet res; // guardar el resultado de un select

	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // driver de conexion
			cnn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/fundacion1?zeroDateTimeBehavior=convertToNull",
							"root", ""); // url (utilzando JDBC en este caso),
											// usuario, password
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	  public int guardarEmpresa(Empresa empresa) {
	        int conf = 0;
	        String query = "INSERT INTO EMPRESA(EMP_RUC,EMP_NOMBRE,EMP_ACTIVIDAD,EMP_GERENTE_GENERAL) values(" + empresa.getRuc() + ",'"
	                + empresa.getNombre() + "','" + empresa.getActividad()+ "','" + empresa.getGerenteGeneral() + "')";

	        try {
	            state = cnn.createStatement();
	            conf = state.executeUpdate(query);
	        } catch (SQLException e) {
				e.printStackTrace();
			}
	        return conf;
	    }

	public ResultSet consultarListaEmpresa() {
		try {
			String query = "SELECT * FROM EMPRESA";

			state = cnn.createStatement();
			res = state.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	public ResultSet consultarEmpresa(String valor){
		 try {
	            String query = "SELECT * FROM EMPRESA WHERE EMP_NOMBRE LIKE'%" + valor + "%' ORDER BY EMP_NOMBRE ASC";

	            state = cnn.createStatement();
	            res = state.executeQuery(query);

	        } catch (SQLException e) {
	           e.printStackTrace();
	        }
	        return res;
	}
	
	
	public int modificarEmpresa(Empresa empresa) {
        int conf = 0;
        String query = "UPDATE EMPRESA SET EMP_NOMBRE='"
                + empresa.getNombre() + "', EMP_ACTIVIDAD='"
                + empresa.getActividad() + "', EMP_GERENTE_GENERAL='"
                + empresa.getGerenteGeneral() + "' , EMP_GERENTE_RR_HH='"
                + empresa.getGereneRh() + "' WHERE EMP_ID="
                + empresa.getId()+ "";

        try {
            state = cnn.createStatement();
            conf = state.executeUpdate(query);
        } catch (SQLException e) {
			e.printStackTrace();
		}
        return conf;
    }
}
