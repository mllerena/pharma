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
@Table(name = "r_resourceplancost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RResourceplancost.findAll", query = "SELECT r FROM RResourceplancost r"),
    @NamedQuery(name = "RResourceplancost.findByRResourceplancostId", query = "SELECT r FROM RResourceplancost r WHERE r.rResourceplancostId = :rResourceplancostId"),
    @NamedQuery(name = "RResourceplancost.findByIsactive", query = "SELECT r FROM RResourceplancost r WHERE r.isactive = :isactive"),
    @NamedQuery(name = "RResourceplancost.findByCreated", query = "SELECT r FROM RResourceplancost r WHERE r.created = :created"),
    @NamedQuery(name = "RResourceplancost.findByCreatedby", query = "SELECT r FROM RResourceplancost r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "RResourceplancost.findByUpdated", query = "SELECT r FROM RResourceplancost r WHERE r.updated = :updated"),
    @NamedQuery(name = "RResourceplancost.findByUpdatedby", query = "SELECT r FROM RResourceplancost r WHERE r.updatedby = :updatedby"),
    @NamedQuery(name = "RResourceplancost.findByCCosttypeId", query = "SELECT r FROM RResourceplancost r WHERE r.cCosttypeId = :cCosttypeId"),
    @NamedQuery(name = "RResourceplancost.findByPlancost", query = "SELECT r FROM RResourceplancost r WHERE r.plancost = :plancost"),
    @NamedQuery(name = "RResourceplancost.findByDescription", query = "SELECT r FROM RResourceplancost r WHERE r.description = :description"),
    @NamedQuery(name = "RResourceplancost.findByHelp", query = "SELECT r FROM RResourceplancost r WHERE r.help = :help")})
public class RResourceplancost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "r_resourceplancost_id")
    private String rResourceplancostId;
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
    @Size(min = 1, max = 32)
    @Column(name = "c_costtype_id")
    private String cCosttypeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plancost")
    private BigInteger plancost;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "s_resource_id", referencedColumnName = "s_resource_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private SResource sResourceId;

    public RResourceplancost() {
    }

    public RResourceplancost(String rResourceplancostId) {
        this.rResourceplancostId = rResourceplancostId;
    }

    public RResourceplancost(String rResourceplancostId, Character isactive, Date created, String createdby, Date updated, String updatedby, String cCosttypeId, BigInteger plancost) {
        this.rResourceplancostId = rResourceplancostId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.cCosttypeId = cCosttypeId;
        this.plancost = plancost;
    }

    public String getRResourceplancostId() {
        return rResourceplancostId;
    }

    public void setRResourceplancostId(String rResourceplancostId) {
        this.rResourceplancostId = rResourceplancostId;
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

    public String getCCosttypeId() {
        return cCosttypeId;
    }

    public void setCCosttypeId(String cCosttypeId) {
        this.cCosttypeId = cCosttypeId;
    }

    public BigInteger getPlancost() {
        return plancost;
    }

    public void setPlancost(BigInteger plancost) {
        this.plancost = plancost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
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

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public SResource getSResourceId() {
        return sResourceId;
    }

    public void setSResourceId(SResource sResourceId) {
        this.sResourceId = sResourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rResourceplancostId != null ? rResourceplancostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RResourceplancost)) {
            return false;
        }
        RResourceplancost other = (RResourceplancost) object;
        if ((this.rResourceplancostId == null && other.rResourceplancostId != null) || (this.rResourceplancostId != null && !this.rResourceplancostId.equals(other.rResourceplancostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.RResourceplancost[ rResourceplancostId=" + rResourceplancostId + " ]";
    }
    
}
