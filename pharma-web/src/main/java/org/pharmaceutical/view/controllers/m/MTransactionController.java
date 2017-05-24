package org.pharmaceutical.view.controllers.m;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.MTransactionFacade;
import org.pharmaceutical.model.entities.MTransaction;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.controllers.AbstractController;

@ManagedBean
@ViewScoped
public class MTransactionController extends
		AbstractController<MTransaction, MTransaction> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private MTransactionFacade mTransactionFacade;


	public MTransactionController() {
		super(MTransactionController.class);
	}

	@PostConstruct
	public void initialize() {
		filterEntity = new MTransaction();
		// filterEntity.setEstado(Estado.ACTIVO);
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MTransaction();

	}

	@Override
	public List<MTransaction> loadDataTable(MTransaction filter) {
		return mTransactionFacade.find(filter);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MTransaction();
		System.out.println("create MTransaction currentEntity: " + currentEntity);

	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub

	}

	@Override
	protected MTransaction save(MTransaction item) {
		// TODO Auto-generated method stub

		System.out.println("save item: " + item);
		return item;
	}

	@Override
	protected void delete(MTransaction item) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void cancel(MTransaction item) {
		// TODO Auto-generated method stub
		// cBpartnerFacade.find(currentEntity.getId());
	}

	

	public YesNo[] getListYesNo() {
		return YesNo.values();
	}


}
