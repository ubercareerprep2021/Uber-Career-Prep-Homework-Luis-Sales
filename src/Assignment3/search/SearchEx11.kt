package Assignment3.search

class SearchEx11 {

    // This is a Trie tree that supports adding words and searching for them. The words that are
    // to be searched are formed from characters a-z, and the character '.'. The '.' is to be
    // interpreted as a wildcard character
    class Trie {
        private class TrieNode (val wordSoFar: String){
            var isFinal = false

            val children = HashMap<Char, TrieNode>()
        }

        private val rootNode: TrieNode = TrieNode("*")

        fun addWord(str: String) {
            addWordHelper(str, 0, StringBuilder(), rootNode)
        }

        private fun addWordHelper(str: String, i: Int, builder: StringBuilder, currentNode: TrieNode) {

            val nextNode: TrieNode
            builder.append(str[i])
            if (!currentNode.children.containsKey(str[i])) {
                val nodeToAdd = TrieNode(builder.toString())
                currentNode.children[str[i]] = nodeToAdd
                nextNode = nodeToAdd
            } else {
                nextNode = currentNode.children[str[i]]!!
            }

            if (i >= str.lastIndex) {
                nextNode.isFinal = true
                return
            }

            addWordHelper(str, i+1, builder, nextNode)
        }

        fun search(word: String) : Boolean {
            return searchHelper(rootNode, word, 0)
        }

        private fun searchHelper(currentNode: TrieNode, word: String, currentCharIdx: Int) : Boolean {
            if (currentNode.isFinal && currentCharIdx >= word.length) return true
            if (currentNode.children.isEmpty() || currentCharIdx >= word.length) return false

            val currentChar = word[currentCharIdx]

            if (currentChar == '.') {
                for (char in 'a'..'z') {
                    if(iterateWithChar(char, currentCharIdx, word, currentNode)) return true
                }
                return false
            } else {
                return iterateWithChar(currentChar, currentCharIdx, word, currentNode)
            }
        }

        private fun iterateWithChar(char: Char, currentCharIdx: Int, word: String, currentNode: TrieNode) : Boolean {
            for (child in currentNode.children) {
                if (child.key == char) {
                    return searchHelper(child.value, word, currentCharIdx + 1)
                }
            }
            return false
        }
    }

}