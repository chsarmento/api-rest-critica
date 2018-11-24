package br.pucminas.arquiteturaBackend.bibliotecaAPI.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reputacao {

    private Long id;
    private Integer estrela;
    private String cpf;
    private Date dataPostagem;

}
