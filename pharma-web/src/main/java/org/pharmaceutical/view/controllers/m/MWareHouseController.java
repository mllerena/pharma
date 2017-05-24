package org.pharmaceutical.view.controllers.m;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.MLocatorFacade;
import org.pharmaceutical.model.ejb.facades.MWarehouseFacade;
import org.pharmaceutical.model.ejb.facades.MLocatorFacade;
import org.pharmaceutical.model.ejb.facades.MLocatorTypeFacade;
import org.pharmaceutical.model.entities.CLocation;
import org.pharmaceutical.model.entities.MWarehouse;
import org.pharmaceutical.model.entities.MLocator;
import org.pharmaceutical.model.entities.MLocatorType;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class MWareHouseController extends
		AbstractController<MWarehouse, MWarehouse> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private MWarehouseFacade mWarehouseFacade;

	@Inject
	private MLocatorFacade mLocatorFacade;

	public MWareHouseController() {
		super(MWareHouseController.class);
	}

	@PostConstruct
	public void initialize() {
		filterEntity = new MWarehouse();
		// filterEntity.setEstado(Estado.ACTIVO);
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MWarehouse();

	}

	@Override
	public List<MWarehouse> loadDataTable(MWarehouse filter) {
		return mWarehouseFacade.find(filter);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MWarehouse();
		currentEntity.setCLocationId(new CLocation());
		System.out.println("create MWarehouse currentEntity: " + currentEntity);

	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		detalleHueco.load();
		detalleHueco.init();
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub

	}

	@Override
	protected MWarehouse save(MWarehouse item) {
		// TODO Auto-generated method stub

		System.out.println("save item: " + item);

		try {

			mWarehouseFacade.save(item);

		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}

		JsfUtils.messageInfo(null,
				"Almacén guardado correctamente.", null);

		return item;
	}

	@Override
	protected void delete(MWarehouse item) {
		// TODO Auto-generated method stub

		try {
			mWarehouseFacade.delete(item);
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}

		JsfUtils.messageInfo(null,
				"Almacén eliminado correctamente.", null);

	}

	@Override
	protected void cancel(MWarehouse item) {
		// TODO Auto-generated method stub
		// cBpartnerFacade.find(currentEntity.getId());
	}

	/*
	 * Detalle herramienta
	 */
	private DataList<MLocator> detalleHueco = new DataList<MLocator>() {

		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
		}

		@Override
		public List<MLocator> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MLocator>();
			}
			return mLocatorFacade.findByMWarehouseId(currentEntity);
		}

		public MLocator create() {
			MLocator pl = new MLocator();
			pl.setMWarehouseId(currentEntity);
			pl.setIsdefault(null);
			return pl;
		}

		protected void delete(List<MLocator> items) {
			System.out.println("BORRO EN BASE: " + items);

			try {
				mLocatorFacade.delete(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null,
					"Hueco(s) elimanado(s) correctamente.", null);

		}

		@Override
		protected MLocator save(MLocator item) {
			// TODO Auto-generated method stub

			// debe guardar el item
			System.out.println("save item: " + item);

			try {
				mLocatorFacade.save(item);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}

			JsfUtils.messageInfo(null, "Hueco guardado correctamente.", null);

			return item;
		}

		protected void cancel() {
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MLocator> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: " + items);

			try {
				mLocatorFacade.save(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null, "Huecos guardados correctamente.", null);

		}

	};

	public DataList<MLocator> getDetalleHueco() {
		return detalleHueco;
	}

	public YesNo[] getListYesNo() {
		return YesNo.values();
	}

	public void returnLocation(SelectEvent event) {
		CLocation cLocation = (CLocation) event.getObject();
		getCurrentEntity().setCLocationId(cLocation);

		System.out.println("returnLocation cLocation: " + cLocation);
	}

}
