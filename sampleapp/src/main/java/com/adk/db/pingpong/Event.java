package com.adk.db.pingpong;
// Generated Dec 7, 2016 5:28:48 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Event generated by hbm2java
 */
@XmlRootElement(name="event")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({GroupMatchesDetails.class})
public class Event implements java.io.Serializable {

	private Integer eventId;
	@XmlTransient
	private Category category;
	@XmlTransient
	private Tournament tournament;
	private String eventName;
	private Date eventDate;
	@XmlElement(name="groupMatches")
	private Set groupMatchesDetailses = new HashSet(0);
	
	
	public Event() {
	}

	public Event(Category category, Tournament tournament, String eventName) {
		this.category = category;
		this.tournament = tournament;
		this.eventName = eventName;
	}

	public Event(Category category, Tournament tournament, String eventName, Set groupMatchesDetailses) {
		this.category = category;
		this.tournament = tournament;
		this.eventName = eventName;
		this.groupMatchesDetailses = groupMatchesDetailses;
	}

	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Tournament getTournament() {
		return this.tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Set getGroupMatchesDetailses() {
		return this.groupMatchesDetailses;
	}

	public void setGroupMatchesDetailses(Set groupMatchesDetailses) {
		this.groupMatchesDetailses = groupMatchesDetailses;
	}

}
