class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // knowledge.sort(Comparator.comparing(list -> list.get(0)));
        Map<String, String> map = new HashMap<>();
        for(List<String> str: knowledge){
            String key = str.get(0);
            String value = str.get(1);
            map.put(key, value);
        }

        StringBuilder res = new StringBuilder();
        int j = 0;

        while(j < s.length()){
            if(s.charAt(j) != '('){
                res.append(s.charAt(j));
                j++;
                continue;
            }

            int i = j + 1;
            StringBuilder sb  =  new StringBuilder();

            while(s.charAt(i) != ')'){
                sb.append(s.charAt(i));
                i++;
            }
            if(map.containsKey(sb.toString())) res.append(map.get(sb.toString()));
            else res.append('?');

            j = i;
            j++;     
        }
        return res.toString();
    }
}