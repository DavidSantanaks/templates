package br.com.david.nosso_template.pessoas;

import br.com.david.nosso_template.company.CompanyEntity;
import br.com.david.nosso_template.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping
    public List<PessoasEntity> allPessoas() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public void savePessoas(@RequestBody PessoaRecord pessoa) {
        PessoasEntity ps = new PessoasEntity(null, pessoa.name(), pessoa.company(), pessoa.email(), pessoa.type());
        pessoaRepository.save(ps);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoasEntity> updatePessoa(@RequestBody PessoaRecord pessoaRecord, @PathVariable Integer id) {

        PessoasEntity pessoa = pessoaRepository.findById(id).orElseThrow(()-> new RuntimeException("ID não encontrado"));

        if(pessoaRecord.name() != null){
            pessoa.setName(pessoaRecord.name());
        }

        if (pessoaRecord.company() != null){
           CompanyEntity dto = companyRepository.findById(pessoaRecord.company().getId()).orElseThrow(()-> new RuntimeException("ID empresa não encontrada"));
            pessoa.setCompany(dto);
        }

        if (pessoaRecord.type() != null){
            pessoa.setType(pessoaRecord.type());
        }

        if (pessoaRecord.email() != null){
            pessoa.setEmail(pessoaRecord.email());
        }

        PessoasEntity salvar = pessoaRepository.save(pessoa);
        return new ResponseEntity<>(salvar, HttpStatusCode.valueOf(200));
    }
}