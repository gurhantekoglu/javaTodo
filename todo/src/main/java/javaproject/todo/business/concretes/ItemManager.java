package javaproject.todo.business.concretes;

import org.springframework.stereotype.Service;

import javaproject.todo.dataAccess.abstracts.ItemDao;

@Service
public class ItemManager {

	private ItemDao itemDao;

	public ItemManager(ItemDao itemDao) {
		super();
		this.itemDao = itemDao;
	}

}
