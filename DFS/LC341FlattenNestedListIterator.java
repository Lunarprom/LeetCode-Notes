/**
 * 虽然是归在Stack的tag底下，但是发现用DFS比较好做
 */
public class LC341FlattenNestedListIterator {
	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation
	 * public interface NestedInteger {
	 *
	 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	 *     public boolean isInteger();
	 *
	 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
	 *     // Return null if this NestedInteger holds a nested list
	 *     public Integer getInteger();
	 *
	 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
	 *     // Return null if this NestedInteger holds a single integer
	 *     public List<NestedInteger> getList();
	 * }
	 */
	public class NestedIterator implements Iterator<Integer> {
	    
	    List<Integer> flattened = new ArrayList<>();
	    int index = 0;

	    public NestedIterator(List<NestedInteger> nestedList) {
	        
	        for (int i = 0; i < nestedList.size(); i++) {
	            dfs(nestedList.get(i));
	        }
	    }
	    
	    private void dfs(NestedInteger nestedNum) {
	        if (nestedNum.isInteger()) {
	            flattened.add(nestedNum.getInteger());
	            return;
	        } 
	        List<NestedInteger> nested = nestedNum.getList();
	        if (nested == null) {
	            return;
	        }
	        for (int i = 0; i < nested.size(); i++) {
	            dfs(nested.get(i));
	        }
	        
	        return;
	    }

	    @Override
	    public Integer next() {
	        return flattened.get(index++);
	    }

	    @Override
	    public boolean hasNext() {
	        return index < flattened.size();
	    }
	}

	/**
	 * Your NestedIterator object will be instantiated and called as such:
	 * NestedIterator i = new NestedIterator(nestedList);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
}