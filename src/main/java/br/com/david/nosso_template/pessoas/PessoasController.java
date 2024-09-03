package br.com.david.nosso_template.pessoas;

import br.com.david.nosso_template.company.CompanyEntity;
import br.com.david.nosso_template.company.CompanyRepository;
import br.com.david.nosso_template.exceptions.ExceptionsComuns;
import br.com.david.nosso_template.parserUtils.ParsesUtils;
import org.apache.logging.log4j.util.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<PessoaRecord> searchOne(@PathVariable Integer id){
        PessoasEntity search = pessoaRepository.findById(id).orElseThrow(() -> new ExceptionsComuns("Pessoa não encontrada, ID: " + id));
        PessoaRecord find = ParsesUtils.toPessoaRecord(search);
        return new ResponseEntity<>(find, HttpStatusCode.valueOf(200));
    }


    @PostMapping
    public void savePessoas(@RequestBody PessoaRecord pessoa) {
        PessoasEntity ps = new PessoasEntity(null, pessoa.name(), pessoa.company(), pessoa.type(),pessoa.email());
        pessoaRepository.save(ps);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoasEntity> updatePessoa(@RequestBody PessoaRecord pessoaRecord, @PathVariable Integer id) {

        PessoasEntity pessoa = pessoaRepository.findById(id).orElseThrow(()-> new ExceptionsComuns("ID não encontrado"));

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