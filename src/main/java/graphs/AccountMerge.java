package graphs;
import java.util.*;
public class AccountMerge {
    public static class DisJointSets {
        private int parent[];
        private int rank[];
        private int size[];

        DisJointSets(int n){
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        private int getUltimateParent(int node){
            if(parent[node] == node){
                return node;
            }
            return parent[node] = getUltimateParent(parent[node]);
        }
        private void unionByRank(int u, int v){
            int pu = getUltimateParent(u);
            int pv = getUltimateParent(v);

            if(pu == pv){
                return;
            }

            int rankU = rank[pu];
            int rankV = rank[pv];
            if(rankU > rankV){
                parent[pv] = pu;
            }else if(rankU < rankV){
                parent[pu] = pv;
            }else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
        private void unionBySize(int u, int v){
            int pu = getUltimateParent(u);
            int pv = getUltimateParent(v);

            if(pu == pv){
                return ;
            }

            int sizeU = size[pu];
            int sizeV = size[pv];
            if(sizeU > sizeV){
                size[pu] += size[pv];
                parent[pv] = pu;
            }else if(sizeV > sizeU){
                size[pv] += size[pu];
                parent[pu] = pv;
            }else{
                size[pv] += size[pu];
                parent[pu] = pv;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisJointSets djs = new DisJointSets(accounts.size());
        HashMap<String, Integer> map= new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail, i);
                }else{
                    int u = i;
                    int v = map.get(mail);
                    djs.unionByRank(u, v);
                }
            }
        }

        //ArrayList
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++){
            ans.add(new ArrayList<>());
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            int idx = djs.getUltimateParent(entry.getValue());
            if(ans.get(idx).size() == 0){
                ans.get(idx).add(accounts.get(entry.getValue()).get(0));
                ans.get(idx).add(entry.getKey());
            }else{
                ans.get(idx).add(entry.getKey());
            }
        }
        int i = 0;
        while(i < ans.size()){
            if(ans.get(i).size() == 0){
                ans.remove(i);
            }else{
                String temp = ans.get(i).remove(0);
                Collections.sort(ans.get(i));
                ans.get(i).add(0, temp);
                i++;
            }
        }

        return ans;
    }
}
