package obj;

public class equip {
    private String id;
    private String sistema;
    private String processador;
    private double ram;
    private double hardDisk;
    private String estat;

    public equip(String id, String sistema, String processador, double ram, double hardDisk, String estat) {
        this.id = id;
        this.sistema = sistema;
        this.processador = processador;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.estat = estat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public double getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(double hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    @Override
    public String toString() {
        return "equip{" +
                "id='" + id + '\'' +
                ", sistema='" + sistema + '\'' +
                ", processador='" + processador + '\'' +
                ", ram=" + ram +
                ", hardDisk=" + hardDisk +
                ", estat='" + estat + '\'' +
                '}';
    }
}
