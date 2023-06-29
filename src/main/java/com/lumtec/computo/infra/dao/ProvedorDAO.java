package com.lumtec.computo.infra.dao;

import com.lumtec.computo.infra.model.Provedor;

import java.util.List;

public interface ProvedorDAO {

    public Provedor getProvedorPorNombre(String nombre);

    public List<Provedor> getProvedores();

}
