/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "c_invoiceschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CInvoiceschedule.findAll", query = "SELECT c FROM CInvoiceschedule c"),
    @NamedQuery(name = "CInvoiceschedule.findByCInvoicescheduleId", query = "SELECT c FROM CInvoiceschedule c WHERE c.cInvoicescheduleId = :cInvoicescheduleId"),
    @NamedQuery(name = "CInvoiceschedule.findByIsactive", query = "SELECT c FROM CInvoiceschedule c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CInvoiceschedule.findByCreated", query = "SELECT c FROM CInvoiceschedule c WHERE c.created = :created"),
    @NamedQuery(name = "CInvoiceschedule.findByCreatedby", query = "SELECT c FROM CInvoiceschedule c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CInvoiceschedule.findByUpdated", query = "SELECT c FROM CInvoiceschedule c WHERE c.updated = :updated"),
    @NamedQuery(name = "CInvoiceschedule.findByUpdatedby", query = "SELECT c FROM CInvoiceschedule c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CInvoiceschedule.findByName", query = "SELECT c FROM CInvoiceschedule c WHERE c.name = :name"),
    @NamedQuery(name = "CInvoiceschedule.findByDescription", query = "SELECT c FROM CInvoiceschedule c WHERE c.description = :description"),
    @NamedQuery(name = "CInvoiceschedule.findByIsamount", query = "SELECT c FROM CInvoiceschedule c WHERE c.isamount = :isamount"),
    @NamedQuery(name = "CInvoiceschedule.findByAmt", query = "SELECT c FROM CInvoiceschedule c WHERE c.amt = :amt"),
    @NamedQuery(name = "CInvoiceschedule.findByInvoicefrequency", query = "SELECT c FROM CInvoiceschedule c WHERE c.invoicefrequency = :invoicefrequency"),
    @NamedQuery(name = "CInvoiceschedule.findByInvoiceweekday", query = "SELECT c FROM CInvoiceschedule c WHERE c.invoiceweekday = :invoiceweekday"),
    @NamedQuery(name = "CInvoiceschedule.findByInvoiceweekdaycutoff", query = "SELECT c FROM CInvoiceschedule c WHERE c.invoiceweekdaycutoff = :invoiceweekdaycutoff"),
    @NamedQuery(name = "CInvoiceschedule.findByEveninvoiceweek", query = "SELECT c FROM CInvoiceschedule c WHERE c.eveninvoiceweek = :eveninvoiceweek"),
    @NamedQuery(name = "CInvoiceschedule.findByInvoiceday", query = "SELECT c FROM CInvoiceschedule c WHERE c.invoiceday = :invoiceday"),
    @NamedQuery(name = "CInvoiceschedule.findByInvoicedaycutoff", query = "SELECT c FROM CInvoiceschedule c WHERE c.invoicedaycutoff = :invoicedaycutoff"),
    @NamedQuery(name = "CInvoiceschedule.findByIsdefault", query = "SELECT c FROM CInvoiceschedule c WHERE c.isdefault = :isdefault")})
public class CInvoiceschedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_invoiceschedule_id")
    private String cInvoicescheduleId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isamount")
    private Character isamount;
    @Column(name = "amt")
    private BigInteger amt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "invoicefrequency")
    private String invoicefrequency;
    @Size(max = 60)
    @Column(name = "invoiceweekday")
    private String invoiceweekday;
    @Size(max = 60)
    @Column(name = "invoiceweekdaycutoff")
    private String invoiceweekdaycutoff;
    @Column(name = "eveninvoiceweek")
    private Character eveninvoiceweek;
    @Column(name = "invoiceday")
    private Long invoiceday;
    @Column(name = "invoicedaycutoff")
    private Long invoicedaycutoff;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoicescheduleId")
    private List<CBpartner> cBpartnerList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public CInvoiceschedule() {
    }

    public CInvoiceschedule(String cInvoicescheduleId) {
        this.cInvoicescheduleId = cInvoicescheduleId;
    }

    public CInvoiceschedule(String cInvoicescheduleId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isamount, String invoicefrequency, Character isdefault) {
        this.cInvoicescheduleId = cInvoicescheduleId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isamount = isamount;
        this.invoicefrequency = invoicefrequency;
        this.isdefault = isdefault;
    }

    public String getCInvoicescheduleId() {
        return cInvoicescheduleId;
    }

    public void setCInvoicescheduleId(String cInvoicescheduleId) {
        this.cInvoicescheduleId = cInvoicescheduleId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIsamount() {
        return isamount;
    }

    public void setIsamount(Character isamount) {
        this.isamount = isamount;
    }

    public BigInteger getAmt() {
        return amt;
    }

    public void setAmt(BigInteger amt) {
        this.amt = amt;
    }

    public String getInvoicefrequency() {
        return invoicefrequency;
    }

    public void setInvoicefrequency(String invoicefrequency) {
        this.invoicefrequency = invoicefrequency;
    }

    public String getInvoiceweekday() {
        return invoiceweekday;
    }

    public void setInvoiceweekday(String invoiceweekday) {
        this.invoiceweekday = invoiceweekday;
    }

    public String getInvoiceweekdaycutoff() {
        return invoiceweekdaycutoff;
    }

    public void setInvoiceweekdaycutoff(String invoiceweekdaycutoff) {
        this.invoiceweekdaycutoff = invoiceweekdaycutoff;
    }

    public Character getEveninvoiceweek() {
        return eveninvoiceweek;
    }

    public void setEveninvoiceweek(Character eveninvoiceweek) {
        this.eveninvoiceweek = eveninvoiceweek;
    }

    public Long getInvoiceday() {
        return invoiceday;
    }

    public void setInvoiceday(Long invoiceday) {
        this.invoiceday = invoiceday;
    }

    public Long getInvoicedaycutoff() {
        return invoicedaycutoff;
    }

    public void setInvoicedaycutoff(Long invoicedaycutoff) {
        this.invoicedaycutoff = invoicedaycutoff;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInvoicescheduleId != null ? cInvoicescheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInvoiceschedule)) {
            return false;
        }
        CInvoiceschedule other = (CInvoiceschedule) object;
        if ((this.cInvoicescheduleId == null && other.cInvoicescheduleId != null) || (this.cInvoicescheduleId != null && !this.cInvoicescheduleId.equals(other.cInvoicescheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CInvoiceschedule[ cInvoicescheduleId=" + cInvoicescheduleId + " ]";
    }
    
}
