public class SubStringService {
    public int findSubString(String string, String subString){
        if (string == null || string.isEmpty()){
            return -1;
        }
        if (subString == null || subString.isEmpty()){
            return -1;
        }

        if(subString.length() > string.length()){
            return -1;
        }
        String stringLow = string.toLowerCase().trim();
        String subStringLow = subString.toLowerCase().trim();

        return stringLow.indexOf(subStringLow);

    }
}
