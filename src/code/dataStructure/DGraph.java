package code.dataStructure;
import java.util.*;

public class DGraph implements graph {
	HashMap<Integer, node_data> allnode = new HashMap<Integer, node_data>();
	ArrayList<edge_data> edges = new ArrayList<edge_data>();
	private HashMap<Integer, HashMap<Integer, edge_data>> alledges = new HashMap<Integer, HashMap<Integer, edge_data>>();

	@Override
	public node_data getNode(int key) {
		if (allnode.get(key) == null) {
			return null;
		} else {
			return allnode.get(key);
		}
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		if (alledges.get(src).get(dest)==null){
			return null;
		}
	return alledges.get(src).get(dest);
}

	@Override
	public void addNode(node_data n) {
		allnode.put(n.getKey(),n);
		
	}
	@Override
	public void connect(int src, int dest, double w) {
		Node u= (Node) allnode.get(src);
		Edge_data a= new Edge_data(src,dest,w);
		if (alledges.get(src).get(dest)==null){
			alledges.put(src,new HashMap<Integer, edge_data>());
		}
		alledges.get(src).put(dest,a);
	}

	@Override
	public Collection<node_data> getV() {
		Collection<node_data> a= (Collection<node_data>) allnode;
		return a;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {

		Collection<edge_data> a= (Collection<edge_data>) alledges.get(node_id);
		return a;
	}

	@Override
	public node_data removeNode(int key) {

		for (Map.Entry entry: allnode.entrySet())
		{
			if(alledges.get(entry)!=null){
				if (alledges.get(entry).get(key)!=null){
					alledges.get(entry).remove(key);
				}
		}


		}
		Node y = (Node) allnode.get(key);
		allnode.put(key,null);
		alledges.remove(key);


		return y;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		if(alledges.get(src).get(dest)!=null){
			Edge_data a = new Edge_data();
			a= (Edge_data) alledges.get(src).get(dest);
			return a;
		}
		else{
			return null;
		}

	}

	@Override
	public int nodeSize() {
		return allnode.size();
	}

	@Override
	public int edgeSize() {
		return edges.size();
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}