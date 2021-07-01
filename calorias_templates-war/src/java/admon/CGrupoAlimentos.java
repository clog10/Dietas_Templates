/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import log_neg.LNGrupoAlimentos;
import modelo.Grupoalimentos;
import modelo.Racion;

/**
 *
 * @author Carlos Loaeza
 */
@Named(value = "cGrupoAlimentos")
@SessionScoped
public class CGrupoAlimentos implements Serializable {

    @EJB
    private LNGrupoAlimentos lNGrupoAlimentos;

    private final int NRESULTADOS = 5;
    private List<Grupoalimentos> gpos;
    private ArrayList<Integer> nraciones;
    private List<Racion> raciones;
    private int kcr = 1500;
    private Racion racion;
    private int kcXtiempo[] = new int[NRESULTADOS];
    private int chXtiempo[] = new int[NRESULTADOS];
    private int grasasXtiempo[] = new int[NRESULTADOS];
    private int proXtiempo[] = new int[NRESULTADOS];
    private String mensaje = "";

    /**
     * Creates a new instance of CGrupoAlimentos
     */
    public CGrupoAlimentos() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Grupoalimentos> grupos() {
        return lNGrupoAlimentos.grupos();
    }

    public void raciones() {
        gpos = lNGrupoAlimentos.grupos();
        raciones = new ArrayList();
        for (Grupoalimentos gpo : gpos) {
            racion = new Racion(gpo);
            raciones.add(racion);
        }
    }

    public List<Racion> getRaciones() {
        if (raciones == null) {
            raciones();
        }
        return raciones;
    }

    public int getResultado(int nr) {
        return kcXtiempo[nr];
    }

    public int getResultado2(int nr) {
        return chXtiempo[nr];
    }

    public int getResultado3(int nr) {
        return proXtiempo[nr];
    }

    public int getResultado4(int nr) {
        return grasasXtiempo[nr];
    }

    public int getKcTotal() {
        int kctotal = 0;
        for (int nt = 0; nt < NRESULTADOS; nt++) {
            kctotal += kcXtiempo[nt];
        }
        return kctotal;
    }

    public int getChTotal() {
        int chtotal = 0;
        for (int nt = 0; nt < NRESULTADOS; nt++) {
            chtotal += chXtiempo[nt];
        }
        return chtotal;
    }

    public int getProTotal() {
        int prototal = 0;
        for (int nt = 0; nt < NRESULTADOS; nt++) {
            prototal += proXtiempo[nt];
        }
        return prototal;
    }

    public int getGraTotal() {
        int gratotal = 0;
        for (int nt = 0; nt < NRESULTADOS; nt++) {
            gratotal += grasasXtiempo[nt];
        }
        return gratotal;
    }

    public void kcXtiempo() {
        for (Racion rac : raciones) {
            kcXtiempo[0] += rac.getTiempo_1() * rac.getGpA().getEnergia();
            kcXtiempo[1] += rac.getTiempo_2() * rac.getGpA().getEnergia();
            kcXtiempo[2] += rac.getTiempo_3() * rac.getGpA().getEnergia();
            kcXtiempo[3] += rac.getTiempo_4() * rac.getGpA().getEnergia();
            kcXtiempo[4] += rac.getTiempo_5() * rac.getGpA().getEnergia();
        }
    }

    public void chXtiempo() {
        for (Racion rac : raciones) {
            chXtiempo[0] += rac.getTiempo_1() * rac.getGpA().getHidratos();
            chXtiempo[1] += rac.getTiempo_2() * rac.getGpA().getHidratos();
            chXtiempo[2] += rac.getTiempo_3() * rac.getGpA().getHidratos();
            chXtiempo[3] += rac.getTiempo_4() * rac.getGpA().getHidratos();
            chXtiempo[4] += rac.getTiempo_5() * rac.getGpA().getHidratos();
        }
    }

    public void proXtiempo() {
        for (Racion rac : raciones) {
            proXtiempo[0] += rac.getTiempo_1() * rac.getGpA().getProteinas();
            proXtiempo[1] += rac.getTiempo_2() * rac.getGpA().getProteinas();
            proXtiempo[2] += rac.getTiempo_3() * rac.getGpA().getProteinas();
            proXtiempo[3] += rac.getTiempo_4() * rac.getGpA().getProteinas();
            proXtiempo[4] += rac.getTiempo_5() * rac.getGpA().getProteinas();
        }
    }

    public void grasasXtiempo() {
        for (Racion rac : raciones) {
            grasasXtiempo[0] += rac.getTiempo_1() * rac.getGpA().getGrasas();
            grasasXtiempo[1] += rac.getTiempo_2() * rac.getGpA().getGrasas();
            grasasXtiempo[2] += rac.getTiempo_3() * rac.getGpA().getGrasas();
            grasasXtiempo[3] += rac.getTiempo_4() * rac.getGpA().getGrasas();
            grasasXtiempo[4] += rac.getTiempo_5() * rac.getGpA().getGrasas();
        }
    }

    public void limpiar() {
        for (int i = 0; i < kcXtiempo.length; i++) {
            kcXtiempo[i] = 0;
        }
        for (int i = 0; i < chXtiempo.length; i++) {
            chXtiempo[i] = 0;
        }
        for (int i = 0; i < grasasXtiempo.length; i++) {
            grasasXtiempo[i] = 0;
        }
        for (int i = 0; i < proXtiempo.length; i++) {
            proXtiempo[i] = 0;
        }
    }

    public void calcular() {
        limpiar();
        kcXtiempo();
        chXtiempo();
        proXtiempo();
        grasasXtiempo();
        if (kcr <= getKcTotal()) {
            mensaje = "Se sobrepasaron las kilocalorias recomendadas, por favor reduzca sus raciones";
        }
    }

    public void setKcr(int cr) {
        kcr = cr;
    }

    public int getKcr() {
        return kcr;
    }

}
