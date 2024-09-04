package br.com.david.nosso_template.templates;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record TemplateRecord(


        Integer id,
        @NotNull(message = "Template não pode ser nulo")
        String template,
        @CreationTimestamp
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime dateCreate)
{ }
