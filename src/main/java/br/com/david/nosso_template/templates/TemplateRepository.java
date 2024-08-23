package br.com.david.nosso_template.templates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
public interface TemplateRepository extends JpaRepository<TemplateEntity, Integer> {
}
