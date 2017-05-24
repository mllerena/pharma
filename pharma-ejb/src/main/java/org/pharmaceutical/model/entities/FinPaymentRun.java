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
@Table(name = "fin_payment_run")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentRun.findAll", query = "SELECT f FROM FinPaymentRun f"),
    @NamedQuery(name = "FinPaymentRun.findByFinPaymentRunId", query = "SELECT f FROM FinPaymentRun f WHERE f.finPaymentRunId = :finPaymentRunId"),
    @NamedQuery(name = "FinPaymentRun.findByCreated", query = "SELECT f FROM FinPaymentRun f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentRun.findByCreatedby", query = "SELECT f FROM FinPaymentRun f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentRun.findByUpdated", query = "SELECT f FROM FinPaymentRun f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentRun.findByUpdatedby", query = "SELECT f FROM FinPaymentRun f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentRun.findByIsactive", query = "SELECT f FROM FinPaymentRun f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentRun.findByStatus", query = "SELECT f FROM FinPaymentRun f WHERE f.status = :status"),
    @NamedQuery(name = "FinPaymentRun.findByRunSource", query = "SELECT f FROM FinPaymentRun f WHERE f.runSource = :runSource"),
    @NamedQuery(name = "FinPaymentRun.findByMessage", query = "SELECT f FROM FinPaymentRun f WHERE f.message = :message")})
public class FinPaymentRun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_run_id")
    private String finPaymentRunId;
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
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "run_source")
    private String runSource;
    @Size(max = 2000)
    @Column(name = "message")
    private String message;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentRunId")
    private List<FinPaymentRunPara> finPaymentRunParaList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "fin_pay_exec_process_id", referencedColumnName = "fin_pay_exec_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPayExecProcess finPayExecProcessId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentRunId")
    private List<FinPaymentRunPayment> finPaymentRunPaymentList;

    public FinPaymentRun() {
    }

    public FinPaymentRun(String finPaymentRunId) {
        this.finPaymentRunId = finPaymentRunId;
    }

    public FinPaymentRun(String finPaymentRunId, Date created, String createdby, Date updated, String updatedby, Character isactive, String status, String runSource) {
        this.finPaymentRunId = finPaymentRunId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.status = status;
        this.runSource = runSource;
    }

    public String getFinPaymentRunId() {
        return finPaymentRunId;
    }

    public void setFinPaymentRunId(String finPaymentRunId) {
        this.finPaymentRunId = finPaymentRunId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRunSource() {
        return runSource;
    }

    public void setRunSource(String runSource) {
        this.runSource = runSource;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlTransient
    public List<FinPaymentRunPara> getFinPaymentRunParaList() {
        return finPaymentRunParaList;
    }

    public void setFinPaymentRunParaList(List<FinPaymentRunPara> finPaymentRunParaList) {
        this.finPaymentRunParaList = finPaymentRunParaList;
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

    public FinPayExecProcess getFinPayExecProcessId() {
        return finPayExecProcessId;
    }

    public void setFinPayExecProcessId(FinPayExecProcess finPayExecProcessId) {
        this.finPayExecProcessId = finPayExecProcessId;
    }

    @XmlTransient
    public List<FinPaymentRunPayment> getFinPaymentRunPaymentList() {
        return finPaymentRunPaymentList;
    }

    public void setFinPaymentRunPaymentList(List<FinPaymentRunPayment> finPaymentRunPaymentList) {
        this.finPaymentRunPaymentList = finPaymentRunPaymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentRunId != null ? finPaymentRunId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentRun)) {
            return false;
        }
        FinPaymentRun other = (FinPaymentRun) object;
        if ((this.finPaymentRunId == null && other.finPaymentRunId != null) || (this.finPaymentRunId != null && !this.finPaymentRunId.equals(other.finPaymentRunId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentRun[ finPaymentRunId=" + finPaymentRunId + " ]";
    }
    
}
