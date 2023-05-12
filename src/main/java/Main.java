import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        XLStoCSV xlStoCSV = new XLStoCSV();
        xlStoCSV.convert("C:\\Users\\Christian Perona\\OneDrive\\Coses_DAM\\Projecte\\idea-workspace\\Gappsoil\\src\\main\\resources\\preciosEESS_es.xls", "C:\\Users\\Christian Perona\\OneDrive\\Coses_DAM\\Projecte\\idea-workspace\\Gappsoil\\src\\main\\resources\\gasolineres_espanya.csv");



        ImportGasolineres importGasolineres = new ImportGasolineres();
        importGasolineres.importGasolineres("C:\\Users\\Christian Perona\\OneDrive\\Coses_DAM\\Projecte\\idea-workspace\\Gappsoil\\src\\main\\resources\\gasolineres_espanya.csv");
        importGasolineres.importGasolineresSQL("importGasolineres.sql");

//        ImportPuntsRecarrega importPuntsRecarrega = new ImportPuntsRecarrega();
//        importPuntsRecarrega.importPuntsRecarrega("C:\\Users\\Christian Perona\\OneDrive\\Coses_DAM\\Projecte\\idea-workspace\\Gappsoil\\src\\main\\resources\\estacions_recarrega_catalunya.csv");
//        importPuntsRecarrega.printPuntsRecarrega();
//        importPuntsRecarrega.importPuntsRecarregaSQL("importPuntsRecarrega.sql");
    }
}
