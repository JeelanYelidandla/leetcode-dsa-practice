
    public static String printUniqueNonRepeatingLetters(String input) {
        input = input.toLowerCase();
       var map = new HashMap<Character, Integer>();

       for( char ch: input.toCharArray()){
           if(Character.isLetter(ch)){
               map.put(ch, map.getOrDefault(ch,0)+1);
           }
       }
       for( char ch: input.toCharArray()){
           if(Character.isLetter(ch) && map.get(ch)==1){
               System.out.print(ch + " ");
           }
       }
        return  null;
    }
    public static void main(String[] args) {
        String test = "Java Programming";
        System.out.print("Unique non-repeating letters: ");
//        printUniqueNonRepeatingLetters(test);

        //Java8
        var map = test.toLowerCase().chars().mapToObj(c -> (char) c)
                .filter(ch -> Character.isLetter(ch))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));

        map.entrySet().stream().filter(c-> c.getValue()==1 )
                .forEach(entry -> System.out.println(entry.getKey() + " "));

        var map1= Stream.of("a", "b", "a")
                .collect(Collectors.groupingBy(Function.identity()));

        System.out.println(map1);

        var map2 = Stream.of("a", "b", "a")
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map2);

       var mapCount =  test.chars().mapToObj(c -> (char) c)
                 .filter(ch -> Character.isLetter(ch))
                 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
       System.out.println(mapCount);

        Stream<String> stream = Stream.of("apple", "banana", "apple");

        Map<String, List<String>> grouped = stream.collect(Collectors.groupingBy(Function.identity()));
        System.out.println(grouped);


        Stream<Character> stream1 = "Java Programming".toLowerCase()
                .chars()
                .mapToObj(c -> (char) c);



        Map<Character, Long> mapLong = test.toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(mapLong);

        Stream<Character> stream2 = "Java Programming".toLowerCase()
                .chars()
                .mapToObj(c -> (char) c);

        Map<Character, Long> mapSteam2 = stream2.collect(
                Collectors.groupingBy(
                        Function.identity(),         // K = Character
                        LinkedHashMap::new,          // M = LinkedHashMap<Character, Long>
                        Collectors.counting()        // D = Long
                )
        );
        System.out.println(mapSteam2);





    }
