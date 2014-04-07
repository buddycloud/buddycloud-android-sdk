package org.buddycloud.sdk.model;

public class Node {

	private String channelJid;
	private String node;

	private Node(String channelJid, String node) {
		this.channelJid = channelJid;
		this.node = node;
	}

	public static Node parse(String nodeId) {
		String[] nodeIdSplit = nodeId.split("/");
		return new Node(nodeIdSplit[2], nodeIdSplit[3]);
	}
	
	public String getChannelJid() {
		return channelJid;
	}
	
	public String getNode() {
		return node;
	}
}
