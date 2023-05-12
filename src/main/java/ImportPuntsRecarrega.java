import java.io.*;
import java.util.ArrayList;

public class ImportPuntsRecarrega {
    private ArrayList<PuntRecarrega> puntsRecarregues;

    public void importPuntsRecarrega(String fitxer) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fitxer));
        this.puntsRecarregues = new ArrayList<>();

        String linia;
        bufferedReader.readLine();
        bufferedReader.readLine();
        for (int i = 0; (linia = bufferedReader.readLine()) != null; i++) {
            //Passem cada linia a Array
            String[] liniaSplit = linia.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            String[] liniaSplitNeta = netejaCometes(liniaSplit);
            this.puntsRecarregues.add(new PuntRecarrega(liniaSplitNeta[4], Double.parseDouble(liniaSplitNeta[5]), Double.parseDouble(liniaSplitNeta[6]), liniaSplitNeta[7], liniaSplit[9], liniaSplit[15], liniaSplit[16]));
        }
    }

    public void importPuntsRecarregaSQL(String fitxer) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fitxer));
        for (int i = 0; i < this.puntsRecarregues.size(); i++) {
            bufferedWriter.write("insert into PUNTS_DE_RECARREGA(TIPUS_VEHICLES,LATITUDE,LONGITUDE,NOM,NUM_PLACES,TIPUS_CONEXIO,TIPUS_CORRENT) values ('" + puntsRecarregues.get(i).getTipusVehicles() + "'," + puntsRecarregues.get(i).getLatitude() + ", " + puntsRecarregues.get(i).getLongitude() + ",'" + puntsRecarregues.get(i).getNom() + "','" + puntsRecarregues.get(i).getNumPlaces() + "','" + puntsRecarregues.get(i).getTipusConnexio() + "','" + puntsRecarregues.get(i).getTipusCorrent() + "');");
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private String[] netejaCometes(String[] liniaSplit) {
        for (int i = 0; i < liniaSplit.length; i++) {
            liniaSplit[i] = liniaSplit[i].replace("\"", "");
            liniaSplit[i] = liniaSplit[i].replace("\'", "´");
        }
        return liniaSplit;
    }

    public void printPuntsRecarrega() {
        for (PuntRecarrega puntRecarrega : this.puntsRecarregues) {
            System.out.println(puntRecarrega.getTipusConnexio() + " " + puntRecarrega.getLatitude() + " " + puntRecarrega.getLongitude() + " " + puntRecarrega.getNom() + " " + puntRecarrega.getTipusCorrent() + " " + puntRecarrega.getNumPlaces() + " " + puntRecarrega.getTipusVehicles());
        }
    }
}
