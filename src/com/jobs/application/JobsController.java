package com.jobs.application;

import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;
import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Volunteer;

import java.util.ArrayList;
import java.util.List;

public class JobsController {

	private EmployeeRepository repository;

	public JobsController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, com.jobs.application.PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee empleao = new Employee(name, address, phone,  salaryPerMonth, com.jobs.application.PaymentFactory.createPaymentRateEmployee());
		repository.addMember(empleao);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, com.jobs.application.PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
		// TODO Auto-generated method stub -  DONE!
		
	}


	public void payAllEmployeers() {
		List<AbsStaffMember> miembros= new ArrayList<>();
		miembros = repository.getAllMembers();
		for (AbsStaffMember e : miembros){
			e.pay();
			//if ( e instanceof Employee) {
			//	((Employee)e).pay();
			//} else if ( e instanceof Volunteer) {
			//	((Volunteer)e).pay();
			//}
		}
		// TODO Auto-generated method stub - DONE!
	
	}

	public String getAllEmployees() {
		String lista_miembros ="\n";
		List<AbsStaffMember> miembros= new ArrayList<>();
		miembros = repository.getAllMembers();
		for (AbsStaffMember e : miembros){
			//System.out.println( e.getName()+ " \n");
			if ( e instanceof Employee) {
				lista_miembros = lista_miembros + e.getName() + " ................Original Salary:" + ((Employee) e).getSalaryPerMonth() + " \n";
			} else if ( e instanceof Volunteer) {
				lista_miembros = lista_miembros + e.getName()  + " ...........es " + ((Volunteer) e).getDescription() + " \n";

			}
		}
		// TODO Auto-generated method stub - DONE!
		return lista_miembros;
	}

	public void createVolunteer(String name, String address, String phone) throws Exception{
		Volunteer voluntario = new Volunteer(name, address, phone, "voluntario sin sueldo");
		repository.addMember(voluntario);
		// TODO Auto-generated method stub - DONE!
	}
	
	
	
}
