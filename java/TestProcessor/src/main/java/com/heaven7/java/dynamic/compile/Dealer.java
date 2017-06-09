package com.heaven7.java.dynamic.compile;
public class Dealer implements Store
{
private Store s;
public Dealer(Store s)
 {  this.s = s;
 }
 public void sell() {
  System.out.println("price markup....");
  s.sell(); }
}