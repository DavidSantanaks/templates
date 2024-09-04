package br.com.david.nosso_template.templates;

import br.com.david.nosso_template.exceptions.ExceptionsComuns;
import br.com.david.nosso_template.parserUtils.ParsesUtils;
import br.com.david.nosso_template.pessoas.PessoasEntity;
import br.com.david.nosso_template.pessoas.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/templates")

public class templateController {

    @Autowired
    TemplateRepository templateRepository;
    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping()
    public List<TemplateEntity> getAll(){
        return templateRepository.findAll();
    }


    @GetMapping("/{id}/pessoa/{idPessoa}")
    public String findTemplateId(@PathVariable Integer id, @PathVariable Integer idPessoa){
       Optional<TemplateEntity> te = templateRepository.findById(id);
       String templateSave = te.get().getTemplate();

       Optional<PessoasEntity> pessoaRecord = pessoaRepository.findById(idPessoa);
       String corrigida = templateSave.replace("${name}", pessoaRecord.get().getName())
                                       .replace("${company}", pessoaRecord.get().getCompany().getName());

       templateSave = corrigida;
       return templateSave;
    }


    @PostMapping()
    public void personalizado(@Validated @RequestBody TemplateRecord templateRecord){
        TemplateEntity te = ParsesUtils.toTemplateEntity(templateRecord);
        templateRepository.save(te);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTemplate(@Validated @RequestBody TemplateRecord templateRecord, @PathVariable Integer id){
        TemplateEntity template = templateRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Template não encontrado, ID:" + id));

        if(templateRecord.template() != null){
            template.setTemplate(templateRecord.template());
            template.setDateCreate(LocalDateTime.now());
        }
        TemplateEntity save = templateRepository.save(template);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

}
