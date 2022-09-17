https://leetcode.com/discuss/interview-question/374846/Twitter-or-OA-2019-or-University-Career-Fair

Implementation using Java8
adding 4 testcases for your reference

// UNIVERSITY CAREER FAIR
int[] arrival = {1, 2};
int[] duration = {7, 3}; // Output = 1

// int[] arrival = {1, 3, 4, 6};
// int[] duration = {4, 3, 3, 2}; // Output = 2

// int[] arrival = {1,3,3,5,7};
// int[] duration = {2,2,1,2,1}; // Output = 4

// int[] arrival = {1,3,5};
// int[] duration = {2,2, 2}; // Output = 3
Map<Integer, Integer> mapOfArrivalAndDuration = new HashMap<>();
for (int i = 0; i < arrival.length; i++) {
mapOfArrivalAndDuration.put(arrival[i], duration[i]);
}
Map<Integer, Integer> sortedMap = mapOfArrivalAndDuration.entrySet().stream().sorted((o1, o2) ->
(o1.getKey() + o2.getKey()) < (o1.getValue() + o2.getValue()) ? 1 : 0)
.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, HashMap::new));

    int max_Events = 0, end = 0;
    for (Map.Entry<Integer, Integer> i : sortedMap.entrySet()) {
        if (i.getKey() >= end) {
            ++max_Events;
            end = i.getKey() + i.getValue();
        }
    }
    System.out.println(max_Events);
