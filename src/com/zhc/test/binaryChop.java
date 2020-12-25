package com.zhc.test;

/**
 * @Date 2020-12-23 14:30:00
 * @title 二分查找
 * @description 请实现有重复数字的有序数组的二分查找。
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 */
public class binaryChop {

	/**
	 *
	 * @param arrays 已知的数组
	 * @param needNum 需要查询的数值
	 * @param startIndex 起始位置
	 * @param endIndex  结束位置
	 * @return
	 */
	private static String binaryChopTest(int[] arrays, int needNum, int startIndex, int endIndex){

		// 二分后生成的新数组
		int[] newArrays = new int[endIndex - startIndex + 1];
		System.arraycopy(arrays, startIndex, newArrays, 0, endIndex - startIndex + 1);

		int lastIndex = newArrays.length - 1;
		if (lastIndex < 0) {
			return "数据不合理";
		} else if (lastIndex == 0) {
			if (newArrays[0] == needNum) {
				return String.valueOf(startIndex);
			}else {
				return "不存在";
			}
		} else {
			// 数组中间的下标
			int middleIndex = lastIndex / 2;
			if (newArrays[middleIndex] > needNum) {
				if (middleIndex > 0) {
					return binaryChopTest(arrays, needNum, startIndex, startIndex + middleIndex - 1);
				} else {
					return "不存在";
				}
			} else if (newArrays[middleIndex] < needNum) {
				return binaryChopTest(arrays, needNum, startIndex + middleIndex + 1, endIndex);
			} else {
				return String.valueOf(startIndex + middleIndex);
			}
		}
	}

	public static void main(String[] args){
		int[] arrays = {1,5,7,9,10,22};
		System.out.println(binaryChopTest(arrays, 5, 0, arrays.length - 1));
	}
}
