import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        ImportGasolineres importGasolineres = new ImportGasolineres();
        importGasolineres.importGasolineresAuto();
    }
}
