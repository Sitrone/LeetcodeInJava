	/**
	 * 计数排序，Counting Sort，时间为线性的排序方法
	 * Ref：https://zh.wikipedia.org/wiki/%E8%AE%A1%E6%95%B0%E6%8E%92%E5%BA%8F
	 *
	 */
public class CountingSort {
	public static int [] countSort(int[] a){
		int[] b = new int[a.length];
		int max = a[0], min = a[0];
		int aLen = a.length;
		
		// find max and min in array a
		for(int i = 1; i < aLen; i++){
			if(a[i] > max) max = a[i];
			if(a[i] < min) min = a[i];
		}
		
		//这里k的大小是要排序的数组中，元素大小的极值差+1
		int k = max - min + 1;
		int c[] = new int[k];
		for(int i = 0; i < a.length; ++i){
			c[a[i]-min] += 1;//优化过的地方，减小了数组c的大小
		}
		for(int i = 1; i < c.length; ++i){
			c[i] = c[i] + c[i-1];
		}
		for(int i = a.length-1; i >= 0; --i){
			b[--c[a[i]-min]] = a[i];//按存取的方式取出c的元素
		}
		return b;
	}
}