package br.edu.ifsp.pep.util;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class Mensagem {
    public static void sucesso(String titulo, String mensagem) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensagem));
    }
    
    public static void atencao(String titulo, String mensagem) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensagem));
    }
    
    public static void erro(String titulo, String mensagem) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensagem));
    }
}
