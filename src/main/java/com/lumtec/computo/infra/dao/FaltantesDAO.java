package com.lumtec.computo.infra.dao;

import com.lumtec.computo.infra.model.Faltante;

import java.util.List;

public interface FaltantesDAO {

    public void nuevoFaltante(Faltante faltante);

    public void actualizarFaltante(Faltante faltante);

    public Faltante getFaltantePorNombre(String nombre);

    public List<Faltante> getListaFaltantes();


}
