package com.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.bean.WardBean;
import com.admin.entity.Ward;
import com.admin.service.WardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/ward")

public class WardController {
	Logger log = LoggerFactory.getLogger(WardController.class);

	@Autowired
	private WardService wardService;

	@PostMapping("/save")
	public ResponseEntity<WardBean> saveWard(@RequestBody WardBean wardBean) {
		log.info("started WardController ::save()");
		WardBean wardBean1 = wardService.saveWard(wardBean);
		log.info("Ward Saved Successfully");
		return new ResponseEntity<WardBean>(wardBean1, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<WardBean> getWardById(@PathVariable Long id) {
		log.info("start wardController:getById");
		WardBean wardBean = wardService.getByWardId(id);
		log.info("Ward is fetched by Id successfully");
		return new ResponseEntity<WardBean>(wardBean, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<WardBean>> getAllWards() {
		log.info("Retrieving all wards");
		List<WardBean> wardBean = wardService.getAllWards();
		log.info("Retrieving all wards successfully");
		return new ResponseEntity<List<WardBean>>(wardBean, HttpStatus.OK);
	}

	@GetMapping("/getByDepartmentId/{id}")
	public ResponseEntity<List<Ward>> getWardsByDepartmentId(@PathVariable Long id) {

		log.info("Get the ward details sucessfully");
		List<Ward> ward = wardService.findByDepartmentId(id);
		return new ResponseEntity<List<Ward>>(ward, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateWardById(@RequestBody WardBean wardBean, @PathVariable Long id) {

		log.info("start::wardController:update");
		wardService.updateWard(wardBean);
		log.info("Ward is updated successfully");
		return new ResponseEntity<>("Update successfully" + wardBean, HttpStatus.OK);

	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Void> deleteWardById(@PathVariable Long id) {
		log.info("Start WardController:delete()");
		wardService.delete(id);
		log.info("deleted successfully");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/updateStatus")
	public void updateWardStatus(@RequestBody Ward ward) {
		log.info("Updating the status of ward");
		wardService.updateStatus(ward);
		log.info("Update ward status sucessfully");
	}

}