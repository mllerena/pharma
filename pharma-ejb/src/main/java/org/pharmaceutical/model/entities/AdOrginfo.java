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
import javax.persistence.OneToOne;
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
@Table(name = "ad_orginfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdOrginfo.findAll", query = "SELECT a FROM AdOrginfo a"),
    @NamedQuery(name = "AdOrginfo.findByAdOrgId", query = "SELECT a FROM AdOrginfo a WHERE a.adOrgId = :adOrgId"),
    @NamedQuery(name = "AdOrginfo.findByIsactive", query = "SELECT a FROM AdOrginfo a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdOrginfo.findByCreated", query = "SELECT a FROM AdOrginfo a WHERE a.created = :created"),
    @NamedQuery(name = "AdOrginfo.findByCreatedby", query = "SELECT a FROM AdOrginfo a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdOrginfo.findByUpdated", query = "SELECT a FROM AdOrginfo a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdOrginfo.findByUpdatedby", query = "SELECT a FROM AdOrginfo a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdOrginfo.findByDuns", query = "SELECT a FROM AdOrginfo a WHERE a.duns = :duns"),
    @NamedQuery(name = "AdOrginfo.findByTaxid", query = "SELECT a FROM AdOrginfo a WHERE a.taxid = :taxid"),
    @NamedQuery(name = "AdOrginfo.findByIstaxundeductable", query = "SELECT a FROM AdOrginfo a WHERE a.istaxundeductable = :istaxundeductable"),
    @NamedQuery(name = "AdOrginfo.findByLogo", query = "SELECT a FROM AdOrginfo a WHERE a.logo = :logo"),
    @NamedQuery(name = "AdOrginfo.findByReferenceOrder", query = "SELECT a FROM AdOrginfo a WHERE a.referenceOrder = :referenceOrder"),
    @NamedQuery(name = "AdOrginfo.findByAutomaticWriteoffAmt", query = "SELECT a FROM AdOrginfo a WHERE a.automaticWriteoffAmt = :automaticWriteoffAmt")})
public class AdOrginfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_org_id")
    private String adOrgId;
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
    @Size(min = 1, max = 11)
    @Column(name = "duns")
    private String duns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "taxid")
    private String taxid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istaxundeductable")
    private Character istaxundeductable;
    @Size(max = 200)
    @Column(name = "logo")
    private String logo;
    @Column(name = "reference_order")
    private Character referenceOrder;
    @Column(name = "automatic_writeoff_amt")
    private BigInteger automaticWriteoffAmt;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "your_company_document_image", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage yourCompanyDocumentImage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AdOrg adOrg;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocationId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;

    public AdOrginfo() {
    }

    public AdOrginfo(String adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdOrginfo(String adOrgId, Character isactive, Date created, String createdby, Date updated, String updatedby, String duns, String taxid, Character istaxundeductable) {
        this.adOrgId = adOrgId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.duns = duns;
        this.taxid = taxid;
        this.istaxundeductable = istaxundeductable;
    }

    public String getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(String adOrgId) {
        this.adOrgId = adOrgId;
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

    public String getDuns() {
        return duns;
    }

    public void setDuns(String duns) {
        this.duns = duns;
    }

    public String getTaxid() {
        return taxid;
    }

    public void setTaxid(String taxid) {
        this.taxid = taxid;
    }

    public Character getIstaxundeductable() {
        return istaxundeductable;
    }

    public void setIstaxundeductable(Character istaxundeductable) {
        this.istaxundeductable = istaxundeductable;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Character getReferenceOrder() {
        return referenceOrder;
    }

    public void setReferenceOrder(Character referenceOrder) {
        this.referenceOrder = referenceOrder;
    }

    public BigInteger getAutomaticWriteoffAmt() {
        return automaticWriteoffAmt;
    }

    public void setAutomaticWriteoffAmt(BigInteger automaticWriteoffAmt) {
        this.automaticWriteoffAmt = automaticWriteoffAmt;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdImage getYourCompanyDocumentImage() {
        return yourCompanyDocumentImage;
    }

    public void setYourCompanyDocumentImage(AdImage yourCompanyDocumentImage) {
        this.yourCompanyDocumentImage = yourCompanyDocumentImage;
    }

    public AdOrg getAdOrg() {
        return adOrg;
    }

    public void setAdOrg(AdOrg adOrg) {
        this.adOrg = adOrg;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
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
        hash += (adOrgId != null ? adOrgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdOrginfo)) {
            return false;
        }
        AdOrginfo other = (AdOrginfo) object;
        if ((this.adOrgId == null && other.adOrgId != null) || (this.adOrgId != null && !this.adOrgId.equals(other.adOrgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdOrginfo[ adOrgId=" + adOrgId + " ]";
    }
    
}
