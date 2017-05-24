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
@Table(name = "fin_payment_run_para")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentRunPara.findAll", query = "SELECT f FROM FinPaymentRunPara f"),
    @NamedQuery(name = "FinPaymentRunPara.findByFinPaymentRunParaId", query = "SELECT f FROM FinPaymentRunPara f WHERE f.finPaymentRunParaId = :finPaymentRunParaId"),
    @NamedQuery(name = "FinPaymentRunPara.findByCreated", query = "SELECT f FROM FinPaymentRunPara f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentRunPara.findByCreatedby", query = "SELECT f FROM FinPaymentRunPara f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentRunPara.findByUpdated", query = "SELECT f FROM FinPaymentRunPara f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentRunPara.findByUpdatedby", query = "SELECT f FROM FinPaymentRunPara f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentRunPara.findByIsactive", query = "SELECT f FROM FinPaymentRunPara f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentRunPara.findByValuecheck", query = "SELECT f FROM FinPaymentRunPara f WHERE f.valuecheck = :valuecheck"),
    @NamedQuery(name = "FinPaymentRunPara.findByValuetext", query = "SELECT f FROM FinPaymentRunPara f WHERE f.valuetext = :valuetext")})
public class FinPaymentRunPara implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_run_para_id")
    private String finPaymentRunParaId;
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
    @Column(name = "valuecheck")
    private Character valuecheck;
    @Size(max = 60)
    @Column(name = "valuetext")
    private String valuetext;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "fin_pay_exec_process_para_id", referencedColumnName = "fin_pay_exec_process_para_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPayExecProcessPara finPayExecProcessParaId;
    @JoinColumn(name = "fin_payment_run_id", referencedColumnName = "fin_payment_run_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPaymentRun finPaymentRunId;

    public FinPaymentRunPara() {
    }

    public FinPaymentRunPara(String finPaymentRunParaId) {
        this.finPaymentRunParaId = finPaymentRunParaId;
    }

    public FinPaymentRunPara(String finPaymentRunParaId, Date created, String createdby, Date updated, String updatedby, Character isactive, Character valuecheck) {
        this.finPaymentRunParaId = finPaymentRunParaId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.valuecheck = valuecheck;
    }

    public String getFinPaymentRunParaId() {
        return finPaymentRunParaId;
    }

    public void setFinPaymentRunParaId(String finPaymentRunParaId) {
        this.finPaymentRunParaId = finPaymentRunParaId;
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

    public Character getValuecheck() {
        return valuecheck;
    }

    public void setValuecheck(Character valuecheck) {
        this.valuecheck = valuecheck;
    }

    public String getValuetext() {
        return valuetext;
    }

    public void setValuetext(String valuetext) {
        this.valuetext = valuetext;
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

    public FinPayExecProcessPara getFinPayExecProcessParaId() {
        return finPayExecProcessParaId;
    }

    public void setFinPayExecProcessParaId(FinPayExecProcessPara finPayExecProcessParaId) {
        this.finPayExecProcessParaId = finPayExecProcessParaId;
    }

    public FinPaymentRun getFinPaymentRunId() {
        return finPaymentRunId;
    }

    public void setFinPaymentRunId(FinPaymentRun finPaymentRunId) {
        this.finPaymentRunId = finPaymentRunId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentRunParaId != null ? finPaymentRunParaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentRunPara)) {
            return false;
        }
        FinPaymentRunPara other = (FinPaymentRunPara) object;
        if ((this.finPaymentRunParaId == null && other.finPaymentRunParaId != null) || (this.finPaymentRunParaId != null && !this.finPaymentRunParaId.equals(other.finPaymentRunParaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentRunPara[ finPaymentRunParaId=" + finPaymentRunParaId + " ]";
    }
    
}
