package com.adk.db.pingpong;
// Generated Dec 5, 2016 11:55:23 AM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Tournament generated by hbm2java
 */
@XmlRootElement(name="Tournament")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Event.class})
public class Tournament implements java.io.Serializable {

	private Integer tourId;
	private String tourName;
	private String venue;
	private String organizer;
	@XmlElement(name="events")
	private Set events = new HashSet(0);

	public Tournament() {
	}

	public Tournament(String tourName, String venue, String organizer, Set events) {
		this.tourName = tourName;
		this.venue = venue;
		this.organizer = organizer;
		this.events = events;
	}

	public Integer getTourId() {
		return this.tourId;
	}

	public void setTourId(Integer tourId) {
		this.tourId = tourId;
	}

	public String getTourName() {
		return this.tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getVenue() {
		return this.venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getOrganizer() {
		return this.organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public Set getEvents() {
		return this.events;
	}

	public void setEvents(Set events) {
		this.events = events;
	}

}
