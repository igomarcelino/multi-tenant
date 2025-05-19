package com.example.multitenant.repository;

import com.example.multitenant.dto.FiscalDocumentDTO;
import com.example.multitenant.mapper.FiscalDocumentMapper;
import com.example.multitenant.model.FiscalDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiscalDocumentRepository extends JpaRepository<FiscalDocument, Long> {

    @Query(value = """
            select *from nota_fiscal
            where cnpj = :cnpjCliente;
            """,nativeQuery = true)
    List<FiscalDocument> findByCnpj(@Param("cnpjCliente") String cnpjCliente);
}
