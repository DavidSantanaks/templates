package br.com.david.nosso_template.templates;

import br.com.david.nosso_template.pessoas.PessoasEntity;
import br.com.david.nosso_template.pessoas.dto.PessoaRecord;
import br.com.david.nosso_template.pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/{id}")
    public String findTemplateId(@PathVariable Integer id){
       Optional<TemplateEntity> te = templateRepository.findById(id);
       String templateSave = te.get().getTemplate();

       Optional<PessoasEntity> pessoaRecord = pessoaRepository.findById(id);
       String corrigida = templateSave.replace("${name}", pessoaRecord.get().getName() );
       templateSave = corrigida;

       return templateSave;

    }


    @PostMapping()
    public void personalizado(@RequestBody TemplateDTO templateDTO){
        TemplateEntity te = new TemplateEntity(null,templateDTO.template(),null);
        templateRepository.save(te);

    }




}
