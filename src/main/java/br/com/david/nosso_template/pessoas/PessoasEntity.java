package br.com.david.nosso_template.pessoas;

import br.com.david.nosso_template.pessoas.dto.PessoaRecord;
import jakarta.persistence.*;
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
    private String company;

}
