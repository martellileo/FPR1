    package br.edu.ifsp.pep.controller;

    import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entidade.NivelUsuario;
    import br.edu.ifsp.pep.entidade.Pessoa;
    import br.edu.ifsp.pep.util.Mensagem;
    import jakarta.enterprise.context.SessionScoped;
    import jakarta.inject.Inject;
    import jakarta.inject.Named;
    import java.io.Serializable;

    @Named
    @SessionScoped
    public class LoginController implements Serializable {

        private Pessoa pessoaLogada = null;
        private int nivelAcesso = 0;

        private String login;
        private String password;

        @Inject
        private PessoaDAO pessoaDAO;

        @Inject
        private PessoaController pessoaController;

        public boolean verificarNivel() {
        if (pessoaLogada != null) {
            if (pessoaLogada.getNivelUsuario().equals(NivelUsuario.Gerente)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

        public String realizarLogin() {

            System.out.println("Buscando login no db");

            this.pessoaLogada = this.pessoaDAO.realizarLogin(login, password);
            login = "";
            password = "";

            if (pessoaLogada != null) {
                System.out.println(pessoaLogada);
                Mensagem.sucesso("Login realizado com sucesso");
                return "/index.xhtml";
            } else {
                Mensagem.erro("Login ou senha incorretos");
                return null;
            }
        }

        public String realizarLogout() {
            this.pessoaLogada = null;
            Mensagem.sucesso("Logout realizado com sucesso!");
            return "/index.xhtml";
        }

        public boolean isLogado() {
            return this.pessoaLogada != null;
        }

        public LoginController() {
            System.out.println("Constructor Login Controller");
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Pessoa getPessoaLogada() {
            return pessoaLogada;
        }

        public int getNivelAcesso() {
            return nivelAcesso;
        }

        public void setNivelAcesso(int nivelAcesso) {
            this.nivelAcesso = nivelAcesso;
        }

    }
