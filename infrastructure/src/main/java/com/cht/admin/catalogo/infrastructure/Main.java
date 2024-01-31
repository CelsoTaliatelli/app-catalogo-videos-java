package com.cht.admin.catalogo.infrastructure;

import com.cht.admin.catalogo.application.UseCase;

public class Main {
    public static void main(String[] args) {
        System.out.println(new UseCase().execute());
    }
}