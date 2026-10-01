package br.com.starlog.model;

import java.util.HashMap;
import java.util.Map;

public class BaseLancamento {
    private Map<String, ModuloCarga> modulos;

    public BaseLancamento() {
        this.modulos = new HashMap<>();
    }

    public void cadastrarModulo(ModuloCarga modulo) {
        modulos.put(modulo.getIdModulo(), modulo);
    }

    public boolean buscarModulo(String idModulo) {
        return modulos.containsKey(idModulo);
    }


}
