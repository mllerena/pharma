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
import javax.persistence.CascadeType;
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
@Table(name = "c_commission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCommission.findAll", query = "SELECT c FROM CCommission c"),
    @NamedQuery(name = "CCommission.findByCCommissionId", query = "SELECT c FROM CCommission c WHERE c.cCommissionId = :cCommissionId"),
    @NamedQuery(name = "CCommission.findByIsactive", query = "SELECT c FROM CCommission c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCommission.findByCreated", query = "SELECT c FROM CCommission c WHERE c.created = :created"),
    @NamedQuery(name = "CCommission.findByCreatedby", query = "SELECT c FROM CCommission c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCommission.findByUpdated", query = "SELECT c FROM CCommission c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCommission.findByUpdatedby", query = "SELECT c FROM CCommission c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCommission.findByName", query = "SELECT c FROM CCommission c WHERE c.name = :name"),
    @NamedQuery(name = "CCommission.findByDescription", query = "SELECT c FROM CCommission c WHERE c.description = :description"),
    @NamedQuery(name = "CCommission.findByFrequencytype", query = "SELECT c FROM CCommission c WHERE c.frequencytype = :frequencytype"),
    @NamedQuery(name = "CCommission.findByDocbasistype", query = "SELECT c FROM CCommission c WHERE c.docbasistype = :docbasistype"),
    @NamedQuery(name = "CCommission.findByListdetails", query = "SELECT c FROM CCommission c WHERE c.listdetails = :listdetails"),
    @NamedQuery(name = "CCommission.findByDatelastrun", query = "SELECT c FROM CCommission c WHERE c.datelastrun = :datelastrun"),
    @NamedQuery(name = "CCommission.findByCreatefrom", query = "SELECT c FROM CCommission c WHERE c.createfrom = :createfrom"),
    @NamedQuery(name = "CCommission.findByProcessing", query = "SELECT c FROM CCommission c WHERE c.processing = :processing")})
public class CCommission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_commission_id")
    private String cCommissionId;
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
    @Size(min = 1, max = 60)
    @Column(name = "frequencytype")
    private String frequencytype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "docbasistype")
    private String docbasistype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "listdetails")
    private Character listdetails;
    @Column(name = "datelastrun")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastrun;
    @Column(name = "createfrom")
    private Character createfrom;
    @Column(name = "processing")
    private Character processing;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCommissionId")
    private List<CCommissionrun> cCommissionrunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCommissionId")
    private List<CCommissionline> cCommissionlineList;

    public CCommission() {
    }

    public CCommission(String cCommissionId) {
        this.cCommissionId = cCommissionId;
    }

    public CCommission(String cCommissionId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String frequencytype, String docbasistype, Character listdetails) {
        this.cCommissionId = cCommissionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.frequencytype = frequencytype;
        this.docbasistype = docbasistype;
        this.listdetails = listdetails;
    }

    public String getCCommissionId() {
        return cCommissionId;
    }

    public void setCCommissionId(String cCommissionId) {
        this.cCommissionId = cCommissionId;
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

    public String getFrequencytype() {
        return frequencytype;
    }

    public void setFrequencytype(String frequencytype) {
        this.frequencytype = frequencytype;
    }

    public String getDocbasistype() {
        return docbasistype;
    }

    public void setDocbasistype(String docbasistype) {
        this.docbasistype = docbasistype;
    }

    public Character getListdetails() {
        return listdetails;
    }

    public void setListdetails(Character listdetails) {
        this.listdetails = listdetails;
    }

    public Date getDatelastrun() {
        return datelastrun;
    }

    public void setDatelastrun(Date datelastrun) {
        this.datelastrun = datelastrun;
    }

    public Character getCreatefrom() {
        return createfrom;
    }

    public void setCreatefrom(Character createfrom) {
        this.createfrom = createfrom;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
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

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @XmlTransient
    public List<CCommissionrun> getCCommissionrunList() {
        return cCommissionrunList;
    }

    public void setCCommissionrunList(List<CCommissionrun> cCommissionrunList) {
        this.cCommissionrunList = cCommissionrunList;
    }

    @XmlTransient
    public List<CCommissionline> getCCommissionlineList() {
        return cCommissionlineList;
    }

    public void setCCommissionlineList(List<CCommissionline> cCommissionlineList) {
        this.cCommissionlineList = cCommissionlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCommissionId != null ? cCommissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCommission)) {
            return false;
        }
        CCommission other = (CCommission) object;
        if ((this.cCommissionId == null && other.cCommissionId != null) || (this.cCommissionId != null && !this.cCommissionId.equals(other.cCommissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCommission[ cCommissionId=" + cCommissionId + " ]";
    }
    
}
