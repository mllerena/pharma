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
@Table(name = "c_paymentterm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPaymentterm.findAll", query = "SELECT c FROM CPaymentterm c"),
    @NamedQuery(name = "CPaymentterm.findByCPaymenttermId", query = "SELECT c FROM CPaymentterm c WHERE c.cPaymenttermId = :cPaymenttermId"),
    @NamedQuery(name = "CPaymentterm.findByIsactive", query = "SELECT c FROM CPaymentterm c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPaymentterm.findByCreated", query = "SELECT c FROM CPaymentterm c WHERE c.created = :created"),
    @NamedQuery(name = "CPaymentterm.findByCreatedby", query = "SELECT c FROM CPaymentterm c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPaymentterm.findByUpdated", query = "SELECT c FROM CPaymentterm c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPaymentterm.findByUpdatedby", query = "SELECT c FROM CPaymentterm c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPaymentterm.findByName", query = "SELECT c FROM CPaymentterm c WHERE c.name = :name"),
    @NamedQuery(name = "CPaymentterm.findByDescription", query = "SELECT c FROM CPaymentterm c WHERE c.description = :description"),
    @NamedQuery(name = "CPaymentterm.findByDocumentnote", query = "SELECT c FROM CPaymentterm c WHERE c.documentnote = :documentnote"),
    @NamedQuery(name = "CPaymentterm.findByIsduefixed", query = "SELECT c FROM CPaymentterm c WHERE c.isduefixed = :isduefixed"),
    @NamedQuery(name = "CPaymentterm.findByNetdays", query = "SELECT c FROM CPaymentterm c WHERE c.netdays = :netdays"),
    @NamedQuery(name = "CPaymentterm.findByFixmonthday", query = "SELECT c FROM CPaymentterm c WHERE c.fixmonthday = :fixmonthday"),
    @NamedQuery(name = "CPaymentterm.findByFixmonthoffset", query = "SELECT c FROM CPaymentterm c WHERE c.fixmonthoffset = :fixmonthoffset"),
    @NamedQuery(name = "CPaymentterm.findByIsnextbusinessday", query = "SELECT c FROM CPaymentterm c WHERE c.isnextbusinessday = :isnextbusinessday"),
    @NamedQuery(name = "CPaymentterm.findByIsdefault", query = "SELECT c FROM CPaymentterm c WHERE c.isdefault = :isdefault"),
    @NamedQuery(name = "CPaymentterm.findByValue", query = "SELECT c FROM CPaymentterm c WHERE c.value = :value"),
    @NamedQuery(name = "CPaymentterm.findByNetday", query = "SELECT c FROM CPaymentterm c WHERE c.netday = :netday"),
    @NamedQuery(name = "CPaymentterm.findByIsvalid", query = "SELECT c FROM CPaymentterm c WHERE c.isvalid = :isvalid"),
    @NamedQuery(name = "CPaymentterm.findByFixmonthday2", query = "SELECT c FROM CPaymentterm c WHERE c.fixmonthday2 = :fixmonthday2"),
    @NamedQuery(name = "CPaymentterm.findByFixmonthday3", query = "SELECT c FROM CPaymentterm c WHERE c.fixmonthday3 = :fixmonthday3")})
public class CPaymentterm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_paymentterm_id")
    private String cPaymenttermId;
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
    @Size(max = 2000)
    @Column(name = "documentnote")
    private String documentnote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isduefixed")
    private Character isduefixed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "netdays")
    private long netdays;
    @Column(name = "fixmonthday")
    private Long fixmonthday;
    @Column(name = "fixmonthoffset")
    private Long fixmonthoffset;
    @Column(name = "isnextbusinessday")
    private Character isnextbusinessday;
    @Column(name = "isdefault")
    private Character isdefault;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "value")
    private String value;
    @Size(max = 60)
    @Column(name = "netday")
    private String netday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isvalid")
    private Character isvalid;
    @Column(name = "fixmonthday2")
    private Long fixmonthday2;
    @Column(name = "fixmonthday3")
    private Long fixmonthday3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPaymenttermId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "poPaymenttermId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPaymenttermId")
    private List<CBpartner> cBpartnerList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cPaymenttermId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cPaymenttermId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPaymenttermId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPaymenttermId")
    private List<CProjectproposal> cProjectproposalList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cPaymenttermId")
    private List<CPaymenttermline> cPaymenttermlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPaymenttermId")
    private List<CWithholding> cWithholdingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cPaymenttermId")
    private List<CPaymenttermTrl> cPaymenttermTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPaymenttermId")
    private List<CProject> cProjectList;

    public CPaymentterm() {
    }

    public CPaymentterm(String cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
    }

    public CPaymentterm(String cPaymenttermId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isduefixed, long netdays, String value, Character isvalid) {
        this.cPaymenttermId = cPaymenttermId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isduefixed = isduefixed;
        this.netdays = netdays;
        this.value = value;
        this.isvalid = isvalid;
    }

    public String getCPaymenttermId() {
        return cPaymenttermId;
    }

    public void setCPaymenttermId(String cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
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

    public String getDocumentnote() {
        return documentnote;
    }

    public void setDocumentnote(String documentnote) {
        this.documentnote = documentnote;
    }

    public Character getIsduefixed() {
        return isduefixed;
    }

    public void setIsduefixed(Character isduefixed) {
        this.isduefixed = isduefixed;
    }

    public long getNetdays() {
        return netdays;
    }

    public void setNetdays(long netdays) {
        this.netdays = netdays;
    }

    public Long getFixmonthday() {
        return fixmonthday;
    }

    public void setFixmonthday(Long fixmonthday) {
        this.fixmonthday = fixmonthday;
    }

    public Long getFixmonthoffset() {
        return fixmonthoffset;
    }

    public void setFixmonthoffset(Long fixmonthoffset) {
        this.fixmonthoffset = fixmonthoffset;
    }

    public Character getIsnextbusinessday() {
        return isnextbusinessday;
    }

    public void setIsnextbusinessday(Character isnextbusinessday) {
        this.isnextbusinessday = isnextbusinessday;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNetday() {
        return netday;
    }

    public void setNetday(String netday) {
        this.netday = netday;
    }

    public Character getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Character isvalid) {
        this.isvalid = isvalid;
    }

    public Long getFixmonthday2() {
        return fixmonthday2;
    }

    public void setFixmonthday2(Long fixmonthday2) {
        this.fixmonthday2 = fixmonthday2;
    }

    public Long getFixmonthday3() {
        return fixmonthday3;
    }

    public void setFixmonthday3(Long fixmonthday3) {
        this.fixmonthday3 = fixmonthday3;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList1() {
        return cBpartnerList1;
    }

    public void setCBpartnerList1(List<CBpartner> cBpartnerList1) {
        this.cBpartnerList1 = cBpartnerList1;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<CProjectproposal> getCProjectproposalList() {
        return cProjectproposalList;
    }

    public void setCProjectproposalList(List<CProjectproposal> cProjectproposalList) {
        this.cProjectproposalList = cProjectproposalList;
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

    @XmlTransient
    public List<CPaymenttermline> getCPaymenttermlineList() {
        return cPaymenttermlineList;
    }

    public void setCPaymenttermlineList(List<CPaymenttermline> cPaymenttermlineList) {
        this.cPaymenttermlineList = cPaymenttermlineList;
    }

    @XmlTransient
    public List<CWithholding> getCWithholdingList() {
        return cWithholdingList;
    }

    public void setCWithholdingList(List<CWithholding> cWithholdingList) {
        this.cWithholdingList = cWithholdingList;
    }

    @XmlTransient
    public List<CPaymenttermTrl> getCPaymenttermTrlList() {
        return cPaymenttermTrlList;
    }

    public void setCPaymenttermTrlList(List<CPaymenttermTrl> cPaymenttermTrlList) {
        this.cPaymenttermTrlList = cPaymenttermTrlList;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPaymenttermId != null ? cPaymenttermId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPaymentterm)) {
            return false;
        }
        CPaymentterm other = (CPaymentterm) object;
        if ((this.cPaymenttermId == null && other.cPaymenttermId != null) || (this.cPaymenttermId != null && !this.cPaymenttermId.equals(other.cPaymenttermId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPaymentterm[ cPaymenttermId=" + cPaymenttermId + " ]";
    }
    
}
