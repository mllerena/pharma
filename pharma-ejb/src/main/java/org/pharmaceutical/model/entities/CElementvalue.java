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
@Table(name = "c_elementvalue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CElementvalue.findAll", query = "SELECT c FROM CElementvalue c"),
    @NamedQuery(name = "CElementvalue.findByCElementvalueId", query = "SELECT c FROM CElementvalue c WHERE c.cElementvalueId = :cElementvalueId"),
    @NamedQuery(name = "CElementvalue.findByIsactive", query = "SELECT c FROM CElementvalue c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CElementvalue.findByCreated", query = "SELECT c FROM CElementvalue c WHERE c.created = :created"),
    @NamedQuery(name = "CElementvalue.findByCreatedby", query = "SELECT c FROM CElementvalue c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CElementvalue.findByUpdated", query = "SELECT c FROM CElementvalue c WHERE c.updated = :updated"),
    @NamedQuery(name = "CElementvalue.findByUpdatedby", query = "SELECT c FROM CElementvalue c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CElementvalue.findByValue", query = "SELECT c FROM CElementvalue c WHERE c.value = :value"),
    @NamedQuery(name = "CElementvalue.findByName", query = "SELECT c FROM CElementvalue c WHERE c.name = :name"),
    @NamedQuery(name = "CElementvalue.findByDescription", query = "SELECT c FROM CElementvalue c WHERE c.description = :description"),
    @NamedQuery(name = "CElementvalue.findByAccounttype", query = "SELECT c FROM CElementvalue c WHERE c.accounttype = :accounttype"),
    @NamedQuery(name = "CElementvalue.findByAccountsign", query = "SELECT c FROM CElementvalue c WHERE c.accountsign = :accountsign"),
    @NamedQuery(name = "CElementvalue.findByIsdoccontrolled", query = "SELECT c FROM CElementvalue c WHERE c.isdoccontrolled = :isdoccontrolled"),
    @NamedQuery(name = "CElementvalue.findByIssummary", query = "SELECT c FROM CElementvalue c WHERE c.issummary = :issummary"),
    @NamedQuery(name = "CElementvalue.findByValidfrom", query = "SELECT c FROM CElementvalue c WHERE c.validfrom = :validfrom"),
    @NamedQuery(name = "CElementvalue.findByValidto", query = "SELECT c FROM CElementvalue c WHERE c.validto = :validto"),
    @NamedQuery(name = "CElementvalue.findByPostactual", query = "SELECT c FROM CElementvalue c WHERE c.postactual = :postactual"),
    @NamedQuery(name = "CElementvalue.findByPostbudget", query = "SELECT c FROM CElementvalue c WHERE c.postbudget = :postbudget"),
    @NamedQuery(name = "CElementvalue.findByPostencumbrance", query = "SELECT c FROM CElementvalue c WHERE c.postencumbrance = :postencumbrance"),
    @NamedQuery(name = "CElementvalue.findByPoststatistical", query = "SELECT c FROM CElementvalue c WHERE c.poststatistical = :poststatistical"),
    @NamedQuery(name = "CElementvalue.findByIsbankaccount", query = "SELECT c FROM CElementvalue c WHERE c.isbankaccount = :isbankaccount"),
    @NamedQuery(name = "CElementvalue.findByIsforeigncurrency", query = "SELECT c FROM CElementvalue c WHERE c.isforeigncurrency = :isforeigncurrency"),
    @NamedQuery(name = "CElementvalue.findByShowelement", query = "SELECT c FROM CElementvalue c WHERE c.showelement = :showelement"),
    @NamedQuery(name = "CElementvalue.findByShowvaluecond", query = "SELECT c FROM CElementvalue c WHERE c.showvaluecond = :showvaluecond"),
    @NamedQuery(name = "CElementvalue.findByElementlevel", query = "SELECT c FROM CElementvalue c WHERE c.elementlevel = :elementlevel"),
    @NamedQuery(name = "CElementvalue.findByIsalwaysshown", query = "SELECT c FROM CElementvalue c WHERE c.isalwaysshown = :isalwaysshown")})
public class CElementvalue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_elementvalue_id")
    private String cElementvalueId;
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
    @Size(min = 1, max = 40)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "accounttype")
    private String accounttype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "accountsign")
    private String accountsign;
    @Column(name = "isdoccontrolled")
    private Character isdoccontrolled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issummary")
    private Character issummary;
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @Column(name = "validto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validto;
    @Column(name = "postactual")
    private Character postactual;
    @Column(name = "postbudget")
    private Character postbudget;
    @Column(name = "postencumbrance")
    private Character postencumbrance;
    @Column(name = "poststatistical")
    private Character poststatistical;
    @Column(name = "isbankaccount")
    private Character isbankaccount;
    @Column(name = "isforeigncurrency")
    private Character isforeigncurrency;
    @Column(name = "showelement")
    private Character showelement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "showvaluecond")
    private String showvaluecond;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "elementlevel")
    private String elementlevel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isalwaysshown")
    private Character isalwaysshown;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bankaccount_id", referencedColumnName = "c_bankaccount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBankaccount cBankaccountId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_element_id", referencedColumnName = "c_element_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CElement cElementId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "accountId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "accountId")
    private List<FactAcctCfs> factAcctCfsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cElementvalueId")
    private List<CElementvalueTrl> cElementvalueTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "accountId")
    private List<CValidcombination> cValidcombinationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cElementvalueId")
    private List<CAcctRptNode> cAcctRptNodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "parentelementvalueId")
    private List<IElementvalue> iElementvalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cElementvalueId")
    private List<IElementvalue> iElementvalueList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cElementvalueId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "accountId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "accountId")
    private List<AdAccountingrptElement> adAccountingrptElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cElementvalueId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cElementvalueId")
    private List<CAcctschemaElement> cAcctschemaElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cElementvalueId")
    private List<CElementvalueOperand> cElementvalueOperandList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "accountId")
    private List<CElementvalueOperand> cElementvalueOperandList1;

    public CElementvalue() {
    }

    public CElementvalue(String cElementvalueId) {
        this.cElementvalueId = cElementvalueId;
    }

    public CElementvalue(String cElementvalueId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, String accounttype, String accountsign, Character issummary, String showvaluecond, String elementlevel, Character isalwaysshown) {
        this.cElementvalueId = cElementvalueId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.accounttype = accounttype;
        this.accountsign = accountsign;
        this.issummary = issummary;
        this.showvaluecond = showvaluecond;
        this.elementlevel = elementlevel;
        this.isalwaysshown = isalwaysshown;
    }

    public String getCElementvalueId() {
        return cElementvalueId;
    }

    public void setCElementvalueId(String cElementvalueId) {
        this.cElementvalueId = cElementvalueId;
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

    public Character getPostencumbrance() {
        return postencumbrance;
    }

    public void setPostencumbrance(Character postencumbrance) {
        this.postencumbrance = postencumbrance;
    }

    public Character getPoststatistical() {
        return poststatistical;
    }

    public void setPoststatistical(Character poststatistical) {
        this.poststatistical = poststatistical;
    }

    public Character getIsbankaccount() {
        return isbankaccount;
    }

    public void setIsbankaccount(Character isbankaccount) {
        this.isbankaccount = isbankaccount;
    }

    public Character getIsforeigncurrency() {
        return isforeigncurrency;
    }

    public void setIsforeigncurrency(Character isforeigncurrency) {
        this.isforeigncurrency = isforeigncurrency;
    }

    public Character getShowelement() {
        return showelement;
    }

    public void setShowelement(Character showelement) {
        this.showelement = showelement;
    }

    public String getShowvaluecond() {
        return showvaluecond;
    }

    public void setShowvaluecond(String showvaluecond) {
        this.showvaluecond = showvaluecond;
    }

    public String getElementlevel() {
        return elementlevel;
    }

    public void setElementlevel(String elementlevel) {
        this.elementlevel = elementlevel;
    }

    public Character getIsalwaysshown() {
        return isalwaysshown;
    }

    public void setIsalwaysshown(Character isalwaysshown) {
        this.isalwaysshown = isalwaysshown;
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

    public CBankaccount getCBankaccountId() {
        return cBankaccountId;
    }

    public void setCBankaccountId(CBankaccount cBankaccountId) {
        this.cBankaccountId = cBankaccountId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CElement getCElementId() {
        return cElementId;
    }

    public void setCElementId(CElement cElementId) {
        this.cElementId = cElementId;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<FactAcctCfs> getFactAcctCfsList() {
        return factAcctCfsList;
    }

    public void setFactAcctCfsList(List<FactAcctCfs> factAcctCfsList) {
        this.factAcctCfsList = factAcctCfsList;
    }

    @XmlTransient
    public List<CElementvalueTrl> getCElementvalueTrlList() {
        return cElementvalueTrlList;
    }

    public void setCElementvalueTrlList(List<CElementvalueTrl> cElementvalueTrlList) {
        this.cElementvalueTrlList = cElementvalueTrlList;
    }

    @XmlTransient
    public List<CValidcombination> getCValidcombinationList() {
        return cValidcombinationList;
    }

    public void setCValidcombinationList(List<CValidcombination> cValidcombinationList) {
        this.cValidcombinationList = cValidcombinationList;
    }

    @XmlTransient
    public List<CAcctRptNode> getCAcctRptNodeList() {
        return cAcctRptNodeList;
    }

    public void setCAcctRptNodeList(List<CAcctRptNode> cAcctRptNodeList) {
        this.cAcctRptNodeList = cAcctRptNodeList;
    }

    @XmlTransient
    public List<IElementvalue> getIElementvalueList() {
        return iElementvalueList;
    }

    public void setIElementvalueList(List<IElementvalue> iElementvalueList) {
        this.iElementvalueList = iElementvalueList;
    }

    @XmlTransient
    public List<IElementvalue> getIElementvalueList1() {
        return iElementvalueList1;
    }

    public void setIElementvalueList1(List<IElementvalue> iElementvalueList1) {
        this.iElementvalueList1 = iElementvalueList1;
    }

    @XmlTransient
    public List<IBudgetline> getIBudgetlineList() {
        return iBudgetlineList;
    }

    public void setIBudgetlineList(List<IBudgetline> iBudgetlineList) {
        this.iBudgetlineList = iBudgetlineList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<AdAccountingrptElement> getAdAccountingrptElementList() {
        return adAccountingrptElementList;
    }

    public void setAdAccountingrptElementList(List<AdAccountingrptElement> adAccountingrptElementList) {
        this.adAccountingrptElementList = adAccountingrptElementList;
    }

    @XmlTransient
    public List<CBudgetline> getCBudgetlineList() {
        return cBudgetlineList;
    }

    public void setCBudgetlineList(List<CBudgetline> cBudgetlineList) {
        this.cBudgetlineList = cBudgetlineList;
    }

    @XmlTransient
    public List<CAcctschemaElement> getCAcctschemaElementList() {
        return cAcctschemaElementList;
    }

    public void setCAcctschemaElementList(List<CAcctschemaElement> cAcctschemaElementList) {
        this.cAcctschemaElementList = cAcctschemaElementList;
    }

    @XmlTransient
    public List<CElementvalueOperand> getCElementvalueOperandList() {
        return cElementvalueOperandList;
    }

    public void setCElementvalueOperandList(List<CElementvalueOperand> cElementvalueOperandList) {
        this.cElementvalueOperandList = cElementvalueOperandList;
    }

    @XmlTransient
    public List<CElementvalueOperand> getCElementvalueOperandList1() {
        return cElementvalueOperandList1;
    }

    public void setCElementvalueOperandList1(List<CElementvalueOperand> cElementvalueOperandList1) {
        this.cElementvalueOperandList1 = cElementvalueOperandList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cElementvalueId != null ? cElementvalueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CElementvalue)) {
            return false;
        }
        CElementvalue other = (CElementvalue) object;
        if ((this.cElementvalueId == null && other.cElementvalueId != null) || (this.cElementvalueId != null && !this.cElementvalueId.equals(other.cElementvalueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CElementvalue[ cElementvalueId=" + cElementvalueId + " ]";
    }
    
}
