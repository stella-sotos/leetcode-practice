class Solution {
    public int compress(char[] chars) {

        char lastChar = chars[0];
        int lastCharCt = 1;
        int updateIndex = 0;

        for (int i = 1; i <= chars.length; i++) {
            if (i != chars.length && chars[i] == lastChar) {
                lastCharCt++;
            } else {
                chars[updateIndex] = lastChar;
                if (lastCharCt > 1) {
                    if (lastCharCt > 9) {
                        int num = lastCharCt;
                        int digits = getNumDigits(num);
                        int digInd = updateIndex + digits;
                        while (num > 9) {
                            char ones = getCharDig(num % 10);
                            chars[digInd] = ones;
                            digInd--;
                            num = num / 10;
                        }
                        char n = getCharDig(num);
                        chars[digInd] = n;
                        updateIndex = updateIndex + digits;
                    } else {
                        chars[updateIndex + 1] = getCharDig(lastCharCt);
                        updateIndex++;
                    }

                }
                updateIndex++;
                if (i != chars.length) {
                    lastChar = chars[i];
                    lastCharCt = 1;
                }
            }
        }

        return updateIndex;
    }

    public char getCharDig(int dig) {
        return (char) (dig + '0');
    }

    public int getNumDigits(int num) {
        return (int) Math.log10(Math.abs(num)) + 1;
    }

}