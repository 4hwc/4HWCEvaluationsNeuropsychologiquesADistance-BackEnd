/**
 * 
 */
package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.beans.Patient;
import enad.dao.PatientDao;
import enad.ip.PatientIp;

/**
 * @author Admin
 *
 */
public final class TransitionRpnApForm {

	private PatientDao patientDao;

	public TransitionRpnApForm(PatientDao patientDao) {

		this.patientDao = patientDao;
	}

	public Patient connecterPatient(HttpServletRequest request) {

		Patient patient = new Patient();

		String identifiant = request.getParameter("identifiant");

		patient.setId_patient(patientDao.trouver(identifiant).getId_patient());

		PatientIp distribuer_ip = new PatientIp(patientDao);

		patient.setIp_patient(distribuer_ip.genererIpPatient());

		patientDao.creer_ip(patient);

		return patientDao.trouver(identifiant);

	}

}
