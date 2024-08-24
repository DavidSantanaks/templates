package br.com.david.nosso_template.pessoas.controller;

import br.com.david.nosso_template.pessoas.PessoasEntity;
import br.com.david.nosso_template.pessoas.dto.PessoaRecord;
import br.com.david.nosso_template.pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    PessoaRepository repository;

    @GetMapping
    public List<PessoasEntity> allPessoas(){
       return repository.findAll();
    }

    @PostMapping
    public void savePessoas(@RequestBody PessoaRecord pessoa){
            PessoasEntity ps = new PessoasEntity(null,pessoa.name(), pessoa.company());
            repository.save(ps);
    }

}
