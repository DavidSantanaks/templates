package br.com.david.nosso_template.pessoas;

import br.com.david.nosso_template.company.CompanyEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

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

    @NotBlank(message = "campo nome n pode ser vazio")
    private String name;

    @ManyToOne
    private CompanyEntity company;

    @Email(message = "Email invalido")
    private String email;


    @Enumerated(EnumType.ORDINAL)
    @NotBlank(message = "campo type n pode ser vazio")
    private PessoaEnum type;

}
