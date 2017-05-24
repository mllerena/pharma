/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "mrp_planningmethodline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrpPlanningmethodline.findAll", query = "SELECT m FROM MrpPlanningmethodline m"),
    @NamedQuery(name = "MrpPlanningmethodline.findByMrpPlanningmethodlineId", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.mrpPlanningmethodlineId = :mrpPlanningmethodlineId"),
    @NamedQuery(name = "MrpPlanningmethodline.findByIsactive", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MrpPlanningmethodline.findByCreated", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.created = :created"),
    @NamedQuery(name = "MrpPlanningmethodline.findByCreatedby", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MrpPlanningmethodline.findByUpdated", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MrpPlanningmethodline.findByUpdatedby", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MrpPlanningmethodline.findByLine", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.line = :line"),
    @NamedQuery(name = "MrpPlanningmethodline.findByInouttrxtype", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.inouttrxtype = :inouttrxtype"),
    @NamedQuery(name = "MrpPlanningmethodline.findByWeighting", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.weighting = :weighting"),
    @NamedQuery(name = "MrpPlanningmethodline.findByDaysfrom", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.daysfrom = :daysfrom"),
    @NamedQuery(name = "MrpPlanningmethodline.findByDaysto", query = "SELECT m FROM MrpPlanningmethodline m WHERE m.daysto = :daysto")})
public class MrpPlanningmethodline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mrp_planningmethodline_id")
    private String mrpPlanningmethodlineId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line")
    private long line;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "inouttrxtype")
    private String inouttrxtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weighting")
    private BigInteger weighting;
    @Column(name = "daysfrom")
    private BigInteger daysfrom;
    @Column(name = "daysto")
    private BigInteger daysto;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "mrp_planningmethod_id", referencedColumnName = "mrp_planningmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MrpPlanningmethod mrpPlanningmethodId;

    public MrpPlanningmethodline() {
    }

    public MrpPlanningmethodline(String mrpPlanningmethodlineId) {
        this.mrpPlanningmethodlineId = mrpPlanningmethodlineId;
    }

    public MrpPlanningmethodline(String mrpPlanningmethodlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, String inouttrxtype, BigInteger weighting) {
        this.mrpPlanningmethodlineId = mrpPlanningmethodlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.inouttrxtype = inouttrxtype;
        this.weighting = weighting;
    }

    public String getMrpPlanningmethodlineId() {
        return mrpPlanningmethodlineId;
    }

    public void setMrpPlanningmethodlineId(String mrpPlanningmethodlineId) {
        this.mrpPlanningmethodlineId = mrpPlanningmethodlineId;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public String getInouttrxtype() {
        return inouttrxtype;
    }

    public void setInouttrxtype(String inouttrxtype) {
        this.inouttrxtype = inouttrxtype;
    }

    public BigInteger getWeighting() {
        return weighting;
    }

    public void setWeighting(BigInteger weighting) {
        this.weighting = weighting;
    }

    public BigInteger getDaysfrom() {
        return daysfrom;
    }

    public void setDaysfrom(BigInteger daysfrom) {
        this.daysfrom = daysfrom;
    }

    public BigInteger getDaysto() {
        return daysto;
    }

    public void setDaysto(BigInteger daysto) {
        this.daysto = daysto;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public MrpPlanningmethod getMrpPlanningmethodId() {
        return mrpPlanningmethodId;
    }

    public void setMrpPlanningmethodId(MrpPlanningmethod mrpPlanningmethodId) {
        this.mrpPlanningmethodId = mrpPlanningmethodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mrpPlanningmethodlineId != null ? mrpPlanningmethodlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrpPlanningmethodline)) {
            return false;
        }
        MrpPlanningmethodline other = (MrpPlanningmethodline) object;
        if ((this.mrpPlanningmethodlineId == null && other.mrpPlanningmethodlineId != null) || (this.mrpPlanningmethodlineId != null && !this.mrpPlanningmethodlineId.equals(other.mrpPlanningmethodlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MrpPlanningmethodline[ mrpPlanningmethodlineId=" + mrpPlanningmethodlineId + " ]";
    }
    
}
