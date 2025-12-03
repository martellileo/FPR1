package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.DesenvolvedorDAO;
import br.edu.ifsp.pep.entidade.Desenvolvedor;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Desenvolvedor.class)
public class DesenvolvedorConverter implements Converter<Desenvolvedor> {

    @Override
    public Desenvolvedor getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        //Obtem o DAO
        DesenvolvedorDAO desenvolvedorDAO = CDI.current().select(DesenvolvedorDAO.class).get();

        //Busca no BD
        return desenvolvedorDAO.buscarPorCodigo(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Desenvolvedor desenvolvedor) {
        return desenvolvedor == null ? null : desenvolvedor.getCodigo().toString();
    }

}
