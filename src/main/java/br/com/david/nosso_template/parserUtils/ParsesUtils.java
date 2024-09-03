package br.com.david.nosso_template.parserUtils;

import br.com.david.nosso_template.pessoas.PessoaRecord;
import br.com.david.nosso_template.pessoas.PessoasEntity;

public class ParsesUtils {

    public static PessoaRecord toPessoaRecord(PessoasEntity pessoas){
        if (pessoas == null){
            return null;
        }

        PessoaRecord convertido = new PessoaRecord(pessoas.getId(), pessoas.getName(), pessoas.getCompany(),pessoas.getType(), pessoas.getEmail());
        return convertido;
    }

    public static PessoasEntity toPessoaEntity(PessoaRecord pessoas){
        if (pessoas == null){
            return null;
        }

        PessoasEntity convertido = new PessoasEntity(pessoas.id(), pessoas.name(), pessoas.company(),pessoas.type(), pessoas.email());
        return convertido;
    }
}
