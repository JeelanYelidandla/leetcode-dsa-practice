

    public static String mergeStringAlternate(String str1,String str2){
        if(str1.length()< 1 || str1.length()> 100){
            throw  new IllegalArgumentException("String length Should not be than 1");
        }if(str2.length()< 1 || str2.length()> 100){
            throw  new IllegalArgumentException("String length Should be less than 100");
        }
        StringBuilder sb=new StringBuilder();
        int maxLength1 = str1.length() >= str2.length() ? str1.length() : str2.length();
        System.out.println(maxLength1);
        int maxLength = Math.max(str1.length(), str2.length());
        System.out.println("maxLength:" + maxLength);
        for (int i = 0; i < maxLength; i++) {
            if (i < str1.length()) {
                sb.append(str1.charAt(i));
            }
            if (i < str2.length()) {
                sb.append(str2.charAt(i));
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
            System.out.println(mergeStringAlternate("abcasdfasd","pqrs"));
    }
