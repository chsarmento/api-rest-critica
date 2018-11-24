package br.pucminas.arquiteturaBackend.bibliotecaAPI.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    private String isbn;

    private List<Critica> listaCritica = new ArrayList<>();
    private List<Reputacao> listaReputacao = new ArrayList<>();

    public Livro(String isbn) {
        this.isbn = isbn;
    }
    
}
