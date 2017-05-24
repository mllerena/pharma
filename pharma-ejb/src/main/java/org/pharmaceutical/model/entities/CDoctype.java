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
@Table(name = "c_doctype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CDoctype.findAll", query = "SELECT c FROM CDoctype c"),
    @NamedQuery(name = "CDoctype.findByCDoctypeId", query = "SELECT c FROM CDoctype c WHERE c.cDoctypeId = :cDoctypeId"),
    @NamedQuery(name = "CDoctype.findByIsactive", query = "SELECT c FROM CDoctype c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CDoctype.findByCreated", query = "SELECT c FROM CDoctype c WHERE c.created = :created"),
    @NamedQuery(name = "CDoctype.findByCreatedby", query = "SELECT c FROM CDoctype c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CDoctype.findByUpdated", query = "SELECT c FROM CDoctype c WHERE c.updated = :updated"),
    @NamedQuery(name = "CDoctype.findByUpdatedby", query = "SELECT c FROM CDoctype c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CDoctype.findByName", query = "SELECT c FROM CDoctype c WHERE c.name = :name"),
    @NamedQuery(name = "CDoctype.findByPrintname", query = "SELECT c FROM CDoctype c WHERE c.printname = :printname"),
    @NamedQuery(name = "CDoctype.findByDescription", query = "SELECT c FROM CDoctype c WHERE c.description = :description"),
    @NamedQuery(name = "CDoctype.findByDocbasetype", query = "SELECT c FROM CDoctype c WHERE c.docbasetype = :docbasetype"),
    @NamedQuery(name = "CDoctype.findByIssotrx", query = "SELECT c FROM CDoctype c WHERE c.issotrx = :issotrx"),
    @NamedQuery(name = "CDoctype.findByDocsubtypeso", query = "SELECT c FROM CDoctype c WHERE c.docsubtypeso = :docsubtypeso"),
    @NamedQuery(name = "CDoctype.findByIsdocnocontrolled", query = "SELECT c FROM CDoctype c WHERE c.isdocnocontrolled = :isdocnocontrolled"),
    @NamedQuery(name = "CDoctype.findByDocumentnote", query = "SELECT c FROM CDoctype c WHERE c.documentnote = :documentnote"),
    @NamedQuery(name = "CDoctype.findByIsdefault", query = "SELECT c FROM CDoctype c WHERE c.isdefault = :isdefault"),
    @NamedQuery(name = "CDoctype.findByDocumentcopies", query = "SELECT c FROM CDoctype c WHERE c.documentcopies = :documentcopies"),
    @NamedQuery(name = "CDoctype.findByOrgfiltered", query = "SELECT c FROM CDoctype c WHERE c.orgfiltered = :orgfiltered"),
    @NamedQuery(name = "CDoctype.findByIsexpense", query = "SELECT c FROM CDoctype c WHERE c.isexpense = :isexpense"),
    @NamedQuery(name = "CDoctype.findByIsreversal", query = "SELECT c FROM CDoctype c WHERE c.isreversal = :isreversal")})
public class CDoctype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_doctype_id")
    private String cDoctypeId;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "printname")
    private String printname;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "docbasetype")
    private String docbasetype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issotrx")
    private Character issotrx;
    @Size(max = 60)
    @Column(name = "docsubtypeso")
    private String docsubtypeso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdocnocontrolled")
    private Character isdocnocontrolled;
    @Size(max = 2000)
    @Column(name = "documentnote")
    private String documentnote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentcopies")
    private long documentcopies;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orgfiltered")
    private Character orgfiltered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isexpense")
    private Character isexpense;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isreversal")
    private Character isreversal;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDoctypeId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<CSettlement> cSettlementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<CDoctypeTrl> cDoctypeTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypetargetId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<CInvoice> cInvoiceList1;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "docnosequence_id", referencedColumnName = "ad_sequence_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdSequence docnosequenceId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTable adTableId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDoctypeReversedId")
    private List<CDoctype> cDoctypeList;
    @JoinColumn(name = "c_doctype_reversed_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDoctype cDoctypeReversedId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDoctypeinvoiceId")
    private List<CDoctype> cDoctypeList1;
    @JoinColumn(name = "c_doctypeinvoice_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDoctype cDoctypeinvoiceId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDoctypeshipmentId")
    private List<CDoctype> cDoctypeList2;
    @JoinColumn(name = "c_doctypeshipment_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDoctype cDoctypeshipmentId;
    @JoinColumn(name = "gl_category_id", referencedColumnName = "gl_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private GlCategory glCategoryId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDoctypeId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypetargetId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<COrder> cOrderList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDoctypeId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<CDpManagement> cDpManagementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<FinPayment> finPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDoctypeId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<CExternalpos> cExternalposList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<FinBankstatement> finBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDoctypeId")
    private List<CTaxregisterTypeLines> cTaxregisterTypeLinesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<FinReconciliation> finReconciliationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<FinPaymentProposal> finPaymentProposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<GlJournal> glJournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDoctypeId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDoctypeId")
    private List<CPocDoctypeTemplate> cPocDoctypeTemplateList;

    public CDoctype() {
    }

    public CDoctype(String cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CDoctype(String cDoctypeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String printname, String docbasetype, Character issotrx, Character isdocnocontrolled, Character isdefault, long documentcopies, Character orgfiltered, Character isexpense, Character isreversal) {
        this.cDoctypeId = cDoctypeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.printname = printname;
        this.docbasetype = docbasetype;
        this.issotrx = issotrx;
        this.isdocnocontrolled = isdocnocontrolled;
        this.isdefault = isdefault;
        this.documentcopies = documentcopies;
        this.orgfiltered = orgfiltered;
        this.isexpense = isexpense;
        this.isreversal = isreversal;
    }

    public String getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(String cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
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

    public String getPrintname() {
        return printname;
    }

    public void setPrintname(String printname) {
        this.printname = printname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocbasetype() {
        return docbasetype;
    }

    public void setDocbasetype(String docbasetype) {
        this.docbasetype = docbasetype;
    }

    public Character getIssotrx() {
        return issotrx;
    }

    public void setIssotrx(Character issotrx) {
        this.issotrx = issotrx;
    }

    public String getDocsubtypeso() {
        return docsubtypeso;
    }

    public void setDocsubtypeso(String docsubtypeso) {
        this.docsubtypeso = docsubtypeso;
    }

    public Character getIsdocnocontrolled() {
        return isdocnocontrolled;
    }

    public void setIsdocnocontrolled(Character isdocnocontrolled) {
        this.isdocnocontrolled = isdocnocontrolled;
    }

    public String getDocumentnote() {
        return documentnote;
    }

    public void setDocumentnote(String documentnote) {
        this.documentnote = documentnote;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public long getDocumentcopies() {
        return documentcopies;
    }

    public void setDocumentcopies(long documentcopies) {
        this.documentcopies = documentcopies;
    }

    public Character getOrgfiltered() {
        return orgfiltered;
    }

    public void setOrgfiltered(Character orgfiltered) {
        this.orgfiltered = orgfiltered;
    }

    public Character getIsexpense() {
        return isexpense;
    }

    public void setIsexpense(Character isexpense) {
        this.isexpense = isexpense;
    }

    public Character getIsreversal() {
        return isreversal;
    }

    public void setIsreversal(Character isreversal) {
        this.isreversal = isreversal;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<CSettlement> getCSettlementList() {
        return cSettlementList;
    }

    public void setCSettlementList(List<CSettlement> cSettlementList) {
        this.cSettlementList = cSettlementList;
    }

    @XmlTransient
    public List<CDoctypeTrl> getCDoctypeTrlList() {
        return cDoctypeTrlList;
    }

    public void setCDoctypeTrlList(List<CDoctypeTrl> cDoctypeTrlList) {
        this.cDoctypeTrlList = cDoctypeTrlList;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList1() {
        return cInvoiceList1;
    }

    public void setCInvoiceList1(List<CInvoice> cInvoiceList1) {
        this.cInvoiceList1 = cInvoiceList1;
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

    public AdSequence getDocnosequenceId() {
        return docnosequenceId;
    }

    public void setDocnosequenceId(AdSequence docnosequenceId) {
        this.docnosequenceId = docnosequenceId;
    }

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @XmlTransient
    public List<CDoctype> getCDoctypeList() {
        return cDoctypeList;
    }

    public void setCDoctypeList(List<CDoctype> cDoctypeList) {
        this.cDoctypeList = cDoctypeList;
    }

    public CDoctype getCDoctypeReversedId() {
        return cDoctypeReversedId;
    }

    public void setCDoctypeReversedId(CDoctype cDoctypeReversedId) {
        this.cDoctypeReversedId = cDoctypeReversedId;
    }

    @XmlTransient
    public List<CDoctype> getCDoctypeList1() {
        return cDoctypeList1;
    }

    public void setCDoctypeList1(List<CDoctype> cDoctypeList1) {
        this.cDoctypeList1 = cDoctypeList1;
    }

    public CDoctype getCDoctypeinvoiceId() {
        return cDoctypeinvoiceId;
    }

    public void setCDoctypeinvoiceId(CDoctype cDoctypeinvoiceId) {
        this.cDoctypeinvoiceId = cDoctypeinvoiceId;
    }

    @XmlTransient
    public List<CDoctype> getCDoctypeList2() {
        return cDoctypeList2;
    }

    public void setCDoctypeList2(List<CDoctype> cDoctypeList2) {
        this.cDoctypeList2 = cDoctypeList2;
    }

    public CDoctype getCDoctypeshipmentId() {
        return cDoctypeshipmentId;
    }

    public void setCDoctypeshipmentId(CDoctype cDoctypeshipmentId) {
        this.cDoctypeshipmentId = cDoctypeshipmentId;
    }

    public GlCategory getGlCategoryId() {
        return glCategoryId;
    }

    public void setGlCategoryId(GlCategory glCategoryId) {
        this.glCategoryId = glCategoryId;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<COrder> getCOrderList1() {
        return cOrderList1;
    }

    public void setCOrderList1(List<COrder> cOrderList1) {
        this.cOrderList1 = cOrderList1;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<CDpManagement> getCDpManagementList() {
        return cDpManagementList;
    }

    public void setCDpManagementList(List<CDpManagement> cDpManagementList) {
        this.cDpManagementList = cDpManagementList;
    }

    @XmlTransient
    public List<FinPayment> getFinPaymentList() {
        return finPaymentList;
    }

    public void setFinPaymentList(List<FinPayment> finPaymentList) {
        this.finPaymentList = finPaymentList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<CExternalpos> getCExternalposList() {
        return cExternalposList;
    }

    public void setCExternalposList(List<CExternalpos> cExternalposList) {
        this.cExternalposList = cExternalposList;
    }

    @XmlTransient
    public List<FinBankstatement> getFinBankstatementList() {
        return finBankstatementList;
    }

    public void setFinBankstatementList(List<FinBankstatement> finBankstatementList) {
        this.finBankstatementList = finBankstatementList;
    }

    @XmlTransient
    public List<CTaxregisterTypeLines> getCTaxregisterTypeLinesList() {
        return cTaxregisterTypeLinesList;
    }

    public void setCTaxregisterTypeLinesList(List<CTaxregisterTypeLines> cTaxregisterTypeLinesList) {
        this.cTaxregisterTypeLinesList = cTaxregisterTypeLinesList;
    }

    @XmlTransient
    public List<FinReconciliation> getFinReconciliationList() {
        return finReconciliationList;
    }

    public void setFinReconciliationList(List<FinReconciliation> finReconciliationList) {
        this.finReconciliationList = finReconciliationList;
    }

    @XmlTransient
    public List<FinPaymentProposal> getFinPaymentProposalList() {
        return finPaymentProposalList;
    }

    public void setFinPaymentProposalList(List<FinPaymentProposal> finPaymentProposalList) {
        this.finPaymentProposalList = finPaymentProposalList;
    }

    @XmlTransient
    public List<GlJournal> getGlJournalList() {
        return glJournalList;
    }

    public void setGlJournalList(List<GlJournal> glJournalList) {
        this.glJournalList = glJournalList;
    }

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
    }

    @XmlTransient
    public List<CPocDoctypeTemplate> getCPocDoctypeTemplateList() {
        return cPocDoctypeTemplateList;
    }

    public void setCPocDoctypeTemplateList(List<CPocDoctypeTemplate> cPocDoctypeTemplateList) {
        this.cPocDoctypeTemplateList = cPocDoctypeTemplateList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDoctypeId != null ? cDoctypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CDoctype)) {
            return false;
        }
        CDoctype other = (CDoctype) object;
        if ((this.cDoctypeId == null && other.cDoctypeId != null) || (this.cDoctypeId != null && !this.cDoctypeId.equals(other.cDoctypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CDoctype[ cDoctypeId=" + cDoctypeId + " ]";
    }
    
}
