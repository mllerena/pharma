/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ad_pinstance_para")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdPinstancePara.findAll", query = "SELECT a FROM AdPinstancePara a"),
    @NamedQuery(name = "AdPinstancePara.findByAdPinstanceParaId", query = "SELECT a FROM AdPinstancePara a WHERE a.adPinstanceParaId = :adPinstanceParaId"),
    @NamedQuery(name = "AdPinstancePara.findBySeqno", query = "SELECT a FROM AdPinstancePara a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AdPinstancePara.findByParametername", query = "SELECT a FROM AdPinstancePara a WHERE a.parametername = :parametername"),
    @NamedQuery(name = "AdPinstancePara.findByPString", query = "SELECT a FROM AdPinstancePara a WHERE a.pString = :pString"),
    @NamedQuery(name = "AdPinstancePara.findByPStringTo", query = "SELECT a FROM AdPinstancePara a WHERE a.pStringTo = :pStringTo"),
    @NamedQuery(name = "AdPinstancePara.findByPNumber", query = "SELECT a FROM AdPinstancePara a WHERE a.pNumber = :pNumber"),
    @NamedQuery(name = "AdPinstancePara.findByPNumberTo", query = "SELECT a FROM AdPinstancePara a WHERE a.pNumberTo = :pNumberTo"),
    @NamedQuery(name = "AdPinstancePara.findByPDate", query = "SELECT a FROM AdPinstancePara a WHERE a.pDate = :pDate"),
    @NamedQuery(name = "AdPinstancePara.findByPDateTo", query = "SELECT a FROM AdPinstancePara a WHERE a.pDateTo = :pDateTo"),
    @NamedQuery(name = "AdPinstancePara.findByInfo", query = "SELECT a FROM AdPinstancePara a WHERE a.info = :info"),
    @NamedQuery(name = "AdPinstancePara.findByInfoTo", query = "SELECT a FROM AdPinstancePara a WHERE a.infoTo = :infoTo"),
    @NamedQuery(name = "AdPinstancePara.findByCreated", query = "SELECT a FROM AdPinstancePara a WHERE a.created = :created"),
    @NamedQuery(name = "AdPinstancePara.findByCreatedby", query = "SELECT a FROM AdPinstancePara a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdPinstancePara.findByUpdated", query = "SELECT a FROM AdPinstancePara a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdPinstancePara.findByUpdatedby", query = "SELECT a FROM AdPinstancePara a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdPinstancePara.findByIsactive", query = "SELECT a FROM AdPinstancePara a WHERE a.isactive = :isactive")})
public class AdPinstancePara implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_pinstance_para_id")
    private String adPinstanceParaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "seqno")
    private String seqno;
    @Size(max = 60)
    @Column(name = "parametername")
    private String parametername;
    @Size(max = 60)
    @Column(name = "p_string")
    private String pString;
    @Size(max = 60)
    @Column(name = "p_string_to")
    private String pStringTo;
    @Column(name = "p_number")
    private BigInteger pNumber;
    @Column(name = "p_number_to")
    private BigInteger pNumberTo;
    @Column(name = "p_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pDate;
    @Column(name = "p_date_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pDateTo;
    @Size(max = 60)
    @Column(name = "info")
    private String info;
    @Size(max = 60)
    @Column(name = "info_to")
    private String infoTo;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "isactive")
    private Character isactive;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_pinstance_id", referencedColumnName = "ad_pinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdPinstance adPinstanceId;

    public AdPinstancePara() {
    }

    public AdPinstancePara(String adPinstanceParaId) {
        this.adPinstanceParaId = adPinstanceParaId;
    }

    public AdPinstancePara(String adPinstanceParaId, String seqno) {
        this.adPinstanceParaId = adPinstanceParaId;
        this.seqno = seqno;
    }

    public String getAdPinstanceParaId() {
        return adPinstanceParaId;
    }

    public void setAdPinstanceParaId(String adPinstanceParaId) {
        this.adPinstanceParaId = adPinstanceParaId;
    }

    public String getSeqno() {
        return seqno;
    }

    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }

    public String getParametername() {
        return parametername;
    }

    public void setParametername(String parametername) {
        this.parametername = parametername;
    }

    public String getPString() {
        return pString;
    }

    public void setPString(String pString) {
        this.pString = pString;
    }

    public String getPStringTo() {
        return pStringTo;
    }

    public void setPStringTo(String pStringTo) {
        this.pStringTo = pStringTo;
    }

    public BigInteger getPNumber() {
        return pNumber;
    }

    public void setPNumber(BigInteger pNumber) {
        this.pNumber = pNumber;
    }

    public BigInteger getPNumberTo() {
        return pNumberTo;
    }

    public void setPNumberTo(BigInteger pNumberTo) {
        this.pNumberTo = pNumberTo;
    }

    public Date getPDate() {
        return pDate;
    }

    public void setPDate(Date pDate) {
        this.pDate = pDate;
    }

    public Date getPDateTo() {
        return pDateTo;
    }

    public void setPDateTo(Date pDateTo) {
        this.pDateTo = pDateTo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoTo() {
        return infoTo;
    }

    public void setInfoTo(String infoTo) {
        this.infoTo = infoTo;
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

    public AdPinstance getAdPinstanceId() {
        return adPinstanceId;
    }

    public void setAdPinstanceId(AdPinstance adPinstanceId) {
        this.adPinstanceId = adPinstanceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adPinstanceParaId != null ? adPinstanceParaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdPinstancePara)) {
            return false;
        }
        AdPinstancePara other = (AdPinstancePara) object;
        if ((this.adPinstanceParaId == null && other.adPinstanceParaId != null) || (this.adPinstanceParaId != null && !this.adPinstanceParaId.equals(other.adPinstanceParaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdPinstancePara[ adPinstanceParaId=" + adPinstanceParaId + " ]";
    }
    
}
