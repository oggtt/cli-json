package app.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetAddress {
    private static final int MAX_WAIT = 3000;

    public static String torfAddress(String ipa) {
        try {
            InetAddress host = InetAddress.getByName(ipa);

            long start = System.currentTimeMillis();
            boolean reachable = host.isReachable(MAX_WAIT);
            long elapsed = System.currentTimeMillis() - start;

            return String.format("%b (%d ms)", reachable, elapsed);

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static String gettoAddress(String ipa) {
        try {
            InetAddress host = InetAddress.getByName(ipa);
            byte[] addr = host.getAddress();

            // IPv4 の場合
            if (addr.length == 4) {
                return String.format("%d.%d.%d.%d",
                        addr[0] & 0xFF,
                        addr[1] & 0xFF,
                        addr[2] & 0xFF,
                        addr[3] & 0xFF);
            }

            // IPv6 の場合
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < addr.length; i += 2) {
                sb.append(String.format("%02x%02x", addr[i], addr[i + 1]));
                if (i < addr.length - 2) sb.append(":");
            }
            return sb.toString();

        } catch (UnknownHostException e) {
            return "Not Found";
        }
    }
}
