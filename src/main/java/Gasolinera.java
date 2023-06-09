public class Gasolinera {
    private String nom;
    private double latitude;
    private double longitude;
    boolean gasolina;
    boolean SP95;
    boolean SP98;
    boolean gasoil;
    boolean Adblue;
    boolean hidrogen;
    boolean GLP;
    boolean GNC;
    boolean GNL;
    String horari;

    public Gasolinera(String nom, double latitude, double longitude, boolean gasolina, boolean SP95, boolean SP98, boolean gasoil, boolean adblue, boolean hidrogen, boolean GLP, boolean GNC, boolean GNL, String horari) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.gasolina = gasolina;
        this.SP95 = SP95;
        this.SP98 = SP98;
        this.gasoil = gasoil;
        Adblue = adblue;
        this.hidrogen = hidrogen;
        this.GLP = GLP;
        this.GNC = GNC;
        this.GNL = GNL;
        this.horari = horari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isGasolina() {
        return gasolina;
    }

    public void setGasolina(boolean gasolina) {
        this.gasolina = gasolina;
    }

    public boolean isSP95() {
        return SP95;
    }

    public void setSP95(boolean SP95) {
        this.SP95 = SP95;
    }

    public boolean isSP98() {
        return SP98;
    }

    public void setSP98(boolean SP98) {
        this.SP98 = SP98;
    }

    public boolean isGasoil() {
        return gasoil;
    }

    public void setGasoil(boolean gasoil) {
        this.gasoil = gasoil;
    }

    public boolean isAdblue() {
        return Adblue;
    }

    public void setAdblue(boolean adblue) {
        Adblue = adblue;
    }

    public boolean isHidrogen() {
        return hidrogen;
    }

    public void setHidrogen(boolean hidrogen) {
        this.hidrogen = hidrogen;
    }

    public boolean isGLP() {
        return GLP;
    }

    public void setGLP(boolean GLP) {
        this.GLP = GLP;
    }

    public boolean isGNC() {
        return GNC;
    }

    public void setGNC(boolean GNC) {
        this.GNC = GNC;
    }

    public boolean isGNL() {
        return GNL;
    }

    public void setGNL(boolean GNL) {
        this.GNL = GNL;
    }

    public String getHorari() {
        return horari;
    }

    public void setHorari(String horari) {
        this.horari = horari;
    }
}
