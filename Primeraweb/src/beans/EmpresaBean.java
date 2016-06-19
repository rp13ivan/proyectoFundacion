package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Empresa;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import controlador.EmpresaServicio;

@ManagedBean
/* clase transformado en Bean */
@ViewScoped
/* alcance de las variables */
public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private EmpresaServicio empresaServicio = new EmpresaServicio();
	private List<Empresa> listaEmpresa;
	private String valorBusqueda;
	private Empresa empresaSeleccionada;
	private Empresa empresaModal;

	public EmpresaBean() {
	}

	public Empresa getEmpresaModal() {
		return empresaModal;
	}

	public void setEmpresaModal(Empresa empresaModal) {
		this.empresaModal = empresaModal;
	}

	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}

	public String getValorBusqueda() {
		return valorBusqueda;
	}

	public void setValorBusqueda(String valorBusqueda) {
		this.valorBusqueda = valorBusqueda;
	}

	public EmpresaServicio getEmpresaServicio() {
		return empresaServicio;
	}

	public void setEmpresaServicio(EmpresaServicio empresaServicio) {
		this.empresaServicio = empresaServicio;
	}

	public List<Empresa> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

	@PostConstruct
	public void inicializar() {
		this.listaEmpresa = empresaServicio.obtenerListaEmpresa();

	}

	public void busquedaEmpresa() {
		this.listaEmpresa = this.empresaServicio
				.obtenerEmpresa(this.valorBusqueda);

		String mensaje = (this.listaEmpresa.size() > 0) ? "Información Encontrada"
				: "Información no Encontrada";
		addMessage(mensaje);
	}

	public void onRowSelect(SelectEvent event) {
		System.out.println("Seleccion Row Edit");
		this.empresaModal = this.empresaSeleccionada;

	}

	public void onRowUnselect(UnselectEvent event) {
		System.out.println("Seleccion Row Not ");
		
	}

	public void botonAgregar() {
		this.empresaModal = new Empresa();

	}
	/*hola mundo*/
	public void botonAceptar(){
        String mensaje = "";
        if(this.empresaModal.getId() > 0){
             this.listaEmpresa = this.empresaServicio.editarEmpresa(this.empresaModal);
             mensaje = "Información Editada";
        }else{
            this.listaEmpresa = this.empresaServicio.guardarEmpresa(this.empresaModal);
            mensaje = "Información Guardada";
            
        }
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').hide()");
        addMessage(mensaje);
        
    }
    
	public void botonCerrar(){
        System.out.println("Modal Cerrada");
    }

	public void botonEditar() {
		this.empresaModal = this.empresaSeleccionada;
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
