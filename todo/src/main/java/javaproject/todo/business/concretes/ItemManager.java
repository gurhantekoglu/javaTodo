package javaproject.todo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javaproject.todo.business.abstracts.ItemService;
import javaproject.todo.core.utilities.results.DataResult;
import javaproject.todo.core.utilities.results.Result;
import javaproject.todo.core.utilities.results.SuccessDataResult;
import javaproject.todo.core.utilities.results.SuccessResult;
import javaproject.todo.dataAccess.abstracts.ItemDao;
import javaproject.todo.dataAccess.abstracts.UserDao;
import javaproject.todo.entities.concretes.Item;
import javaproject.todo.entities.dtos.ItemForUserDto;

@Service
public class ItemManager implements ItemService {

	private ItemDao itemDao;
	private UserDao userDao;

	@Autowired
	public ItemManager(ItemDao itemDao) {
		super();
		this.itemDao = itemDao;
	}

	@Override
	public Result add(ItemForUserDto itemForUserDto) {
		Item item = new Item();
		item.setId(0);
		item.setUser(this.userDao.getById(itemForUserDto.getId()));
		item.setName(itemForUserDto.getName());
		item.setDescription(itemForUserDto.getDescription());
		item.setCreatedDate(itemForUserDto.getCreatedDate());
		this.itemDao.save(item);
		return new SuccessResult("Listeye eklendi!");
	}

	@Override
	public Result update(ItemForUserDto itemForUserDto) {
		Item itemUpdate = this.itemDao.getById(itemForUserDto.getId());
		itemUpdate.setName(itemForUserDto.getName());
		itemUpdate.setDescription(itemForUserDto.getDescription());
		itemUpdate.setCreatedDate(itemForUserDto.getCreatedDate());
		this.itemDao.save(itemUpdate);
		return new SuccessResult("Güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.itemDao.deleteById(id);
		return new SuccessResult("Listeden silindi!");
	}

	@Override
	public DataResult<List<Item>> getAll() {
		return new SuccessDataResult<List<Item>>(this.itemDao.findAll());
	}

	@Override
	public DataResult<List<Item>> sortByItemCreateYear() {
		Sort sort = Sort.by(Sort.Direction.DESC, "createYearOfItem");
		return new SuccessDataResult<List<Item>>(this.itemDao.findAll(sort));
	}

}
