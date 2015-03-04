package com.gdcc.live.core.utils;

import java.awt.FontMetrics;

/**
 * String自动换行工具类
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     Version       Date        Changes
 * kaizhou.chen    1.0           2015-01-12     Created
 * 
 * </pre>
 * @since 1.
 */
public class WordWrap {

    /**
     * Wraps a string to a given number of columns.
     */
    public static String wrap(String string, int numColumns) {
        return wrap(string, numColumns, new CharColumnScanner());
    }

    /**
     * Wraps a string to a given number of pixels in width, given a font whose
     * metrics are provided as well.
     */
    public static String wrap(String string, int numPixels, FontMetrics metrics) {
        return wrap(string, numPixels, new FontMetricsScanner(metrics));
    }

    static String wrap(String string, double desiredLength, WordWrapScanner scanner) {
        StringBuilder buf = new StringBuilder(string);

        int s = 0;
        int e;

        while (true) {
            if (s == buf.length()) {
                return buf.toString();
            }

            e = scanner.scan(buf, s, desiredLength) + 1;

            if (e >= buf.length()) {
                return buf.toString();
            }

            char ce = buf.charAt(e);

            if (ce == '\n') {
                s = e + 1;
            } else if (Character.isWhitespace(ce)) {
                int top = getAheadOfLine(buf, e);
                buf.delete(e, top);
                if (buf.charAt(e) != '\n') {
                    buf.insert(e, '\n');
                }
                s = e + 1;
            } else {
                int l = getEndOfLine(buf, e, s);
                if (l == s && !Character.isWhitespace(buf.charAt(l))) {
                    buf.insert(e, '\n');
                    s = e + 1;
                } else {
                    buf.insert(l + 1, '\n');
                    s = l + 2;
                }
            }
        }
    }
    
    static int getAheadOfLine(StringBuilder buf, int e) {
    	int top = e;
        while(top < buf.length() - 1 &&
                Character.isWhitespace(buf.charAt(top)) &&
                buf.charAt(top) != '\n') {
            top++;
        }
        
        return top;
    }
    
    static int getEndOfLine(StringBuilder buf, int e, int s) {
    	int l = e;
        while(l > s && !Character.isWhitespace(buf.charAt(l))) {
            l--;
        }
        
        return l;
    }
}

interface WordWrapScanner {

    public int scan(StringBuilder buf, int startIndex, double nextLoc);
}

class CharColumnScanner implements WordWrapScanner {

    public int scan(StringBuilder buf, int start, double nextLoc) {
        int nextIndex = start + ((int) nextLoc) - 1;
        if (buf.length() <= nextIndex) {
            nextIndex = buf.length() - 1;
        }

        for (int x = start; x < nextIndex; x++) {
            if (buf.charAt(x) == '\n') {
                nextIndex = x - 1;
            }
        }
        return nextIndex;
    }
}

class FontMetricsScanner implements WordWrapScanner {

    FontMetrics metrics;

    public FontMetricsScanner(FontMetrics metrics){
        this.metrics = metrics;
    }

    public int scan(StringBuilder buf, int start, double nextLoc) {
        char[] chars = new char[buf.length() - start];
        buf.getChars(start, buf.length(), chars, 0);

        for (int x = 0; x < chars.length; x++) {
            if (chars[x] == '\n') {
                return start + x - 1;
            }
            int len = metrics.charsWidth(chars, 0, x + 1);
            if (len > nextLoc) {
                return start + x - 1;
            }
        }
        return buf.length() - 1;
    }
}
