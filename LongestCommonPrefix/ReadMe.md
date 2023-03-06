# Intuition
Use a trie data structure to efficiently find the longest common prefix of a set of strings.

A trie data structure is a tree-like data structure that is used to efficiently store and search for strings. Each node in the trie represents a prefix of the strings stored in the trie, and the edges leading from the node represent the next character in each string that extends the prefix represented by the node. The leaves of the trie represent the end of a string.

# Approach
To find the longest common prefix of a set of strings, we first insert all the strings into the trie. We then find the shortest string in the set, which will be used as a reference to find the longest common prefix.

Starting from the root of the trie, we iterate through each character in the shortest string and follow the path in the trie that matches the character. If we encounter a node with more than one child, or if we reach a node that represents the end of a word, we return the longest common prefix found so far. Otherwise, we continue iterating through the characters in the shortest string until we reach the end of the string or a node that satisfies one of the two conditions mentioned above.

# Why tries? 
The trie method is particularly suited for the longest common prefix problem because it takes advantage of the common prefix structure among the strings in the input set. By storing the prefixes of all the strings in a trie, we can efficiently search for the longest common prefix by traversing the trie in a way that minimizes the number of comparisons we need to make.

Other methods for solving the longest common prefix problem typically involve some form of comparison between the strings in the input set. For example, one simple approach is to compare the first character of all the strings, then the second character, and so on until we find the first character that is not common to all the strings. However, this method may require a large number of comparisons in the worst case, especially if the input strings are long and have only a small common prefix.

In contrast, the trie method allows us to exploit the common prefix structure of the strings in a more efficient way by representing all the prefixes of the strings in a compact and structured data structure. This makes the trie method particularly well-suited for the longest common prefix problem and can lead to a significant improvement in time complexity over other methods.

# Complexity
- Time complexity:
The time complexity of this code is $$O(MN)$$, where $$M$$ is the length of the shortest word and $$N$$ is the number of words in the input array. This is because the trie is constructed by iterating over each letter in each word in the input array, and finding the longest common prefix requires iterating over each letter in the shortest word, each of which takes $$O(1)$$ time in the worst case.

- Space complexity:
The space complexity of this code is $$O(MN)$$, where $$M$$ is the length of the shortest word and $$N$$ is the number of words in the input array. This is because the trie data structure is constructed by creating a new node for each letter in each word in the input array, resulting in $$M*N$$ nodes in the worst case.
