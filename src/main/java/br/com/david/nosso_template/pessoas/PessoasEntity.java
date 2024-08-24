package br.com.david.nosso_template.pessoas;

import br.com.david.nosso_template.company.CompanyEntity;
import jakarta.persistence.*;
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
    private String name;
    @ManyToOne
    private CompanyEntity company;
    @Enumerated(EnumType.ORDINAL)
    private PessoaEnum type;

}
