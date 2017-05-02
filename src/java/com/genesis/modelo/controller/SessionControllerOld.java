/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.controller;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Ismael
 */
@Named(value = "sessionControllerOld")
@RequestScoped
public class SessionControllerOld implements Serializable{

    private Locale languageSelected;
    
    /**
     * Creates a new instance of SessionController
     */
    public SessionControllerOld() {
    }
    
    @PostConstruct
    public void init(){
        languageSelected = new Locale("es");
    }

    public Locale getLanguageSelected() {
        return languageSelected;
    }

    public void setLanguageSelected(Locale languageSelected) {
        this.languageSelected = languageSelected;
    }
    
    public String cambiarIdioma(String idioma){
        if(idioma != null && (idioma.equals("es") || idioma.equals("en") )){
            this.languageSelected = new Locale(idioma);
        }
        return "";
    }
    
}
