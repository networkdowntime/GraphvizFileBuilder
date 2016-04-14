package net.networkdowntime.renderer;

/**
 * This software is licensed under the MIT license
 * Copyright (c) 2015 Ryan Wiles
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, 
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software 
 * is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE 
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR 
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * @author rwiles
 *
 */
public class GraphvizNeatoRenderer extends GraphvizRenderer {

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

	@Override
	public String getFooter() {
		StringBuffer graph = new StringBuffer();
		graph.append("}");
		return graph.toString();
	}

	@Override
	public String getBeginCluster(String subBlockName) {
		StringBuffer graph = new StringBuffer();
		graph.append("subgraph cluster_" + encodeName(subBlockName) + " {\n");
		graph.append("color=black\n");
		return graph.toString();

	}

	@Override
	public String getEndCluster() {
		StringBuffer graph = new StringBuffer();
		graph.append("}\n");
		return graph.toString();
	}

	@Override
	public String getLabel(String labelName) {
		StringBuffer graph = new StringBuffer();
		graph.append("label=\"" + labelName + "\";\n");
		return graph.toString();
	}

	@Override
	public String getBeginRecord(String recordName, String numberOfRows) {
		StringBuffer sb = new StringBuffer();
		sb.append("\"" + encodeName(recordName) + "\" [\n");
		sb.append("\tlabel = \"{<T_NAME> " + recordName + numberOfRows);
		return sb.toString();
	}

	@Override
	public String getBeginRecord(String recordName, String recordLabel, String numberOfRows) {
		StringBuffer sb = new StringBuffer();
		sb.append("\"" + encodeName(recordName) + "\" [\n");
		sb.append("\tlabel = \"{<T_NAME> " + recordLabel + numberOfRows);
		return sb.toString();
	}

	@Override
	public String getBeginRecord(String recordName, String recordLabel, String numberOfRows, String color) {
		StringBuffer sb = new StringBuffer();
		sb.append("\"" + encodeName(recordName) + "\" [\n");
		sb.append("\tstyle=filled fillcolor=\"" + color + "\"\n");
		sb.append("\tlabel = \"{<T_NAME> " + recordLabel + numberOfRows);
		return sb.toString();
	}

	@Override
	public String addRecordField(String fieldName, String field) {
		StringBuffer sb = new StringBuffer();
		sb.append("|<" + fieldName + "> " + field);
		return sb.toString();
	}
	
	@Override
	public String getEndRecord() {
		StringBuffer sb = new StringBuffer();
		sb.append("}\"\n");
		sb.append("\tshape = \"record\"\n");
		sb.append("];\n");
		return sb.toString();
	}

	@Override
	public String addEdge(String record, String referencesRecord, String edgeLabel) {
		StringBuffer graph = new StringBuffer();
		graph.append("\"" + encodeName(record) + "\"->\"" + encodeName(referencesRecord) + "\"" + " [ label = \"" + escapeString(edgeLabel) + "\" arrowhead=vee, arrowtail=crow, arrowsize=1.0 ];\n");
		return graph.toString();
	}

	@Override
	public String addEdge(String record, String referencesRecord, String edgeLabel, boolean open) {

		StringBuffer graph = new StringBuffer();
		graph.append("\"" + encodeName(record) + "\"->\"" + encodeName(referencesRecord) + "\"" + " [ label = \"" + escapeString(edgeLabel) + "\" arrowhead=\"" + ((open) ? "o" : "") + "normal\" arrowtail=\"none\" ];\n");
		return graph.toString();
	}

	@Override
	public String addEdge(String record, String referencesRecord, String edgeLabel, boolean open, boolean solid) {
		StringBuffer graph = new StringBuffer();
		graph.append("\"" + encodeName(record) + "\"->\"" + encodeName(referencesRecord) + "\"" + " [ label = \"" + escapeString(edgeLabel) + "\" arrowhead=\"" + ((open) ? "o" : "") + "normal\" arrowtail=\"none\" style=\"" + ((solid) ? "solid" : "dotted") + "\" ];\n");
		return graph.toString();
	}


}
