class ReverseString {

    String reverse(String inputString) {
        if (inputString.isEmpty())
            return "";
        else
            return reverse(inputString.substring(1)) + inputString.substring(0, 1);
    }
}