package com.yidu.victory.popedom.domain;
/**
 * 角色信息表
 * @author Administrator
 *
 */
public class Role {
 private int roleid;
 private String rolename;
 
 public Role(int roleid, String rolename) {
  super();
  this.roleid = roleid;
  this.rolename = rolename;
 }

 public Role() {
  super();
 }

 public int getRoleid() {
  return roleid;
 }

 public void setRoleid(int roleid) {
  this.roleid = roleid;
 }

 public String getRolename() {
  return rolename;
 }

 public void setRolename(String rolename) {
  this.rolename = rolename;
 }

 
 
 
 
}