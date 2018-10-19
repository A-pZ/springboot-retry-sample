package com.github.apz.springsample.service;

import org.springframework.stereotype.Service;

import com.github.apz.springsample.model.Item;
import com.github.apz.springsample.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	private final ItemRepository itemRepository;

	public boolean insertItem() {
		Item item = new Item();
		item.setId(1);
		item.setName("name");
		int count = itemRepository.insertItem(item);

		return count > 0;
	}
}
