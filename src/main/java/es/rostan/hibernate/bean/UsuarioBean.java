package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.usuarioDAO;
import es.rostan.hibernate.entidades.usuario;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 * Created by Rostan on 21/05/2017.
 */
@ManagedBean
public class UsuarioBean {

    private usuario usuario = new usuario();

//    METODOS
    public String login(){
        String res = "";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean flag = false;

        usuarioDAO usuarioDAO = new usuarioDAO();
        if (usuarioDAO.validaUsuario(this.usuario)  != null) {
            flag = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", usuario.getId());

            HttpSession session = Util.getSession();
            session.setAttribute("username", usuario.getId());

            res=  "home?faces-redirect=true";
        } else {
            flag = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales inválidas.");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", flag);

        return res;
    }

    public String logout(){
        HttpSession session = Util.getSession();
        session.invalidate();
        return "index.xhtml?faces-redirect=true";
    }

//    GETTER Y SETTER
    public es.rostan.hibernate.entidades.usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(es.rostan.hibernate.entidades.usuario usuario) {
        this.usuario = usuario;
    }
}
