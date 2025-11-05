package br.edu.ifsp.pep.util;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

/**
 *
 * @author aluno
 */
public class Mensagem {
    
    private static void addMessage(FacesMessage.Severity severity, String mensagem) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, "", mensagem));
    }

    public static void sucesso(String mensagem) {
        addMessage(FacesMessage.SEVERITY_INFO, mensagem);
    }
    public static void atencao(String mensagem) {
        addMessage(FacesMessage.SEVERITY_WARN, mensagem);
    }
    public static void erro(String mensagem) {
        addMessage(FacesMessage.SEVERITY_ERROR, mensagem);
    }
}
