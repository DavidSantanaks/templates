package br.com.david.nosso_template.templates;

import java.time.LocalDateTime;

public record TemplateRecord(Integer id, String template, LocalDateTime dateCreate) {
}
