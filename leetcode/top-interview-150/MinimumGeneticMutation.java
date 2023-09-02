package leetcode.topinterview150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is
defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed
to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

Example 1:

Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
Example 2:

Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2

 */
public class MinimumGeneticMutation {
    public static void main(String[] args) {
        System.out.println(new MinimumGeneticMutation()
                .minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
    }

    /*
        We just have to check out all possible mutations with a given string.
        We can apply bfs on the given string start . If a generated mutation is present in our Gene Bank
        then only we will consider it as a valid mutation or a valid node.
        If we are not able to generate end String we can simply return -1.
        And thus by using a simple bfs we can find the minimum number of mutations needed to mutate from start to end.

        Steps for solving this problem :-

        Save all mutations of gene bank into a hashset .This hashset will be used to check whether a
        generated mutation is valid or not.
        Use a queue for implementing breadth first search.
        Start your bfs by pushing the given string start into the queue.
        Once removed from the queue , check all possible mutation from that gene and push all valid mutation into the queue.
        Keep doing this untill you get end gene or your queue is empty.
        Return ans.
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        int level = 0;
        char[] geneType = {'A', 'C', 'G', 'T'};

        Set<String> set = new HashSet<>(Arrays.asList(bank)); // store all valid mutations

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);

        while(true) {
            level++;
            int n = queue.size();

            if(n == 0) {
                return -1;
            }

            for(int i = 0; i < n; i++) {
                char[] ch = queue.poll().toCharArray();

                for(int j = 0; j < 8; j++) {
                    char originalChar = ch[j];
                    for(int c = 0; c < 4; c++) {
                        ch[j] = geneType[c];
                        String str = String.valueOf(ch);
                        if(str.equals(endGene) && set.contains(str)) {
                            return level;
                        }
                        if(!set.contains(str)) {
                            continue;
                        }
                        set.remove(str);
                        queue.add(str);
                    }
                    ch[j] = originalChar;
                }
            }
        }
    }
}
