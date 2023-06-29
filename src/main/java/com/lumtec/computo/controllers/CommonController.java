package com.lumtec.computo.controllers;

import com.lumtec.computo.infra.Shortcuts;

import javax.swing.*;

public class CommonController {

    public void cargarListaProvedores(JComboBox jComboBox){
        Shortcuts.cargarListaProvedores().forEach(provedor -> jComboBox.addItem(provedor.getNombre()));
    }


}
