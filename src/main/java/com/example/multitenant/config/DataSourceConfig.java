package com.example.multitenant.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    //banco utilizado para subir a aplicao8
    @Bean
    public DataSource bancoPadrao() {
        return DataSourceBuilder.create().
                url("jdbc:postgresql://localhost:5432/teste-2").
                username("postgres").
                password("postgres").
                driverClassName("org.postgresql.Driver").
                build();
    }

    @Bean
    public DataSource client1DataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/cliente1_db") // Substitua pela sua URL
                .username("postgres") // Substitua pelo seu usuário
                .password("postgres") // Substitua pela sua senha
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    public DataSource client2DataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/cliente2_db") // Substitua pela sua URL
                .username("postgres") // Substitua pelo seu usuário
                .password("postgres") // Substitua pela sua senha
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    public DataSource client3DataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/cliente3_db") // Substitua pela sua URL
                .username("postgres") // Substitua pelo seu usuário
                .password("postgres") // Substitua pela sua senha
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    @Primary // Define este como o DataSource principal para o JPA
    public AbstractRoutingDataSource tenantAwareDataSource(
            @Qualifier("client1DataSource") DataSource client1DataSource,
            @Qualifier("client2DataSource") DataSource client2DataSource,
            @Qualifier("client3DataSource") DataSource client3DataSource) {
        TenantAwareRoutingSource routingSource = new TenantAwareRoutingSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("12345678901234", client1DataSource); // CNPJ do Cliente 1
        targetDataSources.put("98765432109876", client2DataSource); // CNPJ do Cliente 2
        targetDataSources.put("93844722000129", client3DataSource); // CNPJ do Cliente 2
        routingSource.setTargetDataSources(targetDataSources);

        return routingSource;
    }
}
