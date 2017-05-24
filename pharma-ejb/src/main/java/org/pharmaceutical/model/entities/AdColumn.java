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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "ad_column")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdColumn.findAll", query = "SELECT a FROM AdColumn a"),
    @NamedQuery(name = "AdColumn.findByAdColumnId", query = "SELECT a FROM AdColumn a WHERE a.adColumnId = :adColumnId"),
    @NamedQuery(name = "AdColumn.findByIsactive", query = "SELECT a FROM AdColumn a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdColumn.findByCreated", query = "SELECT a FROM AdColumn a WHERE a.created = :created"),
    @NamedQuery(name = "AdColumn.findByUpdated", query = "SELECT a FROM AdColumn a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdColumn.findByCreatedby", query = "SELECT a FROM AdColumn a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdColumn.findByUpdatedby", query = "SELECT a FROM AdColumn a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdColumn.findByName", query = "SELECT a FROM AdColumn a WHERE a.name = :name"),
    @NamedQuery(name = "AdColumn.findByDescription", query = "SELECT a FROM AdColumn a WHERE a.description = :description"),
    @NamedQuery(name = "AdColumn.findByHelp", query = "SELECT a FROM AdColumn a WHERE a.help = :help"),
    @NamedQuery(name = "AdColumn.findByColumnname", query = "SELECT a FROM AdColumn a WHERE a.columnname = :columnname"),
    @NamedQuery(name = "AdColumn.findByFieldlength", query = "SELECT a FROM AdColumn a WHERE a.fieldlength = :fieldlength"),
    @NamedQuery(name = "AdColumn.findByDefaultvalue", query = "SELECT a FROM AdColumn a WHERE a.defaultvalue = :defaultvalue"),
    @NamedQuery(name = "AdColumn.findByIskey", query = "SELECT a FROM AdColumn a WHERE a.iskey = :iskey"),
    @NamedQuery(name = "AdColumn.findByIsparent", query = "SELECT a FROM AdColumn a WHERE a.isparent = :isparent"),
    @NamedQuery(name = "AdColumn.findByIsmandatory", query = "SELECT a FROM AdColumn a WHERE a.ismandatory = :ismandatory"),
    @NamedQuery(name = "AdColumn.findByIsupdateable", query = "SELECT a FROM AdColumn a WHERE a.isupdateable = :isupdateable"),
    @NamedQuery(name = "AdColumn.findByReadonlylogic", query = "SELECT a FROM AdColumn a WHERE a.readonlylogic = :readonlylogic"),
    @NamedQuery(name = "AdColumn.findByIsidentifier", query = "SELECT a FROM AdColumn a WHERE a.isidentifier = :isidentifier"),
    @NamedQuery(name = "AdColumn.findBySeqno", query = "SELECT a FROM AdColumn a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AdColumn.findByIstranslated", query = "SELECT a FROM AdColumn a WHERE a.istranslated = :istranslated"),
    @NamedQuery(name = "AdColumn.findByIsencrypted", query = "SELECT a FROM AdColumn a WHERE a.isencrypted = :isencrypted"),
    @NamedQuery(name = "AdColumn.findByCallout", query = "SELECT a FROM AdColumn a WHERE a.callout = :callout"),
    @NamedQuery(name = "AdColumn.findByVformat", query = "SELECT a FROM AdColumn a WHERE a.vformat = :vformat"),
    @NamedQuery(name = "AdColumn.findByValuemin", query = "SELECT a FROM AdColumn a WHERE a.valuemin = :valuemin"),
    @NamedQuery(name = "AdColumn.findByValuemax", query = "SELECT a FROM AdColumn a WHERE a.valuemax = :valuemax"),
    @NamedQuery(name = "AdColumn.findByIsselectioncolumn", query = "SELECT a FROM AdColumn a WHERE a.isselectioncolumn = :isselectioncolumn"),
    @NamedQuery(name = "AdColumn.findByIssessionattr", query = "SELECT a FROM AdColumn a WHERE a.issessionattr = :issessionattr"),
    @NamedQuery(name = "AdColumn.findByIssecondarykey", query = "SELECT a FROM AdColumn a WHERE a.issecondarykey = :issecondarykey"),
    @NamedQuery(name = "AdColumn.findByIsdesencryptable", query = "SELECT a FROM AdColumn a WHERE a.isdesencryptable = :isdesencryptable"),
    @NamedQuery(name = "AdColumn.findByDevelopmentstatus", query = "SELECT a FROM AdColumn a WHERE a.developmentstatus = :developmentstatus"),
    @NamedQuery(name = "AdColumn.findByPosition", query = "SELECT a FROM AdColumn a WHERE a.position = :position"),
    @NamedQuery(name = "AdColumn.findByIstransient", query = "SELECT a FROM AdColumn a WHERE a.istransient = :istransient"),
    @NamedQuery(name = "AdColumn.findByIstransientcondition", query = "SELECT a FROM AdColumn a WHERE a.istransientcondition = :istransientcondition"),
    @NamedQuery(name = "AdColumn.findByIsautosave", query = "SELECT a FROM AdColumn a WHERE a.isautosave = :isautosave"),
    @NamedQuery(name = "AdColumn.findByValidateonnew", query = "SELECT a FROM AdColumn a WHERE a.validateonnew = :validateonnew")})
public class AdColumn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_column_id")
    private String adColumnId;
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
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "createdby")
    private String createdby;
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
    @Size(min = 1, max = 40)
    @Column(name = "columnname")
    private String columnname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fieldlength")
    private long fieldlength;
    @Size(max = 2000)
    @Column(name = "defaultvalue")
    private String defaultvalue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iskey")
    private Character iskey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isparent")
    private Character isparent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ismandatory")
    private Character ismandatory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isupdateable")
    private Character isupdateable;
    @Size(max = 2000)
    @Column(name = "readonlylogic")
    private String readonlylogic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isidentifier")
    private Character isidentifier;
    @Column(name = "seqno")
    private Long seqno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istranslated")
    private Character istranslated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isencrypted")
    private Character isencrypted;
    @Size(max = 60)
    @Column(name = "callout")
    private String callout;
    @Size(max = 60)
    @Column(name = "vformat")
    private String vformat;
    @Size(max = 20)
    @Column(name = "valuemin")
    private String valuemin;
    @Size(max = 20)
    @Column(name = "valuemax")
    private String valuemax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isselectioncolumn")
    private Character isselectioncolumn;
    @Column(name = "issessionattr")
    private Character issessionattr;
    @Column(name = "issecondarykey")
    private Character issecondarykey;
    @Column(name = "isdesencryptable")
    private Character isdesencryptable;
    @Size(max = 60)
    @Column(name = "developmentstatus")
    private String developmentstatus;
    @Column(name = "position")
    private BigInteger position;
    @Column(name = "istransient")
    private Character istransient;
    @Size(max = 2000)
    @Column(name = "istransientcondition")
    private String istransientcondition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isautosave")
    private Character isautosave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validateonnew")
    private Character validateonnew;
    @JoinColumn(name = "ad_callout_id", referencedColumnName = "ad_callout_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdCallout adCalloutId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_element_id", referencedColumnName = "ad_element_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdElement adElementId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_process_id", referencedColumnName = "ad_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdProcess adProcessId;
    @JoinColumn(name = "ad_reference_id", referencedColumnName = "ad_reference_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdReference adReferenceId;
    @JoinColumn(name = "ad_reference_value_id", referencedColumnName = "ad_reference_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdReference adReferenceValueId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;
    @JoinColumn(name = "ad_val_rule_id", referencedColumnName = "ad_val_rule_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdValRule adValRuleId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adColumnId")
    private List<AdRefSearch> adRefSearchList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adColumnId")
    private List<AdDatasetColumn> adDatasetColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adKey")
    private List<AdRefTable> adRefTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adDisplay")
    private List<AdRefTable> adRefTableList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adColumnId")
    private List<IElementvalue> iElementvalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adColumnId")
    private List<AdChangelog> adChangelogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adColumnId")
    private List<AdImpformatRow> adImpformatRowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adColumnId")
    private List<AdTab> adTabList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adColumnsortorderId")
    private List<AdTab> adTabList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adColumnsortyesnoId")
    private List<AdTab> adTabList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "acctdateColumnId")
    private List<AdTable> adTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adColumnId")
    private List<AdColumnAccess> adColumnAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adColumnId")
    private List<AdField> adFieldList;

    public AdColumn() {
    }

    public AdColumn(String adColumnId) {
        this.adColumnId = adColumnId;
    }

    public AdColumn(String adColumnId, Character isactive, Date created, Date updated, String createdby, String updatedby, String name, String columnname, long fieldlength, Character iskey, Character isparent, Character ismandatory, Character isupdateable, Character isidentifier, Character istranslated, Character isencrypted, Character isselectioncolumn, Character isautosave, Character validateonnew) {
        this.adColumnId = adColumnId;
        this.isactive = isactive;
        this.created = created;
        this.updated = updated;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.name = name;
        this.columnname = columnname;
        this.fieldlength = fieldlength;
        this.iskey = iskey;
        this.isparent = isparent;
        this.ismandatory = ismandatory;
        this.isupdateable = isupdateable;
        this.isidentifier = isidentifier;
        this.istranslated = istranslated;
        this.isencrypted = isencrypted;
        this.isselectioncolumn = isselectioncolumn;
        this.isautosave = isautosave;
        this.validateonnew = validateonnew;
    }

    public String getAdColumnId() {
        return adColumnId;
    }

    public void setAdColumnId(String adColumnId) {
        this.adColumnId = adColumnId;
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

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
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

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public long getFieldlength() {
        return fieldlength;
    }

    public void setFieldlength(long fieldlength) {
        this.fieldlength = fieldlength;
    }

    public String getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(String defaultvalue) {
        this.defaultvalue = defaultvalue;
    }

    public Character getIskey() {
        return iskey;
    }

    public void setIskey(Character iskey) {
        this.iskey = iskey;
    }

    public Character getIsparent() {
        return isparent;
    }

    public void setIsparent(Character isparent) {
        this.isparent = isparent;
    }

    public Character getIsmandatory() {
        return ismandatory;
    }

    public void setIsmandatory(Character ismandatory) {
        this.ismandatory = ismandatory;
    }

    public Character getIsupdateable() {
        return isupdateable;
    }

    public void setIsupdateable(Character isupdateable) {
        this.isupdateable = isupdateable;
    }

    public String getReadonlylogic() {
        return readonlylogic;
    }

    public void setReadonlylogic(String readonlylogic) {
        this.readonlylogic = readonlylogic;
    }

    public Character getIsidentifier() {
        return isidentifier;
    }

    public void setIsidentifier(Character isidentifier) {
        this.isidentifier = isidentifier;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public Character getIstranslated() {
        return istranslated;
    }

    public void setIstranslated(Character istranslated) {
        this.istranslated = istranslated;
    }

    public Character getIsencrypted() {
        return isencrypted;
    }

    public void setIsencrypted(Character isencrypted) {
        this.isencrypted = isencrypted;
    }

    public String getCallout() {
        return callout;
    }

    public void setCallout(String callout) {
        this.callout = callout;
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

    public Character getIsselectioncolumn() {
        return isselectioncolumn;
    }

    public void setIsselectioncolumn(Character isselectioncolumn) {
        this.isselectioncolumn = isselectioncolumn;
    }

    public Character getIssessionattr() {
        return issessionattr;
    }

    public void setIssessionattr(Character issessionattr) {
        this.issessionattr = issessionattr;
    }

    public Character getIssecondarykey() {
        return issecondarykey;
    }

    public void setIssecondarykey(Character issecondarykey) {
        this.issecondarykey = issecondarykey;
    }

    public Character getIsdesencryptable() {
        return isdesencryptable;
    }

    public void setIsdesencryptable(Character isdesencryptable) {
        this.isdesencryptable = isdesencryptable;
    }

    public String getDevelopmentstatus() {
        return developmentstatus;
    }

    public void setDevelopmentstatus(String developmentstatus) {
        this.developmentstatus = developmentstatus;
    }

    public BigInteger getPosition() {
        return position;
    }

    public void setPosition(BigInteger position) {
        this.position = position;
    }

    public Character getIstransient() {
        return istransient;
    }

    public void setIstransient(Character istransient) {
        this.istransient = istransient;
    }

    public String getIstransientcondition() {
        return istransientcondition;
    }

    public void setIstransientcondition(String istransientcondition) {
        this.istransientcondition = istransientcondition;
    }

    public Character getIsautosave() {
        return isautosave;
    }

    public void setIsautosave(Character isautosave) {
        this.isautosave = isautosave;
    }

    public Character getValidateonnew() {
        return validateonnew;
    }

    public void setValidateonnew(Character validateonnew) {
        this.validateonnew = validateonnew;
    }

    public AdCallout getAdCalloutId() {
        return adCalloutId;
    }

    public void setAdCalloutId(AdCallout adCalloutId) {
        this.adCalloutId = adCalloutId;
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

    public AdModule getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(AdModule adModuleId) {
        this.adModuleId = adModuleId;
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

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    public AdValRule getAdValRuleId() {
        return adValRuleId;
    }

    public void setAdValRuleId(AdValRule adValRuleId) {
        this.adValRuleId = adValRuleId;
    }

    @XmlTransient
    public List<AdRefSearch> getAdRefSearchList() {
        return adRefSearchList;
    }

    public void setAdRefSearchList(List<AdRefSearch> adRefSearchList) {
        this.adRefSearchList = adRefSearchList;
    }

    @XmlTransient
    public List<AdDatasetColumn> getAdDatasetColumnList() {
        return adDatasetColumnList;
    }

    public void setAdDatasetColumnList(List<AdDatasetColumn> adDatasetColumnList) {
        this.adDatasetColumnList = adDatasetColumnList;
    }

    @XmlTransient
    public List<AdRefTable> getAdRefTableList() {
        return adRefTableList;
    }

    public void setAdRefTableList(List<AdRefTable> adRefTableList) {
        this.adRefTableList = adRefTableList;
    }

    @XmlTransient
    public List<AdRefTable> getAdRefTableList1() {
        return adRefTableList1;
    }

    public void setAdRefTableList1(List<AdRefTable> adRefTableList1) {
        this.adRefTableList1 = adRefTableList1;
    }

    @XmlTransient
    public List<IElementvalue> getIElementvalueList() {
        return iElementvalueList;
    }

    public void setIElementvalueList(List<IElementvalue> iElementvalueList) {
        this.iElementvalueList = iElementvalueList;
    }

    @XmlTransient
    public List<AdChangelog> getAdChangelogList() {
        return adChangelogList;
    }

    public void setAdChangelogList(List<AdChangelog> adChangelogList) {
        this.adChangelogList = adChangelogList;
    }

    @XmlTransient
    public List<AdImpformatRow> getAdImpformatRowList() {
        return adImpformatRowList;
    }

    public void setAdImpformatRowList(List<AdImpformatRow> adImpformatRowList) {
        this.adImpformatRowList = adImpformatRowList;
    }

    @XmlTransient
    public List<AdTab> getAdTabList() {
        return adTabList;
    }

    public void setAdTabList(List<AdTab> adTabList) {
        this.adTabList = adTabList;
    }

    @XmlTransient
    public List<AdTab> getAdTabList1() {
        return adTabList1;
    }

    public void setAdTabList1(List<AdTab> adTabList1) {
        this.adTabList1 = adTabList1;
    }

    @XmlTransient
    public List<AdTab> getAdTabList2() {
        return adTabList2;
    }

    public void setAdTabList2(List<AdTab> adTabList2) {
        this.adTabList2 = adTabList2;
    }

    @XmlTransient
    public List<AdTable> getAdTableList() {
        return adTableList;
    }

    public void setAdTableList(List<AdTable> adTableList) {
        this.adTableList = adTableList;
    }

    @XmlTransient
    public List<AdColumnAccess> getAdColumnAccessList() {
        return adColumnAccessList;
    }

    public void setAdColumnAccessList(List<AdColumnAccess> adColumnAccessList) {
        this.adColumnAccessList = adColumnAccessList;
    }

    @XmlTransient
    public List<AdField> getAdFieldList() {
        return adFieldList;
    }

    public void setAdFieldList(List<AdField> adFieldList) {
        this.adFieldList = adFieldList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adColumnId != null ? adColumnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdColumn)) {
            return false;
        }
        AdColumn other = (AdColumn) object;
        if ((this.adColumnId == null && other.adColumnId != null) || (this.adColumnId != null && !this.adColumnId.equals(other.adColumnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdColumn[ adColumnId=" + adColumnId + " ]";
    }
    
}
