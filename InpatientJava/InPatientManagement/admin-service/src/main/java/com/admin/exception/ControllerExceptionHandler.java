package com.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
	Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<String> exception(RecordNotFoundException exception) {
		log.error("ResourceNotFoundException-" + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception exception) {
		log.error("Exception-" + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BedAlreadyExistsException.class)
	public ResponseEntity<Object> handleException(BedAlreadyExistsException exception) {
		log.error("BedAlreadyExistsException-" + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DepartmentAlreadyExistsException.class)
	public ResponseEntity<Object> handleDepartmentAlreadyExistsException(DepartmentAlreadyExistsException exception) {
		log.error("DepartmentAlreadyExistsException-" + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Object> handleDepartmentNotFoundException(DepartmentNotFoundException exception) {
		log.error("DepartmentNotFoundException-" + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<Object> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception) {
		log.error("EmailAlreadyExistsException-" + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<Object> handleEmailNotFoundException(EmailNotFoundException exception) {
		log.error("EmailNotFoundException-" + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ExternalServiceException.class)
	public ResponseEntity<Object> handleExternalServiceException(ExternalServiceException exception) {
		log.error("EmailNotFoundException-" + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<Object> handleInvalidOtpException(InvalidOtpException exception) {
		log.error("InvalidOtpException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<Object> handlePasswordMismatchException(PasswordMismatchException exception) {
		log.error("PasswordMismatchException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PatientDoesNotExistsException.class)
	public ResponseEntity<Object> handlePatientDoesNotExistsException(PatientDoesNotExistsException exception) {
		log.error("PatientDoesNotExistsException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RegistrationException.class)
	public ResponseEntity<Object> handleRegistrationException(RegistrationException exception) {
		log.error("RegistrationException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RoomAlreadyExistsException.class)
	public ResponseEntity<Object> handleRoomAlreadyExistsException(RoomAlreadyExistsException exception) {
		log.error("RoomAlreadyExistsException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(RoomAvailabilityException.class)
	public ResponseEntity<Object> handleRoomAvailabilityException(RoomAvailabilityException exception) {
		log.error("RoomAvailabilityException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RoomCapacityExceededException.class)
	public ResponseEntity<Object> handleRoomCapacityExceededException(RoomCapacityExceededException exception) {
		log.error("RoomCapacityExceededException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RoomTypeAlreadyExistsException.class)
	public ResponseEntity<Object> handleRoomTypeAlreadyExistsException(RoomTypeAlreadyExistsException exception) {
		log.error("RoomTypeAlreadyExistsException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(RoomTypeDetailsNotFoundException.class)
	public ResponseEntity<Object> handleRoomTypeDetailsNotFoundException(RoomTypeDetailsNotFoundException exception) {
		log.error("RoomTypeDetailsNotFoundException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(WardAlreadyExistsException.class)
	public ResponseEntity<Object> handleWardAlreadyExistsException(WardAlreadyExistsException exception) {
		log.error("WardAlreadyExistsException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(WardAvailabilityException.class)
	public ResponseEntity<Object> handleWardAvailabilityException(WardAvailabilityException exception) {
		log.error("WardAvailabilityException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(WardCapacityExceededException.class)
	public ResponseEntity<Object> handleWardCapacityExceededException(WardCapacityExceededException exception) {
		log.error("WardCapacityExceededException: " + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
