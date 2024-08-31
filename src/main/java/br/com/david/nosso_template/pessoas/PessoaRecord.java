package br.com.david.nosso_template.pessoas;

import br.com.david.nosso_template.company.CompanyEntity;


public record PessoaRecord(Integer id, String name, CompanyEntity company, PessoaEnum type, String email) {

}
