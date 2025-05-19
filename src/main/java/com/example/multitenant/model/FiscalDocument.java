package com.example.multitenant.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "nota_fiscal")
public class FiscalDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long id;

    @Column(name = "xml")
    private String content; // Conteúdo do XML (simplificado)
    private String cnpj; // CNPJ da empresa que enviou o documento

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}