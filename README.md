Graphviz Graph File Builder
====

A simple utility for creating a properly formatted graphviz dot file.

Sample Usage
---
```
GraphvizRenderer renderer = new GraphvizNeatoRenderer();
StringBuffer graph = new StringBuffer();

graph.append(renderer.getHeader());

graph.append(renderer.getBeginCluster("cluster1"));
graph.append(renderer.getLabel("Cluster 1"));

graph.append(renderer.getBeginRecord("Record1", ""));
graph.append(renderer.addRecordField("rec1field1", "Field 1"));
graph.append(renderer.getEndRecord());

graph.append(renderer.getBeginRecord("Record2", ""));
graph.append(renderer.addRecordField("rec2field1", "Field 1"));
graph.append(renderer.getEndRecord());

graph.append(renderer.addEdge("Record1", "Record2", "connection"));

graph.append(renderer.getEndCluster());
graph.append(renderer.getFooter());
graph.toString();
```

   