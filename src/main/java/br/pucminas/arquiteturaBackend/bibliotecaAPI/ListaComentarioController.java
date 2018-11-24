package br.pucminas.arquiteturaBackend.bibliotecaAPI;

import br.pucminas.arquiteturaBackend.bibliotecaAPI.dto.Critica;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.arquiteturaBackend.bibliotecaAPI.dto.Livro;
import br.pucminas.arquiteturaBackend.bibliotecaAPI.dto.Reputacao;
import io.swagger.annotations.ApiOperation;
import java.util.Random;

@RestController
@RequestMapping("/v1/public/")
public class ListaComentarioController {

    private List<Livro> livros = new ArrayList<>();

    // Usuarios
    @ApiOperation(value = "Busca lista de criticas de um livro", response = List.class)
    @GetMapping("criticas/{isbn}")
    public List<Critica> todasCriticas(@PathVariable String isbn) {

        Livro livro = obterLivroBy(isbn);

        if (null != livro) {
            return livro.getListaCritica();
        }
        return null;
    }

    @ApiOperation(value = "Adiciona uma critica ao livro", response = Critica.class)
    @PostMapping("criticas/{isbn}")
    Critica adicionarCritica(@RequestBody Critica critica, @PathVariable String isbn) {

        Livro livro = obterLivroBy(isbn);

        if (null != livro) {
            critica.setId(new Long(new Random().nextInt(100)));
            livro.getListaCritica().add(critica);
        }
        return critica;

    }

    @ApiOperation(value = "Remove uma crítica do livro", response = Void.class)
    @DeleteMapping("criticas/{isbn}/{idCritica}")
    void deleteCritica(@PathVariable String isbn, @PathVariable Long idCritica) {

        Livro livro = obterLivroBy(isbn);

        if (null != livro) {
            livro.getListaCritica()
                    .removeIf(l -> l.getId().equals(idCritica));

        }
    }

    @ApiOperation(value = "Busca lista de reputação de um livro", response = List.class)
    @GetMapping("reputacoes/{isbn}")
    public List<Reputacao> todasReputacoes(@PathVariable String isbn) {

        Livro livro = obterLivroBy(isbn);

        if (null != livro) {
            return livro.getListaReputacao();
        }
        return null;
    }

    @ApiOperation(value = "Adiciona uma reputacao ao livro", response = Critica.class)
    @PostMapping("reputacoes/{isbn}")
    Reputacao adicionarReputacao(@RequestBody Reputacao reputacao, @PathVariable String isbn) {

        Livro livro = obterLivroBy(isbn);

        if (null != livro) {
            reputacao.setId(new Long(new Random().nextInt(100)));
            livro.getListaReputacao().add(reputacao);
        }
        return reputacao;

    }

    @ApiOperation(value = "Remove uma reputação do livro", response = Void.class)
    @DeleteMapping("reputacoes/{isbn}/{idCritica}")
    void deleteReputacao(@PathVariable String isbn, @PathVariable Long idReputacao) {

        Livro livro = obterLivroBy(isbn);

        if (null != livro) {
            livro.getListaReputacao()
                    .removeIf(l -> l.getId().equals(idReputacao));

        }
    }

    private Livro obterLivroBy(String isbn) {

        Livro livro = livros.stream()
                .filter(p -> p.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);

        if (null == livro) {
            livro = new Livro();
            livro.setIsbn(isbn);
            livros.add(livro);
        }

        return livro;
    }

}
