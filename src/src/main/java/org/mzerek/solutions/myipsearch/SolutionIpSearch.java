package org.mzerek.solutions.myipsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.geeksforgeeks.org/parsing-apache-access-log-in-java/
public class SolutionIpSearch {

    public static void main(String[] str) {

        String logs  = "123.123.123.123 - - [26/Apr/2000:00:23:48 -0400] \"GET /pics/wpaper.gif HTTP/1.0\" 200 6248 \"http:// www.jafsoft.com/asctortf/\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n"
                + "123.123.123.123 - - [26/Apr/2000:00:23:47 -0400] \"GET /asctortf/ HTTP/1.0\" 200 8130 \"http:// search.netscape.com/Computers/Data_Formats/Document/Text/RTF\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n"
                + "123.123.123.124 - - [26/Apr/2000:00:23:48 -0400] \"GET /pics/5star2000.gif HTTP/1.0\" 200 4005 \"http:// www.jafsoft.com/asctortf/\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n"
                + "123.123.123.123 - - [26/Apr/2000:00:23:50 -0400] \"GET /pics/5star.gif HTTP/1.0\" 404 1031 \"http:// www.jafsoft.com/asctortf/\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n"
                + "123.123.123.126 - - [26/Apr/2000:00:23:51 -0400] \"GET /pics/a2hlogo.jpg HTTP/1.0\" 200 4282 \"http:// www.jafsoft.com/asctortf/\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n"
                + "123.123.123.123 - - [26/Apr/2000:00:23:51 -0400] \"GET /cgi-bin/newcount?jafsof3&width=4&font=digital&noshow HTTP/1.0\" 200 36 \"http:// www.jafsoft.com/asctortf/\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n";

        Map<String, Integer> ipCounter = fetchIpAddress(logs);

        for (Map.Entry entry : ipCounter.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    public static Map<String, Integer> fetchIpAddress(String logs) {

        String regexPattern = "^(\\S+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(\\S+) (\\S+)\\s*(\\S+)?\\s*\" (\\d{3}) (\\S+)";

        Pattern pattern = Pattern.compile(regexPattern, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(logs);

        Map<String, Integer> ipCounter = new HashMap<>();

        while (matcher.find()) {
            String ipAddress = matcher.group(1);
            String codeResponse = matcher.group(8);
            int response = Integer.parseInt(codeResponse);

            if (response == 200) {
                if (ipCounter.containsKey(ipAddress)) {
                    ipCounter.put(ipAddress, ipCounter.get(ipAddress) + 1);
                } else {
                    ipCounter.put(ipAddress, 1);
                }
            }
        }
        return ipCounter;
    }
}
