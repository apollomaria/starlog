package br.com.starlog.model;

import java.util.ArrayList;
import java.util.List;

import br.com.starlog.exception.CapacidadeExcedidaException;

public class ModuloCarga {
    private String idModulo;
    private int capacidadeMaxima;
    private List<Carga> cargas;

    public ModuloCarga(String idModulo, int capacidadeMaxima) {
        if (idModulo.trim().isEmpty() || idModulo == null) {
            throw new IllegalArgumentException("Id do Modulo da Carga nao pode ser nulo ou vazio.");
        }
        
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("Capacidade maxima nao pode ser negativo ou igual a zero.");
        }
        
        this.idModulo = idModulo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.cargas = new ArrayList<>(capacidadeMaxima);
    }
    
    
    public String getIdModulo() {
        return idModulo;
    }


    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }


    public List<Carga> getCargas() {
        return cargas;
    }


    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }


    public void setCargas(List<Carga> cargas) {
        this.cargas = cargas;
    }


    public void carregarCarga(Carga carga) throws CapacidadeExcedidaException {
        if (cargas.size() >= capacidadeMaxima) {
            throw new CapacidadeExcedidaException("Capacidade maxima de " + this.capacidadeMaxima + " atingida no modulo " + this.idModulo);
        }

        cargas.add(carga);
        System.out.println("Carga " + carga.getCodigoRastreio() + " carregada no modulo com sucesso.");
    }


    public double calcularSeguroTotal() {
        return this.cargas.stream()
                                .mapToDouble(c -> c.getValorSeguro())
                                .sum();
    }


    public long contarPorCategoria(String categoria) {
        return this.cargas.stream()
                                .filter(c -> c.getCategoria().equals(categoria))
                                .count()
                                ;
    }


    public double calcularSeguroPesadas(double pesoCorte) {
        return this.cargas.stream()
                                .filter(c -> c.getPesoKg() > pesoCorte)
                                .mapToDouble(c -> c.getValorSeguro())
                                .sum()
                                ;
    }

}
