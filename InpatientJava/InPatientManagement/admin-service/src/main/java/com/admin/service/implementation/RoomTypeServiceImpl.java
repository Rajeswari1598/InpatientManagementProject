package com.admin.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.bean.RoomTypeBean;
import com.admin.constants.CommonConstants;
import com.admin.entity.RoomType;
import com.admin.exception.RecordNotFoundException;
import com.admin.exception.RoomTypeAlreadyExistsException;
import com.admin.exception.RoomTypeDetailsNotFoundException;
import com.admin.repository.RoomTypeRepository;
import com.admin.service.RoomTypeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

	@Autowired
	RoomTypeRepository roomTypeRepository;
	@Autowired
	private ObjectMapper objectMapper;
	Logger log = LoggerFactory.getLogger(RoomTypeServiceImpl.class);

	@Override
	public RoomTypeBean save(RoomTypeBean roomTypeBean) {

		log.info("Saving roomtype");
		RoomType roomtype1 = roomTypeRepository.getByName(roomTypeBean.getName());
		if (roomtype1 == null) {
			RoomType roomType = objectMapper.convertValue(roomTypeBean, RoomType.class);
			roomType.setStatus(CommonConstants.ACTIVE);
			roomTypeRepository.save(roomType);
		} else {
			log.info("roomtype is already exists");
			throw new RoomTypeAlreadyExistsException("Already exists");
		}
		return roomTypeBean;

	}

	@Override
	public List<RoomTypeBean> getAll() {

		try {
			log.info("Fetching all roomtypes");
			List<RoomType> entityList = roomTypeRepository.findAll();
			List<RoomTypeBean> beanList = new ArrayList<>();
			entityListToBeanList(entityList, beanList);
			return beanList;
		} catch (Exception exception) {
			log.info("Error occured while fetching all roomTypes", exception);
			throw exception;
		}
	}

	private void entityListToBeanList(List<RoomType> entityList, List<RoomTypeBean> beanList) {

		for (RoomType roomType : entityList) {
			RoomTypeBean roomTypeBean = objectMapper.convertValue(roomType, RoomTypeBean.class);
			beanList.add(roomTypeBean);
		}
	}

	@Override
	public RoomTypeBean getById(long id) {

		log.info("Fetching roomtype by ID");
		RoomType roomType = roomTypeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("There is no record with the given id"));
		RoomTypeBean roomTypeBean = objectMapper.convertValue(roomType, RoomTypeBean.class);
		log.info("Fetching roomtype by ID is done");
		return roomTypeBean;

	}

	@Override
	public void delete(long id) {

		try {
			log.info("deleting the roomtype");
			roomTypeRepository.deleteById(id);
		} catch (Exception exception) {
			log.info("Error occured while deleting roomType by Id", exception);
			throw exception;
		}
	}

	@Override
	public RoomType updateRoomType(RoomTypeBean roomTypeBean) {
		if (roomTypeBean != null) {
			log.info("updating the roomtype by id");
			RoomType roomType = roomTypeRepository.getReferenceById(roomTypeBean.getId());
			roomType = objectMapper.convertValue(roomTypeBean, RoomType.class);
			roomTypeRepository.save(roomType);
			log.info("updating the roomtype by id is done");
			return roomType;
		} else {
			log.info("Error occured while updating the roomType by Id");
			throw new RoomTypeDetailsNotFoundException("roomtype details not found");
		}
	}

	@Override
	public void updateStatus(RoomType roomTypeEntity) {
		if (roomTypeEntity != null) {
			log.info("updating the Status of roomType");
			if (roomTypeEntity.getStatus().equalsIgnoreCase(CommonConstants.ACTIVE)) {
				roomTypeEntity.setStatus(CommonConstants.INACTIVE);
			} else {
				roomTypeEntity.setStatus(CommonConstants.ACTIVE);
			}
			roomTypeRepository.save(roomTypeEntity);
		} else {
			log.info("Error occured while updating the status of roomType");
			throw new RoomTypeDetailsNotFoundException("roomtype details not found");
		}

	}

}
