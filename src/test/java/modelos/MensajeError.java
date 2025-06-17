package modelos;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("mensajes")
public class MensajeError {
    @ExcelCellName("NOMBRE")
    private String nombre;
    @ExcelCellName("MENSAJE")
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public String getNombre() {
        return nombre;
    }
}
