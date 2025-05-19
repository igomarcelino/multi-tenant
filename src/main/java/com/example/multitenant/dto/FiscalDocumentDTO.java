package com.example.multitenant.dto;

public class FiscalDocumentDTO {
    private String content;
    private String cnpj;

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
