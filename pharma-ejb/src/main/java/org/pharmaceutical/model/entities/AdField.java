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
@Table(name = "ad_field")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdField.findAll", query = "SELECT a FROM AdField a"),
    @NamedQuery(name = "AdField.findByAdFieldId", query = "SELECT a FROM AdField a WHERE a.adFieldId = :adFieldId"),
    @NamedQuery(name = "AdField.findByIsactive", query = "SELECT a FROM AdField a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdField.findByCreated", query = "SELECT a FROM AdField a WHERE a.created = :created"),
    @NamedQuery(name = "AdField.findByCreatedby", query = "SELECT a FROM AdField a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdField.findByUpdated", query = "SELECT a FROM AdField a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdField.findByUpdatedby", query = "SELECT a FROM AdField a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdField.findByName", query = "SELECT a FROM AdField a WHERE a.name = :name"),
    @NamedQuery(name = "AdField.findByDescription", query = "SELECT a FROM AdField a WHERE a.description = :description"),
    @NamedQuery(name = "AdField.findByHelp", query = "SELECT a FROM AdField a WHERE a.help = :help"),
    @NamedQuery(name = "AdField.findByIscentrallymaintained", query = "SELECT a FROM AdField a WHERE a.iscentrallymaintained = :iscentrallymaintained"),
    @NamedQuery(name = "AdField.findByIsdisplayed", query = "SELECT a FROM AdField a WHERE a.isdisplayed = :isdisplayed"),
    @NamedQuery(name = "AdField.findByDisplaylogic", query = "SELECT a FROM AdField a WHERE a.displaylogic = :displaylogic"),
    @NamedQuery(name = "AdField.findByDisplaylength", query = "SELECT a FROM AdField a WHERE a.displaylength = :displaylength"),
    @NamedQuery(name = "AdField.findByIsreadonly", query = "SELECT a FROM AdField a WHERE a.isreadonly = :isreadonly"),
    @NamedQuery(name = "AdField.findBySeqno", query = "SELECT a FROM AdField a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AdField.findBySortno", query = "SELECT a FROM AdField a WHERE a.sortno = :sortno"),
    @NamedQuery(name = "AdField.findByIssameline", query = "SELECT a FROM AdField a WHERE a.issameline = :issameline"),
    @NamedQuery(name = "AdField.findByIsfieldonly", query = "SELECT a FROM AdField a WHERE a.isfieldonly = :isfieldonly"),
    @NamedQuery(name = "AdField.findByIsencrypted", query = "SELECT a FROM AdField a WHERE a.isencrypted = :isencrypted"),
    @NamedQuery(name = "AdField.findByShowinrelation", query = "SELECT a FROM AdField a WHERE a.showinrelation = :showinrelation"),
    @NamedQuery(name = "AdField.findByIsfirstfocusedfield", query = "SELECT a FROM AdField a WHERE a.isfirstfocusedfield = :isfirstfocusedfield"),
    @NamedQuery(name = "AdField.findByGridSeqno", query = "SELECT a FROM AdField a WHERE a.gridSeqno = :gridSeqno")})
public class AdField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_field_id")
    private String adFieldId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscentrallymaintained")
    private Character iscentrallymaintained;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdisplayed")
    private Character isdisplayed;
    @Size(max = 2000)
    @Column(name = "displaylogic")
    private String displaylogic;
    @Column(name = "displaylength")
    private Long displaylength;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isreadonly")
    private Character isreadonly;
    @Column(name = "seqno")
    private Long seqno;
    @Column(name = "sortno")
    private Long sortno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issameline")
    private Character issameline;
    @Column(name = "isfieldonly")
    private Character isfieldonly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isencrypted")
    private Character isencrypted;
    @Column(name = "showinrelation")
    private Character showinrelation;
    @Column(name = "isfirstfocusedfield")
    private Character isfirstfocusedfield;
    @Column(name = "grid_seqno")
    private Long gridSeqno;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adFieldId")
    private List<AdFieldTrl> adFieldTrlList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_column_id", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdColumn adColumnId;
    @JoinColumn(name = "ad_fieldgroup_id", referencedColumnName = "ad_fieldgroup_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdFieldgroup adFieldgroupId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_tab_id", referencedColumnName = "ad_tab_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTab adTabId;

    public AdField() {
    }

    public AdField(String adFieldId) {
        this.adFieldId = adFieldId;
    }

    public AdField(String adFieldId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character iscentrallymaintained, Character isdisplayed, Character isreadonly, Character issameline, Character isencrypted) {
        this.adFieldId = adFieldId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.iscentrallymaintained = iscentrallymaintained;
        this.isdisplayed = isdisplayed;
        this.isreadonly = isreadonly;
        this.issameline = issameline;
        this.isencrypted = isencrypted;
    }

    public String getAdFieldId() {
        return adFieldId;
    }

    public void setAdFieldId(String adFieldId) {
        this.adFieldId = adFieldId;
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

    public Character getIscentrallymaintained() {
        return iscentrallymaintained;
    }

    public void setIscentrallymaintained(Character iscentrallymaintained) {
        this.iscentrallymaintained = iscentrallymaintained;
    }

    public Character getIsdisplayed() {
        return isdisplayed;
    }

    public void setIsdisplayed(Character isdisplayed) {
        this.isdisplayed = isdisplayed;
    }

    public String getDisplaylogic() {
        return displaylogic;
    }

    public void setDisplaylogic(String displaylogic) {
        this.displaylogic = displaylogic;
    }

    public Long getDisplaylength() {
        return displaylength;
    }

    public void setDisplaylength(Long displaylength) {
        this.displaylength = displaylength;
    }

    public Character getIsreadonly() {
        return isreadonly;
    }

    public void setIsreadonly(Character isreadonly) {
        this.isreadonly = isreadonly;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public Long getSortno() {
        return sortno;
    }

    public void setSortno(Long sortno) {
        this.sortno = sortno;
    }

    public Character getIssameline() {
        return issameline;
    }

    public void setIssameline(Character issameline) {
        this.issameline = issameline;
    }

    public Character getIsfieldonly() {
        return isfieldonly;
    }

    public void setIsfieldonly(Character isfieldonly) {
        this.isfieldonly = isfieldonly;
    }

    public Character getIsencrypted() {
        return isencrypted;
    }

    public void setIsencrypted(Character isencrypted) {
        this.isencrypted = isencrypted;
    }

    public Character getShowinrelation() {
        return showinrelation;
    }

    public void setShowinrelation(Character showinrelation) {
        this.showinrelation = showinrelation;
    }

    public Character getIsfirstfocusedfield() {
        return isfirstfocusedfield;
    }

    public void setIsfirstfocusedfield(Character isfirstfocusedfield) {
        this.isfirstfocusedfield = isfirstfocusedfield;
    }

    public Long getGridSeqno() {
        return gridSeqno;
    }

    public void setGridSeqno(Long gridSeqno) {
        this.gridSeqno = gridSeqno;
    }

    @XmlTransient
    public List<AdFieldTrl> getAdFieldTrlList() {
        return adFieldTrlList;
    }

    public void setAdFieldTrlList(List<AdFieldTrl> adFieldTrlList) {
        this.adFieldTrlList = adFieldTrlList;
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

    public AdFieldgroup getAdFieldgroupId() {
        return adFieldgroupId;
    }

    public void setAdFieldgroupId(AdFieldgroup adFieldgroupId) {
        this.adFieldgroupId = adFieldgroupId;
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

    public AdTab getAdTabId() {
        return adTabId;
    }

    public void setAdTabId(AdTab adTabId) {
        this.adTabId = adTabId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adFieldId != null ? adFieldId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdField)) {
            return false;
        }
        AdField other = (AdField) object;
        if ((this.adFieldId == null && other.adFieldId != null) || (this.adFieldId != null && !this.adFieldId.equals(other.adFieldId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdField[ adFieldId=" + adFieldId + " ]";
    }
    
}
