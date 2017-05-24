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
@Table(name = "r_requestaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RRequestaction.findAll", query = "SELECT r FROM RRequestaction r"),
    @NamedQuery(name = "RRequestaction.findByRRequestactionId", query = "SELECT r FROM RRequestaction r WHERE r.rRequestactionId = :rRequestactionId"),
    @NamedQuery(name = "RRequestaction.findByIsactive", query = "SELECT r FROM RRequestaction r WHERE r.isactive = :isactive"),
    @NamedQuery(name = "RRequestaction.findByCreated", query = "SELECT r FROM RRequestaction r WHERE r.created = :created"),
    @NamedQuery(name = "RRequestaction.findByCreatedby", query = "SELECT r FROM RRequestaction r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "RRequestaction.findByUpdated", query = "SELECT r FROM RRequestaction r WHERE r.updated = :updated"),
    @NamedQuery(name = "RRequestaction.findByUpdatedby", query = "SELECT r FROM RRequestaction r WHERE r.updatedby = :updatedby"),
    @NamedQuery(name = "RRequestaction.findByActiontype", query = "SELECT r FROM RRequestaction r WHERE r.actiontype = :actiontype"),
    @NamedQuery(name = "RRequestaction.findByMailtext", query = "SELECT r FROM RRequestaction r WHERE r.mailtext = :mailtext"),
    @NamedQuery(name = "RRequestaction.findByResult", query = "SELECT r FROM RRequestaction r WHERE r.result = :result"),
    @NamedQuery(name = "RRequestaction.findByDatenextaction", query = "SELECT r FROM RRequestaction r WHERE r.datenextaction = :datenextaction"),
    @NamedQuery(name = "RRequestaction.findByDateaction", query = "SELECT r FROM RRequestaction r WHERE r.dateaction = :dateaction")})
public class RRequestaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "r_requestaction_id")
    private String rRequestactionId;
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
    @Size(max = 60)
    @Column(name = "actiontype")
    private String actiontype;
    @Size(max = 2000)
    @Column(name = "mailtext")
    private String mailtext;
    @Size(max = 2000)
    @Column(name = "result")
    private String result;
    @Column(name = "datenextaction")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datenextaction;
    @Column(name = "dateaction")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateaction;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoice cInvoiceId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdUser salesrepId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_debt_payment_id", referencedColumnName = "c_debt_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDebtPayment cDebtPaymentId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "r_request_id", referencedColumnName = "r_request_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private RRequest rRequestId;
    @JoinColumn(name = "r_mailtext_id", referencedColumnName = "r_mailtext_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private RMailtext rMailtextId;

    public RRequestaction() {
    }

    public RRequestaction(String rRequestactionId) {
        this.rRequestactionId = rRequestactionId;
    }

    public RRequestaction(String rRequestactionId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.rRequestactionId = rRequestactionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getRRequestactionId() {
        return rRequestactionId;
    }

    public void setRRequestactionId(String rRequestactionId) {
        this.rRequestactionId = rRequestactionId;
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

    public String getActiontype() {
        return actiontype;
    }

    public void setActiontype(String actiontype) {
        this.actiontype = actiontype;
    }

    public String getMailtext() {
        return mailtext;
    }

    public void setMailtext(String mailtext) {
        this.mailtext = mailtext;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDatenextaction() {
        return datenextaction;
    }

    public void setDatenextaction(Date datenextaction) {
        this.datenextaction = datenextaction;
    }

    public Date getDateaction() {
        return dateaction;
    }

    public void setDateaction(Date dateaction) {
        this.dateaction = dateaction;
    }

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
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

    public AdUser getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(AdUser salesrepId) {
        this.salesrepId = salesrepId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CDebtPayment getCDebtPaymentId() {
        return cDebtPaymentId;
    }

    public void setCDebtPaymentId(CDebtPayment cDebtPaymentId) {
        this.cDebtPaymentId = cDebtPaymentId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public RRequest getRRequestId() {
        return rRequestId;
    }

    public void setRRequestId(RRequest rRequestId) {
        this.rRequestId = rRequestId;
    }

    public RMailtext getRMailtextId() {
        return rMailtextId;
    }

    public void setRMailtextId(RMailtext rMailtextId) {
        this.rMailtextId = rMailtextId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rRequestactionId != null ? rRequestactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RRequestaction)) {
            return false;
        }
        RRequestaction other = (RRequestaction) object;
        if ((this.rRequestactionId == null && other.rRequestactionId != null) || (this.rRequestactionId != null && !this.rRequestactionId.equals(other.rRequestactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.RRequestaction[ rRequestactionId=" + rRequestactionId + " ]";
    }
    
}
