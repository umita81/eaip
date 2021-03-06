/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.sys.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "sys_menuprin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysMenuprin.findAll", query = "SELECT s FROM SysMenuprin s"),
    @NamedQuery(name = "SysMenuprin.findByMenId", query = "SELECT s FROM SysMenuprin s WHERE s.menId = :menId"),
    @NamedQuery(name = "SysMenuprin.findByMenNombre", query = "SELECT s FROM SysMenuprin s WHERE s.menNombre = :menNombre"),
    @NamedQuery(name = "SysMenuprin.findByMenDesc", query = "SELECT s FROM SysMenuprin s WHERE s.menDesc = :menDesc"),
    @NamedQuery(name = "SysMenuprin.menxFrn", query = "SELECT s FROM SysMenuprin s WHERE  s.menId IN ( SELECT DISTINCT s.menId FROM SysMenuprin m JOIN m.sysModulosList msm JOIN msm.sysSubmodprocList msmp JOIN msmp.sysSubmodxfrnList msxf JOIN msxf.frnId frn WHERE frn.frnId = :frnId) AND s.menEst = :menEst ORDER BY s.menOrden ASC")})

public class SysMenuprin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_id")
    private Integer menId;
    @Size(max = 250)
    @Column(name = "men_nombre")
    private String menNombre;
    @Size(max = 2147483647)
    @Column(name = "men_desc")
    private String menDesc;
    @Column(name = "men_est")
    private Boolean menEst;
    @Column(name = "indversion")
    @Version
    private Integer indversion;
    @Column(name = "men_orden")
    private Integer menOrden;
    @OneToMany(mappedBy = "menId")

    private List<SysModulos> sysModulosList;

    public SysMenuprin() {
    }

    public SysMenuprin(Integer menId) {
        this.menId = menId;
    }

    public Integer getMenId() {
        return menId;
    }

    public void setMenId(Integer menId) {
        this.menId = menId;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public String getMenDesc() {
        return menDesc;
    }

    public void setMenDesc(String menDesc) {
        this.menDesc = menDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menId != null ? menId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysMenuprin)) {
            return false;
        }
        SysMenuprin other = (SysMenuprin) object;
        if ((this.menId == null && other.menId != null) || (this.menId != null && !this.menId.equals(other.menId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.SysMenuprin[ menId=" + menId + " ]";
    }

    /**
     * @return the sysModulosList
     */
    public List<SysModulos> getSysModulosList() {
        return sysModulosList;
    }

    /**
     * @param sysModulosList the sysModulosList to set
     */
    public void setSysModulosList(List<SysModulos> sysModulosList) {
        this.sysModulosList = sysModulosList;
    }

    /**
     * @return the menEst
     */
    public Boolean getMenEst() {
        return menEst;
    }

    /**
     * @param menEst the menEst to set
     */
    public void setMenEst(Boolean menEst) {
        this.menEst = menEst;
    }

    /**
     * @return the indversion
     */
    public Integer getIndversion() {
        return indversion;
    }

    /**
     * @param indversion the indversion to set
     */
    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    /**
     * @return the menOrden
     */
    public Integer getMenOrden() {
        return menOrden;
    }

    /**
     * @param menOrden the menOrden to set
     */
    public void setMenOrden(Integer menOrden) {
        this.menOrden = menOrden;
    }
}
