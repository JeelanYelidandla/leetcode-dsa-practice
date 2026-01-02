
    public static int mejorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length - 1] == 0 ? nums.length - 1 : nums[nums.length - 1];
    }
    public static void main(String[] args) {

        int[] nums=new int[]{2, 2, 1, 1, 1, 2, 2};
        var list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(list);
        Map<Integer,Integer> frequencyMap=new HashMap<>();

        for(int num: list){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

        int maxFrequency = 0;
        int mostFrequentNumber = -1; // Initialize with a default or invalid value

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentNumber = entry.getKey();
            }
        }
        System.out.println(mostFrequentNumber);
    }
