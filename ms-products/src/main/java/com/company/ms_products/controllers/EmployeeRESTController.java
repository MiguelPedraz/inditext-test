package com.company.ms_products.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.ms_products.dto.EmployeeListVO;
import com.company.ms_products.dto.EmployeeReport;
import com.company.ms_products.dto.EmployeeVO;
import com.company.ms_products.entities.EmployeeDB;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeRESTController {

	@RequestMapping(method = RequestMethod.GET)
	public EmployeeListVO getAllEmployees() {
		EmployeeListVO employeesList = new EmployeeListVO();

		for (EmployeeVO employee : EmployeeDB.getEmployeeList()) {
			// Adding self link employee 'singular' resource
			Link link = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(EmployeeRESTController.class).getAllEmployees())
					.slash(employee.getEmployeeId()).withSelfRel();

			// Add link to singular resource
			employee.add(link);

			// Adding method link employee 'singular' resource
			ResponseEntity<EmployeeReport> methodLinkBuilder = WebMvcLinkBuilder.methodOn(EmployeeRESTController.class)
					.getReportByEmployeeById(employee.getEmployeeId());
			Link reportLink = WebMvcLinkBuilder.linkTo(methodLinkBuilder).withRel("employee-report");

			// Add link to singular resource
			employee.add(reportLink);

			employeesList.getEmployees().add(employee);
		}

		// Adding self link employee collection resource
		Link selfLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(EmployeeRESTController.class).getAllEmployees()).withSelfRel();

		// Add link to collection resource
		employeesList.add(selfLink);

		return employeesList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable("id") int id) {
		if (id <= 3) {
			EmployeeVO employee = EmployeeDB.getEmployeeList().get(id - 1);

			// Self link
			Link selfLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(EmployeeRESTController.class).getEmployeeById(id)).withSelfRel();

			// Method link
			Link reportLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeRESTController.class)
					.getReportByEmployeeById(employee.getEmployeeId())).withRel("report");

			employee.add(selfLink);
			employee.add(reportLink);
			return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<EmployeeVO>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}/report", method = RequestMethod.GET)
	public ResponseEntity<EmployeeReport> getReportByEmployeeById(@PathVariable("id") int id) {
		// Do some operation and return report
		return null;
	}

	@RequestMapping(value = "/headers", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> listAllHeaders(@RequestHeader Map<String, String> headers) {
		
		Map<String,String> lsHeaders = new HashMap<String,String>();
		
		headers.forEach((key, value) -> {
			lsHeaders.put(key, value);
		});

		return new ResponseEntity<Map<String,String>>(lsHeaders, HttpStatus.OK);
	}
}
