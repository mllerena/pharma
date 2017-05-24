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
@Table(name = "c_acctschema_element")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAcctschemaElement.findAll", query = "SELECT c FROM CAcctschemaElement c"),
    @NamedQuery(name = "CAcctschemaElement.findByCAcctschemaElementId", query = "SELECT c FROM CAcctschemaElement c WHERE c.cAcctschemaElementId = :cAcctschemaElementId"),
    @NamedQuery(name = "CAcctschemaElement.findByIsactive", query = "SELECT c FROM CAcctschemaElement c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CAcctschemaElement.findByCreated", query = "SELECT c FROM CAcctschemaElement c WHERE c.created = :created"),
    @NamedQuery(name = "CAcctschemaElement.findByCreatedby", query = "SELECT c FROM CAcctschemaElement c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CAcctschemaElement.findByUpdated", query = "SELECT c FROM CAcctschemaElement c WHERE c.updated = :updated"),
    @NamedQuery(name = "CAcctschemaElement.findByUpdatedby", query = "SELECT c FROM CAcctschemaElement c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CAcctschemaElement.findByElementtype", query = "SELECT c FROM CAcctschemaElement c WHERE c.elementtype = :elementtype"),
    @NamedQuery(name = "CAcctschemaElement.findByName", query = "SELECT c FROM CAcctschemaElement c WHERE c.name = :name"),
    @NamedQuery(name = "CAcctschemaElement.findBySeqno", query = "SELECT c FROM CAcctschemaElement c WHERE c.seqno = :seqno"),
    @NamedQuery(name = "CAcctschemaElement.findByIsmandatory", query = "SELECT c FROM CAcctschemaElement c WHERE c.ismandatory = :ismandatory"),
    @NamedQuery(name = "CAcctschemaElement.findByIsbalanced", query = "SELECT c FROM CAcctschemaElement c WHERE c.isbalanced = :isbalanced")})
public class CAcctschemaElement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_acctschema_element_id")
    private String cAcctschemaElementId;
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
    @Column(name = "elementtype")
    private String elementtype;
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
    @Column(name = "ismandatory")
    private Character ismandatory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbalanced")
    private Character isbalanced;
    @JoinColumn(name = "org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg orgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_salesregion_id", referencedColumnName = "c_salesregion_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalesregion cSalesregionId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "c_element_id", referencedColumnName = "c_element_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CElement cElementId;
    @JoinColumn(name = "c_elementvalue_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CElementvalue cElementvalueId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocationId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;

    public CAcctschemaElement() {
    }

    public CAcctschemaElement(String cAcctschemaElementId) {
        this.cAcctschemaElementId = cAcctschemaElementId;
    }

    public CAcctschemaElement(String cAcctschemaElementId, Character isactive, Date created, String createdby, Date updated, String updatedby, String elementtype, String name, long seqno, Character ismandatory, Character isbalanced) {
        this.cAcctschemaElementId = cAcctschemaElementId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.elementtype = elementtype;
        this.name = name;
        this.seqno = seqno;
        this.ismandatory = ismandatory;
        this.isbalanced = isbalanced;
    }

    public String getCAcctschemaElementId() {
        return cAcctschemaElementId;
    }

    public void setCAcctschemaElementId(String cAcctschemaElementId) {
        this.cAcctschemaElementId = cAcctschemaElementId;
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

    public String getElementtype() {
        return elementtype;
    }

    public void setElementtype(String elementtype) {
        this.elementtype = elementtype;
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

    public Character getIsmandatory() {
        return ismandatory;
    }

    public void setIsmandatory(Character ismandatory) {
        this.ismandatory = ismandatory;
    }

    public Character getIsbalanced() {
        return isbalanced;
    }

    public void setIsbalanced(Character isbalanced) {
        this.isbalanced = isbalanced;
    }

    public AdOrg getOrgId() {
        return orgId;
    }

    public void setOrgId(AdOrg orgId) {
        this.orgId = orgId;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CSalesregion getCSalesregionId() {
        return cSalesregionId;
    }

    public void setCSalesregionId(CSalesregion cSalesregionId) {
        this.cSalesregionId = cSalesregionId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public CElement getCElementId() {
        return cElementId;
    }

    public void setCElementId(CElement cElementId) {
        this.cElementId = cElementId;
    }

    public CElementvalue getCElementvalueId() {
        return cElementvalueId;
    }

    public void setCElementvalueId(CElementvalue cElementvalueId) {
        this.cElementvalueId = cElementvalueId;
    }

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cAcctschemaElementId != null ? cAcctschemaElementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAcctschemaElement)) {
            return false;
        }
        CAcctschemaElement other = (CAcctschemaElement) object;
        if ((this.cAcctschemaElementId == null && other.cAcctschemaElementId != null) || (this.cAcctschemaElementId != null && !this.cAcctschemaElementId.equals(other.cAcctschemaElementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CAcctschemaElement[ cAcctschemaElementId=" + cAcctschemaElementId + " ]";
    }
    
}
