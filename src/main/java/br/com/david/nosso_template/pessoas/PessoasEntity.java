package br.com.david.nosso_template.pessoas;

import br.com.david.nosso_template.company.CompanyEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="pessoas")
@Table(name = "pessoas")
public class PessoasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    private CompanyEntity company;
    private PessoaEnum type;
    private String email;


}
