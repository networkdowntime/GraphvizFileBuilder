package net.networkdowntime.renderer;

public class GraphvizNeatoRenderer extends GraphvizRenderer {

	/*
	 * (non-Javadoc)
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
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getBeginCluster(java.lang.String)
	 */
	@Override
	public String getBeginCluster(String subBlockName) {
		StringBuffer graph = new StringBuffer();
		graph.append("subgraph cluster_" + encodeName(subBlockName) + " {\n");
		graph.append("color=black\n");
		return graph.toString();

	}

	/*
	 * (non-Javadoc)
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
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getLabel(java.lang.String)
	 */
	@Override
	public String getLabel(String labelName) {
		StringBuffer graph = new StringBuffer();
		graph.append("label=\"" + labelName + "\";\n");
		return graph.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getBeginRecord(java.lang.String, java.lang.String)
	 */
	@Override
	public String getBeginRecord(String recordName, String numberOfRows) {
		StringBuffer sb = new StringBuffer();
		sb.append("\"" + encodeName(recordName) + "\" [\n");
		sb.append("\tlabel = \"{<T_NAME> " + recordName + numberOfRows);
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see net.networkdowntime.renderer.GraphvizRenderer#getBeginRecord(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getBeginRecord(String recordName, String recordLabel, String numberOfRows) {
		StringBuffer sb = new StringBuffer();
		sb.append("\"" + encodeName(recordName) + "\" [\n");
		sb.append("\tlabel = \"{<T_NAME> " + recordLabel + numberOfRows);
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see net.networkdowntime.renderer.GraphvizRenderer#addRecordField(java.lang.String, java.lang.String)
	 */
	@Override
	public String addRecordField(String fieldName, String field) {
		StringBuffer sb = new StringBuffer();
		sb.append("|<" + fieldName + "> " + field);
		return sb.toString();
	}
	
	/*
	 * (non-Javadoc)
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
	 * @see net.networkdowntime.renderer.GraphvizRenderer#addEdge(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String addEdge(String record, String referencesRecord, String edgeLabel) {
		StringBuffer graph = new StringBuffer();
		graph.append(encodeName(record) + "->" + encodeName(referencesRecord) + " [ label = \"" + edgeLabel + "\" arrowhead=vee, arrowtail=crow, arrowsize=1.0 ];\n");
		return graph.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see net.networkdowntime.renderer.GraphvizRenderer#addEdge(java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String addEdge(String record, String referencesRecord, String edgeLabel, boolean open) {

		StringBuffer graph = new StringBuffer();
		graph.append(encodeName(record) + "->" + encodeName(referencesRecord) + " [ label = \"" + edgeLabel + "\" arrowhead=\"" + ((open) ? "o" : "") + "normal\" arrowtail=\"none\" ];\n");
		return graph.toString();
	}


}
