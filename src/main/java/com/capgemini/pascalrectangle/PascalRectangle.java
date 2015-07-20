package com.capgemini.pascalrectangle;

/**
 * Created by ldrygala on 2015-01-23.
 * 0                     1
 * 1                   1   1
 * 2                 1   2   1
 * 3               1   3   3   1
 * 4             1   4   6   4   1
 * 5           1   5   10  10   5   1
 * 6         1   6   15  20  15   6   1
 * 7       1   7   21  35  35   21  7   1
 * 8     1   8   28  56  70  56   28  8   1
 * 9   1   9  36   84  126 126  84  36  9   1
 */
public class PascalRectangle {
    public static long pascal(int column, int row) {
    	if(column > row){
    		throw new IllegalArgumentException();
    	}
    	if (column == 0 || column == row)
    	{
    		return 1;
    	}
    	else
    	{
    		return pascal(column - 1, row - 1) + pascal(column, row - 1);
    	}
    }
}
