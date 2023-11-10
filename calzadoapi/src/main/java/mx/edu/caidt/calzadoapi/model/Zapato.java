package mx.edu.caidt.calzadoapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name= "zapato")
public class Zapato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idModelo;
    private String marca;
    private String color;
    private String numeracion;
    private int cantidad;

    //Getters & Setters
    public long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(long idModelo) {
        this.idModelo = idModelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Constructor
    /*public Zapato(long idModelo, String marca, String color, String numeracion, int cantidad) {
        this.idModelo = idModelo;
        this.marca = marca;
        this.color = color;
        this.numeracion = numeracion;
        this.cantidad = cantidad;
    }
    //Empty constructor
    public Zapato() {
    }*/

    @Override
    public String toString() {
        return "Zapato{" +
                "idModelo = " + idModelo + ", " + '\'' +
                "Marca = " + marca + ", " + '\'' +
                "Color = " + color + ", " + '\'' +
                "Numeración = " + numeracion + ", " + '\'' +
                "Cantidad en existencia= " + cantidad + ", " + '\''
                ;
    }

}
