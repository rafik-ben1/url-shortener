package com.rafikben.urlshortner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Arrays;

import jakarta.persistence.*;
@Entity
public class Sequence {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private long id;
 
 @Column
 private int[] nextIndex;

public long getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int[] getNextIndex() {
	return nextIndex;
}

public void setNextIndex(int[] nextIndex) {
	this.nextIndex = nextIndex;
}

public Sequence(long id, int[] nextIndex) {
	super();
	this.id = id;
	this.nextIndex = nextIndex;
}
 public Sequence() {}

@Override
public String toString() {
	return "Sequence [id=" + id + ", nextIndex=" + Arrays.toString(nextIndex) + "]";
}
 
}
