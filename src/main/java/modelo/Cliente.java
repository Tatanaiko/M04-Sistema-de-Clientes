package modelo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Cliente {
    private String rutCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private int aniosCliente;
    private CategoriaEnum nombreCategoria;

}
