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
@Table(name = "fin_pay_exec_process_para")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPayExecProcessPara.findAll", query = "SELECT f FROM FinPayExecProcessPara f"),
    @NamedQuery(name = "FinPayExecProcessPara.findByFinPayExecProcessParaId", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.finPayExecProcessParaId = :finPayExecProcessParaId"),
    @NamedQuery(name = "FinPayExecProcessPara.findByCreated", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.created = :created"),
    @NamedQuery(name = "FinPayExecProcessPara.findByCreatedby", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPayExecProcessPara.findByUpdated", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPayExecProcessPara.findByUpdatedby", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPayExecProcessPara.findByIsactive", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPayExecProcessPara.findByName", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.name = :name"),
    @NamedQuery(name = "FinPayExecProcessPara.findBySeqno", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.seqno = :seqno"),
    @NamedQuery(name = "FinPayExecProcessPara.findByInputtype", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.inputtype = :inputtype"),
    @NamedQuery(name = "FinPayExecProcessPara.findByIsmandatory", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.ismandatory = :ismandatory"),
    @NamedQuery(name = "FinPayExecProcessPara.findByDefaultcheck", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.defaultcheck = :defaultcheck"),
    @NamedQuery(name = "FinPayExecProcessPara.findByDefaulttext", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.defaulttext = :defaulttext"),
    @NamedQuery(name = "FinPayExecProcessPara.findByDescription", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.description = :description"),
    @NamedQuery(name = "FinPayExecProcessPara.findByParametertype", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.parametertype = :parametertype"),
    @NamedQuery(name = "FinPayExecProcessPara.findByValue", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.value = :value"),
    @NamedQuery(name = "FinPayExecProcessPara.findByFieldlength", query = "SELECT f FROM FinPayExecProcessPara f WHERE f.fieldlength = :fieldlength")})
public class FinPayExecProcessPara implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_pay_exec_process_para_id")
    private String finPayExecProcessParaId;
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
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private long seqno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "inputtype")
    private String inputtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ismandatory")
    private Character ismandatory;
    @Size(max = 60)
    @Column(name = "defaultcheck")
    private String defaultcheck;
    @Size(max = 60)
    @Column(name = "defaulttext")
    private String defaulttext;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "parametertype")
    private String parametertype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "value")
    private String value;
    @Column(name = "fieldlength")
    private Long fieldlength;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPayExecProcessParaId")
    private List<FinPaymentRunPara> finPaymentRunParaList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_reference_value_id", referencedColumnName = "ad_reference_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdReference adReferenceValueId;
    @JoinColumn(name = "ad_reference_id", referencedColumnName = "ad_reference_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdReference adReferenceId;
    @JoinColumn(name = "ad_val_rule_id", referencedColumnName = "ad_val_rule_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdValRule adValRuleId;
    @JoinColumn(name = "fin_pay_exec_process_id", referencedColumnName = "fin_pay_exec_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPayExecProcess finPayExecProcessId;

    public FinPayExecProcessPara() {
    }

    public FinPayExecProcessPara(String finPayExecProcessParaId) {
        this.finPayExecProcessParaId = finPayExecProcessParaId;
    }

    public FinPayExecProcessPara(String finPayExecProcessParaId, Date created, String createdby, Date updated, String updatedby, Character isactive, String name, long seqno, String inputtype, Character ismandatory, String parametertype, String value) {
        this.finPayExecProcessParaId = finPayExecProcessParaId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.name = name;
        this.seqno = seqno;
        this.inputtype = inputtype;
        this.ismandatory = ismandatory;
        this.parametertype = parametertype;
        this.value = value;
    }

    public String getFinPayExecProcessParaId() {
        return finPayExecProcessParaId;
    }

    public void setFinPayExecProcessParaId(String finPayExecProcessParaId) {
        this.finPayExecProcessParaId = finPayExecProcessParaId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public String getInputtype() {
        return inputtype;
    }

    public void setInputtype(String inputtype) {
        this.inputtype = inputtype;
    }

    public Character getIsmandatory() {
        return ismandatory;
    }

    public void setIsmandatory(Character ismandatory) {
        this.ismandatory = ismandatory;
    }

    public String getDefaultcheck() {
        return defaultcheck;
    }

    public void setDefaultcheck(String defaultcheck) {
        this.defaultcheck = defaultcheck;
    }

    public String getDefaulttext() {
        return defaulttext;
    }

    public void setDefaulttext(String defaulttext) {
        this.defaulttext = defaulttext;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParametertype() {
        return parametertype;
    }

    public void setParametertype(String parametertype) {
        this.parametertype = parametertype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getFieldlength() {
        return fieldlength;
    }

    public void setFieldlength(Long fieldlength) {
        this.fieldlength = fieldlength;
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

    public AdReference getAdReferenceValueId() {
        return adReferenceValueId;
    }

    public void setAdReferenceValueId(AdReference adReferenceValueId) {
        this.adReferenceValueId = adReferenceValueId;
    }

    public AdReference getAdReferenceId() {
        return adReferenceId;
    }

    public void setAdReferenceId(AdReference adReferenceId) {
        this.adReferenceId = adReferenceId;
    }

    public AdValRule getAdValRuleId() {
        return adValRuleId;
    }

    public void setAdValRuleId(AdValRule adValRuleId) {
        this.adValRuleId = adValRuleId;
    }

    public FinPayExecProcess getFinPayExecProcessId() {
        return finPayExecProcessId;
    }

    public void setFinPayExecProcessId(FinPayExecProcess finPayExecProcessId) {
        this.finPayExecProcessId = finPayExecProcessId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPayExecProcessParaId != null ? finPayExecProcessParaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPayExecProcessPara)) {
            return false;
        }
        FinPayExecProcessPara other = (FinPayExecProcessPara) object;
        if ((this.finPayExecProcessParaId == null && other.finPayExecProcessParaId != null) || (this.finPayExecProcessParaId != null && !this.finPayExecProcessParaId.equals(other.finPayExecProcessParaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPayExecProcessPara[ finPayExecProcessParaId=" + finPayExecProcessParaId + " ]";
    }
    
}
