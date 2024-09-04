package br.com.david.nosso_template.parserUtils;

import br.com.david.nosso_template.pessoas.PessoaRecord;
import br.com.david.nosso_template.pessoas.PessoasEntity;
import br.com.david.nosso_template.templates.TemplateEntity;
import br.com.david.nosso_template.templates.TemplateRecord;

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

    public static TemplateRecord toTemplateRecord(TemplateEntity template){
        if (template == null){
            return null;
        }

        TemplateRecord convertido = new TemplateRecord(template.getId(),template.getTemplate(),template.getDateCreate());
        return convertido;
    }

    public static TemplateEntity toTemplateEntity(TemplateRecord template){
        if (template == null){
            return null;
        }

        TemplateEntity convertido = new TemplateEntity(template.id(),template.template(),template.dateCreate());
        return convertido;
    }
}
