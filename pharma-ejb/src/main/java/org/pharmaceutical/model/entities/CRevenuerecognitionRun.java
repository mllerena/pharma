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
@Table(name = "c_revenuerecognition_run")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRevenuerecognitionRun.findAll", query = "SELECT c FROM CRevenuerecognitionRun c"),
    @NamedQuery(name = "CRevenuerecognitionRun.findByCRevenuerecognitionRunId", query = "SELECT c FROM CRevenuerecognitionRun c WHERE c.cRevenuerecognitionRunId = :cRevenuerecognitionRunId"),
    @NamedQuery(name = "CRevenuerecognitionRun.findByIsactive", query = "SELECT c FROM CRevenuerecognitionRun c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CRevenuerecognitionRun.findByCreated", query = "SELECT c FROM CRevenuerecognitionRun c WHERE c.created = :created"),
    @NamedQuery(name = "CRevenuerecognitionRun.findByCreatedby", query = "SELECT c FROM CRevenuerecognitionRun c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CRevenuerecognitionRun.findByUpdated", query = "SELECT c FROM CRevenuerecognitionRun c WHERE c.updated = :updated"),
    @NamedQuery(name = "CRevenuerecognitionRun.findByUpdatedby", query = "SELECT c FROM CRevenuerecognitionRun c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CRevenuerecognitionRun.findByRecognizedamt", query = "SELECT c FROM CRevenuerecognitionRun c WHERE c.recognizedamt = :recognizedamt")})
public class CRevenuerecognitionRun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_revenuerecognition_run_id")
    private String cRevenuerecognitionRunId;
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
    @Column(name = "recognizedamt")
    private BigInteger recognizedamt;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_revenuerecognition_plan_id", referencedColumnName = "c_revenuerecognition_plan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CRevenuerecognitionPlan cRevenuerecognitionPlanId;
    @JoinColumn(name = "gl_journal_id", referencedColumnName = "gl_journal_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private GlJournal glJournalId;

    public CRevenuerecognitionRun() {
    }

    public CRevenuerecognitionRun(String cRevenuerecognitionRunId) {
        this.cRevenuerecognitionRunId = cRevenuerecognitionRunId;
    }

    public CRevenuerecognitionRun(String cRevenuerecognitionRunId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger recognizedamt) {
        this.cRevenuerecognitionRunId = cRevenuerecognitionRunId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.recognizedamt = recognizedamt;
    }

    public String getCRevenuerecognitionRunId() {
        return cRevenuerecognitionRunId;
    }

    public void setCRevenuerecognitionRunId(String cRevenuerecognitionRunId) {
        this.cRevenuerecognitionRunId = cRevenuerecognitionRunId;
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

    public BigInteger getRecognizedamt() {
        return recognizedamt;
    }

    public void setRecognizedamt(BigInteger recognizedamt) {
        this.recognizedamt = recognizedamt;
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

    public CRevenuerecognitionPlan getCRevenuerecognitionPlanId() {
        return cRevenuerecognitionPlanId;
    }

    public void setCRevenuerecognitionPlanId(CRevenuerecognitionPlan cRevenuerecognitionPlanId) {
        this.cRevenuerecognitionPlanId = cRevenuerecognitionPlanId;
    }

    public GlJournal getGlJournalId() {
        return glJournalId;
    }

    public void setGlJournalId(GlJournal glJournalId) {
        this.glJournalId = glJournalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cRevenuerecognitionRunId != null ? cRevenuerecognitionRunId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRevenuerecognitionRun)) {
            return false;
        }
        CRevenuerecognitionRun other = (CRevenuerecognitionRun) object;
        if ((this.cRevenuerecognitionRunId == null && other.cRevenuerecognitionRunId != null) || (this.cRevenuerecognitionRunId != null && !this.cRevenuerecognitionRunId.equals(other.cRevenuerecognitionRunId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CRevenuerecognitionRun[ cRevenuerecognitionRunId=" + cRevenuerecognitionRunId + " ]";
    }
    
}
