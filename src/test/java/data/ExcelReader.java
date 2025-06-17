package data;

import com.poiji.bind.Poiji;
import modelos.ItemProducto;
import modelos.MensajeError;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private static final String excelPath = "src/test/resources/data/dataExcel.xlsx";

    public static List<ItemProducto> leerListaItemProductoExcel() {
        return Poiji.fromExcel(new File(excelPath), ItemProducto.class);
    }

    public static List<MensajeError> leerMensajesErrorExcel() {
        return Poiji.fromExcel(new File(excelPath), MensajeError.class);
    }
}
