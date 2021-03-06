/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.sys.dao;

import com.veeduria.adm.dao.AdmEntidad;
import com.veeduria.adm.dao.AdmSectorestruc;
import com.veeduria.adm.dao.AdmUnidadejec;
import com.veeduria.pla.dao.PlaDistritoind;
import com.veeduria.pla.dao.PlaGeneralsec;
import com.veeduria.pla.dao.PlaLocalidades;
import com.veeduria.pre.dao.PreCmgasto;
import com.veeduria.pre.dao.PreCmgastoinicial;
import com.veeduria.pre.dao.PreCmingreso;
import com.veeduria.pre.dao.PreCmreserva;
import com.veeduria.pre.dao.PreConcmsaldosmovs;
import com.veeduria.pre.dao.PreConoperarecipro;
import com.veeduria.thm.dao.ThmCarrdocente;
import com.veeduria.thm.dao.ThmContratistas;
import com.veeduria.thm.dao.ThmEmpleados;
import com.veeduria.thm.dao.ThmSupernumerarios;
import com.veeduria.thm.dao.ThmTemporal;
import com.veeduria.thm.dao.ThmTrabajoficiales;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "sys_registrocarga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysRegistrocarga.findAll", query = "SELECT s FROM SysRegistrocarga s"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregId", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregId = :lgregId"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregNomarchivo", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregNomarchivo = :lgregNomarchivo"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregRutaarchivo", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregRutaarchivo = :lgregRutaarchivo"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregFechacarga", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregFechacarga = :lgregFechacarga"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregEstado", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregEstado = :lgregEstado"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregMensajecarga", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregMensajecarga = :lgregMensajecarga"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregPeriodo", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregPeriodo = :lgregPeriodo"),
    @NamedQuery(name = "SysRegistrocarga.nomarchcargaporIdcarga", query = "SELECT count (s.lgregId) FROM SysRegistrocarga s WHERE s.lgregNomarchivocarga = :lgregNomarchivocarga AND s.lgregIdmsjcarga = :lgregIdmsjcarga"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregTipomensaje", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregTipomensaje = :lgregTipomensaje"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregNomarchivocarga", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregNomarchivocarga = :lgregNomarchivocarga"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregIdmsjcarga", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregIdmsjcarga = :lgregIdmsjcarga"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregValidado", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregValidado = :lgregValidado"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregCorregido", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregCorregido = :lgregCorregido"),
    @NamedQuery(name = "SysRegistrocarga.findByLgregAceptado", query = "SELECT s FROM SysRegistrocarga s WHERE s.lgregAceptado = :lgregAceptado"),
    @NamedQuery(name = "SysRegistrocarga.sysRegConLogInc", query = "SELECT src FROM SysRegistrocarga src WHERE src.lgregId IN( SELECT DISTINCT s.lgregId FROM SysRegistrocarga s  JOIN s.preCmgastoinicialList gin JOIN gin.preCmgastoinconsistenciaList inc JOIN inc.admLoginconsistenciasList li  WHERE li.logAplicado = :logAplicado )")
})

public class SysRegistrocarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "sys_registrocarga_lgreg_id_seq",sequenceName = "sys_registrocarga_lgreg_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sys_registrocarga_lgreg_id_seq")
    @Basic(optional = false)
    @Column(name = "lgreg_id")
    private Long lgregId;
    @Size(max = 300)
    @Column(name = "lgreg_nomarchivo")
    private String lgregNomarchivo;
    @Size(max = 1500)
    @Column(name = "lgreg_rutaarchivo")
    private String lgregRutaarchivo;
    @Column(name = "lgreg_fechacarga")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lgregFechacarga;
    @Column(name = "lgreg_estado")
    private Boolean lgregEstado;
    @Size(max = 2147483647)
    @Column(name = "lgreg_mensajecarga")
    private String lgregMensajecarga;
    @Column(name = "lgreg_periodo")
    @Temporal(TemporalType.DATE)
    private Date lgregPeriodo;
    @Size(max = 50)
    @Column(name = "lgreg_tipomensaje")
    private String lgregTipomensaje;
    @Size(max = 300)
    @Column(name = "lgreg_nomarchivocarga")
    private String lgregNomarchivocarga;
    @Column(name = "lgreg_idmsjcarga")
    private Integer lgregIdmsjcarga;
    @Column(name = "lgreg_validado")
    private Boolean lgregValidado;
    @Column(name = "lgreg_corregido")
    private Boolean lgregCorregido;
    @Column(name = "lgreg_aceptado")
    private Boolean lgregAceptado;
    @OneToMany(mappedBy = "lgregId")
    private List<PreConcmsaldosmovs> preConcmsaldosmovsList;
    @OneToMany(mappedBy = "lgregId")
    private List<ThmEmpleados> thmEmpleadosList;
    @OneToMany(mappedBy = "lgregId")
    private List<ThmTrabajoficiales> thmTrabajoficialesList;
    @OneToMany(mappedBy = "lgregId")
    private List<PreCmingreso> preCmingresoList;
    @OneToMany(mappedBy = "lgregId")
    private List<PreConoperarecipro> preConoperareciproList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgregId")
    private List<PlaGeneralsec> plaGeneralsecList;
    @OneToMany(mappedBy = "lgregId")
    private List<PreCmgastoinicial> preCmgastoinicialList;
    @OneToMany(mappedBy = "lgregId")
    private List<ThmContratistas> thmContratistasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgregId")
    private List<PlaLocalidades> plaLocalidadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgregId")
    private List<PlaDistritoind> plaDistritoindList;
    @OneToMany(mappedBy = "lgregId")
    private List<ThmCarrdocente> thmCarrdocenteList;
    @OneToMany(mappedBy = "lgregId")
    private List<PreCmreserva> preCmreservaList;
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne
    private AdmEntidad entId;
    @JoinColumn(name = "ses_id", referencedColumnName = "ses_id")
    @ManyToOne
    private AdmSectorestruc sesId;
    @JoinColumn(name = "eje_codigo", referencedColumnName = "eje_codigo")
    @ManyToOne
    private AdmUnidadejec ejeCodigo;
    @JoinColumn(name = "frn_id", referencedColumnName = "frn_id")
    @ManyToOne
    private SysFuncionario frnId;
    @OneToMany(mappedBy = "lgregId")
    private List<ThmSupernumerarios> thmSupernumerariosList;
    @OneToMany(mappedBy = "lgregId")
    private List<ThmTemporal> thmTemporalList;
    @OneToMany(mappedBy = "lgregId")
    private List<PreCmgasto> preCmgastoList;

    public SysRegistrocarga() {
    }

    public SysRegistrocarga(Long lgregId) {
        this.lgregId = lgregId;
    }

    public Long getLgregId() {
        return lgregId;
    }

    public void setLgregId(Long lgregId) {
        this.lgregId = lgregId;
    }

    public String getLgregNomarchivo() {
        return lgregNomarchivo;
    }

    public void setLgregNomarchivo(String lgregNomarchivo) {
        this.lgregNomarchivo = lgregNomarchivo;
    }

    public String getLgregRutaarchivo() {
        return lgregRutaarchivo;
    }

    public void setLgregRutaarchivo(String lgregRutaarchivo) {
        this.lgregRutaarchivo = lgregRutaarchivo;
    }

    public Date getLgregFechacarga() {
        return lgregFechacarga;
    }

    public void setLgregFechacarga(Date lgregFechacarga) {
        this.lgregFechacarga = lgregFechacarga;
    }

    public Boolean getLgregEstado() {
        return lgregEstado;
    }

    public void setLgregEstado(Boolean lgregEstado) {
        this.lgregEstado = lgregEstado;
    }

    public String getLgregMensajecarga() {
        return lgregMensajecarga;
    }

    public void setLgregMensajecarga(String lgregMensajecarga) {
        this.lgregMensajecarga = lgregMensajecarga;
    }

    public Date getLgregPeriodo() {
        return lgregPeriodo;
    }

    public void setLgregPeriodo(Date lgregPeriodo) {
        this.lgregPeriodo = lgregPeriodo;
    }

    public String getLgregTipomensaje() {
        return lgregTipomensaje;
    }

    public void setLgregTipomensaje(String lgregTipomensaje) {
        this.lgregTipomensaje = lgregTipomensaje;
    }

    public String getLgregNomarchivocarga() {
        return lgregNomarchivocarga;
    }

    public void setLgregNomarchivocarga(String lgregNomarchivocarga) {
        this.lgregNomarchivocarga = lgregNomarchivocarga;
    }

    public Integer getLgregIdmsjcarga() {
        return lgregIdmsjcarga;
    }

    public void setLgregIdmsjcarga(Integer lgregIdmsjcarga) {
        this.lgregIdmsjcarga = lgregIdmsjcarga;
    }

    public Boolean getLgregValidado() {
        return lgregValidado;
    }

    public void setLgregValidado(Boolean lgregValidado) {
        this.lgregValidado = lgregValidado;
    }

    public Boolean getLgregCorregido() {
        return lgregCorregido;
    }

    public void setLgregCorregido(Boolean lgregCorregido) {
        this.lgregCorregido = lgregCorregido;
    }

    public Boolean getLgregAceptado() {
        return lgregAceptado;
    }

    public void setLgregAceptado(Boolean lgregAceptado) {
        this.lgregAceptado = lgregAceptado;
    }

    @XmlTransient
    public List<PreConcmsaldosmovs> getPreConcmsaldosmovsList() {
        return preConcmsaldosmovsList;
    }

    public void setPreConcmsaldosmovsList(List<PreConcmsaldosmovs> preConcmsaldosmovsList) {
        this.preConcmsaldosmovsList = preConcmsaldosmovsList;
    }

    @XmlTransient
    public List<ThmEmpleados> getThmEmpleadosList() {
        return thmEmpleadosList;
    }

    public void setThmEmpleadosList(List<ThmEmpleados> thmEmpleadosList) {
        this.thmEmpleadosList = thmEmpleadosList;
    }

    @XmlTransient
    public List<ThmTrabajoficiales> getThmTrabajoficialesList() {
        return thmTrabajoficialesList;
    }

    public void setThmTrabajoficialesList(List<ThmTrabajoficiales> thmTrabajoficialesList) {
        this.thmTrabajoficialesList = thmTrabajoficialesList;
    }

    @XmlTransient
    public List<PreCmingreso> getPreCmingresoList() {
        return preCmingresoList;
    }

    public void setPreCmingresoList(List<PreCmingreso> preCmingresoList) {
        this.preCmingresoList = preCmingresoList;
    }

    @XmlTransient
    public List<PreConoperarecipro> getPreConoperareciproList() {
        return preConoperareciproList;
    }

    public void setPreConoperareciproList(List<PreConoperarecipro> preConoperareciproList) {
        this.preConoperareciproList = preConoperareciproList;
    }

    @XmlTransient
    public List<PlaGeneralsec> getPlaGeneralsecList() {
        return plaGeneralsecList;
    }

    public void setPlaGeneralsecList(List<PlaGeneralsec> plaGeneralsecList) {
        this.plaGeneralsecList = plaGeneralsecList;
    }

    @XmlTransient
    public List<PreCmgastoinicial> getPreCmgastoinicialList() {
        return preCmgastoinicialList;
    }

    public void setPreCmgastoinicialList(List<PreCmgastoinicial> preCmgastoinicialList) {
        this.preCmgastoinicialList = preCmgastoinicialList;
    }

    @XmlTransient
    public List<ThmContratistas> getThmContratistasList() {
        return thmContratistasList;
    }

    public void setThmContratistasList(List<ThmContratistas> thmContratistasList) {
        this.thmContratistasList = thmContratistasList;
    }

    @XmlTransient
    public List<PlaLocalidades> getPlaLocalidadesList() {
        return plaLocalidadesList;
    }

    public void setPlaLocalidadesList(List<PlaLocalidades> plaLocalidadesList) {
        this.plaLocalidadesList = plaLocalidadesList;
    }

    @XmlTransient
    public List<PlaDistritoind> getPlaDistritoindList() {
        return plaDistritoindList;
    }

    public void setPlaDistritoindList(List<PlaDistritoind> plaDistritoindList) {
        this.plaDistritoindList = plaDistritoindList;
    }

    @XmlTransient
    public List<ThmCarrdocente> getThmCarrdocenteList() {
        return thmCarrdocenteList;
    }

    public void setThmCarrdocenteList(List<ThmCarrdocente> thmCarrdocenteList) {
        this.thmCarrdocenteList = thmCarrdocenteList;
    }

    @XmlTransient
    public List<PreCmreserva> getPreCmreservaList() {
        return preCmreservaList;
    }

    public void setPreCmreservaList(List<PreCmreserva> preCmreservaList) {
        this.preCmreservaList = preCmreservaList;
    }

    public AdmEntidad getEntId() {
        return entId;
    }

    public void setEntId(AdmEntidad entId) {
        this.entId = entId;
    }

    public AdmSectorestruc getSesId() {
        return sesId;
    }

    public void setSesId(AdmSectorestruc sesId) {
        this.sesId = sesId;
    }

    public AdmUnidadejec getEjeCodigo() {
        return ejeCodigo;
    }

    public void setEjeCodigo(AdmUnidadejec ejeCodigo) {
        this.ejeCodigo = ejeCodigo;
    }

    public SysFuncionario getFrnId() {
        return frnId;
    }

    public void setFrnId(SysFuncionario frnId) {
        this.frnId = frnId;
    }

    @XmlTransient
    public List<ThmSupernumerarios> getThmSupernumerariosList() {
        return thmSupernumerariosList;
    }

    public void setThmSupernumerariosList(List<ThmSupernumerarios> thmSupernumerariosList) {
        this.thmSupernumerariosList = thmSupernumerariosList;
    }

    @XmlTransient
    public List<ThmTemporal> getThmTemporalList() {
        return thmTemporalList;
    }

    public void setThmTemporalList(List<ThmTemporal> thmTemporalList) {
        this.thmTemporalList = thmTemporalList;
    }

    @XmlTransient
    public List<PreCmgasto> getPreCmgastoList() {
        return preCmgastoList;
    }

    public void setPreCmgastoList(List<PreCmgasto> preCmgastoList) {
        this.preCmgastoList = preCmgastoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgregId != null ? lgregId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysRegistrocarga)) {
            return false;
        }
        SysRegistrocarga other = (SysRegistrocarga) object;
        return !((this.lgregId == null && other.lgregId != null) || (this.lgregId != null && !this.lgregId.equals(other.lgregId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.sys.dao.SysRegistrocarga[ lgregId=" + lgregId + " ]";
    }

}
