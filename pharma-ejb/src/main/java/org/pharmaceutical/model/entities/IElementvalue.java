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
@Table(name = "i_elementvalue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IElementvalue.findAll", query = "SELECT i FROM IElementvalue i"),
    @NamedQuery(name = "IElementvalue.findByIElementvalueId", query = "SELECT i FROM IElementvalue i WHERE i.iElementvalueId = :iElementvalueId"),
    @NamedQuery(name = "IElementvalue.findByIsactive", query = "SELECT i FROM IElementvalue i WHERE i.isactive = :isactive"),
    @NamedQuery(name = "IElementvalue.findByCreatedby", query = "SELECT i FROM IElementvalue i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "IElementvalue.findByCreated", query = "SELECT i FROM IElementvalue i WHERE i.created = :created"),
    @NamedQuery(name = "IElementvalue.findByUpdated", query = "SELECT i FROM IElementvalue i WHERE i.updated = :updated"),
    @NamedQuery(name = "IElementvalue.findByUpdatedby", query = "SELECT i FROM IElementvalue i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "IElementvalue.findByElementname", query = "SELECT i FROM IElementvalue i WHERE i.elementname = :elementname"),
    @NamedQuery(name = "IElementvalue.findByValue", query = "SELECT i FROM IElementvalue i WHERE i.value = :value"),
    @NamedQuery(name = "IElementvalue.findByName", query = "SELECT i FROM IElementvalue i WHERE i.name = :name"),
    @NamedQuery(name = "IElementvalue.findByDescription", query = "SELECT i FROM IElementvalue i WHERE i.description = :description"),
    @NamedQuery(name = "IElementvalue.findByAccounttype", query = "SELECT i FROM IElementvalue i WHERE i.accounttype = :accounttype"),
    @NamedQuery(name = "IElementvalue.findByAccountsign", query = "SELECT i FROM IElementvalue i WHERE i.accountsign = :accountsign"),
    @NamedQuery(name = "IElementvalue.findByIsdoccontrolled", query = "SELECT i FROM IElementvalue i WHERE i.isdoccontrolled = :isdoccontrolled"),
    @NamedQuery(name = "IElementvalue.findByIssummary", query = "SELECT i FROM IElementvalue i WHERE i.issummary = :issummary"),
    @NamedQuery(name = "IElementvalue.findByParentvalue", query = "SELECT i FROM IElementvalue i WHERE i.parentvalue = :parentvalue"),
    @NamedQuery(name = "IElementvalue.findByPostactual", query = "SELECT i FROM IElementvalue i WHERE i.postactual = :postactual"),
    @NamedQuery(name = "IElementvalue.findByPostbudget", query = "SELECT i FROM IElementvalue i WHERE i.postbudget = :postbudget"),
    @NamedQuery(name = "IElementvalue.findByPoststatistical", query = "SELECT i FROM IElementvalue i WHERE i.poststatistical = :poststatistical"),
    @NamedQuery(name = "IElementvalue.findByPostencumbrance", query = "SELECT i FROM IElementvalue i WHERE i.postencumbrance = :postencumbrance"),
    @NamedQuery(name = "IElementvalue.findByDefaultAccount", query = "SELECT i FROM IElementvalue i WHERE i.defaultAccount = :defaultAccount"),
    @NamedQuery(name = "IElementvalue.findByProcessing", query = "SELECT i FROM IElementvalue i WHERE i.processing = :processing"),
    @NamedQuery(name = "IElementvalue.findByProcessed", query = "SELECT i FROM IElementvalue i WHERE i.processed = :processed"),
    @NamedQuery(name = "IElementvalue.findByIErrormsg", query = "SELECT i FROM IElementvalue i WHERE i.iErrormsg = :iErrormsg"),
    @NamedQuery(name = "IElementvalue.findByIIsimported", query = "SELECT i FROM IElementvalue i WHERE i.iIsimported = :iIsimported"),
    @NamedQuery(name = "IElementvalue.findByElementlevel", query = "SELECT i FROM IElementvalue i WHERE i.elementlevel = :elementlevel"),
    @NamedQuery(name = "IElementvalue.findByOperands", query = "SELECT i FROM IElementvalue i WHERE i.operands = :operands"),
    @NamedQuery(name = "IElementvalue.findBySeqno", query = "SELECT i FROM IElementvalue i WHERE i.seqno = :seqno")})
public class IElementvalue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "i_elementvalue_id")
    private String iElementvalueId;
    @Column(name = "isactive")
    private Character isactive;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 60)
    @Column(name = "elementname")
    private String elementname;
    @Size(max = 40)
    @Column(name = "value")
    private String value;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 60)
    @Column(name = "accounttype")
    private String accounttype;
    @Size(max = 60)
    @Column(name = "accountsign")
    private String accountsign;
    @Column(name = "isdoccontrolled")
    private Character isdoccontrolled;
    @Column(name = "issummary")
    private Character issummary;
    @Size(max = 40)
    @Column(name = "parentvalue")
    private String parentvalue;
    @Column(name = "postactual")
    private Character postactual;
    @Column(name = "postbudget")
    private Character postbudget;
    @Column(name = "poststatistical")
    private Character poststatistical;
    @Column(name = "postencumbrance")
    private Character postencumbrance;
    @Size(max = 30)
    @Column(name = "default_account")
    private String defaultAccount;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
    @Size(max = 2000)
    @Column(name = "i_errormsg")
    private String iErrormsg;
    @Column(name = "i_isimported")
    private Character iIsimported;
    @Size(max = 60)
    @Column(name = "elementlevel")
    private String elementlevel;
    @Size(max = 1000)
    @Column(name = "operands")
    private String operands;
    @Column(name = "seqno")
    private Long seqno;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_column_id", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdColumn adColumnId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_element_id", referencedColumnName = "c_element_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CElement cElementId;
    @JoinColumn(name = "parentelementvalue_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CElementvalue parentelementvalueId;
    @JoinColumn(name = "c_elementvalue_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CElementvalue cElementvalueId;

    public IElementvalue() {
    }

    public IElementvalue(String iElementvalueId) {
        this.iElementvalueId = iElementvalueId;
    }

    public String getIElementvalueId() {
        return iElementvalueId;
    }

    public void setIElementvalueId(String iElementvalueId) {
        this.iElementvalueId = iElementvalueId;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
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

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getElementname() {
        return elementname;
    }

    public void setElementname(String elementname) {
        this.elementname = elementname;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getAccountsign() {
        return accountsign;
    }

    public void setAccountsign(String accountsign) {
        this.accountsign = accountsign;
    }

    public Character getIsdoccontrolled() {
        return isdoccontrolled;
    }

    public void setIsdoccontrolled(Character isdoccontrolled) {
        this.isdoccontrolled = isdoccontrolled;
    }

    public Character getIssummary() {
        return issummary;
    }

    public void setIssummary(Character issummary) {
        this.issummary = issummary;
    }

    public String getParentvalue() {
        return parentvalue;
    }

    public void setParentvalue(String parentvalue) {
        this.parentvalue = parentvalue;
    }

    public Character getPostactual() {
        return postactual;
    }

    public void setPostactual(Character postactual) {
        this.postactual = postactual;
    }

    public Character getPostbudget() {
        return postbudget;
    }

    public void setPostbudget(Character postbudget) {
        this.postbudget = postbudget;
    }

    public Character getPoststatistical() {
        return poststatistical;
    }

    public void setPoststatistical(Character poststatistical) {
        this.poststatistical = poststatistical;
    }

    public Character getPostencumbrance() {
        return postencumbrance;
    }

    public void setPostencumbrance(Character postencumbrance) {
        this.postencumbrance = postencumbrance;
    }

    public String getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(String defaultAccount) {
        this.defaultAccount = defaultAccount;
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

    public String getIErrormsg() {
        return iErrormsg;
    }

    public void setIErrormsg(String iErrormsg) {
        this.iErrormsg = iErrormsg;
    }

    public Character getIIsimported() {
        return iIsimported;
    }

    public void setIIsimported(Character iIsimported) {
        this.iIsimported = iIsimported;
    }

    public String getElementlevel() {
        return elementlevel;
    }

    public void setElementlevel(String elementlevel) {
        this.elementlevel = elementlevel;
    }

    public String getOperands() {
        return operands;
    }

    public void setOperands(String operands) {
        this.operands = operands;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdColumn getAdColumnId() {
        return adColumnId;
    }

    public void setAdColumnId(AdColumn adColumnId) {
        this.adColumnId = adColumnId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public CElement getCElementId() {
        return cElementId;
    }

    public void setCElementId(CElement cElementId) {
        this.cElementId = cElementId;
    }

    public CElementvalue getParentelementvalueId() {
        return parentelementvalueId;
    }

    public void setParentelementvalueId(CElementvalue parentelementvalueId) {
        this.parentelementvalueId = parentelementvalueId;
    }

    public CElementvalue getCElementvalueId() {
        return cElementvalueId;
    }

    public void setCElementvalueId(CElementvalue cElementvalueId) {
        this.cElementvalueId = cElementvalueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iElementvalueId != null ? iElementvalueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IElementvalue)) {
            return false;
        }
        IElementvalue other = (IElementvalue) object;
        if ((this.iElementvalueId == null && other.iElementvalueId != null) || (this.iElementvalueId != null && !this.iElementvalueId.equals(other.iElementvalueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.IElementvalue[ iElementvalueId=" + iElementvalueId + " ]";
    }
    
}
