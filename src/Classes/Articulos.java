
package Classes;

import java.io.Serializable;

public class Articulos implements Serializable {
    
    private String codigo;
    private String nombreFamilia;
    private String nombreArticulo;
    private String coste;
    private String piezasPorCaja;

    public Articulos(String codigo, String nombreFamilia, String nombreArticulo, String coste, String piezasPorCaja) {
        this.codigo = codigo;
        this.nombreFamilia = nombreFamilia;
        this.nombreArticulo = nombreArticulo;
        this.coste = coste;
        this.piezasPorCaja = piezasPorCaja;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getCoste() {
        return coste;
    }

    public void setCoste(String coste) {
        this.coste = coste;
    }

    public String getPiezasPorCaja() {
        return piezasPorCaja;
    }

    public void setPiezasPorCaja(String piezasPorCaja) {
        this.piezasPorCaja = piezasPorCaja;
    }

    @Override
    public String toString() {
        return "Articulos{" + "codigo=" + codigo + ", nombreFamilia=" + nombreFamilia + ", nombreArticulo=" + nombreArticulo + ", coste=" + coste + ", piezasPorCaja=" + piezasPorCaja + '}';
    }
    
    
    
    
}
