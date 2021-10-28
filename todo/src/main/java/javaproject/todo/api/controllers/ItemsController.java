package javaproject.todo.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javaproject.todo.business.abstracts.ItemService;
import javaproject.todo.core.utilities.results.ErrorDataResult;
import javaproject.todo.entities.dtos.ItemForUserDto;

@RestController
@RequestMapping("/api/items")
@CrossOrigin
public class ItemsController {

	private ItemService itemService;

	@Autowired
	public ItemsController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Validated @RequestBody ItemForUserDto itemForUserDto) {
		return ResponseEntity.ok(this.itemService.add(itemForUserDto));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@Validated @RequestBody ItemForUserDto itemForUserDto) {
		return ResponseEntity.ok(this.itemService.update(itemForUserDto));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return ResponseEntity.ok(this.itemService.delete(id));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.itemService.getAll());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları!");
		return errors;
	}

}
