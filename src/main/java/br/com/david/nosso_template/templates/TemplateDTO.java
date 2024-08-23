package br.com.david.nosso_template.templates;

import java.time.LocalDateTime;
import java.util.Date;

public record TemplateDTO(Integer id, String template, LocalDateTime dateCreate) {
}
