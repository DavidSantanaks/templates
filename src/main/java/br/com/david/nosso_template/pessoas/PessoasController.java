package br.com.david.nosso_template.pessoas;

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
            PessoasEntity ps = new PessoasEntity(null,pessoa.name(), pessoa.company(), pessoa.type());
            repository.save(ps);
    }

}
