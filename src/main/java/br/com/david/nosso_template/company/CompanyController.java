package br.com.david.nosso_template.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping()
    public List<CompanyEntity> getAll(){
        return companyRepository.findAll();
    }

    @GetMapping("{id}")
    public CompanyEntity findCompany(@PathVariable Integer id){
        Optional<CompanyEntity> companyDTO = companyRepository.findById(id);
        return companyDTO.get();
    }

    @PostMapping
    public void saveCompany(@RequestBody CompanyRecord companyRecord){
        companyRepository.save(new CompanyEntity(null, companyRecord.name(), companyRecord.cnpj()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyRecord> updateCompany(@RequestBody CompanyRecord companyRecord,@PathVariable Integer id){
        Optional<CompanyEntity> company = companyRepository.findById(id);
        if(company.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(companyRecord.name() != null){
            company.get().setName(companyRecord.name());
        }

        if(companyRecord.cnpj() != null){
            company.get().setCnpj(companyRecord.cnpj());
        }

        CompanyEntity companySave = companyRepository.save(company.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
