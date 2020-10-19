class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new OrderComparator());
        return logs;
    }
    
    class OrderComparator implements Comparator<String> {
        public int compare(String order1, String order2) {
            String[] split1 = order1.split(" ", 2);
            String[] split2 = order2.split(" ", 2);
            
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (isDigit1 && isDigit2)
                return 0;
            else if (isDigit1)
                return 1;
            else if (isDigit2)
                return -1;
            else { // both letter
                int comp = split1[1].compareTo(split2[1]);
                if (comp != 0)
                    return comp;
                return split1[0].compareTo(split2[0]);
            }
        }
    }
}