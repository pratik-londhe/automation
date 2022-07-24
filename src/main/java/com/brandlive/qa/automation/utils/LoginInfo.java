package com.brandlive.qa.automation.utils;

public class LoginInfo {
	
	private String name = null;
	private String channelName = null;
	private String greenroomUrl = null;
	private String greenroomUser = null;
	private String greenroomPassword = null;
	private String greenroomRole = null;
	private String greenroomEntryMode = null;
	private String eventsUrl = null;
	private String eventsUser = null;
	private String eventsPassword = null;
	private String greenroomDBHost = null;
	private String greenroomDBPort = null;
	private String greenroomDBUser = null;
	private String greenroomDBPassword = null;
	private String greenroomDBName = null;
	private String eventsDBHost = null;
	private String eventsDBPort = null;
	private String eventsDBUser = null;
	private String eventsDBPassword = null;
	private String eventsDBName = null;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getGreenroomUrl() {
		return greenroomUrl;
	}
	public void setGreenroomUrl(String greenroomUrl) {
		this.greenroomUrl = greenroomUrl;
	}
	public String getGreenroomUser() {
		return greenroomUser;
	}
	public void setGreenroomUser(String greenroomUser) {
		this.greenroomUser = greenroomUser;
	}
	public String getGreenroomPassword() {
		return greenroomPassword;
	}
	public void setGreenroomPassword(String greenroomPassword) {
		this.greenroomPassword = greenroomPassword;
	}
	public String getGreenroomRole() {
		return greenroomRole;
	}
	public void setGreenroomRole(String greenroomRole) {
		this.greenroomRole = greenroomRole;
	}
	public String getGreenroomEntryMode() {
		return greenroomEntryMode;
	}
	public void setGreenroomEntryMode(String greenroomEntryMode) {
		this.greenroomEntryMode = greenroomEntryMode;
	}
	public String getEventsUrl() {
		return eventsUrl;
	}
	public void setEventsUrl(String eventsUrl) {
		this.eventsUrl = eventsUrl;
	}
	public String getEventsUser() {
		return eventsUser;
	}
	public void setEventsUser(String eventsUser) {
		this.eventsUser = eventsUser;
	}
	public String getEventsPassword() {
		return eventsPassword;
	}
	public void setEventsPassword(String eventsPassword) {
		this.eventsPassword = eventsPassword;
	}
	public String getGreenroomDBHost() {
		return greenroomDBHost;
	}
	public void setGreenroomDBHost(String greenroomDBHost) {
		this.greenroomDBHost = greenroomDBHost;
	}
	public String getGreenroomDBPort() {
		return greenroomDBPort;
	}
	public void setGreenroomDBPort(String greenroomDBPort) {
		this.greenroomDBPort = greenroomDBPort;
	}
	public String getGreenroomDBUser() {
		return greenroomDBUser;
	}
	public void setGreenroomDBUser(String greenroomDBUser) {
		this.greenroomDBUser = greenroomDBUser;
	}
	public String getGreenroomDBPassword() {
		return greenroomDBPassword;
	}
	public void setGreenroomDBPassword(String greenroomDBPassword) {
		this.greenroomDBPassword = greenroomDBPassword;
	}
	public String getGreenroomDBName() {
		return greenroomDBName;
	}
	public void setGreenroomDBName(String greenroomDBName) {
		this.greenroomDBName = greenroomDBName;
	}
	public String getEventsDBHost() {
		return eventsDBHost;
	}
	public void setEventsDBHost(String eventsDBHost) {
		this.eventsDBHost = eventsDBHost;
	}
	public String getEventsDBPort() {
		return eventsDBPort;
	}
	public void setEventsDBPort(String eventsDBPort) {
		this.eventsDBPort = eventsDBPort;
	}
	public String getEventsDBUser() {
		return eventsDBUser;
	}
	public void setEventsDBUser(String eventsDBUser) {
		this.eventsDBUser = eventsDBUser;
	}
	public String getEventsDBPassword() {
		return eventsDBPassword;
	}
	public void setEventsDBPassword(String eventsDBPassword) {
		this.eventsDBPassword = eventsDBPassword;
	}
	public String getEventsDBName() {
		return eventsDBName;
	}
	public void setEventsDBName(String eventsDBName) {
		this.eventsDBName = eventsDBName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channelName == null) ? 0 : channelName.hashCode());
		result = prime * result + ((eventsDBHost == null) ? 0 : eventsDBHost.hashCode());
		result = prime * result + ((eventsDBName == null) ? 0 : eventsDBName.hashCode());
		result = prime * result + ((eventsDBPassword == null) ? 0 : eventsDBPassword.hashCode());
		result = prime * result + ((eventsDBPort == null) ? 0 : eventsDBPort.hashCode());
		result = prime * result + ((eventsDBUser == null) ? 0 : eventsDBUser.hashCode());
		result = prime * result + ((eventsPassword == null) ? 0 : eventsPassword.hashCode());
		result = prime * result + ((eventsUrl == null) ? 0 : eventsUrl.hashCode());
		result = prime * result + ((eventsUser == null) ? 0 : eventsUser.hashCode());
		result = prime * result + ((greenroomDBHost == null) ? 0 : greenroomDBHost.hashCode());
		result = prime * result + ((greenroomDBName == null) ? 0 : greenroomDBName.hashCode());
		result = prime * result + ((greenroomDBPassword == null) ? 0 : greenroomDBPassword.hashCode());
		result = prime * result + ((greenroomDBPort == null) ? 0 : greenroomDBPort.hashCode());
		result = prime * result + ((greenroomDBUser == null) ? 0 : greenroomDBUser.hashCode());
		result = prime * result + ((greenroomEntryMode == null) ? 0 : greenroomEntryMode.hashCode());
		result = prime * result + ((greenroomPassword == null) ? 0 : greenroomPassword.hashCode());
		result = prime * result + ((greenroomRole == null) ? 0 : greenroomRole.hashCode());
		result = prime * result + ((greenroomUrl == null) ? 0 : greenroomUrl.hashCode());
		result = prime * result + ((greenroomUser == null) ? 0 : greenroomUser.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		LoginInfo other = (LoginInfo) obj;
		if (channelName == null) {
			if (other.channelName != null)
				return false;
		} else if (!channelName.equals(other.channelName))
			return false;
		if (eventsDBHost == null) {
			if (other.eventsDBHost != null)
				return false;
		} else if (!eventsDBHost.equals(other.eventsDBHost))
			return false;
		if (eventsDBName == null) {
			if (other.eventsDBName != null)
				return false;
		} else if (!eventsDBName.equals(other.eventsDBName))
			return false;
		if (eventsDBPassword == null) {
			if (other.eventsDBPassword != null)
				return false;
		} else if (!eventsDBPassword.equals(other.eventsDBPassword))
			return false;
		if (eventsDBPort == null) {
			if (other.eventsDBPort != null)
				return false;
		} else if (!eventsDBPort.equals(other.eventsDBPort))
			return false;
		if (eventsDBUser == null) {
			if (other.eventsDBUser != null)
				return false;
		} else if (!eventsDBUser.equals(other.eventsDBUser))
			return false;
		if (eventsPassword == null) {
			if (other.eventsPassword != null)
				return false;
		} else if (!eventsPassword.equals(other.eventsPassword))
			return false;
		if (eventsUrl == null) {
			if (other.eventsUrl != null)
				return false;
		} else if (!eventsUrl.equals(other.eventsUrl))
			return false;
		if (eventsUser == null) {
			if (other.eventsUser != null)
				return false;
		} else if (!eventsUser.equals(other.eventsUser))
			return false;
		if (greenroomDBHost == null) {
			if (other.greenroomDBHost != null)
				return false;
		} else if (!greenroomDBHost.equals(other.greenroomDBHost))
			return false;
		if (greenroomDBName == null) {
			if (other.greenroomDBName != null)
				return false;
		} else if (!greenroomDBName.equals(other.greenroomDBName))
			return false;
		if (greenroomDBPassword == null) {
			if (other.greenroomDBPassword != null)
				return false;
		} else if (!greenroomDBPassword.equals(other.greenroomDBPassword))
			return false;
		if (greenroomDBPort == null) {
			if (other.greenroomDBPort != null)
				return false;
		} else if (!greenroomDBPort.equals(other.greenroomDBPort))
			return false;
		if (greenroomDBUser == null) {
			if (other.greenroomDBUser != null)
				return false;
		} else if (!greenroomDBUser.equals(other.greenroomDBUser))
			return false;
		if (greenroomEntryMode == null) {
			if (other.greenroomEntryMode != null)
				return false;
		} else if (!greenroomEntryMode.equals(other.greenroomEntryMode))
			return false;
		if (greenroomPassword == null) {
			if (other.greenroomPassword != null)
				return false;
		} else if (!greenroomPassword.equals(other.greenroomPassword))
			return false;
		if (greenroomRole == null) {
			if (other.greenroomRole != null)
				return false;
		} else if (!greenroomRole.equals(other.greenroomRole))
			return false;
		if (greenroomUrl == null) {
			if (other.greenroomUrl != null)
				return false;
		} else if (!greenroomUrl.equals(other.greenroomUrl))
			return false;
		if (greenroomUser == null) {
			if (other.greenroomUser != null)
				return false;
		} else if (!greenroomUser.equals(other.greenroomUser))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoginInfo [name=" + name + ", channelName=" + channelName + ", greenroomUrl=" + greenroomUrl
				+ ", greenroomUser=" + greenroomUser + ", greenroomPassword=" + greenroomPassword + ", greenroomRole="
				+ greenroomRole + ", greenroomEntryMode=" + greenroomEntryMode + ", eventsUrl=" + eventsUrl
				+ ", eventsUser=" + eventsUser + ", eventsPassword=" + eventsPassword + ", greenroomDBHost="
				+ greenroomDBHost + ", greenroomDBPort=" + greenroomDBPort + ", greenroomDBUser=" + greenroomDBUser
				+ ", greenroomDBPassword=" + greenroomDBPassword + ", greenroomDBName=" + greenroomDBName
				+ ", eventsDBHost=" + eventsDBHost + ", eventsDBPort=" + eventsDBPort + ", eventsDBUser=" + eventsDBUser
				+ ", eventsDBPassword=" + eventsDBPassword + ", eventsDBName=" + eventsDBName + "]";
	}

}
