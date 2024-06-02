package practice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
public class Account {
		@Id
		private long acNo;
		private String acName;
		private String acAddress;
		private long mobileNo;
		private long adharNo;
		private  String panNo;
		private String gender;
		private double balance;
		
		public long getAcNo() {
			return acNo;
		}
		public void setAcNo(long acNo) {
			this.acNo = acNo;
		}
		public String getAcName() {
			return acName;
		}
		public void setAcName(String acName) {
			this.acName = acName;
		}
		public String getAcAddress() {
			return acAddress;
		}
		public void setAcAddress(String acAddress) {
			this.acAddress = acAddress;
		}
		public long getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(long mobileNo) {
			this.mobileNo = mobileNo;
		}
		public long getAdharNo() {
			return adharNo;
		}
		public void setAdharNo(long adharNo) {
			this.adharNo = adharNo;
		}
		public String getPanNo() {
			return panNo;
		}
		public void setPanNo(String panNo) {
			this.panNo = panNo;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		
	}


