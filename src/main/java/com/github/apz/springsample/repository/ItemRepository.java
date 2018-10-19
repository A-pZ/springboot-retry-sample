/**
 *
 */
package com.github.apz.springsample.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;

import com.github.apz.springsample.model.Item;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author a-pz
 *
 */
@Repository
@RequiredArgsConstructor
@Log4j2
public class ItemRepository {
	private final SqlSessionTemplate sqlSessionTemplate;

	@Retryable(include= {DuplicateKeyException.class}, maxAttempts=3, backoff= @Backoff(delay=1000))
	public int insertItem(Item item) {
		log.info("execute -----> ");
		return sqlSessionTemplate.insert("items.insertItem", item);
	}

	@Recover
	public int retryInsertItem(DuplicateKeyException ex) {
		log.warn(ex);
		throw new RuntimeException(ex);
	}
}
