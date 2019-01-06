package com.main.vo;

public class NotificationVO {
String statuschange;
String ticketcreation;
String ticketassignment;
public String getStatuschange() {
	return statuschange;
}
public void setStatuschange(String statuschange) {
	this.statuschange = statuschange;
}
public String getTicketcreation() {
	return ticketcreation;
}
public void setTicketcreation(String ticketcreation) {
	this.ticketcreation = ticketcreation;
}
public String getTicketassignment() {
	return ticketassignment;
}
public void setTicketassignment(String ticketassignment) {
	this.ticketassignment = ticketassignment;
}
@Override
public String toString() {
	return "NotificationVO [statuschange=" + statuschange + ", ticketcreation=" + ticketcreation + ", ticketassignment="
			+ ticketassignment + "]";
}

}
