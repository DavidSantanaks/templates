package br.com.david.nosso_template.templates;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;
import java.util.Date;

@Entity(name ="templates")
@Table(name ="templates")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String template;
    private LocalDateTime dateCreate;



}
