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
import javax.persistence.FetchType;
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
@Table(name = "ad_process_para")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdProcessPara.findAll", query = "SELECT a FROM AdProcessPara a"),
    @NamedQuery(name = "AdProcessPara.findByAdProcessParaId", query = "SELECT a FROM AdProcessPara a WHERE a.adProcessParaId = :adProcessParaId"),
    @NamedQuery(name = "AdProcessPara.findByIsactive", query = "SELECT a FROM AdProcessPara a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdProcessPara.findByCreated", query = "SELECT a FROM AdProcessPara a WHERE a.created = :created"),
    @NamedQuery(name = "AdProcessPara.findByCreatedby", query = "SELECT a FROM AdProcessPara a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdProcessPara.findByUpdated", query = "SELECT a FROM AdProcessPara a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdProcessPara.findByUpdatedby", query = "SELECT a FROM AdProcessPara a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdProcessPara.findByName", query = "SELECT a FROM AdProcessPara a WHERE a.name = :name"),
    @NamedQuery(name = "AdProcessPara.findByDescription", query = "SELECT a FROM AdProcessPara a WHERE a.description = :description"),
    @NamedQuery(name = "AdProcessPara.findByHelp", query = "SELECT a FROM AdProcessPara a WHERE a.help = :help"),
    @NamedQuery(name = "AdProcessPara.findBySeqno", query = "SELECT a FROM AdProcessPara a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AdProcessPara.findByColumnname", query = "SELECT a FROM AdProcessPara a WHERE a.columnname = :columnname"),
    @NamedQuery(name = "AdProcessPara.findByIscentrallymaintained", query = "SELECT a FROM AdProcessPara a WHERE a.iscentrallymaintained = :iscentrallymaintained"),
    @NamedQuery(name = "AdProcessPara.findByFieldlength", query = "SELECT a FROM AdProcessPara a WHERE a.fieldlength = :fieldlength"),
    @NamedQuery(name = "AdProcessPara.findByIsmandatory", query = "SELECT a FROM AdProcessPara a WHERE a.ismandatory = :ismandatory"),
    @NamedQuery(name = "AdProcessPara.findByIsrange", query = "SELECT a FROM AdProcessPara a WHERE a.isrange = :isrange"),
    @NamedQuery(name = "AdProcessPara.findByDefaultvalue", query = "SELECT a FROM AdProcessPara a WHERE a.defaultvalue = :defaultvalue"),
    @NamedQuery(name = "AdProcessPara.findByDefaultvalue2", query = "SELECT a FROM AdProcessPara a WHERE a.defaultvalue2 = :defaultvalue2"),
    @NamedQuery(name = "AdProcessPara.findByVformat", query = "SELECT a FROM AdProcessPara a WHERE a.vformat = :vformat"),
    @NamedQuery(name = "AdProcessPara.findByValuemin", query = "SELECT a FROM AdProcessPara a WHERE a.valuemin = :valuemin"),
    @NamedQuery(name = "AdProcessPara.findByValuemax", query = "SELECT a FROM AdProcessPara a WHERE a.valuemax = :valuemax")})
public class AdProcessPara implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_process_para_id")
    private String adProcessParaId;
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
    @Column(name = "help")
    private String help;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private long seqno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "columnname")
    private String columnname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscentrallymaintained")
    private Character iscentrallymaintained;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fieldlength")
    private long fieldlength;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ismandatory")
    private Character ismandatory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isrange")
    private Character isrange;
    @Size(max = 1000)
    @Column(name = "defaultvalue")
    private String defaultvalue;
    @Size(max = 60)
    @Column(name = "defaultvalue2")
    private String defaultvalue2;
    @Size(max = 20)
    @Column(name = "vformat")
    private String vformat;
    @Size(max = 20)
    @Column(name = "valuemin")
    private String valuemin;
    @Size(max = 20)
    @Column(name = "valuemax")
    private String valuemax;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adProcessParaId")
    private List<AdProcessParaTrl> adProcessParaTrlList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_element_id", referencedColumnName = "ad_element_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdElement adElementId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_process_id", referencedColumnName = "ad_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdProcess adProcessId;
    @JoinColumn(name = "ad_reference_id", referencedColumnName = "ad_reference_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdReference adReferenceId;
    @JoinColumn(name = "ad_reference_value_id", referencedColumnName = "ad_reference_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdReference adReferenceValueId;
    @JoinColumn(name = "ad_val_rule_id", referencedColumnName = "ad_val_rule_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdValRule adValRuleId;

    public AdProcessPara() {
    }

    public AdProcessPara(String adProcessParaId) {
        this.adProcessParaId = adProcessParaId;
    }

    public AdProcessPara(String adProcessParaId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, long seqno, String columnname, Character iscentrallymaintained, long fieldlength, Character ismandatory, Character isrange) {
        this.adProcessParaId = adProcessParaId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.seqno = seqno;
        this.columnname = columnname;
        this.iscentrallymaintained = iscentrallymaintained;
        this.fieldlength = fieldlength;
        this.ismandatory = ismandatory;
        this.isrange = isrange;
    }

    public String getAdProcessParaId() {
        return adProcessParaId;
    }

    public void setAdProcessParaId(String adProcessParaId) {
        this.adProcessParaId = adProcessParaId;
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

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public Character getIscentrallymaintained() {
        return iscentrallymaintained;
    }

    public void setIscentrallymaintained(Character iscentrallymaintained) {
        this.iscentrallymaintained = iscentrallymaintained;
    }

    public long getFieldlength() {
        return fieldlength;
    }

    public void setFieldlength(long fieldlength) {
        this.fieldlength = fieldlength;
    }

    public Character getIsmandatory() {
        return ismandatory;
    }

    public void setIsmandatory(Character ismandatory) {
        this.ismandatory = ismandatory;
    }

    public Character getIsrange() {
        return isrange;
    }

    public void setIsrange(Character isrange) {
        this.isrange = isrange;
    }

    public String getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(String defaultvalue) {
        this.defaultvalue = defaultvalue;
    }

    public String getDefaultvalue2() {
        return defaultvalue2;
    }

    public void setDefaultvalue2(String defaultvalue2) {
        this.defaultvalue2 = defaultvalue2;
    }

    public String getVformat() {
        return vformat;
    }

    public void setVformat(String vformat) {
        this.vformat = vformat;
    }

    public String getValuemin() {
        return valuemin;
    }

    public void setValuemin(String valuemin) {
        this.valuemin = valuemin;
    }

    public String getValuemax() {
        return valuemax;
    }

    public void setValuemax(String valuemax) {
        this.valuemax = valuemax;
    }

    @XmlTransient
    public List<AdProcessParaTrl> getAdProcessParaTrlList() {
        return adProcessParaTrlList;
    }

    public void setAdProcessParaTrlList(List<AdProcessParaTrl> adProcessParaTrlList) {
        this.adProcessParaTrlList = adProcessParaTrlList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdElement getAdElementId() {
        return adElementId;
    }

    public void setAdElementId(AdElement adElementId) {
        this.adElementId = adElementId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdProcess getAdProcessId() {
        return adProcessId;
    }

    public void setAdProcessId(AdProcess adProcessId) {
        this.adProcessId = adProcessId;
    }

    public AdReference getAdReferenceId() {
        return adReferenceId;
    }

    public void setAdReferenceId(AdReference adReferenceId) {
        this.adReferenceId = adReferenceId;
    }

    public AdReference getAdReferenceValueId() {
        return adReferenceValueId;
    }

    public void setAdReferenceValueId(AdReference adReferenceValueId) {
        this.adReferenceValueId = adReferenceValueId;
    }

    public AdValRule getAdValRuleId() {
        return adValRuleId;
    }

    public void setAdValRuleId(AdValRule adValRuleId) {
        this.adValRuleId = adValRuleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adProcessParaId != null ? adProcessParaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdProcessPara)) {
            return false;
        }
        AdProcessPara other = (AdProcessPara) object;
        if ((this.adProcessParaId == null && other.adProcessParaId != null) || (this.adProcessParaId != null && !this.adProcessParaId.equals(other.adProcessParaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdProcessPara[ adProcessParaId=" + adProcessParaId + " ]";
    }
    
}
