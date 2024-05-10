package com.tasks.psp.tasksmanager.models;

import java.time.LocalDate;
import java.util.Date;

public class JobTask {
    public String codTrabajo;

    public String categoria;

    public String descripcion;

    public String fecIni;

    public String fecFin;

    public float tiempo;

    public JobTask(){}

    public JobTask(String categoria, String descripcion, String fecIni){
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fecIni = fecIni;
    }

    public String getCodTrabajo(){
        return this.codTrabajo;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public String getDescripcion(){return this.descripcion;}
}
