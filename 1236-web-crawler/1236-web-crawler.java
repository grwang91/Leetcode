/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    List<String> ans = new ArrayList<>();
    Set<String> set = new HashSet<>();
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        set.add(startUrl);
        ans.add(startUrl);
        String hostUrl = host(startUrl);
        
        for(String next: htmlParser.getUrls(startUrl)) {
            if(!set.contains(next) && host(next).equals(hostUrl)) {
                set.add(next);
                crawl(next, htmlParser);
            }
        }
        
        return ans;
    }
    
    private String host(String url) {
        return url.split("\\/")[2];
    }
}