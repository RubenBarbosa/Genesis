/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.controller;

import com.genesis.modelo.entities.Rol;
import com.genesis.modelo.entities.Rolusuario;
import com.genesis.modelo.entities.Usuario;
import com.genesis.modelo.facade.UsuarioFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author ismael
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

    @EJB
    private UsuarioFacade ufl;

    private Long documento;
    private String clave;
    private Integer rol;

    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public String action() {
        
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        FacesMessage msj = new FacesMessage();
        String url = "";
        if (documento != null && documento != 0
                && clave != null && !clave.equals("")) {
            Usuario u = ufl.login(documento, clave);
            if (u != null) {

                List<Rolusuario> roles = u.getRolusuarioList();

                for (Rolusuario role : roles) {
                    if (role.getIdRol()!= null) {
                        rol = role.getIdRol().getIdRol();

                    }
                }

                switch (rol) {
                    case 1:
                        ec.getSessionMap().put("user", u);
                        url = "app/administrador/inicioadministrador.xhtml?faces-redirect=true";
                        break;
                    case 2:
                        ec.getSessionMap().put("user", u);
                        url = "/app/capitan/iniciocapitan.xhtml?faces-redirect=true";
                        break;
                    case 3:
                        ec.getSessionMap().put("user", u);
                        url = "/app/cajero/iniciocajero.xhtml?faces-redirect=true";
                        break;
                    default:
                        url="";

                }

            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos incorrectos", "Compruebe sus datos de acceso.");
            }
        } else {
            msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos incompletos", "Debe diligenciar todos los campos.");
        }

        fc.addMessage(null, msj);
        return url;
    }

    public Usuario getUsuarioSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        return (Usuario) ec.getSessionMap().get("user");
    }

    public void validarSesion() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            if (getUsuarioSesion() == null) {
                ec.redirect(ec.getRequestContextPath() + "/login.xhtml");

            }
        } catch (IOException ex) {
            Logger.getLogger(SessionController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String cerrarSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.invalidateSession();
        documento = null;
        clave = "";
        return "";
    }

    public void actionListener() {

    }


//IDIOMAS IDIOMAS IDIOMAS

 

    private Locale languageSelected;
    
    /**
     * Creates a new instance of SessionController
     */

    
    @PostConstruct
    public void init(){
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        Locale idiomaUsuario = ec.getRequestLocale();
        boolean support = false;
        for (Locale l : getSupportLanguages()) {
            if(l.getLanguage().equals(idiomaUsuario.getLanguage())){
                support = true; break;
            }
        }
        languageSelected = (support) ? idiomaUsuario: new Locale("es");
        
    }

    public Locale getLanguageSelected() {
        return languageSelected;
    }

    public void setLanguageSelected(Locale languageSelected) {
        this.languageSelected = languageSelected;
    }
    
    public List<Locale> getSupportLanguages(){
        List<Locale> idiomas = new ArrayList<>();
        Iterator<Locale> it = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
        while(it.hasNext()){
            idiomas.add(it.next());
        }
        return idiomas;
    }
    
    public String cambiarIdioma(Locale idioma){
        if(idioma != null){
            this.languageSelected = idioma;
            FacesContext.getCurrentInstance().getViewRoot().setLocale(languageSelected);
        }
        return "";
    }
    
}

