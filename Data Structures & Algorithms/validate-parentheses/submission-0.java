class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        Deque<Character> stack = new ArrayDeque();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() && !map.keySet().contains(ch))
                return false;
            if (map.keySet().contains(ch))
                stack.push(ch);
            else if (map.keySet().contains(stack.peek())) {
                if (map.get(stack.peek()) != ch)
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
