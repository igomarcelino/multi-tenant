package com.example.multitenant.filter;


import com.example.multitenant.context.TenantContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TenantFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String cnpj = request.getHeader("X-Tenant-CNPJ"); // Vamos usar um header para identificar o cliente
        if (cnpj != null && !cnpj.isEmpty()) {
            TenantContext.setCurrentTenant(cnpj);
            try {
                filterChain.doFilter(request, response);
            } finally {
                TenantContext.clear();
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Header 'X-Tenant-CNPJ' é obrigatório.");
        }
    }
}