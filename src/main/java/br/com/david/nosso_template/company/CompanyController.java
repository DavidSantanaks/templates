package br.com.david.nosso_template.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyRepository repository;

    @GetMapping()
    public List<CompanyEntity> getAll(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public CompanyEntity findCompany(@PathVariable Integer id){
        Optional<CompanyEntity> companyDTO = repository.findById(id);
        return companyDTO.get();
    }

    @PostMapping
    public void saveCompany(@RequestBody CompanyDTO companyDTO){
        repository.save(new CompanyEntity(null, companyDTO.name(), companyDTO.cnpj()));
    }
}
