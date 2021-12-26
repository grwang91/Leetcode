class Solution {
    public int distinctEchoSubstrings(String text) {
		if (text == null || text.length() == 0) return 0;
		Set<String> stringSet = new HashSet<>();

		for (int right = 1; right <= text.length(); ++right)
		{
			for (int left = 0; left < right; ++left)
			{
				if (right - left <= 1) continue;
				String subStr = text.substring(left, right);
				if (isEchoString(subStr)) {
					stringSet.add(subStr);
				}
			}
		}

		return stringSet.size();
	}

	private boolean isEchoString(String subStr)
	{
		if (subStr.length() % 2 != 0) return false;

		if (subStr.substring(0, subStr.length()/2).equals(subStr.substring(subStr.length()/2, subStr.length())))
			return true;
		return false;
	}
}