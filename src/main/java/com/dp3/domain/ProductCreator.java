package com.dp3.domain;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.dp3.dao.SequenceId;

@Component
public class ProductCreator {

	@Autowired
	private MongoTemplate mongoTemplate;

<<<<<<< HEAD
	public Stock createProduct() {
=======
	public Product createProduct() {
>>>>>>> c885f0c2656b8ce59f835f24e12ac74303215185
		return null;
	}

	protected BigInteger getNextSequenceId() {

		// get sequence id
		Query query = new Query(Criteria.where("_id").is("productId"));

		// increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);

		// return new increased id
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		// this is the magic happened.
		SequenceId seqId = mongoTemplate.findAndModify(query, update, options, SequenceId.class);

		return seqId.getSeq();
	}
}