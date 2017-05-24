package org.pharmaceutical.model.ejb.services;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.el.FunctionMapper;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.sql.DataSource;

import org.pharmaceutical.model.ejb.facades.AdPinstanceFacade;
import org.pharmaceutical.model.ejb.facades.AdProcessFacade;
import org.pharmaceutical.model.entities.AbstractEntityModel;
import org.pharmaceutical.model.entities.AdPinstance;
import org.pharmaceutical.model.entities.AdProcess;
import org.pharmaceutical.model.entities.MaWorkrequirement;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.utils.SecurityUtils;

@Stateless
public class MaPackageService {

	@PersistenceContext(unitName = "pharmaceutical-pu")
	private EntityManager em;

	@Inject
	private AdProcessFacade adProcessFacade;

	@Inject
	private AdPinstanceFacade adPinstanceFacade;

	@Inject
	private SecurityUtils security;

	public MaPackageService() {

	}

	public String workRequirementProcess(AdPinstance adPinstance) {

		// System.out.println("dsPharma conexion: "+dsPharma);
		String sequenceDoc = null;

		try {

			// MA_WorkRequirement_Process

			System.out.println("workRequirementProcess adPinstanceId: "
					+ adPinstance.getAdPinstanceId());

			StoredProcedureQuery sp = em.createStoredProcedureQuery(
					"ma_workrequirement_process", "VOID_MAPPING");
			sp.registerStoredProcedureParameter(1, String.class,
					ParameterMode.IN);
			sp.setParameter(1, adPinstance.getAdPinstanceId());
			sp.execute();

			/*
			 * String queryString =
			 * "SELECT \"ma_workrequirement_process\"( ? )"; Query query =
			 * em.createNativeQuery(queryString); query.setParameter(1,
			 * instance.getAdPinstanceId());
			 * 
			 * Object result = query.getSingleResult();
			 */

			// sequenceDoc = (String) sp.getOutputParameterValue(4);

			// System.out.println("workRequirementProcess Successfully: "+result);

			System.out.println("workRequirementProcess Successfully: ");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return sequenceDoc;

	}

	public void createStandards(AdPinstance adPinstance) {

		// System.out.println("dsPharma conexion: "+dsPharma);

		try {

			// ma_productionrun_standard

			System.out.println("createStandards adPinstanceId: "
					+ adPinstance.getAdPinstanceId());

			StoredProcedureQuery sp = em.createStoredProcedureQuery(
					"ma_productionrun_standard", "VOID_MAPPING");
			sp.registerStoredProcedureParameter(1, String.class,
					ParameterMode.IN);
			sp.setParameter(1, adPinstance.getAdPinstanceId());
			sp.execute();

			System.out.println("createStandards Successfully: ");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void workEffortValidate(AdPinstance adPinstance) {

		// System.out.println("dsPharma conexion: "+dsPharma);

		try {

			// ma_productionrun_standard

			System.out.println("workEffortValidate adPinstanceId: "
					+ adPinstance.getAdPinstanceId());

			StoredProcedureQuery sp = em.createStoredProcedureQuery(
					"ma_workeffort_validate", "VOID_MAPPING");
			sp.registerStoredProcedureParameter(1, String.class,
					ParameterMode.IN);
			sp.setParameter(1, adPinstance.getAdPinstanceId());
			sp.execute();

			System.out.println("workEffortValidate Successfully: ");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void workRequirementClose(AdPinstance adPinstance) {

		// System.out.println("dsPharma conexion: "+dsPharma);

		try {

			// ma_productionrun_standard

			System.out.println("workRequirementClose adPinstanceId: "
					+ adPinstance.getAdPinstanceId());

			StoredProcedureQuery sp = em.createStoredProcedureQuery(
					"MA_WorkRequirement_Close", "VOID_MAPPING");
			sp.registerStoredProcedureParameter(1, String.class,
					ParameterMode.IN);
			sp.setParameter(1, adPinstance.getAdPinstanceId());
			sp.execute();

			System.out.println("workRequirementClose Successfully: ");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void workReqPhaseClose(AdPinstance adPinstance) {

		// System.out.println("dsPharma conexion: "+dsPharma);

		try {

			// ma_productionrun_standard

			System.out.println("workReqPhaseClose adPinstanceId: "
					+ adPinstance.getAdPinstanceId());

			StoredProcedureQuery sp = em.createStoredProcedureQuery(
					"MA_WRPhase_Close", "VOID_MAPPING");
			sp.registerStoredProcedureParameter(1, String.class,
					ParameterMode.IN);
			sp.setParameter(1, adPinstance.getAdPinstanceId());
			sp.execute();

			System.out.println("workReqPhaseClose Successfully: ");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
