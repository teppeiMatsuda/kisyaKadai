package com.example.mail.dao;

/**
 * �A�h���X�pdao�N���X
 * @author t.matsuda
 *
 */
public class AddressDao {

	// �Ώێ�
	private String address;
	// ���[�U�[ID
	private String userId;
	// ���{�ꖼ
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