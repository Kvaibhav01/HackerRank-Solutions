package Jan21_26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import Jan13.GenericMinHeap;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nghbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vertices = new HashMap<>();

	public int numVetex() {
		return vertices.size();
	}

	public boolean containsVertex(String vname) {
		return vertices.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vertices.put(vname, vtx);
	}

	public void removeVertex(String vname) {
		Vertex vtx = vertices.get(vname);
		ArrayList<String> nbrnames = new ArrayList<>(vtx.nghbrs.keySet());
		for (String n : nbrnames) {
			Vertex vtxnbrs = vertices.get(n);
			vtxnbrs.nghbrs.remove(vname);
		}
		vertices.remove(vname);
	}

	public int numEdges() {

		ArrayList<String> vnames = new ArrayList<>(vertices.keySet());
		int ans = 0;

		for (String vname : vnames) {

			Vertex vtx = vertices.get(vname);
			ans += vtx.nghbrs.size();
		}

		return ans / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nghbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nghbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nghbrs.put(vname2, cost);
		vtx2.nghbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nghbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nghbrs.remove(vname2);
		vtx2.nghbrs.remove(vname1);
	}

	public void display() {

		System.out.println("------------------");
		ArrayList<String> vnames = new ArrayList<>(vertices.keySet());

		for (String vname : vnames) {

			String str = vname + " => ";

			Vertex vtx = vertices.get(vname);
			str += vtx.nghbrs;

			System.out.println(str);
		}
		System.out.println("------------------");

	}

	public boolean hasPath(String vname1, String vname2) {
		HashMap<String, Boolean> temp = new HashMap<>();
		return hasPath(vname1, vname2, temp);
	}

	private boolean hasPath(String vname1, String vname2, HashMap temp) {
		temp.put(vname1, true);
		Vertex vtx1 = vertices.get(vname1);
		if (vtx1.nghbrs.containsKey(vname2))
			return true;
		ArrayList<String> v1 = new ArrayList<>(vtx1.nghbrs.keySet());
		for (String n : v1) {
			if (!temp.containsKey(n) && hasPath(n, vname2, temp))
				return true;
		}
		return false;
	}

	private class Pair {
		String vname;
		Vertex vtx;
		String psf;
	}

	public boolean bfs(String vname1, String vname2) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair np = new Pair();
		np.vname = vname1;
		np.vtx = vertices.get(vname1);
		np.psf = vname1;
		queue.addLast(np);
		while (!queue.isEmpty()) {
			Pair rp = queue.removeFirst();
			if (!processed.containsKey(rp.vname)) {
				processed.put(rp.vname, true);
				if (containsEdge(rp.vname, vname2)) {
					System.out.println(rp.psf + vname2);
					return true;
				}
				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nghbrs.keySet());
				for (String n : nbrnames) {
					if (!processed.containsKey(n)) {
						Pair p = new Pair();
						p.vname = n;
						p.vtx = vertices.get(n);
						p.psf = rp.psf + n;

						queue.addLast(p);
					}

				}
			}
		}
		return false;
	}

	public boolean dfs(String vname1, String vname2) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Pair np = new Pair();
		np.vname = vname1;
		np.vtx = vertices.get(vname1);
		np.psf = vname1;
		stack.addFirst(np);
		while (!stack.isEmpty()) {
			Pair rp = stack.removeFirst();
			if (!processed.containsKey(rp.vname)) {
				processed.put(rp.vname, true);
				if (containsEdge(rp.vname, vname2)) {
					System.out.println(rp.psf + vname2);
					return true;
				}
				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nghbrs.keySet());
				for (String n : nbrnames) {
					if (!processed.containsKey(n)) {
						Pair p = new Pair();
						p.vname = n;
						p.vtx = vertices.get(n);
						p.psf = rp.psf + n;

						stack.addFirst(p);
					}

				}
			}
		}
		return false;
	}

	public void bft() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		for (String str : keys) {
			if (processed.containsKey(str))
				continue;
			Pair np = new Pair();
			np.vname = str;
			np.vtx = vertices.get(str);
			np.psf = str;
			queue.addLast(np);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (!processed.containsKey(rp.vname)) {
					processed.put(rp.vname, true);
					System.out.println(rp.vname + " via " + rp.psf);
					ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nghbrs.keySet());
					for (String n : nbrnames) {
						if (!processed.containsKey(n)) {
							Pair p = new Pair();
							p.vname = n;
							p.vtx = vertices.get(n);
							p.psf = rp.psf + n;

							queue.addLast(p);
						}

					}
				}
			}
		}
	}

	public void dft() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		for (String str : keys) {
			if (processed.containsKey(str))
				continue;
			Pair np = new Pair();
			np.vname = str;
			np.vtx = vertices.get(str);
			np.psf = str;
			stack.addFirst(np);
			while (!stack.isEmpty()) {
				Pair rp = stack.removeFirst();
				if (!processed.containsKey(rp.vname)) {
					processed.put(rp.vname, true);
					System.out.println(rp.vname + " via " + rp.psf);
					ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nghbrs.keySet());
					for (String n : nbrnames) {
						if (!processed.containsKey(n)) {
							Pair p = new Pair();
							p.vname = n;
							p.vtx = vertices.get(n);
							p.psf = rp.psf + n;

							stack.addFirst(p);
						}
					}
				}
			}
		}
	}

	public boolean isConnected() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		int ctr = 0;
		for (String str : keys) {
			if (processed.containsKey(str))
				continue;
			ctr++;
			Pair np = new Pair();
			np.vname = str;
			np.vtx = vertices.get(str);
			np.psf = str;
			queue.addLast(np);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (!processed.containsKey(rp.vname)) {
					processed.put(rp.vname, true);
					// System.out.println(rp.vname + " via " + rp.psf);
					ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nghbrs.keySet());
					for (String n : nbrnames) {
						if (!processed.containsKey(n)) {
							Pair p = new Pair();
							p.vname = n;
							p.vtx = vertices.get(n);
							p.psf = rp.psf + n;

							queue.addLast(p);
						}

					}
				}
			}
		}
		if (ctr > 1)
			return false;
		return true;
	}

	public boolean isCyclic() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		for (String str : keys) {
			if (processed.containsKey(str))
				continue;
			Pair np = new Pair();
			np.vname = str;
			np.vtx = vertices.get(str);
			np.psf = str;
			queue.addLast(np);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (!processed.containsKey(rp.vname)) {
					processed.put(rp.vname, true);
					// System.out.println(rp.vname + " via " + rp.psf);
					ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nghbrs.keySet());
					for (String n : nbrnames) {
						if (!processed.containsKey(n)) {
							Pair p = new Pair();
							p.vname = n;
							p.vtx = vertices.get(n);
							p.psf = rp.psf + n;

							queue.addLast(p);
						}

					}
				} else
					return true;
			}
		}
		return false;
	}

	public ArrayList<ArrayList<String>> getConnectedComponents() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		int ctr = 0;
		for (String str : keys) {
			if (processed.containsKey(str))
				continue;
			ctr++;
			ans.add(new ArrayList<>());
			Pair np = new Pair();
			np.vname = str;
			np.vtx = vertices.get(str);
			np.psf = str;
			queue.addLast(np);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (!processed.containsKey(rp.vname)) {
					processed.put(rp.vname, true);
					// System.out.println(rp.vname + " via " + rp.psf);
					ans.get(ctr - 1).add(rp.vname);
					ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nghbrs.keySet());
					for (String n : nbrnames) {
						if (!processed.containsKey(n)) {
							Pair p = new Pair();
							p.vname = n;
							p.vtx = vertices.get(n);
							p.psf = rp.psf + n;

							queue.addLast(p);
						}

					}
				}
			}
		}
		return ans;
	}

	public boolean isTree() {
		if (isConnected() && !isCyclic())
			return true;
		return false;
	}

	private class BPair {
		String vname;
		Vertex vtx;
		String psf;
		String color;
	}

	public boolean bipartite() {
		HashMap<String, String> processed = new HashMap<>();
		LinkedList<BPair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		for (String str : keys) {
			if (processed.containsKey(str))
				continue;
			BPair np = new BPair();
			np.vname = str;
			np.vtx = vertices.get(str);
			np.psf = str;
			np.color = "r";
			queue.addLast(np);
			while (!queue.isEmpty()) {
				BPair rp = queue.removeFirst();
				if (!processed.containsKey(rp.vname)) {
					processed.put(rp.vname, rp.color);

					ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nghbrs.keySet());
					for (String n : nbrnames) {
						if (!processed.containsKey(n)) {
							String c = rp.color == "r" ? "g" : "r";
							BPair p = new BPair();
							p.vname = n;
							p.vtx = vertices.get(n);
							p.psf = rp.psf + n;
							p.color = c;
							queue.addLast(p);
						}
					}
				} else {
					String oc = processed.get(rp.vname);
					String nc = rp.color;
					if (!oc.equals(nc))
						return false;
				}
			}
		}
		return true;
	}

	private class DijikstraPair implements Comparable<DijikstraPair> {
		String vname;
		Vertex vtx;
		int cost;
		String psf;

		@Override
		public int compareTo(DijikstraPair o) {
			return o.cost - this.cost;
		}

		@Override
		public String toString() {
			return this.vname + " @ " + this.cost + " via " + this.psf + "\n";

		}
	}

	public HashMap<String, DijikstraPair> dijikstra(String src) {
		HashMap<String, DijikstraPair> map = new HashMap<>();
		GenericMinHeap<DijikstraPair> heap = new GenericMinHeap<>();
		ArrayList<String> vnames = new ArrayList<>(vertices.keySet());
		for (String vname : vnames) {
			DijikstraPair np = new DijikstraPair();
			np.vtx = vertices.get(vname);
			np.psf = "";
			np.cost = Integer.MAX_VALUE;
			if (vname.equals(src)) {
				np.psf = vname;
				np.cost = 0;
			}
			heap.add(np);
			map.put(vname, np);
		}
		while (!heap.isEmpty()) {
			DijikstraPair rp = heap.remove();
			ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nghbrs.keySet());
			for (String nbrname : nbrnames) {
				DijikstraPair nbrpair = map.get(nbrname);
				int oc = nbrpair.cost;
				int nc = rp.cost + rp.vtx.nghbrs.get(nbrname);
				if (oc > nc) {
					nbrpair.cost = nc;
					nbrpair.psf = rp.psf + nbrname;

					heap.priorityUpdate(nbrpair);
				}
			}
		}
		return map;
	}
}
