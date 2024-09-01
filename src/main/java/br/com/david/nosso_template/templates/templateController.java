package br.com.david.nosso_template.templates;

import br.com.david.nosso_template.pessoas.PessoasEntity;
import br.com.david.nosso_template.pessoas.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public void personalizado(@RequestBody TemplateRecord templateRecord){
        TemplateEntity te = new TemplateEntity(null,templateRecord.template(),null);
        templateRepository.save(te);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TemplateRecord> updateTemplate(@RequestBody TemplateRecord templateRecord, @PathVariable Integer id){
        Optional<TemplateEntity> template = templateRepository.findById(id);

        if (template.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(templateRecord.template() != null){
            template.get().setTemplate(templateRecord.template());
            template.get().setDateCreate(LocalDateTime.now());
        }

        TemplateEntity save = templateRepository.save(template.get());
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));

    }

}
