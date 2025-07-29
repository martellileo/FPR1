package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.LoginController;
import br.edu.ifsp.pep.entity.NivelAcesso;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;
import java.io.IOException;

/**
 *
 * @author aluno
 */
public class LifeCycleListener implements PhaseListener {

    @Inject
    private LoginController loginController;

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext ctx = event.getFacesContext();
        String pagina = ctx.getViewRoot().getViewId();
        System.out.println("Pagina " + pagina);

//        if(pagina.equals("/pessoa/ListPessoa.xhtml")){
//            if(loginController.getPessoaAutenticada() == null){
//                // redirecionar para pagina de erro ou login
//                redirecionar(ctx, "/erro.xhtml");
//            }
//        }

        // COMUM
        if (pagina.equals("/comum.xhtml")) {
            if (loginController.getPessoaAutenticada() == null) {
                redirecionar(ctx, "/erro.xhtml");
            } else {
                if (loginController.getPessoaAutenticada().getNivelAcesso() != NivelAcesso.Comum
                        && loginController.getPessoaAutenticada().getNivelAcesso() != NivelAcesso.Administrador) {
                    redirecionar(ctx, "/erro.xhtml");
                }
            }
        }
        
        // FINANCEIRO CREATE
        if(pagina.equals("/financeiro/create.xhtml")){
            if(loginController.getPessoaAutenticada() == null){
                redirecionar(ctx, "/erro.xhtml");
            } else {
                if(loginController.getPessoaAutenticada().getNivelAcesso() != NivelAcesso.Administrador){
                    redirecionar(ctx, "/erro.xhtml");
                }
            }
        }
        
        // FINANCEIRO LIST
        if(pagina.equals("/financeiro/list.xhtml")){
            if(loginController.getPessoaAutenticada() == null){
                redirecionar(ctx, "/erro.xhtml");
            } else {
                if(loginController.getPessoaAutenticada().getNivelAcesso() != NivelAcesso.Administrador
                        && loginController.getPessoaAutenticada().getNivelAcesso() != NivelAcesso.Financeiro){
                    redirecionar(ctx, "/erro.xhtml");
                }
            }
        }
        
        // PESSOA
        if(pagina.equals("/pessoa/ListPessoa.xhtml")){
            if(loginController.getPessoaAutenticada() == null){
                redirecionar(ctx, "/login/login.xhtml");
            } else {
                if(loginController.getPessoaAutenticada().getNivelAcesso() != NivelAcesso.Administrador){
                    redirecionar(ctx, "/erro.xhtml");
                }
            }
        }
        
        // VEICULO
        if(pagina.equals("/veiculo/ListVeiculo.xhtml")){
            if(loginController.getPessoaAutenticada() == null){
                redirecionar(ctx, "/login/login.xhtml");
            } else {
                if(loginController.getPessoaAutenticada().getNivelAcesso() != NivelAcesso.Administrador){
                    redirecionar(ctx, "/erro.xhtml");
                }
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
//        System.out.println("Antes da fase " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    private void redirecionar(FacesContext ctx, String pagina) {
        try {
            // nome do projeto
            String projeto = ctx.getExternalContext().getRequestContextPath();

            // encaminhar/redirecionar
            ctx.getExternalContext().redirect(projeto + pagina);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
