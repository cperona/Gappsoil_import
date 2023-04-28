import java.io.*;
import java.util.ArrayList;

public class ImportGasolineres {
    private ArrayList<Gasolinera> gasolineres;
    public void importGasolineres(String fitxer) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fitxer));
        this.gasolineres = new ArrayList<>();

        String linia;
        bufferedReader.readLine();
        bufferedReader.readLine();
        bufferedReader.readLine();
        bufferedReader.readLine();
        for (int i = 0; (linia = bufferedReader.readLine()) != null; i++) {
            //Passem cada linia a Array
            String[] liniaSplit = linia.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            //Netejem de cometes el resultat
            String[] liniaSplitNeta = netejaCometes(liniaSplit);
            //Filtrem les gasolineres de catalunya
            if (liniaSplitNeta[0].equals("BARCELONA") || liniaSplitNeta[0].equals("TARRAGONA") || liniaSplitNeta[0].equals("LLEIDA") || liniaSplitNeta[0].equals("GIRONA")) {
                this.gasolineres.add(new Gasolinera(liniaSplitNeta[26], Double.parseDouble(liniaSplitNeta[7]), Double.parseDouble(liniaSplitNeta[6]), teGasolina(liniaSplitNeta), teGasolinaSP95(liniaSplitNeta), teGasolinaSP98(liniaSplitNeta), teGasoil(liniaSplitNeta), false, false, liniaSplitNeta[29]));
            }
        }
    }

    public void importGasolineresSQL(String fitxer) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fitxer));
        for (int i = 0; i < this.gasolineres.size(); i++) {
            bufferedWriter.write("insert into BENZINERES (ADBLUE, SP95, SP98, GASOIL, GASOLINA, HIDROGEN, HORARI, LATITUDE, LONGITUDE, NOM) values (" + gasolineres.get(i).isAdblue() + ", " + gasolineres.get(i).isSP95() + ", " + gasolineres.get(i).isSP98() + ", " + gasolineres.get(i).isGasoil() + ", " + gasolineres.get(i).isGasolina() + ", " + gasolineres.get(i).isHidrogen() + ", \'" + gasolineres.get(i).getHorari() + "\', " + gasolineres.get(i).getLatitude() + ", " + gasolineres.get(i).getLongitude() + ", \'" + gasolineres.get(i).getNom() + "\');");
            System.out.println("insert into BENZINERES (ADBLUE, SP95, SP98, GASOIL, GASOLINA, HIDROGEN, HORARI, LATITUDE, LONGITUDE, NOM) values (" + gasolineres.get(i).isAdblue() + ", " + gasolineres.get(i).isSP95() + ", " + gasolineres.get(i).isSP98() + ", " + gasolineres.get(i).isGasoil() + ", " + gasolineres.get(i).isGasolina() + ", " + gasolineres.get(i).isHidrogen() + ", \'" + gasolineres.get(i).getHorari() + "\', " + gasolineres.get(i).getLatitude() + ", " + gasolineres.get(i).getLongitude() + ", \'" + gasolineres.get(i).getNom() + "\');");
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private String[] netejaCometes(String[] liniaSplit) {
        for (int i = 0; i < liniaSplit.length; i++) {
            liniaSplit[i] = liniaSplit[i].replace("\"", "");
            liniaSplit[i] = liniaSplit[i].replace("\'", "´");
            if (liniaSplit[i].matches("-?\\d+,\\d+")) {
                liniaSplit[i] = liniaSplit[i].replace(",", ".");
            }
        }
        return liniaSplit;
    }

    public void printGasolineres() {
        for (Gasolinera gasolinera : this.gasolineres) {
            System.out.println(gasolinera.getNom() + " " + gasolinera.getLatitude() + " " + gasolinera.getLongitude() + " " + gasolinera.isGasolina() + " " + gasolinera.isSP95() + " " + gasolinera.isSP98() + " " + gasolinera.isGasoil() + " " + gasolinera.isAdblue() + " " + gasolinera.isHidrogen() + " " + gasolinera.getHorari());
        }
    }

    private boolean teGasoil(String[] liniaSplit) {
        if (liniaSplit[14] != null || liniaSplit[15] != null || liniaSplit[16] != null || liniaSplit[17] != null) {
            return true;
        }
        return false;
    }

    private boolean teGasolinaSP98(String[] liniaSplit) {
        if (liniaSplit[12] != null || liniaSplit[13] != null) {
            return true;
        }
        return false;
    }

    private boolean teGasolinaSP95(String[] liniaSplit) {
        if (liniaSplit[9] != null || liniaSplit[10] != null || liniaSplit[11] != null) {
            return true;
        }
        return false;
    }

    private boolean teGasolina(String[] liniaSplit) {
        if (liniaSplit[9] != null || liniaSplit[10] != null || liniaSplit[11] != null || liniaSplit[12] != null ||liniaSplit[13] != null) {
            return true;
        }
        return false;
    }
}
