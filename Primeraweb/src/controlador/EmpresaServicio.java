package controlador;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Empresa;
import conexionBase.Conexion;

public class EmpresaServicio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public EmpresaServicio(){}
	
	
	
	
	public List<Empresa> guardarEmpresa(Empresa empresa) {
        Conexion cn = new Conexion();

        int confirma = cn.guardarEmpresa(empresa);

        if (confirma != 1) {
            System.out.println("guardarEmpresa: Error Datos");
        } else {
            List<Empresa> almacenEditado = new ArrayList<Empresa>();
            ResultSet res = cn.consultarListaEmpresa();
            try {
                while (res.next()) {
                    almacenEditado.add(new Empresa(res.getInt("EMP_ID"),res.getInt("EMP_RUC"),
                            res.getString("EMP_NOMBRE"), res.getString("EMP_ACTIVIDAD"),
                            res.getString("EMP_GERENTE_GENERAL"),res.getString("EMP_GERENTE_RR_HH"),res.getString("EMP_DIRECCION"),
							res.getInt("EMP_TELEFONO"), res.getString("EMP_EMAIL"),res.getString("EMP_RESPONSABLE_FACTURACION")
							));
                }


            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return almacenEditado;
        }
        return null;

    }
	
	public List<Empresa> editarEmpresa(Empresa empresa) {
        Conexion cn = new Conexion();

        int confirma = cn.modificarEmpresa(empresa);

        if (confirma != 1) {
            System.out.println("editarEmpresa: Error no guardado");
        } else {
            List<Empresa> empresaEditada = new ArrayList<Empresa>();
            ResultSet res = cn.consultarListaEmpresa();
            try {
            	while(res.next()){
            		empresaEditada.add(new Empresa(res.getInt("EMP_ID"),res.getInt("EMP_RUC"), res.getString("EMP_NOMBRE"), res.getString("EMP_ACTIVIDAD"),
							res.getString("EMP_GERENTE_GENERAL"), res.getString("EMP_GERENTE_RR_HH"),res.getString("EMP_DIRECCION"),
							res.getInt("EMP_TELEFONO"), res.getString("EMP_EMAIL"),res.getString("EMP_RESPONSABLE_FACTURACION")
							));
				}

            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
            return empresaEditada;
        }
        return null;

    }
	
	
	
	

	public List<Empresa> obtenerListaEmpresa(){
		Conexion cn = new Conexion();
		
		ResultSet res = cn.consultarListaEmpresa();
		List<Empresa> empresaAll = new ArrayList<Empresa>();
		
		if(res == null){
			System.out.println("no hay datos");
			
		}else{
			try {
				while(res.next()){
					empresaAll.add(new Empresa(res.getInt("EMP_ID"),res.getInt("EMP_RUC"), res.getString("EMP_NOMBRE"), res.getString("EMP_ACTIVIDAD"),
							res.getString("EMP_GERENTE_GENERAL"), res.getString("EMP_GERENTE_RR_HH"),res.getString("EMP_DIRECCION"),
							res.getInt("EMP_TELEFONO"), res.getString("EMP_EMAIL"),res.getString("EMP_RESPONSABLE_FACTURACION")
							));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return empresaAll;
		
	}
	
	public List<Empresa> obtenerEmpresa(String valorBusqueda){
		Conexion cn = new Conexion();
		ResultSet res = cn.consultarEmpresa(valorBusqueda);
		List<Empresa> empresaAll = new ArrayList<Empresa>();
		try {
			while(res.next()){
				empresaAll.add(new Empresa(res.getInt("EMP_ID"),res.getInt("EMP_RUC"), res.getString("EMP_NOMBRE"), res.getString("EMP_ACTIVIDAD"),
						res.getString("EMP_GERENTE_GENERAL"), res.getString("EMP_GERENTE_RR_HH"),res.getString("EMP_DIRECCION"),
						res.getInt("EMP_TELEFONO"), res.getString("EMP_EMAIL"),res.getString("EMP_RESPONSABLE_FACTURACION")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empresaAll;
		
	}
}

