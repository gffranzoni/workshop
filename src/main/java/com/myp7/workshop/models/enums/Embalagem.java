package com.myp7.workshop.models.enums;

public enum Embalagem {

    UN ("Unidade"),
    CX ("Caixa"),
    PC ("Pacote"),
    LT ("Litro"),
    KG ("Quilo");

    Embalagem(String descricao) {
        this.descricao = descricao;
    }

    private final String descricao;

    public String getDescricao(){
        return descricao;
    }
}
