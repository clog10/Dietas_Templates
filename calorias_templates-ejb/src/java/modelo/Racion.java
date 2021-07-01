package modelo;

/**
 *
 * @author Carlos Loaeza
 */
public class Racion {

    //private Integer idR;
    private final int NTIEMPOS = 5;
    private Grupoalimentos gpA;
    private int tiempos[];
    //private Integer nracion;
    //private int ntiempos;

    public Racion(Grupoalimentos gpA) {
        this.gpA = gpA;
        inicia();
    }

    public Racion() {

    }

    public void inicia() {
        tiempos = new int[NTIEMPOS];
        for (int t = 0; t < NTIEMPOS; t++) {
            tiempos[t] = 0;
        }
    }

    public Grupoalimentos getGpA() {
        return gpA;
    }

    public void setGpA(Grupoalimentos gpA) {
        this.gpA = gpA;
    }

    public Integer getTiempo_1() {
        return tiempos[0];
    }

    public void setTiempo_1(Integer tiempo) {
        this.tiempos[0] = tiempo;
    }

    public Integer getTiempo_2() {
        return tiempos[1];
    }

    public void setTiempo_2(Integer tiempo) {
        this.tiempos[1] = tiempo;
    }

    public Integer getTiempo_3() {
        return tiempos[2];
    }

    public void setTiempo_3(Integer tiempo) {
        this.tiempos[2] = tiempo;
    }

    public Integer getTiempo_4() {
        return tiempos[3];
    }

    public void setTiempo_4(Integer tiempo) {
        this.tiempos[3] = tiempo;
    }

    public Integer getTiempo_5() {
        return tiempos[4];
    }

    public void setTiempo_5(Integer tiempo) {
        this.tiempos[4] = tiempo;
    }
}
