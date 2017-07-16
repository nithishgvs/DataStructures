package org.nithish.Java_general;

public class Temp {

	/* "()"->true"(()"->false")("->false"()""[]""{}""<>"

	static {
		HashMap<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');
		map.put('>', '<');
		Set<String> set = new HashSet<>(map.values());
	}

	Stack<String> stack = new Stack<>();

	public boolean matchParanthesis(String str){
	if(str.length()==0){
	return true;
	} 
	  for(int i=0;i<str.length();i++){
	  if(str.charAt(i)!=null){
	  
	  if(set.contains(str.charAt(i))){
	  stack.push(str.charAt(i));
	  
	  }else{
	       if(!stack.isEmpty){
	       char c=stack.pop();
	       if(c!=null){
	      if(map.get(str.charAt(i)).equals(c){
	        return true && matchParenthesis(str.subString(i+!));
	      }else{
	      return false; 
	      }
	      }
	  }
	  
	  return false;
	}

	 ")(" -> false "(())" -> true "()()" -> true "([])" -> true "([]" -> false
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
