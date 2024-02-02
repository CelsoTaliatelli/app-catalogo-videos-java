package com.cht.admin.catalogo.application;

import com.cht.admin.catalogo.domain.category.Category;

public class UseCase {

    public Category execute(){
        return new Category();
    }

}