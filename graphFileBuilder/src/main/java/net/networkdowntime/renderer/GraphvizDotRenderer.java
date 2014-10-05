package net.networkdowntime.renderer;

public class GraphvizDotRenderer extends GraphvizRenderer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getHeader()
	 */
	@Override
	public String getHeader() {
		StringBuffer graph = new StringBuffer();

		graph.append("digraph g {\n");
		graph.append("graph [\n");
		graph.append("fontsize = \"14\"\n");
		graph.append("splines = \"true\"\n");
		graph.append("overlap = \"scale\"\n");
		// graph.append("rankdir = \"TB\"\n");
		graph.append("];\n");
		graph.append("node [\n");
		graph.append("fontsize = \"8\"\n");
		graph.append("shape = \"record\"\n");
		graph.append("];\n");
		graph.append("edge [\n");
		graph.append("headclip = \"true\"\n");
		graph.append("tailclip = \"true\"\n");
		graph.append("fontsize = \"8\"\n");
		graph.append("];\n");

		return graph.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getFooter()
	 */
	@Override
	public String getFooter() {
		StringBuffer graph = new StringBuffer();
		graph.append("}");
		return graph.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getBeginCluster(java.lang.String)
	 */
	@Override
	public String getBeginCluster(String subBlockName) {
		StringBuffer graph = new StringBuffer();
		graph.append("subgraph cluster_" + encodeName(subBlockName) + " {\n");
		graph.append("color=black\n");
		graph.append("label=\"" + escapeString(subBlockName) + "\"\n");
		return graph.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getEndCluster()
	 */
	@Override
	public String getEndCluster() {
		StringBuffer graph = new StringBuffer();
		graph.append("}\n");
		return graph.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getLabel(java.lang.String)
	 */
	@Override
	public String getLabel(String labelName) {
		StringBuffer graph = new StringBuffer();
		graph.append("label=\"" + escapeString(labelName) + "\";\n");
		return graph.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getBeginRecord(java.lang.String, java.lang.String)
	 */
	@Override
	public String getBeginRecord(String recordName, String numberOfRows) {
		StringBuffer sb = new StringBuffer();
		sb.append("\"" + encodeName(recordName) + "\" [\n");
		sb.append("\tlabel = \"{<T_NAME> " + escapeString(recordName + numberOfRows));

		return sb.toString();
	}

	@Override
	public String getBeginRecord(String recordName, String recordLabel, String numberOfRows) {
		StringBuffer sb = new StringBuffer();
		sb.append("\"" + encodeName(recordName) + "\" [\n");
		sb.append("\tlabel = \"{<T_NAME> " + escapeString(recordLabel + numberOfRows));

		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.networkdowntime.renderer.GraphvizRenderer#addRecordField(java.lang.String, java.lang.String)
	 */
	@Override
	public String addRecordField(String fieldName, String field) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t\n|<" + escapeString(fieldName) + "> " + escapeString(field));
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getEndRecord()
	 */
	@Override
	public String getEndRecord() {
		StringBuffer sb = new StringBuffer();
		sb.append("}\"\n");
		sb.append("\tshape = \"record\"\n");
		sb.append("];\n");
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.networkdowntime.renderer.GraphvizRenderer#addEdge(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String addEdge(String record, String referencesRecord, String edgeLabel) {
		return addEdge(record, referencesRecord, edgeLabel, false);
	}

	/*
	 * (non-Javadoc)
	 * @see net.networkdowntime.renderer.GraphvizRenderer#addEdge(java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String addEdge(String record, String referencesRecord, String edgeLabel, boolean open) {

		StringBuffer graph = new StringBuffer();
		graph.append(encodeName(record) + "->" + encodeName(referencesRecord) + " [ label = \"" + escapeString(edgeLabel) + "\" arrowhead=\"" + ((open) ? "o" : "") + "normal\" arrowtail=\"none\" ];\n");
		return graph.toString();
	}

}
