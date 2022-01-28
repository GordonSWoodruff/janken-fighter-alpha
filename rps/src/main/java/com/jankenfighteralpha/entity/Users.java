package com.jankenfighteralpha.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	// Class Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="stat_id")
	private UserStats userStats;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="avatar_id")
	private Avatar avatar;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="moveset_id")
	private Moveset moveset;
	@Column(name="user_name")
	private String userName;
	@Column(name="email")
	private String email;
	@Column(name="user_password")
	private String password;
	
	// Basic Constructor
	public Users() {
		
	}
	// Getters and Setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public UserStats getUserStats() {
		return userStats;
	}
	public void setUserStats(UserStats userStats) {
		this.userStats = userStats;
	}
	public Avatar getAvatar() {
		return avatar;
	}
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	public Moveset getMoveset() {
		return moveset;
	}
	public void setMoveset(Moveset moveset) {
		this.moveset = moveset;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User: " + userName + "(" + userId + ")" + "\nEmail: " + email;
	}
}
