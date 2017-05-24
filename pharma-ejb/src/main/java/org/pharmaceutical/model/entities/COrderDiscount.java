/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "c_order_discount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "COrderDiscount.findAll", query = "SELECT c FROM COrderDiscount c"),
    @NamedQuery(name = "COrderDiscount.findByCOrderDiscountId", query = "SELECT c FROM COrderDiscount c WHERE c.cOrderDiscountId = :cOrderDiscountId"),
    @NamedQuery(name = "COrderDiscount.findByIsactive", query = "SELECT c FROM COrderDiscount c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "COrderDiscount.findByCreated", query = "SELECT c FROM COrderDiscount c WHERE c.created = :created"),
    @NamedQuery(name = "COrderDiscount.findByCreatedby", query = "SELECT c FROM COrderDiscount c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "COrderDiscount.findByUpdated", query = "SELECT c FROM COrderDiscount c WHERE c.updated = :updated"),
    @NamedQuery(name = "COrderDiscount.findByUpdatedby", query = "SELECT c FROM COrderDiscount c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "COrderDiscount.findByLine", query = "SELECT c FROM COrderDiscount c WHERE c.line = :line"),
    @NamedQuery(name = "COrderDiscount.findByCascade", query = "SELECT c FROM COrderDiscount c WHERE c.cascade = :cascade")})
public class COrderDiscount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_order_discount_id")
    private String cOrderDiscountId;
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
    @Column(name = "cascade")
    private Character cascade;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_discount_id", referencedColumnName = "c_discount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDiscount cDiscountId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private COrder cOrderId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderDiscountId")
    private List<COrderline> cOrderlineList;

    public COrderDiscount() {
    }

    public COrderDiscount(String cOrderDiscountId) {
        this.cOrderDiscountId = cOrderDiscountId;
    }

    public COrderDiscount(String cOrderDiscountId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, Character cascade) {
        this.cOrderDiscountId = cOrderDiscountId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.cascade = cascade;
    }

    public String getCOrderDiscountId() {
        return cOrderDiscountId;
    }

    public void setCOrderDiscountId(String cOrderDiscountId) {
        this.cOrderDiscountId = cOrderDiscountId;
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

    public Character getCascade() {
        return cascade;
    }

    public void setCascade(Character cascade) {
        this.cascade = cascade;
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

    public CDiscount getCDiscountId() {
        return cDiscountId;
    }

    public void setCDiscountId(CDiscount cDiscountId) {
        this.cDiscountId = cDiscountId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cOrderDiscountId != null ? cOrderDiscountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof COrderDiscount)) {
            return false;
        }
        COrderDiscount other = (COrderDiscount) object;
        if ((this.cOrderDiscountId == null && other.cOrderDiscountId != null) || (this.cOrderDiscountId != null && !this.cOrderDiscountId.equals(other.cOrderDiscountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.COrderDiscount[ cOrderDiscountId=" + cOrderDiscountId + " ]";
    }
    
}
