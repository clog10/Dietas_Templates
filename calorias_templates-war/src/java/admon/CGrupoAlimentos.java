package admon;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import log_neg.LNAlimento;
import log_neg.LNGrupoAlimentos;
import modelo.Alimentos;
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
    private LNAlimento lNAlimento;

    @EJB
    private LNGrupoAlimentos lNGrupoAlimentos;

    private final int NRESULTADOS = 5;
    private List<Grupoalimentos> gpos;
    private ArrayList<Integer> nraciones;
    private List<Racion> raciones;
    private int kcr = 1500;
    private Racion racion;
    private double kcXtiempo[] = new double[NRESULTADOS];
    private double chXtiempo[] = new double[NRESULTADOS];
    private double grasasXtiempo[] = new double[NRESULTADOS];
    private double proXtiempo[] = new double[NRESULTADOS];
    private String mensaje = "";
    private List<Integer> alimentosSeleccionadosTiempo1;
    private List<Integer> alimentosSeleccionadosTiempo2;
    private List<Integer> alimentosSeleccionadosTiempo3;
    private List<Integer> alimentosSeleccionadosTiempo4;
    private List<Integer> alimentosSeleccionadosTiempo5;
    private int idAlimentoTiempo1;
    private int idAlimentoTiempo2;
    private int idAlimentoTiempo3;
    private int idAlimentoTiempo4;
    private int idAlimentoTiempo5;

    /**
     * Creates a new instance of CGrupoAlimentos
     */
    public CGrupoAlimentos() {
        alimentosSeleccionadosTiempo1 = new ArrayList();
        alimentosSeleccionadosTiempo2 = new ArrayList();
        alimentosSeleccionadosTiempo3 = new ArrayList();
        alimentosSeleccionadosTiempo4 = new ArrayList();
        alimentosSeleccionadosTiempo5 = new ArrayList();
    }

    public int getIdAlimentoTiempo1() {
        return idAlimentoTiempo1;
    }

    public void setIdAlimentoTiempo1(int idAlimentoTiempo1) {
        alimentosSeleccionadosTiempo1.add(idAlimentoTiempo1);
    }

    public int getIdAlimentoTiempo2() {
        return idAlimentoTiempo2;
    }

    public void setIdAlimentoTiempo2(int idAlimentoTiempo2) {
        alimentosSeleccionadosTiempo2.add(idAlimentoTiempo2);
    }

    public int getIdAlimentoTiempo3() {
        return idAlimentoTiempo3;
    }

    public void setIdAlimentoTiempo3(int idAlimentoTiempo3) {
        alimentosSeleccionadosTiempo3.add(idAlimentoTiempo3);
    }

    public int getIdAlimentoTiempo4() {
        return idAlimentoTiempo4;
    }

    public void setIdAlimentoTiempo4(int idAlimentoTiempo4) {
        alimentosSeleccionadosTiempo4.add(idAlimentoTiempo4);
    }

    public int getIdAlimentoTiempo5() {
        return idAlimentoTiempo5;
    }

    public void setIdAlimentoTiempo5(int idAlimentoTiempo5) {
        alimentosSeleccionadosTiempo5.add(idAlimentoTiempo5);
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

    public double getResultado(int nr) {
        return kcXtiempo[nr];
    }

    public double getResultado2(int nr) {
        return chXtiempo[nr];
    }

    public double getResultado3(int nr) {
        return proXtiempo[nr];
    }

    public double getResultado4(int nr) {
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

    public List<Alimentos> llenaTiempo1() {
        List<Alimentos> lista = new ArrayList();
        Alimentos a = null;
        for (int i : alimentosSeleccionadosTiempo1) {
            a = lNAlimento.buscar(i);
            lista.add(a);
        }
        return lista;
    }

    public List<Alimentos> llenaTiempo2() {
        List<Alimentos> lista = new ArrayList();
        Alimentos a = null;
        for (int i : alimentosSeleccionadosTiempo2) {
            a = lNAlimento.buscar(i);
            lista.add(a);
        }
        return lista;
    }

    public List<Alimentos> llenaTiempo3() {
        List<Alimentos> lista = new ArrayList();
        Alimentos a = null;
        for (int i : alimentosSeleccionadosTiempo3) {
            a = lNAlimento.buscar(i);
            lista.add(a);
        }
        return lista;
    }

    public List<Alimentos> llenaTiempo4() {
        List<Alimentos> lista = new ArrayList();
        Alimentos a = null;
        for (int i : alimentosSeleccionadosTiempo4) {
            a = lNAlimento.buscar(i);
            lista.add(a);
        }
        return lista;
    }

    public List<Alimentos> llenaTiempo5() {
        List<Alimentos> lista = new ArrayList();
        Alimentos a = null;
        for (int i : alimentosSeleccionadosTiempo5) {
            a = lNAlimento.buscar(i);
            lista.add(a);
        }
        return lista;
    }

    public void kcXtiempo() {
        List<Alimentos> listaTiempo1 = llenaTiempo1();
        List<Alimentos> listaTiempo2 = llenaTiempo2();
        List<Alimentos> listaTiempo3 = llenaTiempo3();
        List<Alimentos> listaTiempo4 = llenaTiempo4();
        List<Alimentos> listaTiempo5 = llenaTiempo5();
        for (int i = 0; i < 14; i++) {
            kcXtiempo[0] += raciones.get(i).getTiempo_1() * raciones.get(i).getGpA().getEnergia() * listaTiempo1.get(i).getRacion();
            kcXtiempo[1] += raciones.get(i).getTiempo_2() * raciones.get(i).getGpA().getEnergia() * listaTiempo2.get(i).getRacion();
            kcXtiempo[2] += raciones.get(i).getTiempo_3() * raciones.get(i).getGpA().getEnergia() * listaTiempo3.get(i).getRacion();
            kcXtiempo[3] += raciones.get(i).getTiempo_4() * raciones.get(i).getGpA().getEnergia() * listaTiempo4.get(i).getRacion();
            kcXtiempo[4] += raciones.get(i).getTiempo_5() * raciones.get(i).getGpA().getEnergia() * listaTiempo5.get(i).getRacion();
        }
    }

    public void chXtiempo() {
        List<Alimentos> listaTiempo1 = llenaTiempo1();
        List<Alimentos> listaTiempo2 = llenaTiempo2();
        List<Alimentos> listaTiempo3 = llenaTiempo3();
        List<Alimentos> listaTiempo4 = llenaTiempo4();
        List<Alimentos> listaTiempo5 = llenaTiempo5();
        for (int i = 0; i < 14; i++) {
            chXtiempo[0] += raciones.get(i).getTiempo_1() * raciones.get(i).getGpA().getHidratos() * listaTiempo1.get(i).getRacion();
            chXtiempo[1] += raciones.get(i).getTiempo_2() * raciones.get(i).getGpA().getHidratos() * listaTiempo2.get(i).getRacion();
            chXtiempo[2] += raciones.get(i).getTiempo_3() * raciones.get(i).getGpA().getHidratos() * listaTiempo3.get(i).getRacion();
            chXtiempo[3] += raciones.get(i).getTiempo_4() * raciones.get(i).getGpA().getHidratos() * listaTiempo4.get(i).getRacion();
            chXtiempo[4] += raciones.get(i).getTiempo_5() * raciones.get(i).getGpA().getHidratos() * listaTiempo5.get(i).getRacion();
        }
    }

    public void proXtiempo() {
        List<Alimentos> listaTiempo1 = llenaTiempo1();
        List<Alimentos> listaTiempo2 = llenaTiempo2();
        List<Alimentos> listaTiempo3 = llenaTiempo3();
        List<Alimentos> listaTiempo4 = llenaTiempo4();
        List<Alimentos> listaTiempo5 = llenaTiempo5();
        for (int i = 0; i < 14; i++) {
            proXtiempo[0] += raciones.get(i).getTiempo_1() * raciones.get(i).getGpA().getProteinas() * listaTiempo1.get(i).getRacion();
            proXtiempo[1] += raciones.get(i).getTiempo_2() * raciones.get(i).getGpA().getProteinas() * listaTiempo2.get(i).getRacion();
            proXtiempo[2] += raciones.get(i).getTiempo_3() * raciones.get(i).getGpA().getProteinas() * listaTiempo3.get(i).getRacion();
            proXtiempo[3] += raciones.get(i).getTiempo_4() * raciones.get(i).getGpA().getProteinas() * listaTiempo4.get(i).getRacion();
            proXtiempo[4] += raciones.get(i).getTiempo_5() * raciones.get(i).getGpA().getProteinas() * listaTiempo5.get(i).getRacion();
        }
    }

    public void grasasXtiempo() {
        List<Alimentos> listaTiempo1 = llenaTiempo1();
        List<Alimentos> listaTiempo2 = llenaTiempo2();
        List<Alimentos> listaTiempo3 = llenaTiempo3();
        List<Alimentos> listaTiempo4 = llenaTiempo4();
        List<Alimentos> listaTiempo5 = llenaTiempo5();
        for (int i = 0; i < 14; i++) {
            grasasXtiempo[0] += raciones.get(i).getTiempo_1() * raciones.get(i).getGpA().getGrasas() * listaTiempo1.get(i).getRacion();
            grasasXtiempo[1] += raciones.get(i).getTiempo_2() * raciones.get(i).getGpA().getGrasas() * listaTiempo2.get(i).getRacion();
            grasasXtiempo[2] += raciones.get(i).getTiempo_3() * raciones.get(i).getGpA().getGrasas() * listaTiempo3.get(i).getRacion();
            grasasXtiempo[3] += raciones.get(i).getTiempo_4() * raciones.get(i).getGpA().getGrasas() * listaTiempo4.get(i).getRacion();
            grasasXtiempo[4] += raciones.get(i).getTiempo_5() * raciones.get(i).getGpA().getGrasas() * listaTiempo5.get(i).getRacion();
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

    public void limpiarListas() {
        alimentosSeleccionadosTiempo1.clear();
        alimentosSeleccionadosTiempo2.clear();
        alimentosSeleccionadosTiempo3.clear();
        alimentosSeleccionadosTiempo4.clear();
        alimentosSeleccionadosTiempo5.clear();
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
        limpiarListas();
    }

    public void setKcr(int cr) {
        kcr = cr;
    }

    public int getKcr() {
        return kcr;
    }

    public List<Alimentos> listar(int id) {
        return lNGrupoAlimentos.listar(id);
    }

}
