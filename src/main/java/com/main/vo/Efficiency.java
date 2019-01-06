package com.main.vo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Efficiency {

	private Long totalTickets;
	private Long totalCompleted;
	private Long totalRejected;
	private Long openTickets;
	private Map<String,FREfficiency> frefficiency;

	public Long getOpenTickets() {
		return openTickets;
	}

	public void setOpenTickets(Long openTickets) {
		this.openTickets = openTickets;
	}

	
	public Collection<FREfficiency> getFrefficiency() {
		return frefficiency.values();
	}

	public void setFrefficiency(Map<String, FREfficiency> frefficiency) {
		this.frefficiency = frefficiency;
	}


	public static class FREfficiency {

		public FREfficiency(String username, Long noOfTickets,Long closedTickets) {
			this.Count = noOfTickets;
			this.AssignedTo = username;
			this.closedTickets=closedTickets;
		}

		private Long Count;
		private Long closedTickets;
		public Long getCount() {
			return Count;
		}
		public void setCount(Long count) {
			Count = count;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((AssignedTo == null) ? 0 : AssignedTo.hashCode());
			result = prime * result + ((Count == null) ? 0 : Count.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FREfficiency other = (FREfficiency) obj;
			if (AssignedTo == null) {
				if (other.AssignedTo != null)
					return false;
			} else if (!AssignedTo.equals(other.AssignedTo))
				return false;
			if (Count == null) {
				if (other.Count != null)
					return false;
			} else if (!Count.equals(other.Count))
				return false;
			return true;
		}
		public String getAssignedTo() {
			return AssignedTo;
		}
		public void setAssignedTo(String assignedTo) {
			AssignedTo = assignedTo;
		}

		private String AssignedTo;
		public Long getClosedTickets() {
			return closedTickets;
		}
		public void setClosedTickets(Long closedTickets) {
			this.closedTickets = closedTickets;
		}

	}

	public Long getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(Long totalTickets) {
		this.totalTickets = totalTickets;
	}

	public Long getTotalCompleted() {
		return totalCompleted;
	}

	public void setTotalCompleted(Long totalCompleted) {
		this.totalCompleted = totalCompleted;
	}

	public Long getTotalRejected() {
		return totalRejected;
	}

	public void setTotalRejected(Long totalRejected) {
		this.totalRejected = totalRejected;
	}

	public Long getTotalInProgress() {
		return totalInProgress;
	}

	public void setTotalInProgress(Long totalInProgress) {
		this.totalInProgress = totalInProgress;
	}

	private Long totalInProgress;

	public void addFREfficiency(String username, Long noOfTickets) {
		this.frefficiency.put(username,new FREfficiency(username, noOfTickets,0L));
	}
	
	public void setClosedTickets(String username,Long closedTickets){
		if(this.frefficiency.get(username)!=null){
			this.frefficiency.get(username).setClosedTickets(closedTickets);
		}
	}
	
	

	public Efficiency() {
		super();
		this.frefficiency = new HashMap<String,FREfficiency>();
	}

}