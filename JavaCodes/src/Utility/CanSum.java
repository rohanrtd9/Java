package Utility;

import java.util.ArrayList;
import java.util.Map;

public class CanSum {
	private boolean canSum(Integer sum,ArrayList<Integer> numbers,Map<String, Boolean> values)
	{
		if (values.containsKey(sum))
			return values.get(sum);
		if (sum==0) 
		{
			values.put(sum.toString(), true);
			return true;
		}
		if (sum<=0)
		{
			values.put(sum.toString(), false);
			return false;
		}
		for (Integer num : numbers) {
			if (this.canSum(sum-num, numbers, values))
			{
				values.put(sum.toString(), true);
				return true;
			}
		}
		values.put(sum.toString(), false);
		return false;
	}

}
