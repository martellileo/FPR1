/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {
    @EmbeddedId
    private TelefoneId telefoneId;
    
    @Column(name = "contato", length = 40)
    private String contato;

    public TelefoneId getTelefoneId() {
        return telefoneId;
    }

    public void setTelefoneId(TelefoneId telefoneId) {
        this.telefoneId = telefoneId;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.telefoneId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefone other = (Telefone) obj;
        return Objects.equals(this.telefoneId, other.telefoneId);
    }
    
    
}
