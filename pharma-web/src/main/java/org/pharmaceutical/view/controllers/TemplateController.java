package org.pharmaceutical.view.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.pharmaceutical.model.exceptions.ProcessOperationException;
import org.pharmaceutical.view.beans.Tab;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

@Named
@SessionScoped
public class TemplateController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Tab> listTabs;

	private TabView tabViewMain;

	private Integer activeIndex;

	@Inject
	private LoginController loginController;
	
	

	@PostConstruct
	public void initialize() {

		System.out.println("initialize TemplateController");
		setListTabs(new ArrayList<Tab>());

		Tab t = new Tab(0, "Inicio", "/pages/home.xhtml", null, false,null);

		getListTabs().add(t);

		setActiveIndex(0);

	}

	public List<Tab> getListTabs() {
		return listTabs;
	}

	public void setListTabs(List<Tab> listTabs) {
		this.listTabs = listTabs;
	}

	public void onSelectMenu(ActionEvent action) {

		System.out.println("onSelectMenu template" + action);
		

		String view = (String) action.getComponent().getAttributes()
				.get("view");
		String title = (String) action.getComponent().getAttributes()
				.get("title");
		String bean = (String) action.getComponent().getAttributes()
				.get("bean");
		
		System.out.println("onSelectMenu view: " + view);
		System.out.println("onSelectMenu title: " + title);
		System.out.println("onSelectMenu bean: " + bean);
		 
		try {
			openTab(view, title, bean,true,null); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	public void openTab(String view, String title, String bean, boolean closable, Map<String,Object> params) 
			throws Exception {

		if (view == null) {
			throw new Exception("openTab view not null");
		}
		if (title == null) {
			throw new Exception("openTab title not null");
		}
		if (bean == null) {
			throw new Exception("openTab bean not null");
		}

		System.out.println("view : " + view + " title: " + title);

		if (listTabs != null && !listTabs.isEmpty())
			for (int i = 0; i < listTabs.size(); i++) {
				Tab t = listTabs.get(i);
				if (t.getView().equals(view)) {
					JsfUtils.executeJS("PF('wvTabs').select(" + i + ");"); 
					return;
				}
			}

		int size = this.getListTabs().size();

		System.out.println("size: " + size);

		if (size < 10) {

			Tab tab = new Tab(size, title, view, bean, closable,params);  

			this.getListTabs().add(tab);

			System.out.println("this.getListTabs() : " + this.getListTabs());

			JsfUtils.executeJS("PF('wvTabs').select(" + size + ");");
			
			setActiveIndex((size-1)); 

		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(
					null,
					new FacesMessage(
							FacesMessage.SEVERITY_WARN,
							"Tiene muchas pestañas abiertas. Necesita cerrar alguna para abrir una nueva.",
							""));
		}

	}

	public void onTabClose(TabCloseEvent event) {
		
		String title = event.getTab().getTitle();

		String id = event.getTab().getId();
		System.out.println("onTabClose id: " + id);
		id = id.substring(1);
		System.out.println("convert id: " + id);
		
		
		Tab t = null;
		if(this.getListTabs() != null && !this.getListTabs().isEmpty())
		for (Tab tab : this.getListTabs()) {
			if(tab.getTitle().contains(title) ){
				t = tab;
				System.out.println("onTabClose tabs contains: " + t);
				break;
			}
		}

		
		this.getListTabs().remove(t);

		System.out.println("onTabClose getListTabs: " + this.getListTabs());

		// para abrir el ultimo
		/*
		 * int size = this.getListTabs().size();
		 * JsfUtils.executeJS("PF('wvTabs').select("+ size +");");
		 */
		
		setActiveIndex((getListTabs().size()-1));

		try {
			JsfUtils.removeViewScope(t.getBean());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTabChange(TabChangeEvent event) {
		// event.g
		
		//System.out.println("TabChangeEvent: "+getTabViewMain().get +" -> "+event);
		
		
		//System.out.println("TabChangeEvent getIndexData: "+getTabViewMain().getIndexData());
		//System.out.println("TabChangeEvent getIndex: "+getTabViewMain().getIndex());
		
		System.out.println("TabChangeEvent getChildren: "+getTabViewMain().getChildren() );
		System.out.println("TabChangeEvent getChildren mayor: "+getTabViewMain().getChildren().get( ( getTabViewMain().getChildren().size() - 1 ) ) );
		
		
		System.out.println("TabChangeEvent getTab: "+event.getTab());
		
		String title = null;
		int index = -1;
		
		if( event.getTab() == null){
			org.primefaces.component.tabview.Tab tb = (org.primefaces.component.tabview.Tab) getTabViewMain().getChildren().get( ( getTabViewMain().getChildren().size() - 1 ) );
			title = tb.getTitle();
		}else{
			title = event.getTab().getTitle();
		}
		
		System.out.println("TabChangeEvent title found: "+title);
		
		
		if(this.getListTabs() != null && !this.getListTabs().isEmpty())
		for (int x=0; x < this.getListTabs().size() ;x++ ) {
			Tab tab = this.getListTabs().get(x);
			if(tab.getTitle().contains(title) ){
				index = x;
				System.out.println("onTabChange tabs contains: " + x);
				break;
			}
		}
		
		setActiveIndex(index ); 
		
		
		

		

	}

	public void handler() {

		System.out.println("handler getActiveIndex(): " + getActiveIndex());

		String js = "fnQuery" + getActiveIndex() + "();";

		System.out.println("js: " + js);
		if (getActiveIndex() != 0) {
			JsfUtils.executeJS(js);
		}

	}

	public TabView getTabViewMain() {
		return tabViewMain;
	}

	public void setTabViewMain(TabView tabViewMain) {
		this.tabViewMain = tabViewMain;
	}

	public Integer getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(Integer activeIndex) {
		this.activeIndex = activeIndex;
	}
	
	public Tab getTabByBean(String bean){
		
		Tab result = null;
		
		if(bean == null) return null;
		
		if(  getListTabs() != null && !getListTabs().isEmpty() ){
			for (Tab tab : getListTabs()) {
				if( tab.getBean() != null && tab.getBean().equals(bean) ){
					
					result = tab;
					break;
				}
			}
		}
		return result;
	}
	
	public void removeTab(){
		JsfUtils.executeJS("PF('wvTabs').remove(" + getActiveIndex() + ");");  
	}

}

