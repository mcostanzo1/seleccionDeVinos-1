package com.dp3.dao;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

public class SequenceId {
	
	@Id
	private String id;
	private BigInteger seq;
	public BigInteger getSeq() {
		return seq;
	}
}
