package br.com.david.nosso_template.pessoas;

import br.com.david.nosso_template.company.CompanyEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PessoaRecord(Integer id,
                           @NotBlank(message = "Campo nome não pode ser vazio.")
                           String name,

                           CompanyEntity company,

                           @Enumerated(EnumType.ORDINAL)
                           @NotNull(message = "Campo tipo não pode ser vazio")
                           PessoaEnum type,

                           @NotBlank(message = "Email nao pode ser vazio")
                           @Email(message = "Email tem que ser valido")
                           String email)
{ }
