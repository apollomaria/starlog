package br.com.starlog.model;

public class Carga {
    private String codigoRastreio;
    private String categoria;
    private double pesoKg;
    private double valorSeguro;

    public Carga(String codigoRastreio, String categoria, double pesoKg, double valorSeguro) {
        if (codigoRastreio.trim().isEmpty() || codigoRastreio == null) {
            throw new IllegalArgumentException("Codigo de rastreio de carga nao pode ser nulo ou vazio.");
        }
        
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("Peso da carga nao pode ser negativo ou igual a zero.");
        }

        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoRastreio == null) ? 0 : codigoRastreio.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carga other = (Carga) obj;
        if (codigoRastreio == null) {
            if (other.codigoRastreio != null)
                return false;
        } else if (!codigoRastreio.equals(other.codigoRastreio))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Carga [rastreio=" + codigoRastreio + ", categoria=" + categoria + ", peso=" + pesoKg
                + "kg, seguro=R$" + valorSeguro + "]";
    }


}
