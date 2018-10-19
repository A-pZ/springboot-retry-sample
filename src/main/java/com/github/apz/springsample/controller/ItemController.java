/**
 *
 */
package com.github.apz.springsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.apz.springsample.repository.service.ItemService;

import lombok.RequiredArgsConstructor;

/**
 * @author a-pz
 *
 */
@RestController
@RequiredArgsConstructor
public class ItemController {

	private final ItemService service;

	@GetMapping("insert")
	public String insert() {
		boolean result = service.insertItem();

		return (result) ? "SUCCESS" : "FAILURE";
	}
}
