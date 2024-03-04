package com.cht.admin.catalogo.infrastructure.category;

import com.cht.admin.catalogo.infrastructure.MySQLGatewayTest;
import com.cht.admin.catalogo.infrastructure.category.persistence.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@MySQLGatewayTest
public class CategoryMySQLGatewayTest {

    @Autowired
    private CategoryMySQLGateway categoryMySQLGateway;
    @Autowired
    private CategoryRepository repository;

    @Test
    public void testInjectedDependecies(){
        Assertions.assertNotNull(categoryMySQLGateway);
        Assertions.assertNotNull(repository);
    }
}


