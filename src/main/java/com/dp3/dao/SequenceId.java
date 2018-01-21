package com.dp3.dao;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;

public class SequenceId {
	
	@Id
	private String id;
	private BigInteger seq;
	public BigInteger getSeq() {
		return seq;
	}
}
