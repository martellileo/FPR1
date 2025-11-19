package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.LoginController;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;
import java.io.IOException;

public class ControleAcessoListener implements PhaseListener {

    @Inject
    private LoginController loginController;

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    private void redirecionar(FacesContext ctx, String pagina) {
        try {
            //Get nome do projeto
            String projeto = ctx.getExternalContext()
                    .getRequestContextPath();

            //Encaminhar/Redirecionar
            ctx.getExternalContext().redirect(projeto + pagina);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("Antes da fase: " + event.getPhaseId());
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("Depois da fase: " + event.getPhaseId());

        FacesContext ctx = event.getFacesContext();
        String pagina = ctx.getViewRoot().getViewId();
        System.out.println("Pagina: " + pagina);

        // /index.xhtml -> publica
        // /manutencao/lista.xhtml -> privada
        if (pagina.equals("/manutencao/lista.xhtml")
                || pagina.equals("/pessoa/cadastro.xhtml")) {
            System.out.println("Entrou na verificação");
            
            if (loginController.getPessoaLogada() == null) {
                System.out.println("Pessoa nao autenticada");
                redirecionar(ctx, "/login.xhtml");
            }
        }
    }

}
