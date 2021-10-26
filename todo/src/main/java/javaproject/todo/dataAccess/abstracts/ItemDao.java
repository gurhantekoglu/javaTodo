package javaproject.todo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaproject.todo.entities.concretes.Item;

public interface ItemDao extends JpaRepository<Item, Integer> {

	Item getById(int id);

}
