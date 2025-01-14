package com.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.bean.BedBean;
import com.admin.service.BedService;

@Controller
@RequestMapping("/bed")
public class BedEntityController {

	@Autowired
	BedService bedService;
	private static Logger log = LoggerFactory.getLogger(BedAllocationController.class.getSimpleName());

	@PostMapping("/save")
	public ResponseEntity<BedBean> saveBed(@RequestBody BedBean bedBean) {
		log.info("Saving Bed");
		BedBean bedDetails = bedService.save(bedBean);
		ResponseEntity<BedBean> responseEntity = new ResponseEntity<>(bedDetails, HttpStatus.CREATED);
		log.info("Bed saved successfully");
		return responseEntity;

	}

	@GetMapping("/getById/{bedId}")
	public ResponseEntity<BedBean> getBedDetailsById(@PathVariable Long bedId) {
		log.info("Getting Bed Details by Id");
		BedBean bed = bedService.getById(bedId);
		log.info("Retrieving bed details by Id is done");
		return new ResponseEntity<BedBean>(bed, HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BedBean>> getAllBedDetails() {
		log.info("Retrieving  all bed details");
		List<BedBean> list = bedService.getAll();
		ResponseEntity<List<BedBean>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		log.info("Retrieved  all bed details successfully");
		return responseEntity;

	}

	@GetMapping(path = "/getByRoomId/{id}")
	public ResponseEntity<List<BedBean>> getAllByWard(@PathVariable Long id) {
		log.info("Retrieving bed details by roomId");

		List<BedBean> list = bedService.findByBedIdRoomEntityId(id);
		log.info("Retrieving bed details by roomId successfully");
		return new ResponseEntity<List<BedBean>>(list, HttpStatus.OK);

	}

	@PutMapping("/update/{bedId}")
	public ResponseEntity<String> updateBedDetails(@PathVariable Long bedId, @RequestBody BedBean bed) {

		log.info("Updating BedStatus");

		bedService.update(bedId, bed);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Bed Status updated Successfully", HttpStatus.OK);
		log.info("Updated bed successfully");
		return responseEntity;

	}

	@DeleteMapping("/deleteById/{bedId}")
	public ResponseEntity<String> deleteBedById(@PathVariable Long bedId) {
		log.info("Deleting BedAllocation By Id");
		bedService.getById(bedId);
		bedService.delete(bedId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		log.info("Deleted Bed successfully");
		return responseEntity;

	}

}
