
    public static String gcdOfStrings(String str1, String str2) {

        if(str1.length() < 1|| str1.length()>1000){
            throw new IllegalArgumentException("String length must be between 1 and 1000");
        }
        if(str2.length() < 1|| str2.length()>1000){
            throw new IllegalArgumentException("String length must be between 1 and 1000");
        }
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int length =  gcd(str1.length(),str2.length());

        return str1.substring(0,length) ;
    }
    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));    // Output: "ABC"
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));    // Output: "AB"
        System.out.println(gcdOfStrings("LEET", "CODE"));      // Output: ""
    }

