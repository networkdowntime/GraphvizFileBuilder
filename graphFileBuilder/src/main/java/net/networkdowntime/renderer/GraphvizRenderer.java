package net.networkdowntime.renderer;

public abstract class GraphvizRenderer {

	String encodeName(String name) {
		return name.replaceAll("\\.", "_");
	}

	String escapeString(String string) {
		return string.replaceAll("<", "\\\\<").replaceAll(">", "\\\\>");
	}
	
	public abstract String getHeader();

	public abstract String getFooter();

	public abstract String getBeginCluster(String subBlockName);

	public abstract String getEndCluster();

	public abstract String getLabel(String labelName);

	public abstract String getBeginRecord(String recordName, String numberOfRows);

	public abstract String addRecordField(String fieldName, String field);

	public abstract String getEndRecord();

	public abstract String addEdge(String record, String referencesRecord, String edgeLabel);

	public abstract Object addEdge(String name, String name2, String string, boolean b);

	public abstract String getBeginRecord(String recordName, String recordLabel, String numberOfRows);

}