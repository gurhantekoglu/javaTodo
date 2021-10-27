package javaproject.todo.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemForUserDto {

	private int id;

	private int userId;

	private String name;

	private String description;

	private LocalDate createdDate;

}
