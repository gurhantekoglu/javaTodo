package javaproject.todo.business.abstracts;

import java.util.List;

import javaproject.todo.core.utilities.results.DataResult;
import javaproject.todo.core.utilities.results.Result;
import javaproject.todo.entities.concretes.Item;
import javaproject.todo.entities.dtos.ItemForUserDto;

public interface ItemService {

	Result add(ItemForUserDto itemForUserDto);

	Result update(ItemForUserDto itemForUserDto);

	Result delete(int id);

	DataResult<List<Item>> getAll();

	DataResult<List<Item>> sortByItemCreateYear();

}
