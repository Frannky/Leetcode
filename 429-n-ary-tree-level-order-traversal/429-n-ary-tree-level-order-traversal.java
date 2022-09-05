/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root)
    {
        if(root == null)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> result = new ArrayList<>();
            
            for(int i = 0; i < size; i++)
            {
                Node node = queue.poll();
                result.add(node.val);
                
                for(Node child : node.children)
                {
                    queue.offer(child);
                }
            }
            
            results.add(result);
        }
        
        return results;
    }
}