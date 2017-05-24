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
@Table(name = "c_validcombination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CValidcombination.findAll", query = "SELECT c FROM CValidcombination c"),
    @NamedQuery(name = "CValidcombination.findByCValidcombinationId", query = "SELECT c FROM CValidcombination c WHERE c.cValidcombinationId = :cValidcombinationId"),
    @NamedQuery(name = "CValidcombination.findByIsactive", query = "SELECT c FROM CValidcombination c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CValidcombination.findByCreated", query = "SELECT c FROM CValidcombination c WHERE c.created = :created"),
    @NamedQuery(name = "CValidcombination.findByCreatedby", query = "SELECT c FROM CValidcombination c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CValidcombination.findByUpdated", query = "SELECT c FROM CValidcombination c WHERE c.updated = :updated"),
    @NamedQuery(name = "CValidcombination.findByUpdatedby", query = "SELECT c FROM CValidcombination c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CValidcombination.findByAlias", query = "SELECT c FROM CValidcombination c WHERE c.alias = :alias"),
    @NamedQuery(name = "CValidcombination.findByCombination", query = "SELECT c FROM CValidcombination c WHERE c.combination = :combination"),
    @NamedQuery(name = "CValidcombination.findByDescription", query = "SELECT c FROM CValidcombination c WHERE c.description = :description"),
    @NamedQuery(name = "CValidcombination.findByIsfullyqualified", query = "SELECT c FROM CValidcombination c WHERE c.isfullyqualified = :isfullyqualified"),
    @NamedQuery(name = "CValidcombination.findByUser1Id", query = "SELECT c FROM CValidcombination c WHERE c.user1Id = :user1Id"),
    @NamedQuery(name = "CValidcombination.findByUser2Id", query = "SELECT c FROM CValidcombination c WHERE c.user2Id = :user2Id")})
public class CValidcombination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_validcombination_id")
    private String cValidcombinationId;
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
    @Size(max = 40)
    @Column(name = "alias")
    private String alias;
    @Size(max = 120)
    @Column(name = "combination")
    private String combination;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isfullyqualified")
    private Character isfullyqualified;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "accountAcct")
    private List<AdTest> adTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "ePrepaymentAcct")
    private List<CBpEmployeeAcct> cBpEmployeeAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "eExpenseAcct")
    private List<CBpEmployeeAcct> cBpEmployeeAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pjWipAcct")
    private List<CProjectAcct> cProjectAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pjAssetAcct")
    private List<CProjectAcct> cProjectAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "chRevenueAcct")
    private List<CChargeAcct> cChargeAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "chExpenseAcct")
    private List<CChargeAcct> cChargeAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "aAccumdepreciationAcct")
    private List<AAssetGroupAcct> aAssetGroupAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "aDisposalGain")
    private List<AAssetGroupAcct> aAssetGroupAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "aDisposalLoss")
    private List<AAssetGroupAcct> aAssetGroupAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "aDepreciationAcct")
    private List<AAssetGroupAcct> aAssetGroupAcctList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cValidcombinationId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finBankrevaluationgainAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finReceivepaymentAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finInClearAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finOutIntransitAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finTransitoryAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finBankrevaluationlossAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList5;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finOutClearAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList6;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finCreditAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList7;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finMakepaymentAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList8;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finInIntransitAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList9;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finAssetAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList10;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finWithdrawalAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList11;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finDepositAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList12;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finDebitAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList13;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finBankfeeAcct")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList14;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "aAccumdepreciationAcct")
    private List<AAssetAcct> aAssetAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "aDisposalLoss")
    private List<AAssetAcct> aAssetAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "aDisposalGain")
    private List<AAssetAcct> aAssetAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "aDepreciationAcct")
    private List<AAssetAcct> aAssetAcctList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pTradediscountgrantAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "wInvactualadjustAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "realizedgainAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cReceivableAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "writeoffAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pExpenseAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList5;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pAssetAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList6;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "chExpenseAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList7;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bUnidentifiedAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList8;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bUnallocatedcashAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList9;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "chRevenueAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList10;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "tLiabilityAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList11;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "paydiscountExpAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList12;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cbCashtransferAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList13;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "bExpenseAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList14;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "aDisposalLoss")
    private List<CAcctschemaDefault> cAcctschemaDefaultList15;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bSettlementlossAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList16;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "notinvoicedreceiptsAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList17;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bInterestexpAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList18;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "wInventoryAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList19;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "wDifferencesAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList20;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pPurchasepricevarianceAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList21;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bPaymentselectAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList22;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pCogsAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList23;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "ePrepaymentAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList24;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "aDepreciationAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList25;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "notinvoicedrevenueAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList26;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pTradediscountrecAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList27;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "bIntransitAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList28;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "tCreditAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList29;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cbReceiptAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList30;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "wRevaluationAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList31;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "notinvoicedreceivablesAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList32;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "bAssetAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList33;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cbDifferencesAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList34;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "bRevaluationlossAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList35;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "eExpenseAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList36;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "unearnedrevenueAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList37;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "withholdingAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList38;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "tDueAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList39;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "tReceivablesAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList40;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "vPrepaymentAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList41;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "vLiabilityAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList42;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "bRevaluationgainAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList43;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pjWipAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList44;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pRevenueAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList45;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pjAssetAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList46;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "vLiabilityServicesAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList47;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "writeoffRevAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList48;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bInterestrevAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList49;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPrepaymentAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList50;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bSettlementgainAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList51;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "tExpenseAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList52;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pInvoicepricevarianceAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList53;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cbAssetAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList54;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cbExpenseAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList55;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "paydiscountRevAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList56;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "aAccumdepreciationAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList57;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "realizedlossAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList58;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "unrealizedgainAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList59;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "aDisposalGain")
    private List<CAcctschemaDefault> cAcctschemaDefaultList60;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "unrealizedlossAcct")
    private List<CAcctschemaDefault> cAcctschemaDefaultList61;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "wInvactualadjustAcct")
    private List<MWarehouseAcct> mWarehouseAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "wDifferencesAcct")
    private List<MWarehouseAcct> mWarehouseAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "wRevaluationAcct")
    private List<MWarehouseAcct> mWarehouseAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "wInventoryAcct")
    private List<MWarehouseAcct> mWarehouseAcctList3;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "account_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CElementvalue accountId;
    @JoinColumn(name = "c_salesregion_id", referencedColumnName = "c_salesregion_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalesregion cSalesregionId;
    @JoinColumn(name = "c_locfrom_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocfromId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "c_locto_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLoctoId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pRevenueAcct")
    private List<MProductAcct> mProductAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pPurchasepricevarianceAcct")
    private List<MProductAcct> mProductAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pInvoicepricevarianceAcct")
    private List<MProductAcct> mProductAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pCogsAcct")
    private List<MProductAcct> mProductAcctList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pAssetAcct")
    private List<MProductAcct> mProductAcctList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pExpenseAcct")
    private List<MProductAcct> mProductAcctList5;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pTradediscountgrantAcct")
    private List<MProductAcct> mProductAcctList6;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pTradediscountrecAcct")
    private List<MProductAcct> mProductAcctList7;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "retainedearningAcct")
    private List<CAcctschemaGl> cAcctschemaGlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "ppvoffsetAcct")
    private List<CAcctschemaGl> cAcctschemaGlList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "intercompanyduefromAcct")
    private List<CAcctschemaGl> cAcctschemaGlList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cfsOrderAcct")
    private List<CAcctschemaGl> cAcctschemaGlList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "incomesummaryAcct")
    private List<CAcctschemaGl> cAcctschemaGlList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "suspensebalancingAcct")
    private List<CAcctschemaGl> cAcctschemaGlList5;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "currencybalancingAcct")
    private List<CAcctschemaGl> cAcctschemaGlList6;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "intercompanyduetoAcct")
    private List<CAcctschemaGl> cAcctschemaGlList7;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "suspenseerrorAcct")
    private List<CAcctschemaGl> cAcctschemaGlList8;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "tReceivablesAcct")
    private List<CTaxAcct> cTaxAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "tCreditAcct")
    private List<CTaxAcct> cTaxAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "tLiabilityAcct")
    private List<CTaxAcct> cTaxAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "tExpenseAcct")
    private List<CTaxAcct> cTaxAcctList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "tDueAcct")
    private List<CTaxAcct> cTaxAcctList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "vLiabilityAcct")
    private List<CBpGroupAcct> cBpGroupAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "unrealizedlossAcct")
    private List<CBpGroupAcct> cBpGroupAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "unrealizedgainAcct")
    private List<CBpGroupAcct> cBpGroupAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "paydiscountRevAcct")
    private List<CBpGroupAcct> cBpGroupAcctList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cReceivableAcct")
    private List<CBpGroupAcct> cBpGroupAcctList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "vPrepaymentAcct")
    private List<CBpGroupAcct> cBpGroupAcctList5;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "notinvoicedrevenueAcct")
    private List<CBpGroupAcct> cBpGroupAcctList6;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "unearnedrevenueAcct")
    private List<CBpGroupAcct> cBpGroupAcctList7;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "notinvoicedreceivablesAcct")
    private List<CBpGroupAcct> cBpGroupAcctList8;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "vLiabilityServicesAcct")
    private List<CBpGroupAcct> cBpGroupAcctList9;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "notinvoicedreceiptsAcct")
    private List<CBpGroupAcct> cBpGroupAcctList10;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "writeoffAcct")
    private List<CBpGroupAcct> cBpGroupAcctList11;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "realizedlossAcct")
    private List<CBpGroupAcct> cBpGroupAcctList12;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "realizedgainAcct")
    private List<CBpGroupAcct> cBpGroupAcctList13;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "writeoffRevAcct")
    private List<CBpGroupAcct> cBpGroupAcctList14;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPrepaymentAcct")
    private List<CBpGroupAcct> cBpGroupAcctList15;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "paydiscountExpAcct")
    private List<CBpGroupAcct> cBpGroupAcctList16;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "intercompanyduefromAcct")
    private List<CInterorgAcct> cInterorgAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "intercompanyduetoAcct")
    private List<CInterorgAcct> cInterorgAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cValidcombinationId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "unearnedrevenueAcct")
    private List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pRevenueAcct")
    private List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "glitemDebitAcct")
    private List<CGlitemAcct> cGlitemAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "glitemCreditAcct")
    private List<CGlitemAcct> cGlitemAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pExpenseAcct")
    private List<MProductCategoryAcct> mProductCategoryAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pPurchasepricevarianceAcct")
    private List<MProductCategoryAcct> mProductCategoryAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pInvoicepricevarianceAcct")
    private List<MProductCategoryAcct> mProductCategoryAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pTradediscountgrantAcct")
    private List<MProductCategoryAcct> mProductCategoryAcctList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pAssetAcct")
    private List<MProductCategoryAcct> mProductCategoryAcctList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pCogsAcct")
    private List<MProductCategoryAcct> mProductCategoryAcctList5;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "pTradediscountrecAcct")
    private List<MProductCategoryAcct> mProductCategoryAcctList6;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "pRevenueAcct")
    private List<MProductCategoryAcct> mProductCategoryAcctList7;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "vLiabilityAcct")
    private List<CBpVendorAcct> cBpVendorAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "vPrepaymentAcct")
    private List<CBpVendorAcct> cBpVendorAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "vLiabilityServicesAcct")
    private List<CBpVendorAcct> cBpVendorAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cReceivableAcct")
    private List<CBpCustomerAcct> cBpCustomerAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPrepaymentAcct")
    private List<CBpCustomerAcct> cBpCustomerAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "withholdingAcct")
    private List<CWithholdingAcct> cWithholdingAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cbReceiptAcct")
    private List<CCashbookAcct> cCashbookAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cbAssetAcct")
    private List<CCashbookAcct> cCashbookAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cbExpenseAcct")
    private List<CCashbookAcct> cCashbookAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cbDifferencesAcct")
    private List<CCashbookAcct> cCashbookAcctList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cbCashtransferAcct")
    private List<CCashbookAcct> cCashbookAcctList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bSettlementgainAcct")
    private List<CBankaccountAcct> cBankaccountAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bUnallocatedcashAcct")
    private List<CBankaccountAcct> cBankaccountAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bUnidentifiedAcct")
    private List<CBankaccountAcct> cBankaccountAcctList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bSettlementlossAcct")
    private List<CBankaccountAcct> cBankaccountAcctList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "bRevaluationgainAcct")
    private List<CBankaccountAcct> cBankaccountAcctList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "bRevaluationlossAcct")
    private List<CBankaccountAcct> cBankaccountAcctList5;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bPaymentselectAcct")
    private List<CBankaccountAcct> cBankaccountAcctList6;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "bAssetAcct")
    private List<CBankaccountAcct> cBankaccountAcctList7;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bInterestexpAcct")
    private List<CBankaccountAcct> cBankaccountAcctList8;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "bIntransitAcct")
    private List<CBankaccountAcct> cBankaccountAcctList9;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "bExpenseAcct")
    private List<CBankaccountAcct> cBankaccountAcctList10;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bInterestrevAcct")
    private List<CBankaccountAcct> cBankaccountAcctList11;

    public CValidcombination() {
    }

    public CValidcombination(String cValidcombinationId) {
        this.cValidcombinationId = cValidcombinationId;
    }

    public CValidcombination(String cValidcombinationId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isfullyqualified) {
        this.cValidcombinationId = cValidcombinationId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isfullyqualified = isfullyqualified;
    }

    public String getCValidcombinationId() {
        return cValidcombinationId;
    }

    public void setCValidcombinationId(String cValidcombinationId) {
        this.cValidcombinationId = cValidcombinationId;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCombination() {
        return combination;
    }

    public void setCombination(String combination) {
        this.combination = combination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIsfullyqualified() {
        return isfullyqualified;
    }

    public void setIsfullyqualified(Character isfullyqualified) {
        this.isfullyqualified = isfullyqualified;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }

    @XmlTransient
    public List<AdTest> getAdTestList() {
        return adTestList;
    }

    public void setAdTestList(List<AdTest> adTestList) {
        this.adTestList = adTestList;
    }

    @XmlTransient
    public List<CBpEmployeeAcct> getCBpEmployeeAcctList() {
        return cBpEmployeeAcctList;
    }

    public void setCBpEmployeeAcctList(List<CBpEmployeeAcct> cBpEmployeeAcctList) {
        this.cBpEmployeeAcctList = cBpEmployeeAcctList;
    }

    @XmlTransient
    public List<CBpEmployeeAcct> getCBpEmployeeAcctList1() {
        return cBpEmployeeAcctList1;
    }

    public void setCBpEmployeeAcctList1(List<CBpEmployeeAcct> cBpEmployeeAcctList1) {
        this.cBpEmployeeAcctList1 = cBpEmployeeAcctList1;
    }

    @XmlTransient
    public List<CProjectAcct> getCProjectAcctList() {
        return cProjectAcctList;
    }

    public void setCProjectAcctList(List<CProjectAcct> cProjectAcctList) {
        this.cProjectAcctList = cProjectAcctList;
    }

    @XmlTransient
    public List<CProjectAcct> getCProjectAcctList1() {
        return cProjectAcctList1;
    }

    public void setCProjectAcctList1(List<CProjectAcct> cProjectAcctList1) {
        this.cProjectAcctList1 = cProjectAcctList1;
    }

    @XmlTransient
    public List<CChargeAcct> getCChargeAcctList() {
        return cChargeAcctList;
    }

    public void setCChargeAcctList(List<CChargeAcct> cChargeAcctList) {
        this.cChargeAcctList = cChargeAcctList;
    }

    @XmlTransient
    public List<CChargeAcct> getCChargeAcctList1() {
        return cChargeAcctList1;
    }

    public void setCChargeAcctList1(List<CChargeAcct> cChargeAcctList1) {
        this.cChargeAcctList1 = cChargeAcctList1;
    }

    @XmlTransient
    public List<AAssetGroupAcct> getAAssetGroupAcctList() {
        return aAssetGroupAcctList;
    }

    public void setAAssetGroupAcctList(List<AAssetGroupAcct> aAssetGroupAcctList) {
        this.aAssetGroupAcctList = aAssetGroupAcctList;
    }

    @XmlTransient
    public List<AAssetGroupAcct> getAAssetGroupAcctList1() {
        return aAssetGroupAcctList1;
    }

    public void setAAssetGroupAcctList1(List<AAssetGroupAcct> aAssetGroupAcctList1) {
        this.aAssetGroupAcctList1 = aAssetGroupAcctList1;
    }

    @XmlTransient
    public List<AAssetGroupAcct> getAAssetGroupAcctList2() {
        return aAssetGroupAcctList2;
    }

    public void setAAssetGroupAcctList2(List<AAssetGroupAcct> aAssetGroupAcctList2) {
        this.aAssetGroupAcctList2 = aAssetGroupAcctList2;
    }

    @XmlTransient
    public List<AAssetGroupAcct> getAAssetGroupAcctList3() {
        return aAssetGroupAcctList3;
    }

    public void setAAssetGroupAcctList3(List<AAssetGroupAcct> aAssetGroupAcctList3) {
        this.aAssetGroupAcctList3 = aAssetGroupAcctList3;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList() {
        return finFinancialAccountAcctList;
    }

    public void setFinFinancialAccountAcctList(List<FinFinancialAccountAcct> finFinancialAccountAcctList) {
        this.finFinancialAccountAcctList = finFinancialAccountAcctList;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList1() {
        return finFinancialAccountAcctList1;
    }

    public void setFinFinancialAccountAcctList1(List<FinFinancialAccountAcct> finFinancialAccountAcctList1) {
        this.finFinancialAccountAcctList1 = finFinancialAccountAcctList1;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList2() {
        return finFinancialAccountAcctList2;
    }

    public void setFinFinancialAccountAcctList2(List<FinFinancialAccountAcct> finFinancialAccountAcctList2) {
        this.finFinancialAccountAcctList2 = finFinancialAccountAcctList2;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList3() {
        return finFinancialAccountAcctList3;
    }

    public void setFinFinancialAccountAcctList3(List<FinFinancialAccountAcct> finFinancialAccountAcctList3) {
        this.finFinancialAccountAcctList3 = finFinancialAccountAcctList3;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList4() {
        return finFinancialAccountAcctList4;
    }

    public void setFinFinancialAccountAcctList4(List<FinFinancialAccountAcct> finFinancialAccountAcctList4) {
        this.finFinancialAccountAcctList4 = finFinancialAccountAcctList4;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList5() {
        return finFinancialAccountAcctList5;
    }

    public void setFinFinancialAccountAcctList5(List<FinFinancialAccountAcct> finFinancialAccountAcctList5) {
        this.finFinancialAccountAcctList5 = finFinancialAccountAcctList5;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList6() {
        return finFinancialAccountAcctList6;
    }

    public void setFinFinancialAccountAcctList6(List<FinFinancialAccountAcct> finFinancialAccountAcctList6) {
        this.finFinancialAccountAcctList6 = finFinancialAccountAcctList6;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList7() {
        return finFinancialAccountAcctList7;
    }

    public void setFinFinancialAccountAcctList7(List<FinFinancialAccountAcct> finFinancialAccountAcctList7) {
        this.finFinancialAccountAcctList7 = finFinancialAccountAcctList7;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList8() {
        return finFinancialAccountAcctList8;
    }

    public void setFinFinancialAccountAcctList8(List<FinFinancialAccountAcct> finFinancialAccountAcctList8) {
        this.finFinancialAccountAcctList8 = finFinancialAccountAcctList8;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList9() {
        return finFinancialAccountAcctList9;
    }

    public void setFinFinancialAccountAcctList9(List<FinFinancialAccountAcct> finFinancialAccountAcctList9) {
        this.finFinancialAccountAcctList9 = finFinancialAccountAcctList9;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList10() {
        return finFinancialAccountAcctList10;
    }

    public void setFinFinancialAccountAcctList10(List<FinFinancialAccountAcct> finFinancialAccountAcctList10) {
        this.finFinancialAccountAcctList10 = finFinancialAccountAcctList10;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList11() {
        return finFinancialAccountAcctList11;
    }

    public void setFinFinancialAccountAcctList11(List<FinFinancialAccountAcct> finFinancialAccountAcctList11) {
        this.finFinancialAccountAcctList11 = finFinancialAccountAcctList11;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList12() {
        return finFinancialAccountAcctList12;
    }

    public void setFinFinancialAccountAcctList12(List<FinFinancialAccountAcct> finFinancialAccountAcctList12) {
        this.finFinancialAccountAcctList12 = finFinancialAccountAcctList12;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList13() {
        return finFinancialAccountAcctList13;
    }

    public void setFinFinancialAccountAcctList13(List<FinFinancialAccountAcct> finFinancialAccountAcctList13) {
        this.finFinancialAccountAcctList13 = finFinancialAccountAcctList13;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList14() {
        return finFinancialAccountAcctList14;
    }

    public void setFinFinancialAccountAcctList14(List<FinFinancialAccountAcct> finFinancialAccountAcctList14) {
        this.finFinancialAccountAcctList14 = finFinancialAccountAcctList14;
    }

    @XmlTransient
    public List<AAssetAcct> getAAssetAcctList() {
        return aAssetAcctList;
    }

    public void setAAssetAcctList(List<AAssetAcct> aAssetAcctList) {
        this.aAssetAcctList = aAssetAcctList;
    }

    @XmlTransient
    public List<AAssetAcct> getAAssetAcctList1() {
        return aAssetAcctList1;
    }

    public void setAAssetAcctList1(List<AAssetAcct> aAssetAcctList1) {
        this.aAssetAcctList1 = aAssetAcctList1;
    }

    @XmlTransient
    public List<AAssetAcct> getAAssetAcctList2() {
        return aAssetAcctList2;
    }

    public void setAAssetAcctList2(List<AAssetAcct> aAssetAcctList2) {
        this.aAssetAcctList2 = aAssetAcctList2;
    }

    @XmlTransient
    public List<AAssetAcct> getAAssetAcctList3() {
        return aAssetAcctList3;
    }

    public void setAAssetAcctList3(List<AAssetAcct> aAssetAcctList3) {
        this.aAssetAcctList3 = aAssetAcctList3;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList() {
        return cAcctschemaDefaultList;
    }

    public void setCAcctschemaDefaultList(List<CAcctschemaDefault> cAcctschemaDefaultList) {
        this.cAcctschemaDefaultList = cAcctschemaDefaultList;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList1() {
        return cAcctschemaDefaultList1;
    }

    public void setCAcctschemaDefaultList1(List<CAcctschemaDefault> cAcctschemaDefaultList1) {
        this.cAcctschemaDefaultList1 = cAcctschemaDefaultList1;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList2() {
        return cAcctschemaDefaultList2;
    }

    public void setCAcctschemaDefaultList2(List<CAcctschemaDefault> cAcctschemaDefaultList2) {
        this.cAcctschemaDefaultList2 = cAcctschemaDefaultList2;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList3() {
        return cAcctschemaDefaultList3;
    }

    public void setCAcctschemaDefaultList3(List<CAcctschemaDefault> cAcctschemaDefaultList3) {
        this.cAcctschemaDefaultList3 = cAcctschemaDefaultList3;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList4() {
        return cAcctschemaDefaultList4;
    }

    public void setCAcctschemaDefaultList4(List<CAcctschemaDefault> cAcctschemaDefaultList4) {
        this.cAcctschemaDefaultList4 = cAcctschemaDefaultList4;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList5() {
        return cAcctschemaDefaultList5;
    }

    public void setCAcctschemaDefaultList5(List<CAcctschemaDefault> cAcctschemaDefaultList5) {
        this.cAcctschemaDefaultList5 = cAcctschemaDefaultList5;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList6() {
        return cAcctschemaDefaultList6;
    }

    public void setCAcctschemaDefaultList6(List<CAcctschemaDefault> cAcctschemaDefaultList6) {
        this.cAcctschemaDefaultList6 = cAcctschemaDefaultList6;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList7() {
        return cAcctschemaDefaultList7;
    }

    public void setCAcctschemaDefaultList7(List<CAcctschemaDefault> cAcctschemaDefaultList7) {
        this.cAcctschemaDefaultList7 = cAcctschemaDefaultList7;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList8() {
        return cAcctschemaDefaultList8;
    }

    public void setCAcctschemaDefaultList8(List<CAcctschemaDefault> cAcctschemaDefaultList8) {
        this.cAcctschemaDefaultList8 = cAcctschemaDefaultList8;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList9() {
        return cAcctschemaDefaultList9;
    }

    public void setCAcctschemaDefaultList9(List<CAcctschemaDefault> cAcctschemaDefaultList9) {
        this.cAcctschemaDefaultList9 = cAcctschemaDefaultList9;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList10() {
        return cAcctschemaDefaultList10;
    }

    public void setCAcctschemaDefaultList10(List<CAcctschemaDefault> cAcctschemaDefaultList10) {
        this.cAcctschemaDefaultList10 = cAcctschemaDefaultList10;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList11() {
        return cAcctschemaDefaultList11;
    }

    public void setCAcctschemaDefaultList11(List<CAcctschemaDefault> cAcctschemaDefaultList11) {
        this.cAcctschemaDefaultList11 = cAcctschemaDefaultList11;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList12() {
        return cAcctschemaDefaultList12;
    }

    public void setCAcctschemaDefaultList12(List<CAcctschemaDefault> cAcctschemaDefaultList12) {
        this.cAcctschemaDefaultList12 = cAcctschemaDefaultList12;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList13() {
        return cAcctschemaDefaultList13;
    }

    public void setCAcctschemaDefaultList13(List<CAcctschemaDefault> cAcctschemaDefaultList13) {
        this.cAcctschemaDefaultList13 = cAcctschemaDefaultList13;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList14() {
        return cAcctschemaDefaultList14;
    }

    public void setCAcctschemaDefaultList14(List<CAcctschemaDefault> cAcctschemaDefaultList14) {
        this.cAcctschemaDefaultList14 = cAcctschemaDefaultList14;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList15() {
        return cAcctschemaDefaultList15;
    }

    public void setCAcctschemaDefaultList15(List<CAcctschemaDefault> cAcctschemaDefaultList15) {
        this.cAcctschemaDefaultList15 = cAcctschemaDefaultList15;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList16() {
        return cAcctschemaDefaultList16;
    }

    public void setCAcctschemaDefaultList16(List<CAcctschemaDefault> cAcctschemaDefaultList16) {
        this.cAcctschemaDefaultList16 = cAcctschemaDefaultList16;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList17() {
        return cAcctschemaDefaultList17;
    }

    public void setCAcctschemaDefaultList17(List<CAcctschemaDefault> cAcctschemaDefaultList17) {
        this.cAcctschemaDefaultList17 = cAcctschemaDefaultList17;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList18() {
        return cAcctschemaDefaultList18;
    }

    public void setCAcctschemaDefaultList18(List<CAcctschemaDefault> cAcctschemaDefaultList18) {
        this.cAcctschemaDefaultList18 = cAcctschemaDefaultList18;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList19() {
        return cAcctschemaDefaultList19;
    }

    public void setCAcctschemaDefaultList19(List<CAcctschemaDefault> cAcctschemaDefaultList19) {
        this.cAcctschemaDefaultList19 = cAcctschemaDefaultList19;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList20() {
        return cAcctschemaDefaultList20;
    }

    public void setCAcctschemaDefaultList20(List<CAcctschemaDefault> cAcctschemaDefaultList20) {
        this.cAcctschemaDefaultList20 = cAcctschemaDefaultList20;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList21() {
        return cAcctschemaDefaultList21;
    }

    public void setCAcctschemaDefaultList21(List<CAcctschemaDefault> cAcctschemaDefaultList21) {
        this.cAcctschemaDefaultList21 = cAcctschemaDefaultList21;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList22() {
        return cAcctschemaDefaultList22;
    }

    public void setCAcctschemaDefaultList22(List<CAcctschemaDefault> cAcctschemaDefaultList22) {
        this.cAcctschemaDefaultList22 = cAcctschemaDefaultList22;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList23() {
        return cAcctschemaDefaultList23;
    }

    public void setCAcctschemaDefaultList23(List<CAcctschemaDefault> cAcctschemaDefaultList23) {
        this.cAcctschemaDefaultList23 = cAcctschemaDefaultList23;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList24() {
        return cAcctschemaDefaultList24;
    }

    public void setCAcctschemaDefaultList24(List<CAcctschemaDefault> cAcctschemaDefaultList24) {
        this.cAcctschemaDefaultList24 = cAcctschemaDefaultList24;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList25() {
        return cAcctschemaDefaultList25;
    }

    public void setCAcctschemaDefaultList25(List<CAcctschemaDefault> cAcctschemaDefaultList25) {
        this.cAcctschemaDefaultList25 = cAcctschemaDefaultList25;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList26() {
        return cAcctschemaDefaultList26;
    }

    public void setCAcctschemaDefaultList26(List<CAcctschemaDefault> cAcctschemaDefaultList26) {
        this.cAcctschemaDefaultList26 = cAcctschemaDefaultList26;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList27() {
        return cAcctschemaDefaultList27;
    }

    public void setCAcctschemaDefaultList27(List<CAcctschemaDefault> cAcctschemaDefaultList27) {
        this.cAcctschemaDefaultList27 = cAcctschemaDefaultList27;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList28() {
        return cAcctschemaDefaultList28;
    }

    public void setCAcctschemaDefaultList28(List<CAcctschemaDefault> cAcctschemaDefaultList28) {
        this.cAcctschemaDefaultList28 = cAcctschemaDefaultList28;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList29() {
        return cAcctschemaDefaultList29;
    }

    public void setCAcctschemaDefaultList29(List<CAcctschemaDefault> cAcctschemaDefaultList29) {
        this.cAcctschemaDefaultList29 = cAcctschemaDefaultList29;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList30() {
        return cAcctschemaDefaultList30;
    }

    public void setCAcctschemaDefaultList30(List<CAcctschemaDefault> cAcctschemaDefaultList30) {
        this.cAcctschemaDefaultList30 = cAcctschemaDefaultList30;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList31() {
        return cAcctschemaDefaultList31;
    }

    public void setCAcctschemaDefaultList31(List<CAcctschemaDefault> cAcctschemaDefaultList31) {
        this.cAcctschemaDefaultList31 = cAcctschemaDefaultList31;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList32() {
        return cAcctschemaDefaultList32;
    }

    public void setCAcctschemaDefaultList32(List<CAcctschemaDefault> cAcctschemaDefaultList32) {
        this.cAcctschemaDefaultList32 = cAcctschemaDefaultList32;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList33() {
        return cAcctschemaDefaultList33;
    }

    public void setCAcctschemaDefaultList33(List<CAcctschemaDefault> cAcctschemaDefaultList33) {
        this.cAcctschemaDefaultList33 = cAcctschemaDefaultList33;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList34() {
        return cAcctschemaDefaultList34;
    }

    public void setCAcctschemaDefaultList34(List<CAcctschemaDefault> cAcctschemaDefaultList34) {
        this.cAcctschemaDefaultList34 = cAcctschemaDefaultList34;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList35() {
        return cAcctschemaDefaultList35;
    }

    public void setCAcctschemaDefaultList35(List<CAcctschemaDefault> cAcctschemaDefaultList35) {
        this.cAcctschemaDefaultList35 = cAcctschemaDefaultList35;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList36() {
        return cAcctschemaDefaultList36;
    }

    public void setCAcctschemaDefaultList36(List<CAcctschemaDefault> cAcctschemaDefaultList36) {
        this.cAcctschemaDefaultList36 = cAcctschemaDefaultList36;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList37() {
        return cAcctschemaDefaultList37;
    }

    public void setCAcctschemaDefaultList37(List<CAcctschemaDefault> cAcctschemaDefaultList37) {
        this.cAcctschemaDefaultList37 = cAcctschemaDefaultList37;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList38() {
        return cAcctschemaDefaultList38;
    }

    public void setCAcctschemaDefaultList38(List<CAcctschemaDefault> cAcctschemaDefaultList38) {
        this.cAcctschemaDefaultList38 = cAcctschemaDefaultList38;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList39() {
        return cAcctschemaDefaultList39;
    }

    public void setCAcctschemaDefaultList39(List<CAcctschemaDefault> cAcctschemaDefaultList39) {
        this.cAcctschemaDefaultList39 = cAcctschemaDefaultList39;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList40() {
        return cAcctschemaDefaultList40;
    }

    public void setCAcctschemaDefaultList40(List<CAcctschemaDefault> cAcctschemaDefaultList40) {
        this.cAcctschemaDefaultList40 = cAcctschemaDefaultList40;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList41() {
        return cAcctschemaDefaultList41;
    }

    public void setCAcctschemaDefaultList41(List<CAcctschemaDefault> cAcctschemaDefaultList41) {
        this.cAcctschemaDefaultList41 = cAcctschemaDefaultList41;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList42() {
        return cAcctschemaDefaultList42;
    }

    public void setCAcctschemaDefaultList42(List<CAcctschemaDefault> cAcctschemaDefaultList42) {
        this.cAcctschemaDefaultList42 = cAcctschemaDefaultList42;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList43() {
        return cAcctschemaDefaultList43;
    }

    public void setCAcctschemaDefaultList43(List<CAcctschemaDefault> cAcctschemaDefaultList43) {
        this.cAcctschemaDefaultList43 = cAcctschemaDefaultList43;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList44() {
        return cAcctschemaDefaultList44;
    }

    public void setCAcctschemaDefaultList44(List<CAcctschemaDefault> cAcctschemaDefaultList44) {
        this.cAcctschemaDefaultList44 = cAcctschemaDefaultList44;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList45() {
        return cAcctschemaDefaultList45;
    }

    public void setCAcctschemaDefaultList45(List<CAcctschemaDefault> cAcctschemaDefaultList45) {
        this.cAcctschemaDefaultList45 = cAcctschemaDefaultList45;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList46() {
        return cAcctschemaDefaultList46;
    }

    public void setCAcctschemaDefaultList46(List<CAcctschemaDefault> cAcctschemaDefaultList46) {
        this.cAcctschemaDefaultList46 = cAcctschemaDefaultList46;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList47() {
        return cAcctschemaDefaultList47;
    }

    public void setCAcctschemaDefaultList47(List<CAcctschemaDefault> cAcctschemaDefaultList47) {
        this.cAcctschemaDefaultList47 = cAcctschemaDefaultList47;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList48() {
        return cAcctschemaDefaultList48;
    }

    public void setCAcctschemaDefaultList48(List<CAcctschemaDefault> cAcctschemaDefaultList48) {
        this.cAcctschemaDefaultList48 = cAcctschemaDefaultList48;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList49() {
        return cAcctschemaDefaultList49;
    }

    public void setCAcctschemaDefaultList49(List<CAcctschemaDefault> cAcctschemaDefaultList49) {
        this.cAcctschemaDefaultList49 = cAcctschemaDefaultList49;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList50() {
        return cAcctschemaDefaultList50;
    }

    public void setCAcctschemaDefaultList50(List<CAcctschemaDefault> cAcctschemaDefaultList50) {
        this.cAcctschemaDefaultList50 = cAcctschemaDefaultList50;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList51() {
        return cAcctschemaDefaultList51;
    }

    public void setCAcctschemaDefaultList51(List<CAcctschemaDefault> cAcctschemaDefaultList51) {
        this.cAcctschemaDefaultList51 = cAcctschemaDefaultList51;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList52() {
        return cAcctschemaDefaultList52;
    }

    public void setCAcctschemaDefaultList52(List<CAcctschemaDefault> cAcctschemaDefaultList52) {
        this.cAcctschemaDefaultList52 = cAcctschemaDefaultList52;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList53() {
        return cAcctschemaDefaultList53;
    }

    public void setCAcctschemaDefaultList53(List<CAcctschemaDefault> cAcctschemaDefaultList53) {
        this.cAcctschemaDefaultList53 = cAcctschemaDefaultList53;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList54() {
        return cAcctschemaDefaultList54;
    }

    public void setCAcctschemaDefaultList54(List<CAcctschemaDefault> cAcctschemaDefaultList54) {
        this.cAcctschemaDefaultList54 = cAcctschemaDefaultList54;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList55() {
        return cAcctschemaDefaultList55;
    }

    public void setCAcctschemaDefaultList55(List<CAcctschemaDefault> cAcctschemaDefaultList55) {
        this.cAcctschemaDefaultList55 = cAcctschemaDefaultList55;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList56() {
        return cAcctschemaDefaultList56;
    }

    public void setCAcctschemaDefaultList56(List<CAcctschemaDefault> cAcctschemaDefaultList56) {
        this.cAcctschemaDefaultList56 = cAcctschemaDefaultList56;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList57() {
        return cAcctschemaDefaultList57;
    }

    public void setCAcctschemaDefaultList57(List<CAcctschemaDefault> cAcctschemaDefaultList57) {
        this.cAcctschemaDefaultList57 = cAcctschemaDefaultList57;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList58() {
        return cAcctschemaDefaultList58;
    }

    public void setCAcctschemaDefaultList58(List<CAcctschemaDefault> cAcctschemaDefaultList58) {
        this.cAcctschemaDefaultList58 = cAcctschemaDefaultList58;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList59() {
        return cAcctschemaDefaultList59;
    }

    public void setCAcctschemaDefaultList59(List<CAcctschemaDefault> cAcctschemaDefaultList59) {
        this.cAcctschemaDefaultList59 = cAcctschemaDefaultList59;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList60() {
        return cAcctschemaDefaultList60;
    }

    public void setCAcctschemaDefaultList60(List<CAcctschemaDefault> cAcctschemaDefaultList60) {
        this.cAcctschemaDefaultList60 = cAcctschemaDefaultList60;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList61() {
        return cAcctschemaDefaultList61;
    }

    public void setCAcctschemaDefaultList61(List<CAcctschemaDefault> cAcctschemaDefaultList61) {
        this.cAcctschemaDefaultList61 = cAcctschemaDefaultList61;
    }

    @XmlTransient
    public List<MWarehouseAcct> getMWarehouseAcctList() {
        return mWarehouseAcctList;
    }

    public void setMWarehouseAcctList(List<MWarehouseAcct> mWarehouseAcctList) {
        this.mWarehouseAcctList = mWarehouseAcctList;
    }

    @XmlTransient
    public List<MWarehouseAcct> getMWarehouseAcctList1() {
        return mWarehouseAcctList1;
    }

    public void setMWarehouseAcctList1(List<MWarehouseAcct> mWarehouseAcctList1) {
        this.mWarehouseAcctList1 = mWarehouseAcctList1;
    }

    @XmlTransient
    public List<MWarehouseAcct> getMWarehouseAcctList2() {
        return mWarehouseAcctList2;
    }

    public void setMWarehouseAcctList2(List<MWarehouseAcct> mWarehouseAcctList2) {
        this.mWarehouseAcctList2 = mWarehouseAcctList2;
    }

    @XmlTransient
    public List<MWarehouseAcct> getMWarehouseAcctList3() {
        return mWarehouseAcctList3;
    }

    public void setMWarehouseAcctList3(List<MWarehouseAcct> mWarehouseAcctList3) {
        this.mWarehouseAcctList3 = mWarehouseAcctList3;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
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

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CElementvalue getAccountId() {
        return accountId;
    }

    public void setAccountId(CElementvalue accountId) {
        this.accountId = accountId;
    }

    public CSalesregion getCSalesregionId() {
        return cSalesregionId;
    }

    public void setCSalesregionId(CSalesregion cSalesregionId) {
        this.cSalesregionId = cSalesregionId;
    }

    public CLocation getCLocfromId() {
        return cLocfromId;
    }

    public void setCLocfromId(CLocation cLocfromId) {
        this.cLocfromId = cLocfromId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public CLocation getCLoctoId() {
        return cLoctoId;
    }

    public void setCLoctoId(CLocation cLoctoId) {
        this.cLoctoId = cLoctoId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList() {
        return mProductAcctList;
    }

    public void setMProductAcctList(List<MProductAcct> mProductAcctList) {
        this.mProductAcctList = mProductAcctList;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList1() {
        return mProductAcctList1;
    }

    public void setMProductAcctList1(List<MProductAcct> mProductAcctList1) {
        this.mProductAcctList1 = mProductAcctList1;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList2() {
        return mProductAcctList2;
    }

    public void setMProductAcctList2(List<MProductAcct> mProductAcctList2) {
        this.mProductAcctList2 = mProductAcctList2;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList3() {
        return mProductAcctList3;
    }

    public void setMProductAcctList3(List<MProductAcct> mProductAcctList3) {
        this.mProductAcctList3 = mProductAcctList3;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList4() {
        return mProductAcctList4;
    }

    public void setMProductAcctList4(List<MProductAcct> mProductAcctList4) {
        this.mProductAcctList4 = mProductAcctList4;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList5() {
        return mProductAcctList5;
    }

    public void setMProductAcctList5(List<MProductAcct> mProductAcctList5) {
        this.mProductAcctList5 = mProductAcctList5;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList6() {
        return mProductAcctList6;
    }

    public void setMProductAcctList6(List<MProductAcct> mProductAcctList6) {
        this.mProductAcctList6 = mProductAcctList6;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList7() {
        return mProductAcctList7;
    }

    public void setMProductAcctList7(List<MProductAcct> mProductAcctList7) {
        this.mProductAcctList7 = mProductAcctList7;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList() {
        return cAcctschemaGlList;
    }

    public void setCAcctschemaGlList(List<CAcctschemaGl> cAcctschemaGlList) {
        this.cAcctschemaGlList = cAcctschemaGlList;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList1() {
        return cAcctschemaGlList1;
    }

    public void setCAcctschemaGlList1(List<CAcctschemaGl> cAcctschemaGlList1) {
        this.cAcctschemaGlList1 = cAcctschemaGlList1;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList2() {
        return cAcctschemaGlList2;
    }

    public void setCAcctschemaGlList2(List<CAcctschemaGl> cAcctschemaGlList2) {
        this.cAcctschemaGlList2 = cAcctschemaGlList2;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList3() {
        return cAcctschemaGlList3;
    }

    public void setCAcctschemaGlList3(List<CAcctschemaGl> cAcctschemaGlList3) {
        this.cAcctschemaGlList3 = cAcctschemaGlList3;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList4() {
        return cAcctschemaGlList4;
    }

    public void setCAcctschemaGlList4(List<CAcctschemaGl> cAcctschemaGlList4) {
        this.cAcctschemaGlList4 = cAcctschemaGlList4;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList5() {
        return cAcctschemaGlList5;
    }

    public void setCAcctschemaGlList5(List<CAcctschemaGl> cAcctschemaGlList5) {
        this.cAcctschemaGlList5 = cAcctschemaGlList5;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList6() {
        return cAcctschemaGlList6;
    }

    public void setCAcctschemaGlList6(List<CAcctschemaGl> cAcctschemaGlList6) {
        this.cAcctschemaGlList6 = cAcctschemaGlList6;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList7() {
        return cAcctschemaGlList7;
    }

    public void setCAcctschemaGlList7(List<CAcctschemaGl> cAcctschemaGlList7) {
        this.cAcctschemaGlList7 = cAcctschemaGlList7;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList8() {
        return cAcctschemaGlList8;
    }

    public void setCAcctschemaGlList8(List<CAcctschemaGl> cAcctschemaGlList8) {
        this.cAcctschemaGlList8 = cAcctschemaGlList8;
    }

    @XmlTransient
    public List<CTaxAcct> getCTaxAcctList() {
        return cTaxAcctList;
    }

    public void setCTaxAcctList(List<CTaxAcct> cTaxAcctList) {
        this.cTaxAcctList = cTaxAcctList;
    }

    @XmlTransient
    public List<CTaxAcct> getCTaxAcctList1() {
        return cTaxAcctList1;
    }

    public void setCTaxAcctList1(List<CTaxAcct> cTaxAcctList1) {
        this.cTaxAcctList1 = cTaxAcctList1;
    }

    @XmlTransient
    public List<CTaxAcct> getCTaxAcctList2() {
        return cTaxAcctList2;
    }

    public void setCTaxAcctList2(List<CTaxAcct> cTaxAcctList2) {
        this.cTaxAcctList2 = cTaxAcctList2;
    }

    @XmlTransient
    public List<CTaxAcct> getCTaxAcctList3() {
        return cTaxAcctList3;
    }

    public void setCTaxAcctList3(List<CTaxAcct> cTaxAcctList3) {
        this.cTaxAcctList3 = cTaxAcctList3;
    }

    @XmlTransient
    public List<CTaxAcct> getCTaxAcctList4() {
        return cTaxAcctList4;
    }

    public void setCTaxAcctList4(List<CTaxAcct> cTaxAcctList4) {
        this.cTaxAcctList4 = cTaxAcctList4;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList() {
        return cBpGroupAcctList;
    }

    public void setCBpGroupAcctList(List<CBpGroupAcct> cBpGroupAcctList) {
        this.cBpGroupAcctList = cBpGroupAcctList;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList1() {
        return cBpGroupAcctList1;
    }

    public void setCBpGroupAcctList1(List<CBpGroupAcct> cBpGroupAcctList1) {
        this.cBpGroupAcctList1 = cBpGroupAcctList1;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList2() {
        return cBpGroupAcctList2;
    }

    public void setCBpGroupAcctList2(List<CBpGroupAcct> cBpGroupAcctList2) {
        this.cBpGroupAcctList2 = cBpGroupAcctList2;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList3() {
        return cBpGroupAcctList3;
    }

    public void setCBpGroupAcctList3(List<CBpGroupAcct> cBpGroupAcctList3) {
        this.cBpGroupAcctList3 = cBpGroupAcctList3;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList4() {
        return cBpGroupAcctList4;
    }

    public void setCBpGroupAcctList4(List<CBpGroupAcct> cBpGroupAcctList4) {
        this.cBpGroupAcctList4 = cBpGroupAcctList4;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList5() {
        return cBpGroupAcctList5;
    }

    public void setCBpGroupAcctList5(List<CBpGroupAcct> cBpGroupAcctList5) {
        this.cBpGroupAcctList5 = cBpGroupAcctList5;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList6() {
        return cBpGroupAcctList6;
    }

    public void setCBpGroupAcctList6(List<CBpGroupAcct> cBpGroupAcctList6) {
        this.cBpGroupAcctList6 = cBpGroupAcctList6;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList7() {
        return cBpGroupAcctList7;
    }

    public void setCBpGroupAcctList7(List<CBpGroupAcct> cBpGroupAcctList7) {
        this.cBpGroupAcctList7 = cBpGroupAcctList7;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList8() {
        return cBpGroupAcctList8;
    }

    public void setCBpGroupAcctList8(List<CBpGroupAcct> cBpGroupAcctList8) {
        this.cBpGroupAcctList8 = cBpGroupAcctList8;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList9() {
        return cBpGroupAcctList9;
    }

    public void setCBpGroupAcctList9(List<CBpGroupAcct> cBpGroupAcctList9) {
        this.cBpGroupAcctList9 = cBpGroupAcctList9;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList10() {
        return cBpGroupAcctList10;
    }

    public void setCBpGroupAcctList10(List<CBpGroupAcct> cBpGroupAcctList10) {
        this.cBpGroupAcctList10 = cBpGroupAcctList10;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList11() {
        return cBpGroupAcctList11;
    }

    public void setCBpGroupAcctList11(List<CBpGroupAcct> cBpGroupAcctList11) {
        this.cBpGroupAcctList11 = cBpGroupAcctList11;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList12() {
        return cBpGroupAcctList12;
    }

    public void setCBpGroupAcctList12(List<CBpGroupAcct> cBpGroupAcctList12) {
        this.cBpGroupAcctList12 = cBpGroupAcctList12;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList13() {
        return cBpGroupAcctList13;
    }

    public void setCBpGroupAcctList13(List<CBpGroupAcct> cBpGroupAcctList13) {
        this.cBpGroupAcctList13 = cBpGroupAcctList13;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList14() {
        return cBpGroupAcctList14;
    }

    public void setCBpGroupAcctList14(List<CBpGroupAcct> cBpGroupAcctList14) {
        this.cBpGroupAcctList14 = cBpGroupAcctList14;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList15() {
        return cBpGroupAcctList15;
    }

    public void setCBpGroupAcctList15(List<CBpGroupAcct> cBpGroupAcctList15) {
        this.cBpGroupAcctList15 = cBpGroupAcctList15;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList16() {
        return cBpGroupAcctList16;
    }

    public void setCBpGroupAcctList16(List<CBpGroupAcct> cBpGroupAcctList16) {
        this.cBpGroupAcctList16 = cBpGroupAcctList16;
    }

    @XmlTransient
    public List<CInterorgAcct> getCInterorgAcctList() {
        return cInterorgAcctList;
    }

    public void setCInterorgAcctList(List<CInterorgAcct> cInterorgAcctList) {
        this.cInterorgAcctList = cInterorgAcctList;
    }

    @XmlTransient
    public List<CInterorgAcct> getCInterorgAcctList1() {
        return cInterorgAcctList1;
    }

    public void setCInterorgAcctList1(List<CInterorgAcct> cInterorgAcctList1) {
        this.cInterorgAcctList1 = cInterorgAcctList1;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<CRevenuerecognitionPlan> getCRevenuerecognitionPlanList() {
        return cRevenuerecognitionPlanList;
    }

    public void setCRevenuerecognitionPlanList(List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList) {
        this.cRevenuerecognitionPlanList = cRevenuerecognitionPlanList;
    }

    @XmlTransient
    public List<CRevenuerecognitionPlan> getCRevenuerecognitionPlanList1() {
        return cRevenuerecognitionPlanList1;
    }

    public void setCRevenuerecognitionPlanList1(List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList1) {
        this.cRevenuerecognitionPlanList1 = cRevenuerecognitionPlanList1;
    }

    @XmlTransient
    public List<CGlitemAcct> getCGlitemAcctList() {
        return cGlitemAcctList;
    }

    public void setCGlitemAcctList(List<CGlitemAcct> cGlitemAcctList) {
        this.cGlitemAcctList = cGlitemAcctList;
    }

    @XmlTransient
    public List<CGlitemAcct> getCGlitemAcctList1() {
        return cGlitemAcctList1;
    }

    public void setCGlitemAcctList1(List<CGlitemAcct> cGlitemAcctList1) {
        this.cGlitemAcctList1 = cGlitemAcctList1;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList() {
        return mProductCategoryAcctList;
    }

    public void setMProductCategoryAcctList(List<MProductCategoryAcct> mProductCategoryAcctList) {
        this.mProductCategoryAcctList = mProductCategoryAcctList;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList1() {
        return mProductCategoryAcctList1;
    }

    public void setMProductCategoryAcctList1(List<MProductCategoryAcct> mProductCategoryAcctList1) {
        this.mProductCategoryAcctList1 = mProductCategoryAcctList1;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList2() {
        return mProductCategoryAcctList2;
    }

    public void setMProductCategoryAcctList2(List<MProductCategoryAcct> mProductCategoryAcctList2) {
        this.mProductCategoryAcctList2 = mProductCategoryAcctList2;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList3() {
        return mProductCategoryAcctList3;
    }

    public void setMProductCategoryAcctList3(List<MProductCategoryAcct> mProductCategoryAcctList3) {
        this.mProductCategoryAcctList3 = mProductCategoryAcctList3;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList4() {
        return mProductCategoryAcctList4;
    }

    public void setMProductCategoryAcctList4(List<MProductCategoryAcct> mProductCategoryAcctList4) {
        this.mProductCategoryAcctList4 = mProductCategoryAcctList4;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList5() {
        return mProductCategoryAcctList5;
    }

    public void setMProductCategoryAcctList5(List<MProductCategoryAcct> mProductCategoryAcctList5) {
        this.mProductCategoryAcctList5 = mProductCategoryAcctList5;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList6() {
        return mProductCategoryAcctList6;
    }

    public void setMProductCategoryAcctList6(List<MProductCategoryAcct> mProductCategoryAcctList6) {
        this.mProductCategoryAcctList6 = mProductCategoryAcctList6;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList7() {
        return mProductCategoryAcctList7;
    }

    public void setMProductCategoryAcctList7(List<MProductCategoryAcct> mProductCategoryAcctList7) {
        this.mProductCategoryAcctList7 = mProductCategoryAcctList7;
    }

    @XmlTransient
    public List<CBpVendorAcct> getCBpVendorAcctList() {
        return cBpVendorAcctList;
    }

    public void setCBpVendorAcctList(List<CBpVendorAcct> cBpVendorAcctList) {
        this.cBpVendorAcctList = cBpVendorAcctList;
    }

    @XmlTransient
    public List<CBpVendorAcct> getCBpVendorAcctList1() {
        return cBpVendorAcctList1;
    }

    public void setCBpVendorAcctList1(List<CBpVendorAcct> cBpVendorAcctList1) {
        this.cBpVendorAcctList1 = cBpVendorAcctList1;
    }

    @XmlTransient
    public List<CBpVendorAcct> getCBpVendorAcctList2() {
        return cBpVendorAcctList2;
    }

    public void setCBpVendorAcctList2(List<CBpVendorAcct> cBpVendorAcctList2) {
        this.cBpVendorAcctList2 = cBpVendorAcctList2;
    }

    @XmlTransient
    public List<CBpCustomerAcct> getCBpCustomerAcctList() {
        return cBpCustomerAcctList;
    }

    public void setCBpCustomerAcctList(List<CBpCustomerAcct> cBpCustomerAcctList) {
        this.cBpCustomerAcctList = cBpCustomerAcctList;
    }

    @XmlTransient
    public List<CBpCustomerAcct> getCBpCustomerAcctList1() {
        return cBpCustomerAcctList1;
    }

    public void setCBpCustomerAcctList1(List<CBpCustomerAcct> cBpCustomerAcctList1) {
        this.cBpCustomerAcctList1 = cBpCustomerAcctList1;
    }

    @XmlTransient
    public List<CWithholdingAcct> getCWithholdingAcctList() {
        return cWithholdingAcctList;
    }

    public void setCWithholdingAcctList(List<CWithholdingAcct> cWithholdingAcctList) {
        this.cWithholdingAcctList = cWithholdingAcctList;
    }

    @XmlTransient
    public List<CCashbookAcct> getCCashbookAcctList() {
        return cCashbookAcctList;
    }

    public void setCCashbookAcctList(List<CCashbookAcct> cCashbookAcctList) {
        this.cCashbookAcctList = cCashbookAcctList;
    }

    @XmlTransient
    public List<CCashbookAcct> getCCashbookAcctList1() {
        return cCashbookAcctList1;
    }

    public void setCCashbookAcctList1(List<CCashbookAcct> cCashbookAcctList1) {
        this.cCashbookAcctList1 = cCashbookAcctList1;
    }

    @XmlTransient
    public List<CCashbookAcct> getCCashbookAcctList2() {
        return cCashbookAcctList2;
    }

    public void setCCashbookAcctList2(List<CCashbookAcct> cCashbookAcctList2) {
        this.cCashbookAcctList2 = cCashbookAcctList2;
    }

    @XmlTransient
    public List<CCashbookAcct> getCCashbookAcctList3() {
        return cCashbookAcctList3;
    }

    public void setCCashbookAcctList3(List<CCashbookAcct> cCashbookAcctList3) {
        this.cCashbookAcctList3 = cCashbookAcctList3;
    }

    @XmlTransient
    public List<CCashbookAcct> getCCashbookAcctList4() {
        return cCashbookAcctList4;
    }

    public void setCCashbookAcctList4(List<CCashbookAcct> cCashbookAcctList4) {
        this.cCashbookAcctList4 = cCashbookAcctList4;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList() {
        return cBankaccountAcctList;
    }

    public void setCBankaccountAcctList(List<CBankaccountAcct> cBankaccountAcctList) {
        this.cBankaccountAcctList = cBankaccountAcctList;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList1() {
        return cBankaccountAcctList1;
    }

    public void setCBankaccountAcctList1(List<CBankaccountAcct> cBankaccountAcctList1) {
        this.cBankaccountAcctList1 = cBankaccountAcctList1;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList2() {
        return cBankaccountAcctList2;
    }

    public void setCBankaccountAcctList2(List<CBankaccountAcct> cBankaccountAcctList2) {
        this.cBankaccountAcctList2 = cBankaccountAcctList2;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList3() {
        return cBankaccountAcctList3;
    }

    public void setCBankaccountAcctList3(List<CBankaccountAcct> cBankaccountAcctList3) {
        this.cBankaccountAcctList3 = cBankaccountAcctList3;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList4() {
        return cBankaccountAcctList4;
    }

    public void setCBankaccountAcctList4(List<CBankaccountAcct> cBankaccountAcctList4) {
        this.cBankaccountAcctList4 = cBankaccountAcctList4;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList5() {
        return cBankaccountAcctList5;
    }

    public void setCBankaccountAcctList5(List<CBankaccountAcct> cBankaccountAcctList5) {
        this.cBankaccountAcctList5 = cBankaccountAcctList5;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList6() {
        return cBankaccountAcctList6;
    }

    public void setCBankaccountAcctList6(List<CBankaccountAcct> cBankaccountAcctList6) {
        this.cBankaccountAcctList6 = cBankaccountAcctList6;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList7() {
        return cBankaccountAcctList7;
    }

    public void setCBankaccountAcctList7(List<CBankaccountAcct> cBankaccountAcctList7) {
        this.cBankaccountAcctList7 = cBankaccountAcctList7;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList8() {
        return cBankaccountAcctList8;
    }

    public void setCBankaccountAcctList8(List<CBankaccountAcct> cBankaccountAcctList8) {
        this.cBankaccountAcctList8 = cBankaccountAcctList8;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList9() {
        return cBankaccountAcctList9;
    }

    public void setCBankaccountAcctList9(List<CBankaccountAcct> cBankaccountAcctList9) {
        this.cBankaccountAcctList9 = cBankaccountAcctList9;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList10() {
        return cBankaccountAcctList10;
    }

    public void setCBankaccountAcctList10(List<CBankaccountAcct> cBankaccountAcctList10) {
        this.cBankaccountAcctList10 = cBankaccountAcctList10;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList11() {
        return cBankaccountAcctList11;
    }

    public void setCBankaccountAcctList11(List<CBankaccountAcct> cBankaccountAcctList11) {
        this.cBankaccountAcctList11 = cBankaccountAcctList11;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cValidcombinationId != null ? cValidcombinationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CValidcombination)) {
            return false;
        }
        CValidcombination other = (CValidcombination) object;
        if ((this.cValidcombinationId == null && other.cValidcombinationId != null) || (this.cValidcombinationId != null && !this.cValidcombinationId.equals(other.cValidcombinationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CValidcombination[ cValidcombinationId=" + cValidcombinationId + " ]";
    }
    
}
