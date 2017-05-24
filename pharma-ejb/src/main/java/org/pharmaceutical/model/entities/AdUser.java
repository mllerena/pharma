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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
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
@Table(name = "ad_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdUser.findAll", query = "SELECT a FROM AdUser a"),
    @NamedQuery(name = "AdUser.findByAdUserId", query = "SELECT a FROM AdUser a WHERE a.adUserId = :adUserId"),
    @NamedQuery(name = "AdUser.findByIsactive", query = "SELECT a FROM AdUser a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdUser.findByCreated", query = "SELECT a FROM AdUser a WHERE a.created = :created"),
    @NamedQuery(name = "AdUser.findByCreatedby", query = "SELECT a FROM AdUser a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdUser.findByUpdated", query = "SELECT a FROM AdUser a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdUser.findByUpdatedby", query = "SELECT a FROM AdUser a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdUser.findByName", query = "SELECT a FROM AdUser a WHERE a.name = :name"),
    @NamedQuery(name = "AdUser.findByDescription", query = "SELECT a FROM AdUser a WHERE a.description = :description"),
    @NamedQuery(name = "AdUser.findByPassword", query = "SELECT a FROM AdUser a WHERE a.password = :password"),
    @NamedQuery(name = "AdUser.findByEmail", query = "SELECT a FROM AdUser a WHERE a.email = :email"),
    @NamedQuery(name = "AdUser.findByProcessing", query = "SELECT a FROM AdUser a WHERE a.processing = :processing"),
    @NamedQuery(name = "AdUser.findByEmailuser", query = "SELECT a FROM AdUser a WHERE a.emailuser = :emailuser"),
    @NamedQuery(name = "AdUser.findByEmailuserpw", query = "SELECT a FROM AdUser a WHERE a.emailuserpw = :emailuserpw"),
    @NamedQuery(name = "AdUser.findByTitle", query = "SELECT a FROM AdUser a WHERE a.title = :title"),
    @NamedQuery(name = "AdUser.findByComments", query = "SELECT a FROM AdUser a WHERE a.comments = :comments"),
    @NamedQuery(name = "AdUser.findByPhone", query = "SELECT a FROM AdUser a WHERE a.phone = :phone"),
    @NamedQuery(name = "AdUser.findByPhone2", query = "SELECT a FROM AdUser a WHERE a.phone2 = :phone2"),
    @NamedQuery(name = "AdUser.findByFax", query = "SELECT a FROM AdUser a WHERE a.fax = :fax"),
    @NamedQuery(name = "AdUser.findByLastcontact", query = "SELECT a FROM AdUser a WHERE a.lastcontact = :lastcontact"),
    @NamedQuery(name = "AdUser.findByLastresult", query = "SELECT a FROM AdUser a WHERE a.lastresult = :lastresult"),
    @NamedQuery(name = "AdUser.findByBirthday", query = "SELECT a FROM AdUser a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "AdUser.findByFirstname", query = "SELECT a FROM AdUser a WHERE a.firstname = :firstname"),
    @NamedQuery(name = "AdUser.findByLastname", query = "SELECT a FROM AdUser a WHERE a.lastname = :lastname"),
    @NamedQuery(name = "AdUser.findByUsername", query = "SELECT a FROM AdUser a WHERE a.username = :username and a.isactive = :isactive"),
    @NamedQuery(name = "AdUser.findByIslocked", query = "SELECT a FROM AdUser a WHERE a.islocked = :islocked")})
public class AdUser extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ad_user_id")
    private String adUserId;
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
    
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    
    @Column(name = "email")
    private String email;
    @Column(name = "processing")
    private Character processing;
    
    @Column(name = "emailuser")
    private String emailuser;
    
    @Column(name = "emailuserpw")
    private String emailuserpw;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "comments")
    private String comments;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "phone2")
    private String phone2;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    
    @Column(name = "fax")
    private String fax;
    @Column(name = "lastcontact")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastcontact;
    
    @Column(name = "lastresult")
    private String lastresult;
    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    
    @Column(name = "firstname")
    private String firstname;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    
    @Column(name = "islocked")
    private Character islocked;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "salesrepId")
    private List<IInvoice> iInvoiceList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adUserId")
    private List<AdTreebar> adTreebarList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "supervisorId")
    private List<RRequestprocessor> rRequestprocessorList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<SResource> sResourceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "salesrepId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "salesrepId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<CInvoice> cInvoiceList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<AdPreference> adPreferenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<AdAlertrecipient> adAlertrecipientList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "salesrepId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<COrder> cOrderList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "dropshipUserId")
    private List<COrder> cOrderList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "salesrepId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<IOrder> iOrderList1;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "default_ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient defaultAdClientId;
    @JoinColumn(name = "default_ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdLanguage defaultAdLanguage;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "default_ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg defaultAdOrgId;
    @JoinColumn(name = "default_ad_role_id", referencedColumnName = "ad_role_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdRole defaultAdRoleId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "supervisorId")
    private List<AdUser> adUserList;
    @JoinColumn(name = "supervisor_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser supervisorId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "default_m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MWarehouse defaultMWarehouseId;
    @JoinColumn(name = "c_greeting_id", referencedColumnName = "c_greeting_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGreeting cGreetingId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<CProjectproposal> cProjectproposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<IBpartner> iBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<CProjectproposaltask> cProjectproposaltaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<AdNote> adNoteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adUserId")
    private List<RContactinterest> rContactinterestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<CBpBankaccount> cBpBankaccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<AdPinstance> adPinstanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "salesrepId")
    private List<CExternalpos> cExternalposList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "lockedby")
    private List<MRequisitionline> mRequisitionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<CPocEmailUser> cPocEmailUserList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<AdOrginfo> adOrginfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<MaMeasureShift> maMeasureShiftList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adUserId")
    private List<RRequestprocessorRoute> rRequestprocessorRouteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<AAsset> aAssetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<AdProcessRequest> adProcessRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adUserId")
    private List<MRequisition> mRequisitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adUserId")
    private List<COrgassignment> cOrgassignmentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "salesrepId")
    private List<RRequest> rRequestList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<AdAlert> adAlertList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "salesrepId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<MInout> mInoutList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<CProject> cProjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "salesrepId")
    private List<CProject> cProjectList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "salesrepId")
    private List<CSalesregion> cSalesregionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adUserId")
    private List<AdUserRoles> adUserRolesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "salesrepId")
    private List<RRequestaction> rRequestactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adUserId")
    private List<RRequestaction> rRequestactionList1;

    public AdUser() {
    }

    public AdUser(String adUserId) {
        this.adUserId = adUserId;
    }

    public String getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(String adUserId) {
        this.adUserId = adUserId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser;
    }

    public String getEmailuserpw() {
        return emailuserpw;
    }

    public void setEmailuserpw(String emailuserpw) {
        this.emailuserpw = emailuserpw;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Date getLastcontact() {
        return lastcontact;
    }

    public void setLastcontact(Date lastcontact) {
        this.lastcontact = lastcontact;
    }

    public String getLastresult() {
        return lastresult;
    }

    public void setLastresult(String lastresult) {
        this.lastresult = lastresult;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Character getIslocked() {
        return islocked;
    }

    public void setIslocked(Character islocked) {
        this.islocked = islocked;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList1() {
        return iInvoiceList1;
    }

    public void setIInvoiceList1(List<IInvoice> iInvoiceList1) {
        this.iInvoiceList1 = iInvoiceList1;
    }

    @XmlTransient
    public List<AdTreebar> getAdTreebarList() {
        return adTreebarList;
    }

    public void setAdTreebarList(List<AdTreebar> adTreebarList) {
        this.adTreebarList = adTreebarList;
    }

    @XmlTransient
    public List<RRequestprocessor> getRRequestprocessorList() {
        return rRequestprocessorList;
    }

    public void setRRequestprocessorList(List<RRequestprocessor> rRequestprocessorList) {
        this.rRequestprocessorList = rRequestprocessorList;
    }

    @XmlTransient
    public List<SResource> getSResourceList() {
        return sResourceList;
    }

    public void setSResourceList(List<SResource> sResourceList) {
        this.sResourceList = sResourceList;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
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

    @XmlTransient
    public List<AdPreference> getAdPreferenceList() {
        return adPreferenceList;
    }

    public void setAdPreferenceList(List<AdPreference> adPreferenceList) {
        this.adPreferenceList = adPreferenceList;
    }

    @XmlTransient
    public List<AdAlertrecipient> getAdAlertrecipientList() {
        return adAlertrecipientList;
    }

    public void setAdAlertrecipientList(List<AdAlertrecipient> adAlertrecipientList) {
        this.adAlertrecipientList = adAlertrecipientList;
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
    public List<COrder> getCOrderList2() {
        return cOrderList2;
    }

    public void setCOrderList2(List<COrder> cOrderList2) {
        this.cOrderList2 = cOrderList2;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList1() {
        return iOrderList1;
    }

    public void setIOrderList1(List<IOrder> iOrderList1) {
        this.iOrderList1 = iOrderList1;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdClient getDefaultAdClientId() {
        return defaultAdClientId;
    }

    public void setDefaultAdClientId(AdClient defaultAdClientId) {
        this.defaultAdClientId = defaultAdClientId;
    }

    public AdLanguage getDefaultAdLanguage() {
        return defaultAdLanguage;
    }

    public void setDefaultAdLanguage(AdLanguage defaultAdLanguage) {
        this.defaultAdLanguage = defaultAdLanguage;
    }

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdOrg getDefaultAdOrgId() {
        return defaultAdOrgId;
    }

    public void setDefaultAdOrgId(AdOrg defaultAdOrgId) {
        this.defaultAdOrgId = defaultAdOrgId;
    }

    public AdRole getDefaultAdRoleId() {
        return defaultAdRoleId;
    }

    public void setDefaultAdRoleId(AdRole defaultAdRoleId) {
        this.defaultAdRoleId = defaultAdRoleId;
    }

    @XmlTransient
    public List<AdUser> getAdUserList() {
        return adUserList;
    }

    public void setAdUserList(List<AdUser> adUserList) {
        this.adUserList = adUserList;
    }

    public AdUser getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(AdUser supervisorId) {
        this.supervisorId = supervisorId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CBpartnerLocation getCBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setCBpartnerLocationId(CBpartnerLocation cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public MWarehouse getDefaultMWarehouseId() {
        return defaultMWarehouseId;
    }

    public void setDefaultMWarehouseId(MWarehouse defaultMWarehouseId) {
        this.defaultMWarehouseId = defaultMWarehouseId;
    }

    public CGreeting getCGreetingId() {
        return cGreetingId;
    }

    public void setCGreetingId(CGreeting cGreetingId) {
        this.cGreetingId = cGreetingId;
    }

    @XmlTransient
    public List<CProjectproposal> getCProjectproposalList() {
        return cProjectproposalList;
    }

    public void setCProjectproposalList(List<CProjectproposal> cProjectproposalList) {
        this.cProjectproposalList = cProjectproposalList;
    }

    @XmlTransient
    public List<IBpartner> getIBpartnerList() {
        return iBpartnerList;
    }

    public void setIBpartnerList(List<IBpartner> iBpartnerList) {
        this.iBpartnerList = iBpartnerList;
    }

    @XmlTransient
    public List<CProjectproposaltask> getCProjectproposaltaskList() {
        return cProjectproposaltaskList;
    }

    public void setCProjectproposaltaskList(List<CProjectproposaltask> cProjectproposaltaskList) {
        this.cProjectproposaltaskList = cProjectproposaltaskList;
    }

    @XmlTransient
    public List<AdNote> getAdNoteList() {
        return adNoteList;
    }

    public void setAdNoteList(List<AdNote> adNoteList) {
        this.adNoteList = adNoteList;
    }

    @XmlTransient
    public List<RContactinterest> getRContactinterestList() {
        return rContactinterestList;
    }

    public void setRContactinterestList(List<RContactinterest> rContactinterestList) {
        this.rContactinterestList = rContactinterestList;
    }

    @XmlTransient
    public List<CBpBankaccount> getCBpBankaccountList() {
        return cBpBankaccountList;
    }

    public void setCBpBankaccountList(List<CBpBankaccount> cBpBankaccountList) {
        this.cBpBankaccountList = cBpBankaccountList;
    }

    @XmlTransient
    public List<AdPinstance> getAdPinstanceList() {
        return adPinstanceList;
    }

    public void setAdPinstanceList(List<AdPinstance> adPinstanceList) {
        this.adPinstanceList = adPinstanceList;
    }

    @XmlTransient
    public List<CExternalpos> getCExternalposList() {
        return cExternalposList;
    }

    public void setCExternalposList(List<CExternalpos> cExternalposList) {
        this.cExternalposList = cExternalposList;
    }

    @XmlTransient
    public List<MRequisitionline> getMRequisitionlineList() {
        return mRequisitionlineList;
    }

    public void setMRequisitionlineList(List<MRequisitionline> mRequisitionlineList) {
        this.mRequisitionlineList = mRequisitionlineList;
    }

    @XmlTransient
    public List<CPocEmailUser> getCPocEmailUserList() {
        return cPocEmailUserList;
    }

    public void setCPocEmailUserList(List<CPocEmailUser> cPocEmailUserList) {
        this.cPocEmailUserList = cPocEmailUserList;
    }

    @XmlTransient
    public List<AdOrginfo> getAdOrginfoList() {
        return adOrginfoList;
    }

    public void setAdOrginfoList(List<AdOrginfo> adOrginfoList) {
        this.adOrginfoList = adOrginfoList;
    }

    @XmlTransient
    public List<MaMeasureShift> getMaMeasureShiftList() {
        return maMeasureShiftList;
    }

    public void setMaMeasureShiftList(List<MaMeasureShift> maMeasureShiftList) {
        this.maMeasureShiftList = maMeasureShiftList;
    }

    @XmlTransient
    public List<RRequestprocessorRoute> getRRequestprocessorRouteList() {
        return rRequestprocessorRouteList;
    }

    public void setRRequestprocessorRouteList(List<RRequestprocessorRoute> rRequestprocessorRouteList) {
        this.rRequestprocessorRouteList = rRequestprocessorRouteList;
    }

    @XmlTransient
    public List<AAsset> getAAssetList() {
        return aAssetList;
    }

    public void setAAssetList(List<AAsset> aAssetList) {
        this.aAssetList = aAssetList;
    }

    @XmlTransient
    public List<AdProcessRequest> getAdProcessRequestList() {
        return adProcessRequestList;
    }

    public void setAdProcessRequestList(List<AdProcessRequest> adProcessRequestList) {
        this.adProcessRequestList = adProcessRequestList;
    }

    @XmlTransient
    public List<MRequisition> getMRequisitionList() {
        return mRequisitionList;
    }

    public void setMRequisitionList(List<MRequisition> mRequisitionList) {
        this.mRequisitionList = mRequisitionList;
    }

    @XmlTransient
    public List<COrgassignment> getCOrgassignmentList() {
        return cOrgassignmentList;
    }

    public void setCOrgassignmentList(List<COrgassignment> cOrgassignmentList) {
        this.cOrgassignmentList = cOrgassignmentList;
    }

    @XmlTransient
    public List<RRequest> getRRequestList() {
        return rRequestList;
    }

    public void setRRequestList(List<RRequest> rRequestList) {
        this.rRequestList = rRequestList;
    }

    @XmlTransient
    public List<RRequest> getRRequestList1() {
        return rRequestList1;
    }

    public void setRRequestList1(List<RRequest> rRequestList1) {
        this.rRequestList1 = rRequestList1;
    }

    @XmlTransient
    public List<AdAlert> getAdAlertList() {
        return adAlertList;
    }

    public void setAdAlertList(List<AdAlert> adAlertList) {
        this.adAlertList = adAlertList;
    }

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
    }

    @XmlTransient
    public List<MInout> getMInoutList1() {
        return mInoutList1;
    }

    public void setMInoutList1(List<MInout> mInoutList1) {
        this.mInoutList1 = mInoutList1;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @XmlTransient
    public List<CProject> getCProjectList1() {
        return cProjectList1;
    }

    public void setCProjectList1(List<CProject> cProjectList1) {
        this.cProjectList1 = cProjectList1;
    }

    @XmlTransient
    public List<CSalesregion> getCSalesregionList() {
        return cSalesregionList;
    }

    public void setCSalesregionList(List<CSalesregion> cSalesregionList) {
        this.cSalesregionList = cSalesregionList;
    }

    @XmlTransient
    public List<AdUserRoles> getAdUserRolesList() {
        return adUserRolesList;
    }

    public void setAdUserRolesList(List<AdUserRoles> adUserRolesList) {
        this.adUserRolesList = adUserRolesList;
    }

    @XmlTransient
    public List<RRequestaction> getRRequestactionList() {
        return rRequestactionList;
    }

    public void setRRequestactionList(List<RRequestaction> rRequestactionList) {
        this.rRequestactionList = rRequestactionList;
    }

    @XmlTransient
    public List<RRequestaction> getRRequestactionList1() {
        return rRequestactionList1;
    }

    public void setRRequestactionList1(List<RRequestaction> rRequestactionList1) {
        this.rRequestactionList1 = rRequestactionList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adUserId != null ? adUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdUser)) {
            return false;
        }
        AdUser other = (AdUser) object;
        if ((this.adUserId == null && other.adUserId != null) || (this.adUserId != null && !this.adUserId.equals(other.adUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdUser[ adUserId=" + adUserId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return adUserId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		adUserId = id;
	}
    
}
