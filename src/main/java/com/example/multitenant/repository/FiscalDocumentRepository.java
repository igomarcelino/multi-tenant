package com.example.multitenant.repository;

import com.example.multitenant.model.FiscalDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiscalDocumentRepository extends JpaRepository<FiscalDocument, Long> {
}
