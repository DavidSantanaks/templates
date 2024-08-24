package br.com.david.nosso_template.pessoas;

import lombok.*;

@AllArgsConstructor
@Getter
public enum PessoaEnum {
    Sale(0),
    Costumer(1);

    private Integer code;
    PessoaEnum(){
        this.code = code;
    }
}
