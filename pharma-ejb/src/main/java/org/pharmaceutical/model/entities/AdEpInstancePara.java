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
@Table(name = "ad_ep_instance_para")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdEpInstancePara.findAll", query = "SELECT a FROM AdEpInstancePara a"),
    @NamedQuery(name = "AdEpInstancePara.findByAdEpInstanceId", query = "SELECT a FROM AdEpInstancePara a WHERE a.adEpInstanceId = :adEpInstanceId"),
    @NamedQuery(name = "AdEpInstancePara.findByParametername", query = "SELECT a FROM AdEpInstancePara a WHERE a.parametername = :parametername"),
    @NamedQuery(name = "AdEpInstancePara.findByPString", query = "SELECT a FROM AdEpInstancePara a WHERE a.pString = :pString"),
    @NamedQuery(name = "AdEpInstancePara.findByPStringTo", query = "SELECT a FROM AdEpInstancePara a WHERE a.pStringTo = :pStringTo"),
    @NamedQuery(name = "AdEpInstancePara.findByPNumber", query = "SELECT a FROM AdEpInstancePara a WHERE a.pNumber = :pNumber"),
    @NamedQuery(name = "AdEpInstancePara.findByPNumberTo", query = "SELECT a FROM AdEpInstancePara a WHERE a.pNumberTo = :pNumberTo"),
    @NamedQuery(name = "AdEpInstancePara.findByPDate", query = "SELECT a FROM AdEpInstancePara a WHERE a.pDate = :pDate"),
    @NamedQuery(name = "AdEpInstancePara.findByPDateTo", query = "SELECT a FROM AdEpInstancePara a WHERE a.pDateTo = :pDateTo"),
    @NamedQuery(name = "AdEpInstancePara.findByPText", query = "SELECT a FROM AdEpInstancePara a WHERE a.pText = :pText"),
    @NamedQuery(name = "AdEpInstancePara.findByAdEpInstanceParaId", query = "SELECT a FROM AdEpInstancePara a WHERE a.adEpInstanceParaId = :adEpInstanceParaId")})
public class AdEpInstancePara implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_ep_instance_id")
    private String adEpInstanceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
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
    @Size(max = 2000)
    @Column(name = "p_text")
    private String pText;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_ep_instance_para_id")
    private String adEpInstanceParaId;
    @JoinColumn(name = "ad_extension_points_id", referencedColumnName = "ad_extension_points_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdExtensionPoints adExtensionPointsId;

    public AdEpInstancePara() {
    }

    public AdEpInstancePara(String adEpInstanceParaId) {
        this.adEpInstanceParaId = adEpInstanceParaId;
    }

    public AdEpInstancePara(String adEpInstanceParaId, String adEpInstanceId, String parametername) {
        this.adEpInstanceParaId = adEpInstanceParaId;
        this.adEpInstanceId = adEpInstanceId;
        this.parametername = parametername;
    }

    public String getAdEpInstanceId() {
        return adEpInstanceId;
    }

    public void setAdEpInstanceId(String adEpInstanceId) {
        this.adEpInstanceId = adEpInstanceId;
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

    public String getPText() {
        return pText;
    }

    public void setPText(String pText) {
        this.pText = pText;
    }

    public String getAdEpInstanceParaId() {
        return adEpInstanceParaId;
    }

    public void setAdEpInstanceParaId(String adEpInstanceParaId) {
        this.adEpInstanceParaId = adEpInstanceParaId;
    }

    public AdExtensionPoints getAdExtensionPointsId() {
        return adExtensionPointsId;
    }

    public void setAdExtensionPointsId(AdExtensionPoints adExtensionPointsId) {
        this.adExtensionPointsId = adExtensionPointsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adEpInstanceParaId != null ? adEpInstanceParaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdEpInstancePara)) {
            return false;
        }
        AdEpInstancePara other = (AdEpInstancePara) object;
        if ((this.adEpInstanceParaId == null && other.adEpInstanceParaId != null) || (this.adEpInstanceParaId != null && !this.adEpInstanceParaId.equals(other.adEpInstanceParaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdEpInstancePara[ adEpInstanceParaId=" + adEpInstanceParaId + " ]";
    }
    
}
