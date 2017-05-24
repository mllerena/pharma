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
import javax.persistence.Convert;
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

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_processplan_version")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaProcessplanVersion.findAll", query = "SELECT m FROM MaProcessplanVersion m"),
    @NamedQuery(name = "MaProcessplanVersion.findByMaProcessplanVersionId", query = "SELECT m FROM MaProcessplanVersion m WHERE m.maProcessplanVersionId = :maProcessplanVersionId"),
    @NamedQuery(name = "MaProcessplanVersion.findByIsactive", query = "SELECT m FROM MaProcessplanVersion m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaProcessplanVersion.findByCreated", query = "SELECT m FROM MaProcessplanVersion m WHERE m.created = :created"),
    @NamedQuery(name = "MaProcessplanVersion.findByCreatedby", query = "SELECT m FROM MaProcessplanVersion m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaProcessplanVersion.findByUpdated", query = "SELECT m FROM MaProcessplanVersion m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaProcessplanVersion.findByUpdatedby", query = "SELECT m FROM MaProcessplanVersion m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaProcessplanVersion.findByDocumentno", query = "SELECT m FROM MaProcessplanVersion m WHERE m.documentno = :documentno"),
    @NamedQuery(name = "MaProcessplanVersion.findByDatefrom", query = "SELECT m FROM MaProcessplanVersion m WHERE m.datefrom = :datefrom"),
    @NamedQuery(name = "MaProcessplanVersion.findByDateto", query = "SELECT m FROM MaProcessplanVersion m WHERE m.dateto = :dateto"),
    @NamedQuery(name = "MaProcessplanVersion.findByMaProcessplanId", query = "SELECT m FROM MaProcessplanVersion m WHERE m.maProcessplanId = :maProcessplanId and m.isactive = :isactive")
    
})
public class MaProcessplanVersion extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_processplan_version_id")
    private String maProcessplanVersionId;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive;
    
    @Basic(optional = false)
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Basic(optional = false)
    @Column(name = "createdby")
    private String createdby;
    
    @Basic(optional = false)
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    
    @Basic(optional = false)
    @Column(name = "updatedby")
    private String updatedby;
    
    @Basic(optional = false)
    @Column(name = "documentno")
    
    private String documentno;
    
    @Basic(optional = false)
    @Column(name = "datefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    
    @Basic(optional = false)
    @Column(name = "dateto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_processplan_id", referencedColumnName = "ma_processplan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaProcessplan maProcessplanId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maProcessplanVersionId")
    private List<MaSequence> maSequenceList;

    public MaProcessplanVersion() {
    }

    public MaProcessplanVersion(String maProcessplanVersionId) {
        this.maProcessplanVersionId = maProcessplanVersionId;
    }

    public String getMaProcessplanVersionId() {
        return maProcessplanVersionId;
    }

    public void setMaProcessplanVersionId(String maProcessplanVersionId) {
        this.maProcessplanVersionId = maProcessplanVersionId;
    }

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
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

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
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

    public MaProcessplan getMaProcessplanId() {
        return maProcessplanId;
    }

    public void setMaProcessplanId(MaProcessplan maProcessplanId) {
        this.maProcessplanId = maProcessplanId;
    }

    @XmlTransient
    public List<MaSequence> getMaSequenceList() {
        return maSequenceList;
    }

    public void setMaSequenceList(List<MaSequence> maSequenceList) {
        this.maSequenceList = maSequenceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maProcessplanVersionId != null ? maProcessplanVersionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaProcessplanVersion)) {
            return false;
        }
        MaProcessplanVersion other = (MaProcessplanVersion) object;
        if ((this.maProcessplanVersionId == null && other.maProcessplanVersionId != null) || (this.maProcessplanVersionId != null && !this.maProcessplanVersionId.equals(other.maProcessplanVersionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaProcessplanVersion[ maProcessplanVersionId=" + maProcessplanVersionId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maProcessplanVersionId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maProcessplanVersionId = id;
	}
    
}
