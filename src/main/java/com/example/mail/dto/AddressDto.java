package com.example.mail.dao;

/**
 * アドレス用daoクラス
 * @author t.matsuda
 *
 */
public class AddressDao {

	// 対象者
	private String address;
	// ユーザーID
	private String userId;
	// 日本語名
	private String japaneseName;
	public String getAddress() {
		return address;
	}
	public void setAddress(Object object) {
		this.address = (String) object;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(Object object) {
		this.userId = (String) object;
	}
	public String getJapaneseName() {
		return japaneseName;
	}
	public void setJapaneseName(Object object) {
		this.japaneseName = (String) object;
	}



}