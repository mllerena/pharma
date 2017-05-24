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
@Table(name = "gl_journalbatch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlJournalbatch.findAll", query = "SELECT g FROM GlJournalbatch g"),
    @NamedQuery(name = "GlJournalbatch.findByGlJournalbatchId", query = "SELECT g FROM GlJournalbatch g WHERE g.glJournalbatchId = :glJournalbatchId"),
    @NamedQuery(name = "GlJournalbatch.findByIsactive", query = "SELECT g FROM GlJournalbatch g WHERE g.isactive = :isactive"),
    @NamedQuery(name = "GlJournalbatch.findByCreated", query = "SELECT g FROM GlJournalbatch g WHERE g.created = :created"),
    @NamedQuery(name = "GlJournalbatch.findByCreatedby", query = "SELECT g FROM GlJournalbatch g WHERE g.createdby = :createdby"),
    @NamedQuery(name = "GlJournalbatch.findByUpdated", query = "SELECT g FROM GlJournalbatch g WHERE g.updated = :updated"),
    @NamedQuery(name = "GlJournalbatch.findByUpdatedby", query = "SELECT g FROM GlJournalbatch g WHERE g.updatedby = :updatedby"),
    @NamedQuery(name = "GlJournalbatch.findByDocumentno", query = "SELECT g FROM GlJournalbatch g WHERE g.documentno = :documentno"),
    @NamedQuery(name = "GlJournalbatch.findByDescription", query = "SELECT g FROM GlJournalbatch g WHERE g.description = :description"),
    @NamedQuery(name = "GlJournalbatch.findByPostingtype", query = "SELECT g FROM GlJournalbatch g WHERE g.postingtype = :postingtype"),
    @NamedQuery(name = "GlJournalbatch.findByDatedoc", query = "SELECT g FROM GlJournalbatch g WHERE g.datedoc = :datedoc"),
    @NamedQuery(name = "GlJournalbatch.findByDateacct", query = "SELECT g FROM GlJournalbatch g WHERE g.dateacct = :dateacct"),
    @NamedQuery(name = "GlJournalbatch.findByTotaldr", query = "SELECT g FROM GlJournalbatch g WHERE g.totaldr = :totaldr"),
    @NamedQuery(name = "GlJournalbatch.findByTotalcr", query = "SELECT g FROM GlJournalbatch g WHERE g.totalcr = :totalcr"),
    @NamedQuery(name = "GlJournalbatch.findByControlamt", query = "SELECT g FROM GlJournalbatch g WHERE g.controlamt = :controlamt"),
    @NamedQuery(name = "GlJournalbatch.findByProcessing", query = "SELECT g FROM GlJournalbatch g WHERE g.processing = :processing"),
    @NamedQuery(name = "GlJournalbatch.findByProcessed", query = "SELECT g FROM GlJournalbatch g WHERE g.processed = :processed"),
    @NamedQuery(name = "GlJournalbatch.findByCopyfrom", query = "SELECT g FROM GlJournalbatch g WHERE g.copyfrom = :copyfrom"),
    @NamedQuery(name = "GlJournalbatch.findByIstemplate", query = "SELECT g FROM GlJournalbatch g WHERE g.istemplate = :istemplate")})
public class GlJournalbatch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "gl_journalbatch_id")
    private String glJournalbatchId;
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
    @Size(min = 1, max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "postingtype")
    private String postingtype;
    @Column(name = "datedoc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedoc;
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totaldr")
    private BigInteger totaldr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalcr")
    private BigInteger totalcr;
    @Column(name = "controlamt")
    private BigInteger controlamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Column(name = "copyfrom")
    private Character copyfrom;
    @Column(name = "istemplate")
    private Character istemplate;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "glJournalbatchId")
    private List<IGljournal> iGljournalList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_period_id", referencedColumnName = "c_period_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPeriod cPeriodId;
    @JoinColumn(name = "gl_category_id", referencedColumnName = "gl_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private GlCategory glCategoryId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "glJournalbatchId")
    private List<GlJournal> glJournalList;

    public GlJournalbatch() {
    }

    public GlJournalbatch(String glJournalbatchId) {
        this.glJournalbatchId = glJournalbatchId;
    }

    public GlJournalbatch(String glJournalbatchId, Character isactive, Date created, String createdby, Date updated, String updatedby, String documentno, String description, String postingtype, BigInteger totaldr, BigInteger totalcr, Character processing, Character processed) {
        this.glJournalbatchId = glJournalbatchId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.description = description;
        this.postingtype = postingtype;
        this.totaldr = totaldr;
        this.totalcr = totalcr;
        this.processing = processing;
        this.processed = processed;
    }

    public String getGlJournalbatchId() {
        return glJournalbatchId;
    }

    public void setGlJournalbatchId(String glJournalbatchId) {
        this.glJournalbatchId = glJournalbatchId;
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

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostingtype() {
        return postingtype;
    }

    public void setPostingtype(String postingtype) {
        this.postingtype = postingtype;
    }

    public Date getDatedoc() {
        return datedoc;
    }

    public void setDatedoc(Date datedoc) {
        this.datedoc = datedoc;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public BigInteger getTotaldr() {
        return totaldr;
    }

    public void setTotaldr(BigInteger totaldr) {
        this.totaldr = totaldr;
    }

    public BigInteger getTotalcr() {
        return totalcr;
    }

    public void setTotalcr(BigInteger totalcr) {
        this.totalcr = totalcr;
    }

    public BigInteger getControlamt() {
        return controlamt;
    }

    public void setControlamt(BigInteger controlamt) {
        this.controlamt = controlamt;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Character getCopyfrom() {
        return copyfrom;
    }

    public void setCopyfrom(Character copyfrom) {
        this.copyfrom = copyfrom;
    }

    public Character getIstemplate() {
        return istemplate;
    }

    public void setIstemplate(Character istemplate) {
        this.istemplate = istemplate;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
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

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CPeriod getCPeriodId() {
        return cPeriodId;
    }

    public void setCPeriodId(CPeriod cPeriodId) {
        this.cPeriodId = cPeriodId;
    }

    public GlCategory getGlCategoryId() {
        return glCategoryId;
    }

    public void setGlCategoryId(GlCategory glCategoryId) {
        this.glCategoryId = glCategoryId;
    }

    @XmlTransient
    public List<GlJournal> getGlJournalList() {
        return glJournalList;
    }

    public void setGlJournalList(List<GlJournal> glJournalList) {
        this.glJournalList = glJournalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (glJournalbatchId != null ? glJournalbatchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlJournalbatch)) {
            return false;
        }
        GlJournalbatch other = (GlJournalbatch) object;
        if ((this.glJournalbatchId == null && other.glJournalbatchId != null) || (this.glJournalbatchId != null && !this.glJournalbatchId.equals(other.glJournalbatchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.GlJournalbatch[ glJournalbatchId=" + glJournalbatchId + " ]";
    }
    
}
