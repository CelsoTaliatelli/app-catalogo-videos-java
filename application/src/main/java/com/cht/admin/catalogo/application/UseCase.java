package com.cht.admin.catalogo.application;

import com.cht.admin.catalogo.domain.category.Category;

public abstract class UseCase <IN, OUT>{

    public abstract OUT execute(IN aIn);

}