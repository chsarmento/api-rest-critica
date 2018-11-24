package br.pucminas.arquiteturaBackend.bibliotecaAPI.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Critica {

    private Long id;
    private String comentario;
    private String cpf;
    private Date dataPostagem;

}
