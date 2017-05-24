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
@Table(name = "m_rappel_bpartner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRappelBpartner.findAll", query = "SELECT m FROM MRappelBpartner m"),
    @NamedQuery(name = "MRappelBpartner.findByMRappelBpartnerId", query = "SELECT m FROM MRappelBpartner m WHERE m.mRappelBpartnerId = :mRappelBpartnerId"),
    @NamedQuery(name = "MRappelBpartner.findByIsactive", query = "SELECT m FROM MRappelBpartner m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MRappelBpartner.findByCreated", query = "SELECT m FROM MRappelBpartner m WHERE m.created = :created"),
    @NamedQuery(name = "MRappelBpartner.findByCreatedby", query = "SELECT m FROM MRappelBpartner m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MRappelBpartner.findByUpdated", query = "SELECT m FROM MRappelBpartner m WHERE m.updated = :updated"),
    @NamedQuery(name = "MRappelBpartner.findByUpdatedby", query = "SELECT m FROM MRappelBpartner m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MRappelBpartner.findByIssotrx", query = "SELECT m FROM MRappelBpartner m WHERE m.issotrx = :issotrx"),
    @NamedQuery(name = "MRappelBpartner.findByValidfrom", query = "SELECT m FROM MRappelBpartner m WHERE m.validfrom = :validfrom"),
    @NamedQuery(name = "MRappelBpartner.findByValidto", query = "SELECT m FROM MRappelBpartner m WHERE m.validto = :validto"),
    @NamedQuery(name = "MRappelBpartner.findBySeqno", query = "SELECT m FROM MRappelBpartner m WHERE m.seqno = :seqno"),
    @NamedQuery(name = "MRappelBpartner.findByGenerateinvoice", query = "SELECT m FROM MRappelBpartner m WHERE m.generateinvoice = :generateinvoice")})
public class MRappelBpartner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_rappel_bpartner_id")
    private String mRappelBpartnerId;
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
    @Column(name = "issotrx")
    private Character issotrx;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @Column(name = "validto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validto;
    @Column(name = "seqno")
    private Long seqno;
    @Column(name = "generateinvoice")
    private Character generateinvoice;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mRappelBpartnerId")
    private List<MRappelInvoice> mRappelInvoiceList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "m_rappel_id", referencedColumnName = "m_rappel_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MRappel mRappelId;

    public MRappelBpartner() {
    }

    public MRappelBpartner(String mRappelBpartnerId) {
        this.mRappelBpartnerId = mRappelBpartnerId;
    }

    public MRappelBpartner(String mRappelBpartnerId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character issotrx, Date validfrom) {
        this.mRappelBpartnerId = mRappelBpartnerId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.issotrx = issotrx;
        this.validfrom = validfrom;
    }

    public String getMRappelBpartnerId() {
        return mRappelBpartnerId;
    }

    public void setMRappelBpartnerId(String mRappelBpartnerId) {
        this.mRappelBpartnerId = mRappelBpartnerId;
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

    public Character getIssotrx() {
        return issotrx;
    }

    public void setIssotrx(Character issotrx) {
        this.issotrx = issotrx;
    }

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public Date getValidto() {
        return validto;
    }

    public void setValidto(Date validto) {
        this.validto = validto;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public Character getGenerateinvoice() {
        return generateinvoice;
    }

    public void setGenerateinvoice(Character generateinvoice) {
        this.generateinvoice = generateinvoice;
    }

    @XmlTransient
    public List<MRappelInvoice> getMRappelInvoiceList() {
        return mRappelInvoiceList;
    }

    public void setMRappelInvoiceList(List<MRappelInvoice> mRappelInvoiceList) {
        this.mRappelInvoiceList = mRappelInvoiceList;
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

    public MRappel getMRappelId() {
        return mRappelId;
    }

    public void setMRappelId(MRappel mRappelId) {
        this.mRappelId = mRappelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mRappelBpartnerId != null ? mRappelBpartnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRappelBpartner)) {
            return false;
        }
        MRappelBpartner other = (MRappelBpartner) object;
        if ((this.mRappelBpartnerId == null && other.mRappelBpartnerId != null) || (this.mRappelBpartnerId != null && !this.mRappelBpartnerId.equals(other.mRappelBpartnerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MRappelBpartner[ mRappelBpartnerId=" + mRappelBpartnerId + " ]";
    }
    
}
