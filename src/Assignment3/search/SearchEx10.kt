package Assignment3.search

class SearchEx10 {

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

        fun buildWordList(validCharacters: Array<Char>) : MutableList<String> {
            val returnList = ArrayList<String>()

            val validCharacterSet = validCharacters.toSet()
            buildWordListHelper(rootNode, validCharacterSet, returnList)

            return returnList
        }

        private fun buildWordListHelper(currentNode: TrieNode, validCharacters: Set<Char>, returnList: MutableList<String>) {
            if (currentNode.isFinal) {
                returnList.add(currentNode.wordSoFar)
            }

            for (child in currentNode.children) {
                if (validCharacters.contains(child.key)) {
                    buildWordListHelper(currentNode.children[child.key]!!, validCharacters, returnList)
                }
            }

        }
    }

    // This function, given a list of strings and an array of characters,
    // returns all valid words that can be formed from the char array that
    // are present in the string list
    fun getValidWords(dict: List<String>, arr: Array<Char>) : Array<String> {
        val trie = Trie()

        for (word in dict) {
            trie.addWord(word)
        }

        val list = trie.buildWordList(arr)

        return list.toTypedArray()
    }

}