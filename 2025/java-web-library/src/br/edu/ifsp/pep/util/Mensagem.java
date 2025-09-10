/*
 */
package br.edu.ifsp.pep.util;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class Mensagem {

    public static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    // Mensagem.sucesso("mensagem", "detail")
    public static void sucesso(String mensagem, String detail){
        addMessage(FacesMessage.SEVERITY_INFO, mensagem, detail);
    }
    
    // Mensagem.warning("mensagem", "detail")
    public static void warning(String mensagem, String detail){
        addMessage(FacesMessage.SEVERITY_WARN, mensagem, detail);
    }
    
    // Mensagem.erro("mensagem", "detail")
    public static void erro(String mensagem, String detail){
        addMessage(FacesMessage.SEVERITY_ERROR, mensagem, detail);
    }
}
