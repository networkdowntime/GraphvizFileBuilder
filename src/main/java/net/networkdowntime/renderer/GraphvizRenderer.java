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
public abstract class GraphvizRenderer {

	String encodeName(String name) {
		if (name.contains("\""))
			System.out.println(name.replaceAll("\"", ""));
		return name.replaceAll("\"", "").replaceAll("\\.", "_");
	}

	String escapeString(String string) {
		if (string.contains("\""))
			System.out.println(string.replaceAll("\"", ""));
		return string.replaceAll("\"", "").replaceAll("<", "\\\\<").replaceAll(">", "\\\\>");
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

	public abstract Object addEdge(String name, String name2, String string, boolean open);

	public abstract Object addEdge(String name, String name2, String string, boolean open, boolean solid);

	public abstract String addReversedEdge(String record, String referencesRecord, String edgeLabel);

	public abstract Object addReversedEdge(String name, String name2, String string, boolean open);

	public abstract Object addReversedEdge(String name, String name2, String string, boolean open, boolean solid);

	public abstract String getBeginRecord(String recordName, String recordLabel, String numberOfRows);

	public abstract String getBeginRecord(String recordName, String recordLabel, String numberOfRows, String color);

}