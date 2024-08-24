package br.com.david.nosso_template.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "company")
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @Column(length = 14, unique = true)
    private String cnpj;
}
