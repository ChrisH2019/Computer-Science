public class Palindrome {

    /** Returns a LinkedListDeque of characters of word. */
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> lld = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            lld.addLast(word.charAt(i));
        }
        return lld;
    }

    /** Return true if the word is a palindrome, and false otherwise. */
    public boolean isPalindrome(String word) {
        LinkedListDeque<Character> lld1 = new LinkedListDeque<>();
        LinkedListDeque<Character> lld2 = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            lld1.addLast(word.charAt(i));
            lld2.addLast(word.charAt(i));
        }

        for (int i = 0; i < lld1.size(); i++) {
            if ((lld1.removeFirst()).compareTo(lld2.removeLast()) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        LinkedListDeque<Character> lld1 = new LinkedListDeque<>();
        LinkedListDeque<Character> lld2 = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            lld1.addLast(word.charAt(i));
            lld2.addLast(word.charAt(i));
        }

        for (int i = 0; i < lld1.size(); i++) {
            if (!cc.equalChars(lld1.removeFirst(), lld2.removeLast())) {
                return false;
            }
        }
        return true;
    }

}
