package com.faangtech.entity;


	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;
	import java.util.Date;

	@Document(collection = "memberships")
	public class Membership {
	    @Id
	    private String membershipId;
	    private String userId;
	    private String membershipType;
	    private Date startDate;
	    private Date endDate;
	    
		public Membership(String membershipId, String userId, String membershipType, Date startDate, Date endDate) {
			super();
			this.membershipId = membershipId;
			this.userId = userId;
			this.membershipType = membershipType;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		public String getMembershipId() {
			return membershipId;
		}
		public void setMembershipId(String membershipId) {
			this.membershipId = membershipId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getMembershipType() {
			return membershipType;
		}
		public void setMembershipType(String membershipType) {
			this.membershipType = membershipType;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

	    // Constructors, Getters, Setters
	}


