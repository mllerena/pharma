/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
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
@Table(name = "c_bpartner_discount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpartnerDiscount.findAll", query = "SELECT c FROM CBpartnerDiscount c"),
    @NamedQuery(name = "CBpartnerDiscount.findByCBpartnerDiscountId", query = "SELECT c FROM CBpartnerDiscount c WHERE c.cBpartnerDiscountId = :cBpartnerDiscountId"),
    @NamedQuery(name = "CBpartnerDiscount.findByIsactive", query = "SELECT c FROM CBpartnerDiscount c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpartnerDiscount.findByCreated", query = "SELECT c FROM CBpartnerDiscount c WHERE c.created = :created"),
    @NamedQuery(name = "CBpartnerDiscount.findByCreatedby", query = "SELECT c FROM CBpartnerDiscount c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpartnerDiscount.findByUpdated", query = "SELECT c FROM CBpartnerDiscount c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpartnerDiscount.findByUpdatedby", query = "SELECT c FROM CBpartnerDiscount c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpartnerDiscount.findByLine", query = "SELECT c FROM CBpartnerDiscount c WHERE c.line = :line"),
    @NamedQuery(name = "CBpartnerDiscount.findByCascade", query = "SELECT c FROM CBpartnerDiscount c WHERE c.cascade = :cascade"),
    @NamedQuery(name = "CBpartnerDiscount.findByIscustomer", query = "SELECT c FROM CBpartnerDiscount c WHERE c.iscustomer = :iscustomer"),
    @NamedQuery(name = "CBpartnerDiscount.findByIsvendor", query = "SELECT c FROM CBpartnerDiscount c WHERE c.isvendor = :isvendor"),
    @NamedQuery(name = "CBpartnerDiscount.findByApplyinorder", query = "SELECT c FROM CBpartnerDiscount c WHERE c.applyinorder = :applyinorder")})
public class CBpartnerDiscount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bpartner_discount_id")
    private String cBpartnerDiscountId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscustomer")
    private Character iscustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isvendor")
    private Character isvendor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "applyinorder")
    private Character applyinorder;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_discount_id", referencedColumnName = "c_discount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDiscount cDiscountId;

    public CBpartnerDiscount() {
    }

    public CBpartnerDiscount(String cBpartnerDiscountId) {
        this.cBpartnerDiscountId = cBpartnerDiscountId;
    }

    public CBpartnerDiscount(String cBpartnerDiscountId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, Character cascade, Character iscustomer, Character isvendor, Character applyinorder) {
        this.cBpartnerDiscountId = cBpartnerDiscountId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.cascade = cascade;
        this.iscustomer = iscustomer;
        this.isvendor = isvendor;
        this.applyinorder = applyinorder;
    }

    public String getCBpartnerDiscountId() {
        return cBpartnerDiscountId;
    }

    public void setCBpartnerDiscountId(String cBpartnerDiscountId) {
        this.cBpartnerDiscountId = cBpartnerDiscountId;
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

    public Character getIscustomer() {
        return iscustomer;
    }

    public void setIscustomer(Character iscustomer) {
        this.iscustomer = iscustomer;
    }

    public Character getIsvendor() {
        return isvendor;
    }

    public void setIsvendor(Character isvendor) {
        this.isvendor = isvendor;
    }

    public Character getApplyinorder() {
        return applyinorder;
    }

    public void setApplyinorder(Character applyinorder) {
        this.applyinorder = applyinorder;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CDiscount getCDiscountId() {
        return cDiscountId;
    }

    public void setCDiscountId(CDiscount cDiscountId) {
        this.cDiscountId = cDiscountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpartnerDiscountId != null ? cBpartnerDiscountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpartnerDiscount)) {
            return false;
        }
        CBpartnerDiscount other = (CBpartnerDiscount) object;
        if ((this.cBpartnerDiscountId == null && other.cBpartnerDiscountId != null) || (this.cBpartnerDiscountId != null && !this.cBpartnerDiscountId.equals(other.cBpartnerDiscountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpartnerDiscount[ cBpartnerDiscountId=" + cBpartnerDiscountId + " ]";
    }
    
}
