package Assignment3.search

class SearchEx9 {

    class Trie {

        private class TrieNode {
            // The list of words that are formed with the current trie node
            val setOfWords = HashSet<String>()

            val children = HashMap<Char, TrieNode>()
        }

        private val rootNode: TrieNode = TrieNode()

        fun addWord(str: String) {
            addWordHelper(str, 0, rootNode)
        }

        private fun addWordHelper(str: String, i: Int, currentNode: TrieNode) {
            if (i == str.length) return

            val nextNode: TrieNode
            if (!currentNode.children.containsKey(str[i])) {
                val nodeToAdd = TrieNode()
                currentNode.children[str[i]] = nodeToAdd
                nextNode = nodeToAdd
            } else {
                nextNode = currentNode.children[str[i]]!!
            }
            nextNode.setOfWords.add(str)
            addWordHelper(str, i+1, nextNode)
        }

        fun countPrefixesThatMatch(prefix: String) : Int {
            return prefixHelper(prefix, 0, rootNode)
        }

        private fun prefixHelper(prefix: String, i: Int, currentNode: TrieNode) : Int {
            if (i == prefix.length) return currentNode.setOfWords.size

            val nextChar = prefix[i]
            return if (currentNode.children.containsKey(nextChar)){
                prefixHelper(prefix, i+1, currentNode.children[nextChar]!!)
            } else {
                0
            }
        }
    }

    // Given an array of strings arr[] and given some queries where each query consists of
    // a string str and an integer k, the function finds the count of strings in arr[]
    // whose prefix of length k matches with the k length prefix of str.
    fun countMatches(arr: Array<String>, str: String, k: Int) : Int {
        val trie = Trie()

        arr.forEach {
            trie.addWord(it)
        }

        return trie.countPrefixesThatMatch(str.substring(0, k))
    }

}