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
@Table(name = "c_orderlinetax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "COrderlinetax.findAll", query = "SELECT c FROM COrderlinetax c"),
    @NamedQuery(name = "COrderlinetax.findByCOrderlinetaxId", query = "SELECT c FROM COrderlinetax c WHERE c.cOrderlinetaxId = :cOrderlinetaxId"),
    @NamedQuery(name = "COrderlinetax.findByIsactive", query = "SELECT c FROM COrderlinetax c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "COrderlinetax.findByCreated", query = "SELECT c FROM COrderlinetax c WHERE c.created = :created"),
    @NamedQuery(name = "COrderlinetax.findByCreatedby", query = "SELECT c FROM COrderlinetax c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "COrderlinetax.findByUpdated", query = "SELECT c FROM COrderlinetax c WHERE c.updated = :updated"),
    @NamedQuery(name = "COrderlinetax.findByUpdatedby", query = "SELECT c FROM COrderlinetax c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "COrderlinetax.findByTaxbaseamt", query = "SELECT c FROM COrderlinetax c WHERE c.taxbaseamt = :taxbaseamt"),
    @NamedQuery(name = "COrderlinetax.findByTaxamt", query = "SELECT c FROM COrderlinetax c WHERE c.taxamt = :taxamt"),
    @NamedQuery(name = "COrderlinetax.findByLine", query = "SELECT c FROM COrderlinetax c WHERE c.line = :line")})
public class COrderlinetax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_orderlinetax_id")
    private String cOrderlinetaxId;
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
    @Column(name = "taxbaseamt")
    private BigInteger taxbaseamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxamt")
    private BigInteger taxamt;
    @Column(name = "line")
    private BigInteger line;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @JoinColumn(name = "c_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private COrderline cOrderlineId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTax cTaxId;

    public COrderlinetax() {
    }

    public COrderlinetax(String cOrderlinetaxId) {
        this.cOrderlinetaxId = cOrderlinetaxId;
    }

    public COrderlinetax(String cOrderlinetaxId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger taxbaseamt, BigInteger taxamt) {
        this.cOrderlinetaxId = cOrderlinetaxId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.taxbaseamt = taxbaseamt;
        this.taxamt = taxamt;
    }

    public String getCOrderlinetaxId() {
        return cOrderlinetaxId;
    }

    public void setCOrderlinetaxId(String cOrderlinetaxId) {
        this.cOrderlinetaxId = cOrderlinetaxId;
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

    public BigInteger getTaxbaseamt() {
        return taxbaseamt;
    }

    public void setTaxbaseamt(BigInteger taxbaseamt) {
        this.taxbaseamt = taxbaseamt;
    }

    public BigInteger getTaxamt() {
        return taxamt;
    }

    public void setTaxamt(BigInteger taxamt) {
        this.taxamt = taxamt;
    }

    public BigInteger getLine() {
        return line;
    }

    public void setLine(BigInteger line) {
        this.line = line;
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

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    public COrderline getCOrderlineId() {
        return cOrderlineId;
    }

    public void setCOrderlineId(COrderline cOrderlineId) {
        this.cOrderlineId = cOrderlineId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cOrderlinetaxId != null ? cOrderlinetaxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof COrderlinetax)) {
            return false;
        }
        COrderlinetax other = (COrderlinetax) object;
        if ((this.cOrderlinetaxId == null && other.cOrderlinetaxId != null) || (this.cOrderlinetaxId != null && !this.cOrderlinetaxId.equals(other.cOrderlinetaxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.COrderlinetax[ cOrderlinetaxId=" + cOrderlinetaxId + " ]";
    }
    
}
