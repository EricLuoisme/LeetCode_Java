package Extras.FlexportPreparing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddress {

    /**
     * 题目1. 判断ip是否合法
     */
    String zeroTo255 = "(\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])";
    String IP_EXPRESSION = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

    private static final String LOCAL_IP = "0.0.0.0";

    public boolean checkIpValidityByRegularExpression(String inputIp) {
        Pattern ipPattern = Pattern.compile(IP_EXPRESSION);
        Matcher matcher = ipPattern.matcher(inputIp);
        if (matcher.matches()) {
            if (!LOCAL_IP.equals(inputIp)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        IpAddress test = new IpAddress();

//        // for question 1
//        List<String> testList = new LinkedList<>();
//        // valid
//        testList.add("123.1.2.40");
//        testList.add("255.1.2.40");
//        testList.add("255.255.255.255");
//        // invalid
//        testList.add("123.256.2.40");
//        testList.add("023.35.001.40");
//        testList.add("123.1.240");
//        testList.add("0.0.0.0");
//        testList.add("1");
//
//        for (String s : testList) {
//            System.out.println("Ip: " + s + ", is " + test.checkIpValidityByRegularExpression(s));
//        }


        // for question 2
        List<String> strings = test.allValidIpFormat("010010");
        for (String string : strings) {
            System.out.println(string);
        }

    }


    public static final Pattern NUMBER_EXPRESSION = Pattern.compile("\\d");

    /**
     * 题目2. 找出该字符串合法的ip形式
     */
    public List<String> allValidIpFormat(String inputNumber) {

        List<String> curSlots = new ArrayList<>();
        List<String> results = new ArrayList<>();

        dfs(inputNumber, 0, curSlots, results);

        return results;
    }


    private void dfs(String totalStr, int curIndex, List<String> curSlots, List<String> allResults) {

        // reach end of input Str, record valid ip address
        if (totalStr.length() == curIndex && 4 == curSlots.size()) {
            StringBuilder sb = new StringBuilder();
            for (String curSlot : curSlots) {
                sb.append(".").append(curSlot);
            }
            allResults.add(sb.substring(1));
        }

        if (4 == curSlots.size()) {
            // have 4 slot, but not totally using the input string
            return;
        }

        for (int i = curIndex; i < totalStr.length(); i++) {
            // possible slot selection
            String chosenSlot = totalStr.substring(curIndex, i + 1);
            // only when the chosen slot is a valid number
            if (!isValid(chosenSlot)) {
                return;
            }
            // add success slot
            curSlots.add(chosenSlot);
            // doing dfs
            dfs(totalStr, i + 1, curSlots, allResults);
            // remove last chosen
            curSlots.remove(curSlots.size() - 1);
        }
    }

    private boolean isValid(String numStr) {
        if ("".equals(numStr)) {
            return false;
        }
        int parsedNum = Integer.parseInt(numStr);
        if (parsedNum > 255
                || (parsedNum != 0 && numStr.startsWith("0"))
                || (parsedNum == 0 && !"0".equals(numStr))) {
            return false;
        }
        return true;
    }


}
