package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.ProjetoDAO;
import br.edu.ifsp.pep.entidade.Projeto;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Projeto.class)
public class ProjetoConverter implements Converter<Projeto> {

    @Override
    public Projeto getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        //Obtem o DAO
        ProjetoDAO projetoDAO = CDI.current().select(ProjetoDAO.class).get();

        //Busca no BD
        return projetoDAO.buscarPorCodigo(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Projeto projeto) {
        return projeto == null ? null : projeto.getCodigo().toString();
    }

}
